package com.example.testui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testui.ui.main.PaparazziFragment

class PaparazziActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paparazzi)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PaparazziFragment.newInstance())
                .commitNow()
        }
    }
}