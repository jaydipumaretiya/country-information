package app.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ara(
    val common: String,
    val official: String
) : Parcelable