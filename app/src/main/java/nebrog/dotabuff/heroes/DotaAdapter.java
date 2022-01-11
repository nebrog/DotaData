package nebrog.dotabuff.heroes;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nebrog.dotabuff.heroesNetwork.DotaHeroesPOJO;
import nebrog.dotabuff.models.HeroAttr;

public class DotaAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<DotaHeroesPOJO> agility = new ArrayList<>();
    private final List<DotaHeroesPOJO> strenght = new ArrayList<>();
    private final List<DotaHeroesPOJO> intllegence = new ArrayList<>();

    private final OnHeroClickListener onClickListener;

    DotaAdapter(OnHeroClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    public interface OnHeroClickListener {
        void onHeroListener(DotaHeroesPOJO hero);
    }


    private static final int TYPE_ATTRIBUTE = 0;
    private static final int TYPE_HEROES = 1;


    public void setHeroes(Collection<DotaHeroesPOJO> dotaHeroesPOJOS) {
        List<DotaHeroesPOJO> dotaHeroesPOJOS1 = new ArrayList<>(dotaHeroesPOJOS);
        for (DotaHeroesPOJO hero : dotaHeroesPOJOS1) {
            if (hero.primaryAttr.equals("str")) {
                strenght.add(hero);
            }
            if (hero.primaryAttr.equals("agi")) {
                agility.add(hero);
            }
            if (hero.primaryAttr.equals("int")) {
                intllegence.add(hero);
            }
        }
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ATTRIBUTE) {
            return new AttrViewHolder(parent);
        } else {
            return new DotaViewHolder(parent);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof AttrViewHolder) {
            AttrViewHolder holder1 = (AttrViewHolder) holder;
            if (position == 0) {
                holder1.setAttribute(HeroAttr.AGILITY);
            }
            if (position == agility.size() + 1) {
                holder1.setAttribute(HeroAttr.STRENGTH);

            }
            if (position == agility.size() + strenght.size() + 2) {
                holder1.setAttribute(HeroAttr.INTELLIGENCE);
            }

        } else {
            DotaViewHolder holder2 = (DotaViewHolder) holder;


            if (position > 0 && position < agility.size() + 1) {
                int x = position - 1;
                DotaHeroesPOJO agi = agility.get(x);
                holder2.setHero(agi);
                holder2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onHeroListener(agi);
                    }
                });

            }
            if (position > agility.size() + 1 && position < agility.size() + strenght.size() + 2) {
                int x = position - (agility.size() + 2);
                DotaHeroesPOJO str = strenght.get(x);
                holder2.setHero(str);
                holder2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onHeroListener(str);
                    }
                });


            }
            if (position > (agility.size() + strenght.size() + 2)) {
                int x = position - (agility.size() + strenght.size() + 3);
                DotaHeroesPOJO intel = intllegence.get(x);
                holder2.setHero(intel);
                holder2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onHeroListener(intel);
                    }
                });

            }

        }

    }

    @Override
    public int getItemCount() {
        if ((agility.size() + strenght.size() + intllegence.size()) == 0) {
            return 0;
        } else {
            return agility.size() + strenght.size() + intllegence.size() + 3;

        }

    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0 || (position == agility.size() + 1) || (position == agility.size() + strenght.size() + 2)) {
            return TYPE_ATTRIBUTE;
        } else {
            return TYPE_HEROES;
        }
    }
}
