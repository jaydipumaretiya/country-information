package app.feature.country

import android.os.Bundle
import app.core.model.Country
import app.core.util.Constants
import app.feature.country.databinding.ActivityCountryInformationBinding
import com.bumptech.glide.Glide

class CountryInformationActivity :
    app.base.DataBindingActivity<ActivityCountryInformationBinding>() {

    override fun layoutId(): Int = R.layout.activity_country_information

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val country = intent.getParcelableExtra<Country>(Constants.EXTRA_COUNTRY)
        vb.country = country

        Glide.with(this)
            .load(country!!.flags.png)
            .into(vb.ivFlag)
    }
}