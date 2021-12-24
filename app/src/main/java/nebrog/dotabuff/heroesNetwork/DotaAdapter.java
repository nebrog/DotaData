package nebrog.dotabuff.heroesNetwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nebrog.dotabuff.R;

public class DotaAdapter extends RecyclerView.Adapter<DotaAdapter.DotaViewHolder> {

   List<DotaHeroesPOJO> heroes = new ArrayList<>();
    public void setHeroes(List<DotaHeroesPOJO> dotaHeroesPOJOS){
        heroes = dotaHeroesPOJOS;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("KekPek onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, parent, false);
        DotaViewHolder pvh = new DotaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DotaViewHolder holder, int position) {
        System.out.println("KekPek onBindViewHolder " + position);
        DotaHeroesPOJO dotaHeroesPOJO = heroes.get(position);
        holder.nameHeroes.setText(dotaHeroesPOJO.name);
        holder.idHeroes.setText(dotaHeroesPOJO.id.toString());
        holder.typeAttack.setText(dotaHeroesPOJO.attackType);
        if (dotaHeroesPOJO.primaryAttr.equalsIgnoreCase("agi")) {
            holder.attribute.setImageResource(R.drawable.agility_attribute_symbol);
        } else if (dotaHeroesPOJO.primaryAttr.equalsIgnoreCase("str")) {
            holder.attribute.setImageResource(R.drawable.strength_attribute_symbol);
        } else {
            holder.attribute.setImageResource(R.drawable.intelligence_attribute_symbol);
        }
    }

    @Override
    public int getItemCount() {
        System.out.println("KekPek getItemCount " + heroes.size());
        return heroes.size();

    }

    public static class DotaViewHolder extends RecyclerView.ViewHolder {
        ImageView attribute;
        TextView idHeroes;
        TextView nameHeroes;
        TextView typeAttack;

        DotaViewHolder(View itemView) {
            super(itemView);
            attribute = itemView.findViewById(R.id.attribute);
            idHeroes = itemView.findViewById(R.id.idHeroes);
            nameHeroes = itemView.findViewById(R.id.nameHeroes);
            typeAttack = itemView.findViewById(R.id.typeAttack);
        }


    }
}
