package app.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Eng(
    val f: String,
    val m: String
) : Parcelable