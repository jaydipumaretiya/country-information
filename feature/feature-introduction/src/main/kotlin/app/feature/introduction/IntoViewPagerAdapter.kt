package app.feature.introduction

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import app.feature.introduction.model.Introduction

class IntroViewPagerAdapter(
    private val mContext: Context,
    private val introArrayList: ArrayList<Introduction>
) : PagerAdapter() {

    override fun getCount(): Int {
        return introArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val intro = introArrayList[position]
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item_introduction, collection, false) as ViewGroup

        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)

        tvTitle.text = intro.title
        tvMessage.text = intro.message

        collection.addView(view)

        return view
    }
}