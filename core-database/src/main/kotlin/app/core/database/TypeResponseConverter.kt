package app.core.database

import androidx.room.ProvidedTypeConverter

@ProvidedTypeConverter
class TypeResponseConverter constructor(
//  private val moshi: Moshi
) {
//  @TypeConverter
//  fun fromString(value: String): List<PokemonInfo.TypeResponse>? {
//    val listType =
//      Types.newParameterizedType(List::class.java, PokemonInfo.TypeResponse::class.java)
//    val adapter: JsonAdapter<List<PokemonInfo.TypeResponse>> = moshi.adapter(listType)
//    return adapter.fromJson(value)
//  }
//
//  @TypeConverter
//  fun fromInfoType(type: List<PokemonInfo.TypeResponse>?): String {
//    val listType =
//      Types.newParameterizedType(List::class.java, PokemonInfo.TypeResponse::class.java)
//    val adapter: JsonAdapter<List<PokemonInfo.TypeResponse>> = moshi.adapter(listType)
//    return adapter.toJson(type)
//  }
}
