
package app.country.information.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class PostalCode {

    @SerializedName("format")
    @Expose
    public String format;
    @SerializedName("regex")
    @Expose
    public String regex;

}
