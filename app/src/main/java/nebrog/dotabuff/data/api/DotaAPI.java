package nebrog.dotabuff.data.api;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import nebrog.dotabuff.data.models.DotaHeroesPOJO;
import nebrog.dotabuff.data.models.HeroStatsPOJO;
import nebrog.dotabuff.data.models.ItemListPOJO;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        DotaAPI dotaAPI = retrofit.create(DotaAPI.class);

        Log.i("nebrog", "1");

        return dotaAPI;
    }

    @GET("constants/heroes")
    Call<Map<Integer, DotaHeroesPOJO>> loadHeroes();


    @GET("usersNetwork")
    Call<List<SearchPOJO>> searchUser(@Query("q") String search);

    @GET("heroes/{hero_id}/itemPopularity")
    Single<ItemPopularityPOJO> loadItems(@Path("hero_id") Integer id);

    @GET("heroStats")
    Single<List<HeroStatsPOJO>> loadStats();

    @GET("constants/items")
    Single<Map<String, ItemListPOJO>> loadItemList();
}
