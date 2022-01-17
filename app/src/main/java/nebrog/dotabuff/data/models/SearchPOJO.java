package nebrog.dotabuff.data.models;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SearchPOJO {

    @SerializedName("avatarfull")
    public String avatar;
    @SerializedName("personaname")
    public String name;
    @SerializedName("account_id")
    public Integer id;
    @SerializedName("last_match_time")
    @Nullable
    public Date lastMatch;
    @Override
    public String toString(){
        return "SearchPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", lastMatch='" + lastMatch + '\'' +
                '}';
    }
}
