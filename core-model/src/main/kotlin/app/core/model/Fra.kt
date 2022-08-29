package app.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fra(
    val f: String,
    val m: String
) : Parcelable