package app.country.information.ui.home

import app.country.information.R
import app.country.information.databinding.ActivityCountryInformationBinding
import app.country.information.model.Country
import app.country.information.ui.base.BaseActivity
import app.country.information.ui.base.delegate.viewBinding
import com.bumptech.glide.Glide

class CountryInformationActivity : BaseActivity(R.layout.activity_country_information) {

    private val binding by viewBinding(ActivityCountryInformationBinding::inflate)

    override fun setContent() {
        val country = intent.getSerializableExtra("country") as Country

        Glide
            .with(this)
            .load(country.flags!!.png)
            .into(binding.ivFlag)

    }
}