package com.example.pagingdemo

import android.app.Application

/**
 * Create by LiangJingJie
 * On Create: 2020/11/3 18:06
 * Description
 */
class MyApplication : Application() {

    companion object {
        lateinit var instant: Application
    }

    override fun onCreate() {
        super.onCreate()
        instant = this
    }
}