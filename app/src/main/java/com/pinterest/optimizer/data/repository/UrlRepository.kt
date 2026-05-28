package com.pinterest.optimizer.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "settings")

@Singleton
class UrlRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val API_URL_KEY = stringPreferencesKey("api_url")

    val apiUrl: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[API_URL_KEY] ?: "http://10.0.2.2:5000/"
    }

    suspend fun updateUrl(newUrl: String) {
        context.dataStore.edit { preferences ->
            preferences[API_URL_KEY] = if (newUrl.endsWith("/")) newUrl else "$newUrl/"
        }
    }
}
