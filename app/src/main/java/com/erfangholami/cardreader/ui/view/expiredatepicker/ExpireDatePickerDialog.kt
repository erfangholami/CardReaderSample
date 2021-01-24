package com.erfangholami.cardreader.ui.view.expiredatepicker

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.erfangholami.cardreader.R
import kotlinx.android.synthetic.main.dialog_expire_date.*
import java.util.*

/**
 * Created by ErfanG on 1/24/2021.
 */
class ExpireDatePickerDialog(val activity : Activity,
                             val listener : OnExpireDateChangeListener) : AppCompatDialog(activity)
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_expire_date)


        monthPicker.minValue = 1
        monthPicker.maxValue = 12

        yearPicker.minValue = Calendar.getInstance().get(Calendar.YEAR)
        yearPicker.maxValue = yearPicker.minValue + 10


        //setup views
        with(cancelButton)
        {
            setOnClickListener {
                dismiss()
            }

            text = resources.getString(R.string.main_page_expire_date_dialog_cancel_button_text)
            setTextColor(resources.getColor(R.color.main_page_expire_date_dialog_cancel_button_color))

            background = GradientDrawable().apply {
                cornerRadius = resources.getDimensionPixelSize(R.dimen.main_page_expire_date_dialog_button_default_corner_radius).toFloat()
                setStroke(resources.getDimensionPixelSize(R.dimen.main_page_expire_date_dialog_button_default_stroke),
                    resources.getColor(R.color.main_page_expire_date_dialog_cancel_button_color))
            }
        }

        with(pickButton)
        {

            text = resources.getString(R.string.main_page_expire_date_dialog_ok_button_text)
            setTextColor(resources.getColor(R.color.main_page_expire_date_dialog_ok_button_color))

            background = GradientDrawable().apply {
                cornerRadius = resources.getDimensionPixelSize(R.dimen.main_page_expire_date_dialog_button_default_corner_radius).toFloat()
                setStroke(resources.getDimensionPixelSize(R.dimen.main_page_expire_date_dialog_button_default_stroke),
                    resources.getColor(R.color.main_page_expire_date_dialog_ok_button_color))
            }

            setOnClickListener {
                listener.OnExpireDateChanged(monthPicker.value, yearPicker.value % 100)
                dismiss()
            }
        }

    }
}