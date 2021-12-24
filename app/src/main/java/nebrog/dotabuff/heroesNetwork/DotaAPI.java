package nebrog.dotabuff.heroesNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DotaAPI {

    @GET("heroes")
    Call<List<DotaHeroesPOJO>> loadHeroes();
}
