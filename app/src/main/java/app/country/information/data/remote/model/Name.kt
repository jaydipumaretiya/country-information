package app.country.information.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    val common: String,
//    val nativeName: NativeName,
    val official: String
) : Parcelable