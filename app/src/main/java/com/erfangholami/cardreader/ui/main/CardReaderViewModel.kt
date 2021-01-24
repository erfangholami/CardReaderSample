package com.erfangholami.cardreader.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erfangholami.cardreader.di.ActivityScope
import com.erfangholami.cardreader.utils.Utils
import javax.inject.Inject

/**
 * Created by ErfanG on 1/24/2021.
 */
@ActivityScope
class CardReaderViewModel @Inject constructor(): ViewModel(), OnCardDataReceive
{
    private val cardNumberLive = MutableLiveData<String>()
    private val cardCVVLive = MutableLiveData<String>()
    private val cardExpireDateLive = MutableLiveData<String>()
    private val bankNameLive = MutableLiveData<String>()


    override fun onCardNumberChanged(cardNumber: String?)
    {
        if(!cardNumber.equals(cardNumberLive.value))
        {
            cardNumberLive.value = cardNumber
            bankNameLive.value = cardNumber?.let { Utils.getBankName(it) }
        }
    }

    override fun onCardCVVChanged(cardCVV: String?)
    {
        if(!cardCVV.equals(cardCVVLive.value))
        {
            cardCVVLive.value = cardCVV
        }
    }

    override fun onCardExpireDateChanged(expireDate: String?)
    {
        if(!expireDate.equals(cardExpireDateLive.value))
        {
            cardExpireDateLive.value = expireDate
        }
    }

    override fun onBankNameChanged(bankName: String?)
    {
        if(!bankName.equals(bankNameLive.value))
        {
            bankNameLive.value = bankName
        }
    }

    fun getCardNumberLive() = cardNumberLive
    fun getCardCVVLive() = cardCVVLive
    fun getCardExpireDateLive() = cardExpireDateLive
    fun getbankNameLive() = bankNameLive

}