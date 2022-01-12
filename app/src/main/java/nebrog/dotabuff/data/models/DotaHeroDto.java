package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public class DotaHeroDto {

    @SerializedName("id")
    public String heroId;

    @SerializedName("image")
    public String tailImageUrl;
}
