package app.country.information.ui.start

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import app.country.information.R
import app.country.information.databinding.ActivitySplashBinding
import app.country.information.ui.base.BaseActivity
import app.country.information.ui.base.delegate.viewBinding
import app.country.information.ui.country.CountryActivity

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    private val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun setContent() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                statusBarColor = Color.TRANSPARENT
            }
        }

        val splashThread = object : Thread() {
            override fun run() {
                synchronized(this) {
                    try {
                        sleep(3000)
                        startActivity(Intent(this@SplashActivity, CountryActivity::class.java))
                        finish()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        splashThread.start()
    }
}