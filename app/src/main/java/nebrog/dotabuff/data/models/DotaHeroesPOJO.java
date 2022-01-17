package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

public class DotaHeroesPOJO {

    @SerializedName("id")
    public Integer id;

    @SerializedName("localized_name")
    public String name;

    @SerializedName("primary_attr")
    public String primaryAttr;

    @SerializedName("attack_type")
    public String attackType;

    @SerializedName("img")
    public String img;

    @Override
    public String toString() {
        return "DotaHeroesPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryAttr='" + primaryAttr + '\'' +
                ", attackType='" + attackType + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
