package com.practicum.sharedpreferncesfragments

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        sharedPreferenced = getSharedPreferences(Constants.PREFERENCES_ACCEPT,Context.MODE_PRIVATE)
        editor = sharedPreferenced.edit()
    }

    companion object{
        lateinit var sharedPreferenced : SharedPreferences
        lateinit var editor:SharedPreferences.Editor
    }

}