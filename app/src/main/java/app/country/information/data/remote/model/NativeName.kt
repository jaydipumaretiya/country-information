package app.country.information.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NativeName(
    val ara: Ara
) : Parcelable