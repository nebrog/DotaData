package nebrog.dotabuff.heroes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nebrog.dotabuff.R;
import nebrog.dotabuff.heroesNetwork.DotaHeroesPOJO;
import nebrog.dotabuff.models.HeroAttr;

public class DotaAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<DotaHeroesPOJO> heroes = new ArrayList<>();

    public void setHeroes(Collection<DotaHeroesPOJO> dotaHeroesPOJOS) {
        List<DotaHeroesPOJO> dotaHeroesPOJOS1 = new ArrayList<>(dotaHeroesPOJOS);
        heroes = dotaHeroesPOJOS1;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new AttrViewHolder(parent);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, parent, false);
            DotaViewHolder pvh = new DotaViewHolder(v);
            return pvh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(holder instanceof AttrViewHolder){
          AttrViewHolder holder1 =  (AttrViewHolder)holder;
          holder1.setAttribute(HeroAttr.AGILITY);

        }else {
            DotaViewHolder holder2 = (DotaViewHolder)holder;
            DotaHeroesPOJO dotaHeroesPOJO = heroes.get(position -1);
            Glide
                    .with(holder2.img)
                    .load("https://api.opendota.com" + dotaHeroesPOJO.img)
                    .into(holder2.img);
        }

//        holder.nameHeroes.setText(dotaHeroesPOJO.name);
//        holder.idHeroes.setText(dotaHeroesPOJO.id.toString());
//        holder.typeAttack.setText(dotaHeroesPOJO.attackType);
//        if (dotaHeroesPOJO.primaryAttr.equalsIgnoreCase("agi")) {
//            holder.attribute.setImageResource(R.drawable.agility_attribute_symbol);
//        } else if (dotaHeroesPOJO.primaryAttr.equalsIgnoreCase("str")) {
//            holder.attribute.setImageResource(R.drawable.strength_attribute_symbol);
//        } else {
//            holder.attribute.setImageResource(R.drawable.intelligence_attribute_symbol);
//        }
    }

    @Override
    public int getItemCount() {
        return heroes.size()+1;

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        }else{
            return 1;
        }
    }
}
