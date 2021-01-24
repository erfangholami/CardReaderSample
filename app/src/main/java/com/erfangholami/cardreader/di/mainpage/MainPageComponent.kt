package com.erfangholami.cardreader.di.mainpage

import com.erfangholami.cardreader.di.ActivityScope
import com.erfangholami.cardreader.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by ErfanG on 1/24/2021.
 */
@ActivityScope
@Subcomponent
interface MainPageComponent
{
    @Subcomponent.Factory
    interface Factory
    {
        fun create() : MainPageComponent
    }

    fun inject(activity : MainActivity)
}