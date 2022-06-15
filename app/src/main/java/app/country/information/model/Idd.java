
package app.country.information.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Idd {

    @SerializedName("root")
    @Expose
    public String root;
    @SerializedName("suffixes")
    @Expose
    public List<String> suffixes = null;

}
