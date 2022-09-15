package app.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
    var page: Int = 0,
    @PrimaryKey val name: String,
    val url: String
)
