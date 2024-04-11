package app.feature.introduction

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import app.base.DataBindingActivity
import app.core.util.AppStartUtils
import app.feature.introduction.databinding.ActivityIntroductionBinding
import app.feature.introduction.model.Introduction

class IntroductionActivity : DataBindingActivity<ActivityIntroductionBinding>() {

    private var introArrayList: ArrayList<Introduction> = arrayListOf()
    private var currentPosition: Int = 0

    override fun layoutId(): Int = R.layout.activity_introduction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        introArrayList.add(
            Introduction(
                "Title 1", "Message 1",
                com.google.android.material.R.drawable.ic_clock_black_24dp
            )
        )
        introArrayList.add(
            Introduction(
                "Title 2", "Message 2",
                com.google.android.material.R.drawable.ic_clock_black_24dp
            )
        )
        introArrayList.add(
            Introduction(
                "Title 3", "Message 3",
                com.google.android.material.R.drawable.ic_clock_black_24dp
            )
        )
        introArrayList.add(
            Introduction(
                "Title 4", "Message 4",
                com.google.android.material.R.drawable.ic_clock_black_24dp
            )
        )

        vb.viewPager.adapter = IntroViewPagerAdapter(this@IntroductionActivity, introArrayList)
        vb.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                currentPosition = position
                when (position) {
                    1 -> vb.btnAction.text = getString(R.string.next)
                    2 -> vb.btnAction.text = getString(R.string.next)
                    3 -> vb.btnAction.text = getString(R.string.get_started)
                }
            }
        })
        vb.btnAction.setOnClickListener { buttonAction() }
    }

    private fun buttonAction() {
        when (currentPosition) {
            0 -> {
                vb.viewPager.currentItem = 1
                vb.btnAction.text = getString(R.string.next)
            }
            1 -> {
                vb.viewPager.currentItem = 2
                vb.btnAction.text = getString(R.string.next)
            }
            2 -> {
                vb.viewPager.currentItem = 3
                vb.btnAction.text = getString(R.string.get_started)
            }
            3 -> {
                launchHomeScreen()
            }
        }
    }

    private fun launchHomeScreen() {
//        startActivity(Intent(this, CountryActivity::class.java))
        AppStartUtils.updateVersionAppStart(this@IntroductionActivity)
        finish()
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}
