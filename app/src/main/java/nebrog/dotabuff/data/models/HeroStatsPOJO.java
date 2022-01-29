package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

public class HeroStatsPOJO {
    @SerializedName("id")
    public Integer id;

    @SerializedName("localized_name")
    public String name;

    @SerializedName("primary_attr")
    public String primaryAttr;

    @SerializedName("attack_type")
    public String attackType;

    @SerializedName("icon")
    public String icon;

    @SerializedName("turbo_wins")
    public Integer turboWin;

    @SerializedName("turbo_picks")
    public Integer turboPicks;

    @Override
    public String toString() {
        return "HeroStatsPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryAttr='" + primaryAttr + '\'' +
                ", attackType='" + attackType + '\'' +
                ", icon='" + icon + '\'' +
                ", turboWin=" + turboWin +
                ", turboPicks=" + turboPicks +
                '}';
    }
}
