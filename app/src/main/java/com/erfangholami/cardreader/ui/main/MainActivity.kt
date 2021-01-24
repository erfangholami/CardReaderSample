package com.erfangholami.cardreader.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erfangholami.cardreader.App
import com.erfangholami.cardreader.R
import com.erfangholami.cardreader.di.mainpage.MainPageComponent
import com.getbouncer.cardscan.ui.CardScanActivity
import com.getbouncer.cardscan.ui.CardScanActivityResult
import com.getbouncer.cardscan.ui.CardScanActivityResultHandler
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() , CardScanActivityResultHandler
{
    lateinit var mainComponent: MainPageComponent

    @Inject
    lateinit var cardReaderViewModel: CardReaderViewModel

    @Inject
    @Named("card_scanner_api")
    lateinit var CARD_SCANNER_API_KEY : String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        mainComponent = (application as App).appComponent.mainComponent().create()
        mainComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup scanner library
        CardScanActivity.warmUp(
            context = this,
            apiKey = CARD_SCANNER_API_KEY,
            initializeNameAndExpiryExtraction = true
        )
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    )
    {
        super.onActivityResult(requestCode, resultCode, data)

        if (CardScanActivity.isScanResult(requestCode)) {
            CardScanActivity.parseScanResult(resultCode, data, this)
        }
    }

    override fun analyzerFailure(scanId: String?)
    {
        showReadCardNumberFailMessage()
    }

    override fun cameraError(scanId: String?)
    {
        showReadCardNumberFailMessage()
    }

    override fun canceledUnknown(scanId: String?)
    {
        showReadCardNumberFailMessage()
    }

    override fun cardScanned(scanId: String?, scanResult: CardScanActivityResult)
    {
        cardReaderViewModel.onCardNumberChanged(scanResult.pan)
        cardReaderViewModel.onCardCVVChanged(scanResult.cvc)
        if(scanResult.expiryYear != null && scanResult.expiryMonth != null)
        {
            cardReaderViewModel.onCardExpireDateChanged(scanResult.expiryYear + scanResult.expiryMonth)
        }
        cardReaderViewModel.onBankNameChanged(scanResult.networkName)
    }

    override fun enterManually(scanId: String?)
    {
        //TODO("Custom scenario should be implemented")
    }

    override fun userCanceled(scanId: String?)
    {
        //TODO("Custom scenario should be implemented")
    }

    private fun showReadCardNumberFailMessage()
    {
        Toast.makeText(this, resources.getString(R.string.main_page_get_card_number_failed_message), Toast.LENGTH_LONG).show()
    }
}