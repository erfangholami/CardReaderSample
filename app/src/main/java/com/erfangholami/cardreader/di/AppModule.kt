package com.erfangholami.cardreader.di

import com.erfangholami.cardreader.Constant
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ErfanG on 1/24/2021.
 */
@Module
class AppModule
{
    @Provides
    @Singleton
    @Named("card_scanner_api")
    fun providesVenueDatabaseName() = Constant.CARD_SCANNER_API

}