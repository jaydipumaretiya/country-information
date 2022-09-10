package app.country.information.ui.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.core.util.AppStartUtils
import app.core.util.enums.AppStart
import app.country.information.R
import app.country.information.ui.country.CountryActivity
import app.feature.introduction.IntroductionActivity

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

//    private val binding by viewBinding(ActivitySplashBinding::inflate)
//
//    override fun setContent() {
//        window.apply {
//            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                statusBarColor = Color.TRANSPARENT
//            }
//        }
//
//        val splashThread = object : Thread() {
//            override fun run() {
//                synchronized(this) {
//                    try {
//                        sleep(3000)
//                        startActivity(Intent(this@SplashActivity, CountryActivity::class.java))
//                        finish()
//                    } catch (e: InterruptedException) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//        }
//        splashThread.start()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashThread = object : Thread() {
            override fun run() {
                synchronized(this) {
                    try {
                        sleep(1000)
                        checkApplicationRunningStatus()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        splashThread.start()
    }

    private fun checkApplicationRunningStatus() {
        when (AppStartUtils.checkAppStart(this)) {
            AppStart.NORMAL -> {
                startActivity(Intent(this@SplashActivity, CountryActivity::class.java))
            }

            AppStart.FIRST_TIME_VERSION -> {

            }

            AppStart.FIRST_TIME -> {
                startActivity(Intent(this, IntroductionActivity::class.java))
            }
        }
        finishAffinity()
    }
}