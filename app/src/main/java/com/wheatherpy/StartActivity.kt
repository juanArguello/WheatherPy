package com.wheatherpy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StartActivity : AppCompatActivity() {

    val URL_AVISO: String = "https://www.meteorologia.gov.py/wp-admin/admin-ajax.php?action=dmh_avisos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }
}