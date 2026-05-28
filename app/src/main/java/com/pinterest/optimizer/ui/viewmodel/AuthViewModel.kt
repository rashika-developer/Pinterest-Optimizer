package com.pinterest.optimizer.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinterest.optimizer.data.api.PinterestApi
import com.pinterest.optimizer.data.models.PinterestAccount
import com.pinterest.optimizer.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Base64

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val pinterestApi: PinterestApi
) : ViewModel() {

    // IMPORTANT: Replace with your actual credentials from developers.pinterest.com
    private val CLIENT_ID = "YOUR_PINTEREST_CLIENT_ID"
    private val CLIENT_SECRET = "YOUR_PINTEREST_CLIENT_SECRET"
    
    // Updated to match your specific GitHub repository name
    private val REDIRECT_URI = "https://rashika-developer.github.io/Pinterest-Optimizer/"

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    val currentAccount: StateFlow<PinterestAccount?> = authRepository.currentAccount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun getOAuthUrl(): String {
        return "https://www.pinterest.com/oauth/?" +
                "client_id=$CLIENT_ID&" +
                "redirect_uri=$REDIRECT_URI&" +
                "response_type=code&" +
                "scope=boards:read,pins:read,pins:write,user_accounts:read"
    }

    fun handleAuthCode(code: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Connecting
            try {
                val basicAuth = "Basic " + Base64.encodeToString(
                    "$CLIENT_ID:$CLIENT_SECRET".toByteArray(),
                    Base64.NO_WRAP
                )
                
                val tokenResponse = pinterestApi.exchangeToken(
                    code = code,
                    redirectUri = REDIRECT_URI,
                    basicAuth = basicAuth
                )

                val userProfile = pinterestApi.getUserAccount("Bearer ${tokenResponse.accessToken}")

                val account = PinterestAccount(
                    userId = userProfile.username ?: "user_${System.currentTimeMillis()}",
                    username = userProfile.username ?: "Pinterest User",
                    accessToken = tokenResponse.accessToken,
                    refreshToken = tokenResponse.refreshToken,
                    tokenExpiresAt = System.currentTimeMillis() + (tokenResponse.expiresIn * 1000L),
                    profileImage = userProfile.profileImage
                )
                
                authRepository.login(account)
                _loginState.value = LoginState.Success
            } catch (e: Exception) {
                e.printStackTrace()
                _loginState.value = LoginState.Error("Handshake failed. Check your internet connection.")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
            _loginState.value = LoginState.Idle
        }
    }
}

sealed class LoginState {
    data object Idle : LoginState()
    data object Connecting : LoginState()
    data object Success : LoginState()
    data class Error(val message: String) : LoginState()
}
