package com.techun.dev.tuskillgt.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.techun.dev.tuskillgt.data.local.preferences.AppPreferencesDataSource.Keys.KEY_FIRST_LAUNCH
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "app_preferences"
)

class AppPreferencesDataSource(
    private val context: Context
) {
    private object Keys {
        val KEY_FIRST_LAUNCH = booleanPreferencesKey("is_first_launch")
    }

    val isFirstLaunch: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[KEY_FIRST_LAUNCH] ?: true }

    suspend fun setFirstLaunchCompleted() {
        context.dataStore.edit { pref ->
            pref[KEY_FIRST_LAUNCH] = false
        }
    }
}