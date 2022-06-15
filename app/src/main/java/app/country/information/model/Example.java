
package app.country.information.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Example {

    @SerializedName("name")
    @Expose
    public Name name;
    @SerializedName("tld")
    @Expose
    public List<String> tld = null;
    @SerializedName("cca2")
    @Expose
    public String cca2;
    @SerializedName("ccn3")
    @Expose
    public String ccn3;
    @SerializedName("cca3")
    @Expose
    public String cca3;
    @SerializedName("cioc")
    @Expose
    public String cioc;
    @SerializedName("independent")
    @Expose
    public boolean independent;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("unMember")
    @Expose
    public boolean unMember;
    @SerializedName("currencies")
    @Expose
    public Currencies currencies;
    @SerializedName("idd")
    @Expose
    public Idd idd;
    @SerializedName("capital")
    @Expose
    public List<String> capital = null;
    @SerializedName("altSpellings")
    @Expose
    public List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("subregion")
    @Expose
    public String subregion;
    @SerializedName("languages")
    @Expose
    public Languages languages;
    @SerializedName("translations")
    @Expose
    public Translations translations;
    @SerializedName("latlng")
    @Expose
    public List<Double> latlng = null;
    @SerializedName("landlocked")
    @Expose
    public boolean landlocked;
    @SerializedName("borders")
    @Expose
    public List<String> borders = null;
    @SerializedName("area")
    @Expose
    public double area;
    @SerializedName("demonyms")
    @Expose
    public Demonyms demonyms;
    @SerializedName("flag")
    @Expose
    public String flag;
    @SerializedName("maps")
    @Expose
    public Maps maps;
    @SerializedName("population")
    @Expose
    public long population;
    @SerializedName("gini")
    @Expose
    public Gini gini;
    @SerializedName("fifa")
    @Expose
    public String fifa;
    @SerializedName("car")
    @Expose
    public Car car;
    @SerializedName("timezones")
    @Expose
    public List<String> timezones = null;
    @SerializedName("continents")
    @Expose
    public List<String> continents = null;
    @SerializedName("flags")
    @Expose
    public Flags flags;
    @SerializedName("coatOfArms")
    @Expose
    public CoatOfArms coatOfArms;
    @SerializedName("startOfWeek")
    @Expose
    public String startOfWeek;
    @SerializedName("capitalInfo")
    @Expose
    public CapitalInfo capitalInfo;
    @SerializedName("postalCode")
    @Expose
    public PostalCode postalCode;

}
