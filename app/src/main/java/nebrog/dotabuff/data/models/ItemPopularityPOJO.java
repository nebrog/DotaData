package nebrog.dotabuff.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ItemPopularityPOJO {


    @SerializedName("start_game_items")
    public Map<String, Integer> start_game_items;

    @SerializedName("early_game_items")
    public Map<String, Integer> early_game_items;

    @SerializedName("mid_game_items")
    public Map<String, Integer> mid_game_items;

    @SerializedName("late_game_items")
    public Map<String, Integer> late_game_items;

    @Override
    public String toString() {
        return "ItemPopularityPOJO{" +
                "start_game_items=" + start_game_items +
                ", early_game_items=" + early_game_items +
                ", mid_game_items=" + mid_game_items +
                ", late_game_items=" + late_game_items +
                '}';
    }
}
