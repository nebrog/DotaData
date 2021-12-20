package search;

import com.google.gson.annotations.SerializedName;

public class SearchPOJO {
    @SerializedName("avatarfull")
    public String avatar;
    @SerializedName("personaname")
    public String name;
    @SerializedName("account_id")
    public Integer id;
    @SerializedName("last_match_time")
    public String lastMatch;
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
