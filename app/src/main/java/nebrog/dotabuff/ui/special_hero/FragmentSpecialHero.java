package nebrog.dotabuff.ui.special_hero;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nebrog.dotabuff.R;
import nebrog.dotabuff.domain.interactors.SpecialHeroInteractor;
import nebrog.dotabuff.domain.models.SpecialHeroModel;

public class FragmentSpecialHero extends Fragment {

    public static SpecialHeroInteractor specialHeroInteractor = new SpecialHeroInteractor();


    private static final String HERO_ID_TAG = "id";

    public static FragmentSpecialHero newInstance(int heroId) {
        FragmentSpecialHero fragmentSpecialHero = new FragmentSpecialHero();
        Bundle bundle = new Bundle();
        bundle.putInt(HERO_ID_TAG, heroId);
        fragmentSpecialHero.setArguments(bundle);
        return fragmentSpecialHero;
    }

    private void setItemContent(LinearLayout linearLayout, List<String> items, @StringRes int gamePeriod) {
        GridLayout gridLayout = linearLayout.findViewById(R.id.allImg);
        TextView game = linearLayout.findViewById(R.id.typeGame);
        game.setText(gamePeriod);
        for (int x = 0; x < items.size(); x++) {
            Glide
                    .with(gridLayout)
                    .load(items.get(x))
                    .into((ImageView) gridLayout.getChildAt(x));
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_special_hero, container, false);
        TextView heroName = view.findViewById(R.id.heroName);
        TextView turboWin = view.findViewById(R.id.turboWin);
        ImageView iconHero = view.findViewById(R.id.iconHero);
        LinearLayout start = view.findViewById(R.id.start);
        LinearLayout early = view.findViewById(R.id.early);
        LinearLayout mid = view.findViewById(R.id.mid);
        LinearLayout late = view.findViewById(R.id.late);


        Bundle bundle = getArguments();
        int id = bundle.getInt(HERO_ID_TAG);
        Single<SpecialHeroModel> specialHero = specialHeroInteractor.loadHero(id);
        specialHero
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SpecialHeroModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull SpecialHeroModel specialHeroModel) {
                        int winTurbo = specialHeroModel.winTurbo;
                        int pickTurbo = specialHeroModel.turboPicks;
                        long winRate = Math.round(((double) winTurbo / (double) pickTurbo) * 100);

                        heroName.setText(specialHeroModel.heroName);
                        turboWin.setText("Процент побед в турбо играх " + winRate + " %");
                        Glide
                                .with(iconHero.getContext())
                                .load(specialHeroModel.iconHero)
                                .into(iconHero);
                        setItemContent(start, specialHeroModel.itemsStart, R.string.start);
                        setItemContent(early, specialHeroModel.itemsEarly, R.string.early);
                        setItemContent(mid, specialHeroModel.itemsMid, R.string.mid);
                        setItemContent(late, specialHeroModel.itemsLate, R.string.late);


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.e("Pek", String.valueOf(e));

                    }


                });


        return view;
    }

}
