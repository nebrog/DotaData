package nebrog.dotabuff.data.api;

import java.util.List;

import nebrog.dotabuff.data.models.DotaHeroDto;
import nebrog.dotabuff.data.models.DotaItemDto;
import nebrog.dotabuff.data.models.DotaItemPopularityDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public interface OpenDotaApi {

    @GET("/ololo/heroes")
    DotaHeroDto loadHero(@Query("id") String heroId);

    @GET("/ololo/item_popularity")
    DotaItemPopularityDto getItemPopularity(@Query("hero_id") String heroId);

    @GET("/ololo/items")
    List<DotaItemDto> loadItems();
}
