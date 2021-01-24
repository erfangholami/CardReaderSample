package com.erfangholami.cardreader.di

import android.content.Context
import com.erfangholami.cardreader.di.mainpage.MainPageComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ErfanG on 1/24/2021.
 */
@Singleton
@Component(modules = [])
interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun applicationContext(context: Context) : Builder

        fun build() : AppComponent
    }

    fun mainComponent() : MainPageComponent.Factory
}
