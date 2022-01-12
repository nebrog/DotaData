package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public class DotaItemPopularityDto {

    @SerializedName("id")
    public String heroId;

    @SerializedName("item_popularity")
    public Map<String, Integer> itemsPopularity;
}
