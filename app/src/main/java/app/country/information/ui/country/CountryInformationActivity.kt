package app.country.information.ui.country

import android.os.Bundle
import app.country.information.R
import app.country.information.base.DataBindingActivity
import app.country.information.data.remote.model.Country
import app.country.information.databinding.ActivityCountryInformationBinding
import app.country.information.ui.utils.Constants
import com.bumptech.glide.Glide

class CountryInformationActivity : DataBindingActivity<ActivityCountryInformationBinding>() {

    override fun layoutId(): Int = R.layout.activity_country_information

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val country = intent.getParcelableExtra<Country>(Constants.EXTRA_COUNTRY)
        vb.country = country

        Glide
            .with(this)
            .load(country!!.flags.png)
            .into(vb.ivFlag)
    }
}