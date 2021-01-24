package com.erfangholami.cardreader.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.erfangholami.cardreader.Constant
import com.erfangholami.cardreader.R

/**
 * Created by ErfanG on 1/24/2021.
 */
class Utils
{
    companion object
    {


        fun getBankIcon(context : Context?, bankName : String?) : Drawable?
        {
            return when(bankName)
            {
                Constant.VISA -> return ResourcesCompat.getDrawable(context!!.resources, R.drawable.ic_visa, null)
                Constant.MASTER_CARD -> return ResourcesCompat.getDrawable(context!!.resources, R.drawable.ic_mastercard, null)
                Constant.DISCOVER -> return ResourcesCompat.getDrawable(context!!.resources, R.drawable.ic_discover, null)
                Constant.AMERICAN_EXPRESS -> return ResourcesCompat.getDrawable(context!!.resources, R.drawable.ic_americanexpress, null)
                Constant.JCB -> return ResourcesCompat.getDrawable(context!!.resources, R.drawable.ic_jcb, null)

                else -> null
            }
        }

        fun getBankName(cardNumber : String) : String
        {
            if(cardNumber.length in 13..16 && cardNumber[0] == '4')
            {
                return Constant.VISA
            }
            else if(cardNumber.length == 16 && (cardNumber.substring(0, 2) == "51" || cardNumber.substring(0, 2) == "52" ||
                cardNumber.substring(0, 2) == "53" || cardNumber.substring(0, 2) == "54" || cardNumber.substring(0, 2) == "55"))
            {
                return Constant.MASTER_CARD
            }
            else if(cardNumber.length == 16 && (cardNumber.substring(0, 4) == "6011" || cardNumber.substring(0, 2) == "65"))
            {
                return Constant.DISCOVER
            }
            else if(cardNumber.length == 15 && (cardNumber.substring(0, 2) == "34" || cardNumber.substring(0, 2) == "37"))
            {
                return Constant.AMERICAN_EXPRESS
            }
            else if((cardNumber.length == 15 && (cardNumber.substring(0, 4) == "2131" || cardNumber.substring(0, 4) == "1800")) ||
                    (cardNumber.length == 16 && (cardNumber.substring(0, 2) == "35" )))
            {
                return Constant.JCB
            }
            else
            {
                return ""
            }
        }

    }
}