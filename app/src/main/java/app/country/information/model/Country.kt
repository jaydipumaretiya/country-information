package app.country.information.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Country {
    @SerializedName("name")
    @Expose
    var name: Name? = null

    @SerializedName("tld")
    @Expose
    var tld: List<String>? = null

    @SerializedName("cca2")
    @Expose
    var cca2: String? = null

    @SerializedName("ccn3")
    @Expose
    var ccn3: String? = null

    @SerializedName("cca3")
    @Expose
    var cca3: String? = null

    @SerializedName("cioc")
    @Expose
    var cioc: String? = null

    @SerializedName("independent")
    @Expose
    var independent = false

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("unMember")
    @Expose
    var unMember = false

    @SerializedName("currencies")
    @Expose
    var currencies: Currencies? = null

    @SerializedName("idd")
    @Expose
    var idd: Idd? = null

    @SerializedName("capital")
    @Expose
    var capital: List<String>? = null

    @SerializedName("altSpellings")
    @Expose
    var altSpellings: List<String>? = null

    @SerializedName("region")
    @Expose
    var region: String? = null

    @SerializedName("subregion")
    @Expose
    var subregion: String? = null

    @SerializedName("languages")
    @Expose
    var languages: Languages? = null

    @SerializedName("translations")
    @Expose
    var translations: Translations? = null

    @SerializedName("latlng")
    @Expose
    var latlng: List<Double>? = null

    @SerializedName("landlocked")
    @Expose
    var landlocked = false

    @SerializedName("borders")
    @Expose
    var borders: List<String>? = null

    @SerializedName("area")
    @Expose
    var area = 0.0

    @SerializedName("demonyms")
    @Expose
    var demonyms: Demonyms? = null

    @SerializedName("flag")
    @Expose
    var flag: String? = null

    @SerializedName("maps")
    @Expose
    var maps: Maps? = null

    @SerializedName("population")
    @Expose
    var population: Long = 0

    @SerializedName("gini")
    @Expose
    var gini: Gini? = null

    @SerializedName("fifa")
    @Expose
    var fifa: String? = null

    @SerializedName("car")
    @Expose
    var car: Car? = null

    @SerializedName("timezones")
    @Expose
    var timezones: List<String>? = null

    @SerializedName("continents")
    @Expose
    var continents: List<String>? = null

    @SerializedName("flags")
    @Expose
    var flags: Flags? = null

    @SerializedName("coatOfArms")
    @Expose
    var coatOfArms: CoatOfArms? = null

    @SerializedName("startOfWeek")
    @Expose
    var startOfWeek: String? = null

    @SerializedName("capitalInfo")
    @Expose
    var capitalInfo: CapitalInfo? = null

    @SerializedName("postalCode")
    @Expose
    var postalCode: PostalCode? = null
}