package app.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostalCode(
    val format: String,
    val regex: String
) : Parcelable