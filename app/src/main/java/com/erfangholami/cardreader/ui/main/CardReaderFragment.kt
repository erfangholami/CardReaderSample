package com.erfangholami.cardreader.ui.main

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.erfangholami.cardreader.R
import com.erfangholami.cardreader.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_card_reader.*
import javax.inject.Inject
import androidx.core.graphics.drawable.DrawableCompat as DrawableCompat1

/**
 * Created by ErfanG on 1/24/2021.
 */
class CardReaderFragment : BaseFragment()
{

    @Inject
    lateinit var cardReaderViewModel: CardReaderViewModel

    override fun getLayoutId(): Int
    {
        return R.layout.fragment_card_reader
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val cardNumberBackground = GradientDrawable().apply {
            cornerRadius = resources.getDimensionPixelSize(R.dimen.main_page_input_background_corner_radius).toFloat()
            setStroke(resources.getDimensionPixelSize(R.dimen.main_page_input_background_stroke_width), resources.getColor(R.color.main_page_input_background_stroke_color))
        }
        val cardExpireDateBackground = GradientDrawable().apply {
            cornerRadius = resources.getDimensionPixelSize(R.dimen.main_page_input_background_corner_radius).toFloat()
            setStroke(resources.getDimensionPixelSize(R.dimen.main_page_input_background_stroke_width), resources.getColor(R.color.main_page_input_background_stroke_color))
        }
        val cardCVVBackground = GradientDrawable().apply {
            cornerRadius = resources.getDimensionPixelSize(R.dimen.main_page_input_background_corner_radius).toFloat()
            setStroke(resources.getDimensionPixelSize(R.dimen.main_page_input_background_stroke_width), resources.getColor(R.color.main_page_input_background_stroke_color))
        }

        cardNumberInput.background = cardNumberBackground
        cardCVVInput.background = cardCVVBackground
        cardExpireInput.background = cardExpireDateBackground

        //TODO add listeners to input data
    }

    override fun onDestroyView()
    {
        super.onDestroyView()

        //TODO remove listeners from input data

    }
}