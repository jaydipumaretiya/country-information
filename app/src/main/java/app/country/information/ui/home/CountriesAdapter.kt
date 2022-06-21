package app.country.information.ui.home

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.country.information.databinding.ItemCountryBinding
import app.country.information.model.Country

class CountriesAdapter(
    private val activity: Activity,
    private val countries: ArrayList<Country>
) : RecyclerView.Adapter<CountriesAdapter.TemplatesViewHolder>() {

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

    class TemplatesViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            activity: Activity,
            country: Country
        ) {
            binding.apply {
                binding.tvCountry.text = country.name!!.common
            }
        }
    }

    fun updateTemplates(templates: List<Country>?) {
        this.countries.apply {
            clear()
            addAll(templates!!)
            notifyDataSetChanged()
        }
    }
}
