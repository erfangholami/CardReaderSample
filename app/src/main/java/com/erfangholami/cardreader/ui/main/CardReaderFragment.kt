package com.erfangholami.cardreader.ui.main

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.erfangholami.cardreader.R
import com.erfangholami.cardreader.base.BaseFragment
import com.getbouncer.cardscan.ui.CardScanActivity
import kotlinx.android.synthetic.main.fragment_card_reader.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by ErfanG on 1/24/2021.
 */
class CardReaderFragment : BaseFragment()
{

    @Inject
    lateinit var cardReaderViewModel: CardReaderViewModel

    @Inject
    @Named("card_scanner_api")
    lateinit var CARD_SCANNER_API_KEY : String

    private val cardNumberTextWatcher = object : TextWatcher
    {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
        {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
        {

        }

        override fun afterTextChanged(p0: Editable?)
        {
            cardReaderViewModel.onCardNumberChanged(p0.toString())
        }
    }
    private val cardCVVTextWatcher = object : TextWatcher
    {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
        {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
        {
            cardReaderViewModel.onCardCVVChanged(p0.toString())
        }

        override fun afterTextChanged(p0: Editable?)
        {

        }
    }


    override fun getLayoutId(): Int
    {
        return R.layout.fragment_card_reader
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)


        //set backgrounds
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

        //set text watchers
        cardNumberInput.addTextChangedListener(cardNumberTextWatcher)
        cardCVVInput.addTextChangedListener(cardCVVTextWatcher)

        cardReaderViewModel.getCardNumberLive().observe(viewLifecycleOwner,  {
            cardNumberInput.setText(it)
            cardNumberInput.setSelection(it.length)
        })
        cardReaderViewModel.getCardCVVLive().observe(viewLifecycleOwner, {
            cardCVVInput.setText(it)
            cardCVVInput.setSelection(it.length)
        })
        cardReaderViewModel.getCardExpireDateLive().observe(viewLifecycleOwner, {
            cardExpireInput.setText(it)
        })


        cardView.setOnClickListener {
            CardScanActivity.start(
                activity = requireActivity(),
                apiKey = CARD_SCANNER_API_KEY,
                enableEnterCardManually = true,
                enableExpiryExtraction = true
            )
        }
        cardExpireInput.setOnClickListener {

            //todo: open the dialog
        }
    }

    override fun onDestroyView()
    {
        super.onDestroyView()

        cardNumberInput.removeTextChangedListener(cardNumberTextWatcher)
        cardCVVInput.removeTextChangedListener(cardCVVTextWatcher)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).mainComponent.inject(this)
    }
}