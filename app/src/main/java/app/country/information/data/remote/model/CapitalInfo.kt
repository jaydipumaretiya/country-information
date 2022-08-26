package app.country.information.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CapitalInfo(
    val latlng: List<Double>
) : Parcelable