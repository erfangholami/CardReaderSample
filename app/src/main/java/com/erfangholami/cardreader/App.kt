package com.erfangholami.cardreader

import android.app.Application
import com.erfangholami.cardreader.di.AppComponent
import com.erfangholami.cardreader.di.DaggerAppComponent

/**
 * Created by ErfanG on 1/24/2021.
 */
class App : Application()
{
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent
    {
        return DaggerAppComponent
            .builder()
            .applicationContext(applicationContext)
            .build()
    }
}