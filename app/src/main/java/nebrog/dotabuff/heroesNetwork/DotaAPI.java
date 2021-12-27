package nebrog.dotabuff.heroesNetwork;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DotaAPI {

    @GET("constants/{resource}")
    Call<Map<Integer,DotaHeroesPOJO>> loadHeroes(@Path("resource") String resourse);
}
