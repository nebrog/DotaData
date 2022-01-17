package nebrog.dotabuff.data.api;

import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import nebrog.dotabuff.data.models.DotaHeroesPOJO;
import nebrog.dotabuff.data.models.HeroStatsPOJO;
import nebrog.dotabuff.data.models.ItemPopularityPOJO;
import nebrog.dotabuff.data.models.SearchPOJO;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DotaAPI {
    DotaAPI SINGLETON = getApi();

    static DotaAPI getApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(25, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DotaAPI dotaAPI = retrofit.create(DotaAPI.class);
        Log.i("nebrog", "1");

        return dotaAPI;
    }

    @GET("constants/{resource}")
    Call<Map<Integer, DotaHeroesPOJO>> loadHeroes(@Path("resource") String resourse);

    @GET("usersNetwork")
    Call<List<SearchPOJO>> searchUser(@Query("q") String search);

    @GET("heroes/{hero_id}/itemPopularity")
    Call<ItemPopularityPOJO> loadItems(@Path("hero_id") Integer id);

    @GET("heroStats")
    Call<List<HeroStatsPOJO>> loadStats();


}
