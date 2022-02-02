package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

public class ItemListPOJO {

    @SerializedName("id")
    public Integer id;

    @SerializedName("img")
    public String img;

    @Override
    public String toString() {
        return "ItemListPOJO{" +
                "id=" + id +
                ", img='" + img + '\'' +
                '}';
    }
}
