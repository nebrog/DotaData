package fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import nebrog.dotabuff.R;
import nebrog.dotabuff.heroesNetwork.DotaAdapter;

import nebrog.dotabuff.heroesNetwork.DotaAPI;
import nebrog.dotabuff.heroesNetwork.DotaHeroesPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentAllHeroes extends Fragment implements View.OnClickListener {
    public FragmentAllHeroes() {
    }

    public static FragmentAllHeroes newInstance() {
        return new FragmentAllHeroes();
    }
    DotaAdapter da = new DotaAdapter();

    @Override
    public void onClick(View v) {    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes,
                container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        loadData();
        recyclerView.setAdapter(da);
        return view;
    }


    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DotaAPI dotaAPI = retrofit.create(DotaAPI.class);
        Call<List<DotaHeroesPOJO>> call = dotaAPI.loadHeroes();

        call.enqueue(new FragmentAllHeroes.HeroCallback());
    }

    private class HeroCallback implements Callback<List<DotaHeroesPOJO>> {
        @Override
        public void onResponse(Call<List<DotaHeroesPOJO>> call, Response<List<DotaHeroesPOJO>> response) {
            if (response.isSuccessful()) {
                List<DotaHeroesPOJO> heroes = response.body();
                da.setHeroes(heroes);
                Log.e("KekPek", heroes.toString());
            } else {
                Log.e("KekPek", response.errorBody().toString());
            }
        }

        @Override
        public void onFailure(Call<List<DotaHeroesPOJO>> call, Throwable t) {
            Log.e("KekPek", t.getMessage(), t);
        }
    }

}


