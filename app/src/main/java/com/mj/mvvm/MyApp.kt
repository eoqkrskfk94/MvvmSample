package com.mj.mvvm

import android.app.Application
import android.content.Context

class MyApp: Application() {

    private lateinit var context: Context

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }


}