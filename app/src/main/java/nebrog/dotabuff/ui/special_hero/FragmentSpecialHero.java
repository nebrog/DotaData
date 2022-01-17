package nebrog.dotabuff.ui.special_hero;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nebrog.dotabuff.R;
import nebrog.dotabuff.data.api.DotaAPI;
import nebrog.dotabuff.data.models.ItemPopularityPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSpecialHero extends Fragment {

    private final DotaAPI dotaAPI = DotaAPI.SINGLETON;


    private static final String HERO_ID_TAG = "id";

    public static FragmentSpecialHero newInstance(int heroId) {
        FragmentSpecialHero fragmentSpecialHero = new FragmentSpecialHero();
        Bundle bundle = new Bundle();
        bundle.putInt(HERO_ID_TAG, heroId);
        fragmentSpecialHero.setArguments(bundle);
        return fragmentSpecialHero;
    }

    @Nullable
    TextView items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_special_hero, container, false);
        items = view.findViewById(R.id.role);
        loadItems();
        return view;
    }

    private void loadItems() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            Call<ItemPopularityPOJO> call = dotaAPI.loadItems(bundle.getInt(HERO_ID_TAG));
            call.enqueue(new FragmentSpecialHero.ItemsCallback());
        }
    }

    private class ItemsCallback implements Callback<ItemPopularityPOJO> {

        @Override
        public void onResponse(Call<ItemPopularityPOJO> call, Response<ItemPopularityPOJO> response) {
            ItemPopularityPOJO itemsList = response.body();
            items.setText(itemsList.toString());
        }

        @Override
        public void onFailure(Call<ItemPopularityPOJO> call, Throwable t) {

        }


    }
}
