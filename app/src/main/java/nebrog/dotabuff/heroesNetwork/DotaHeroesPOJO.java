package nebrog.dotabuff.heroesNetwork;

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

    @Override
    public String toString() {
        return "DotaHeroesPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryAttr='" + primaryAttr + '\'' +
                ", attackType='" + attackType + '\'' +
                '}';
    }
}
