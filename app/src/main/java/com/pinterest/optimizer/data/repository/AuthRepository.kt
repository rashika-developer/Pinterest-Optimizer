package com.pinterest.optimizer.data.repository

import com.pinterest.optimizer.data.database.PinterestAccountDao
import com.pinterest.optimizer.data.models.PinterestAccount
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val accountDao: PinterestAccountDao
) {
    val currentAccount: Flow<PinterestAccount?> = accountDao.getAccount()

    suspend fun login(account: PinterestAccount) {
        accountDao.insertAccount(account)
    }

    suspend fun logout() {
        accountDao.deleteAccount()
    }

    fun isLoggedIn(): Flow<Boolean> {
        return accountDao.getAccount().map { it != null }
    }
}
