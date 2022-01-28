package nebrog.dotabuff.ui.search_players;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nebrog.dotabuff.BuildConfig;
import nebrog.dotabuff.R;
import nebrog.dotabuff.data.api.DotaAPI;
import nebrog.dotabuff.data.models.SearchPOJO;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentUsers extends Fragment implements View.OnClickListener {
    @Override
    public void onClick(View v) {

    }

    private final DotaAPI dotaAPI = DotaAPI.SINGLETON;


    SearchAdapter searchAdapter = new SearchAdapter();
    EditText editText;

    public FragmentUsers() {
    }

    public static FragmentUsers newInstance() {
        return new FragmentUsers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users, container, false);
        editText = view.findViewById(R.id.editText);
        RecyclerView recyclerView = view.findViewById(R.id.recSearchView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(searchAdapter);
        Button search = view.findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        };
        search.setOnClickListener(listener);
        return view;
    }
    private void loadData() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        Call<List<SearchPOJO>> call = dotaAPI.searchUser(editText.getText().toString());

        call.enqueue(new FragmentUsers.SearchCallback());
        Log.e("Pek", "3");

    }

    private class SearchCallback implements Callback<List<SearchPOJO>> {
        @Override
        public void onResponse(Call<List<SearchPOJO>> call, Response<List<SearchPOJO>> response) {
            if (response
                    .isSuccessful()) {
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
