package com.sparklead.musicwiki.ui.activities

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.snackbar.Snackbar
import com.sparklead.musicwiki.R

open class BaseActivity : AppCompatActivity() {


    private var doubleBackToExitPressedOnce = false
    private lateinit var loadingDialog : Dialog


    fun doubleBackToExit() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true

        Toast.makeText(
            this,
            "Please click back again to exit",
            Toast.LENGTH_SHORT
        ).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2500)
    }

    fun showLoadingDialog(){

        loadingDialog = Dialog(this)

        loadingDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.dialog_progress)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
        }
    }

    fun hideLoading(){
        loadingDialog.let { if (it.isShowing)it.cancel() }
    }
}

