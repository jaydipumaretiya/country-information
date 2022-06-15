
package app.country.information.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Car {

    @SerializedName("signs")
    @Expose
    public List<String> signs = null;
    @SerializedName("side")
    @Expose
    public String side;

}
