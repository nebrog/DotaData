package nebrog.dotabuff.ui.heroes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

import nebrog.dotabuff.R;
import nebrog.dotabuff.data.api.DotaAPI;
import nebrog.dotabuff.data.models.DotaHeroesPOJO;
import nebrog.dotabuff.ui.special_hero.FragmentSpecialHero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAllHeroes extends Fragment {
    public FragmentAllHeroes() {
    }

    private final DotaAPI dotaAPI = DotaAPI.SINGLETON;

    public static FragmentAllHeroes newInstance() {
        return new FragmentAllHeroes();
    }

    public static final int numberOfColumns = 6;

    DotaAdapter.OnHeroClickListener onHeroClickListener = new DotaAdapter.OnHeroClickListener() {
        @Override
        public void onHeroListener(DotaHeroesPOJO hero) {
            FragmentSpecialHero fragmentSpecialHero = FragmentSpecialHero.newInstance(hero.id);
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_view, fragmentSpecialHero)
                    .commit();
        }

    };

    DotaAdapter da = new DotaAdapter(onHeroClickListener);
    DotaSpanSizeLookUp spanSizeLookup = new DotaSpanSizeLookUp(numberOfColumns);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);


        recyclerView.setLayoutManager(gridLayoutManager);
        loadData();
        recyclerView.setAdapter(da);
        return view;
    }


    private void loadData() {

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


