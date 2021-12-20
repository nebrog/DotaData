package search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import nebrog.dotabuff.BuildConfig;
import nebrog.dotabuff.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search_Activity extends AppCompatActivity {
    SearchAdapter searchAdapter = new SearchAdapter();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = findViewById(R.id.editText);
        RecyclerView recyclerView = findViewById(R.id.recSearchView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Log.e("Pek", "1");

        recyclerView.setAdapter(searchAdapter);


        Button search = findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();


            }
        };
        search.setOnClickListener(listener);
        Log.e("Pek", "2");

    }

    private void loadData() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        SearchAPI searchAPI = retrofit.create(SearchAPI.class);
        Call<List<SearchPOJO>> call = searchAPI.searchUser(editText.getText().toString());

        call.enqueue(new Search_Activity.SearchCallback());
        Log.e("Pek", "3");

    }

    private class SearchCallback implements Callback<List<SearchPOJO>> {
        @Override
        public void onResponse(Call<List<SearchPOJO>> call, Response<List<SearchPOJO>> response) {
            if (response.isSuccessful()) {
                List<SearchPOJO> search = response.body();
                searchAdapter.setSearches(search);
//                Log.e("Pek",search);
                System.out.println("Ker " + search);

            } else {
            }
        }

        @Override
        public void onFailure(Call<List<SearchPOJO>> call, Throwable t) {
        }
    }
}

