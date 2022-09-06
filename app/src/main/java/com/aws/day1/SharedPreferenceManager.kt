package com.aws.day1

import android.content.Context

class SharedPreferenceManager(private val context: Context){

    private fun getSharedPreference() =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    private fun getEditor() = getSharedPreference().edit()

    fun saveSet(key: String, value: MutableSet<String>) = getEditor().putStringSet(key, value).commit()

    fun getSet(key: String, default: MutableSet<String>? = null) : MutableSet<String>? =  getSharedPreference().getStringSet(key,default)

    fun saveString(key: String, value: String) = getEditor().putString(key, value).commit()

    fun getString(key: String, default: String? = null): String? = getSharedPreference().getString(key, default)

    fun saveNumber(key: String, value: Int) = getEditor().putLong(key, value.toLong()).commit()

    fun getNumber(key: String, default: Long = 0): Long =
        getSharedPreference().getLong(key, default)

    fun removeValue(key: String) = getEditor().remove(key).commit()

    companion object {
        private const val SHARED_PREF_NAME = "com.dome.SharedPreferenceManager"
    }

    fun clearData() {
//        removeValue(Constants.TOKEN)
//        removeValue(Constants.NAME)
//        removeValue(Constants.NUM)
    }
}