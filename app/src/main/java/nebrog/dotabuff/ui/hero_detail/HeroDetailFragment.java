package nebrog.dotabuff.ui.hero_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nebrog.dotabuff.domain.interactors.OpenDotaInteractor;
import nebrog.dotabuff.domain.models.DotaHero;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public class HeroDetailFragment extends Fragment {

    private final OpenDotaInteractor interactor = new OpenDotaInteractor();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DotaHero hero = interactor.getHero("1");

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
