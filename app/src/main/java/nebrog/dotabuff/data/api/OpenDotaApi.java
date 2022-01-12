package nebrog.dotabuff.data.api;

import java.util.List;

import nebrog.dotabuff.data.models.DotaHeroDto;
import nebrog.dotabuff.data.models.DotaItemDto;
import nebrog.dotabuff.data.models.DotaItemPopularityDto;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public interface OpenDotaApi {

    OpenDotaApi SINGLETON = getApi();

    static OpenDotaApi getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenDotaApi openDotaApi = retrofit.create(OpenDotaApi.class);

        return openDotaApi;
    }

    @GET("/ololo/heroes")
    DotaHeroDto loadHero(@Query("id") String heroId);

    @GET("/ololo/item_popularity")
    DotaItemPopularityDto getItemPopularity(@Query("hero_id") String heroId);

    @GET("/ololo/items")
    List<DotaItemDto> loadItems();
}
