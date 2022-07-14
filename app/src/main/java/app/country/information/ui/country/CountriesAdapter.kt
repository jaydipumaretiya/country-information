package app.country.information.ui.country

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import app.country.information.databinding.ItemCountryBinding
import app.country.information.interfaces.OnCountryClickListener
import app.country.information.data.remote.model.Country
import com.bumptech.glide.Glide

class CountriesAdapter(
    private val activity: Activity,
    private var countries: ArrayList<Country>,
    private var onCountryClickListener: OnCountryClickListener
) : RecyclerView.Adapter<CountriesAdapter.TemplatesViewHolder>(), Filterable {

    private var countriesSearch: List<Country>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplatesViewHolder {
        return TemplatesViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: TemplatesViewHolder, position: Int) {
        holder.bind(activity, countries[position])
    }

    inner class TemplatesViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            activity: Activity,
            country: Country
        ) {
            binding.apply {
                Glide
                    .with(activity)
                    .load(country.flags!!.png)
                    .into(binding.ivFlag)

                binding.tvCountry.text = country.name!!.common

                with(itemView) {
                    setOnClickListener {
                        onCountryClickListener.onCountryClicked(country)
                    }
                }
            }
        }
    }

    fun updateTemplates(countries: List<Country>?) {
        this.countries.apply {
            clear()
            addAll(countries!!)
            notifyDataSetChanged()
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val oReturn = FilterResults()
                val results = ArrayList<Country>()
                if (countriesSearch == null) {
                    countriesSearch = countries
                }
                if (charSequence != null) {
                    if (countriesSearch != null && countriesSearch!!.isNotEmpty()) {
                        for (country in countriesSearch!!) {
                            if (country.name!!.common!!.contains(
                                    charSequence.toString(),
                                    ignoreCase = true
                                )
                            ) {
                                results.add(country)
                            }
                        }
                    }
                    oReturn.values = results
                    oReturn.count = results.size
                }
                return oReturn
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                //                if (filterResults.count > 0) {
                //                    MainActivity.setResultsMessage(false);
                //                } else {
                //                    MainActivity.setResultsMessage(true);
                //                }
                countries = filterResults.values as ArrayList<Country>
                notifyDataSetChanged()
            }
        }
    }
}
