package com.erfangholami.cardreader.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erfangholami.cardreader.App
import com.erfangholami.cardreader.R
import com.erfangholami.cardreader.di.mainpage.MainPageComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity()
{
    lateinit var mainComponent: MainPageComponent

    override fun onCreate(savedInstanceState: Bundle?)
    {
        mainComponent = (application as App).appComponent.mainComponent().create()
        mainComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}