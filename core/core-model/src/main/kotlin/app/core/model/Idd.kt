package app.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Idd(
    val root: String,
    val suffixes: List<String>
) : Parcelable