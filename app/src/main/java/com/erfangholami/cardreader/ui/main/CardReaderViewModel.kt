package com.erfangholami.cardreader.ui.main

import androidx.lifecycle.ViewModel
import com.erfangholami.cardreader.di.ActivityScope
import javax.inject.Inject

/**
 * Created by ErfanG on 1/24/2021.
 */
@ActivityScope
class CardReaderViewModel @Inject constructor(): ViewModel(), OnCardDataReceive
{
    private lateinit var cardNumber : String
    private lateinit var cardCVV : String
    private lateinit var cardExpireDate : String




    override fun onCardNumberChanged(cardNumber: String)
    {
        this.cardNumber = cardNumber
    }

    override fun onCardCVVChanged(cardCVV: String)
    {
        this.cardCVV = cardCVV
    }

    override fun onCardExpireDateChanged(expireDate: String)
    {
        this.cardExpireDate = cardExpireDate
    }
}