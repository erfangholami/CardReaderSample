package com.erfangholami.cardreader.ui.main

/**
 * Created by ErfanG on 1/24/2021.
 */
interface OnCardDataReceive
{
    fun onCardNumberChanged(cardNumber : String)
    fun onCardCVVChanged(cardCVV : String)
    fun onCardExpireDateChanged(expireDate : String)
}