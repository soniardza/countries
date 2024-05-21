package com.example.testui

import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.androidHome
import app.cash.paparazzi.detectEnvironment
import com.example.testui.ui.main.PaparazziFragment
import org.junit.Rule
import org.junit.Test

class PaparazziFragmentTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5,
        theme = "android:Theme.Material.Light.NoActionBar",
        environment = detectEnvironment().copy(
            platformDir = "${androidHome()}/platforms/android-32",
            compileSdkVersion = 32
        )
    )

    @Test
    fun testAssert() {
        assert(true)
    }

    @Test
    fun testMyFragmentSnapshot() {
        val fragment = PaparazziFragment()
        val view = fragment.onCreateView(LayoutInflater.from(paparazzi.context), null, null)

        checkNotNull(view) { "Fragment view is not created" }
        paparazzi.snapshot(view)
    }

    @Test
    fun testMyViewSnapshot() {

        val view = paparazzi.inflate<ConstraintLayout>(R.layout.fragment_paparazzi)
        checkNotNull(view) { "Layout view is not created" }
        paparazzi.snapshot(view)
    }

}
