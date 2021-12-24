package usersNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchAPI {
    @GET("usersNetwork")
    Call<List<SearchPOJO>> searchUser(@Query("q") String search);


}
