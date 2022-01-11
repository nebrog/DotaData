package nebrog.dotabuff.heroes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

import nebrog.dotabuff.R;
import nebrog.dotabuff.heroesNetwork.DotaAPI;
import nebrog.dotabuff.heroesNetwork.DotaHeroesPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentAllHeroes extends Fragment {
    public FragmentAllHeroes() {
    }

    public static FragmentAllHeroes newInstance() {
        return new FragmentAllHeroes();
    }

    public static final int numberOfColumns = 6;

    DotaAdapter.OnHeroClickListener onHeroClickListener = new DotaAdapter.OnHeroClickListener() {
        @Override
        public void onHeroListener(DotaHeroesPOJO hero) {
            Toast.makeText(getContext(), "Был выбран герой " + hero.name,
                    Toast.LENGTH_SHORT).show();
        }

    };

    DotaAdapter da = new DotaAdapter(onHeroClickListener);
    DotaSpanSizeLookUp spanSizeLookup = new DotaSpanSizeLookUp(numberOfColumns);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes,
                container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);

        recyclerView.setLayoutManager(gridLayoutManager);
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
        Call<Map<Integer, DotaHeroesPOJO>> call = dotaAPI.loadHeroes("heroes");

        call.enqueue(new FragmentAllHeroes.HeroCallback());
    }


    private class HeroCallback implements Callback<Map<Integer, DotaHeroesPOJO>> {
        @Override
        public void onResponse(Call<Map<Integer, DotaHeroesPOJO>> call, Response<Map<Integer, DotaHeroesPOJO>> response) {
            if (response.isSuccessful()) {
                Map<Integer, DotaHeroesPOJO> heroes = response.body();
                spanSizeLookup.setHeroes(heroes.values());
                da.setHeroes(heroes.values());
                Log.e("KekPek", heroes.toString());
            } else {
                Log.e("KekPek", response.errorBody().toString());
            }
        }

        @Override
        public void onFailure(Call<Map<Integer, DotaHeroesPOJO>> call, Throwable t) {
            Log.e("KekPek", t.getMessage(), t);
        }
    }

}


