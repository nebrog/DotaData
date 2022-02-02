package nebrog.dotabuff.ui.heroes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import nebrog.dotabuff.R;
import nebrog.dotabuff.data.models.DotaHeroesPOJO;

public class DotaViewHolder extends RecyclerView.ViewHolder {

    private final ImageView img;

    DotaViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, parent, false));
        img = itemView.findViewById(R.id.img);
    }

    public void setHero(DotaHeroesPOJO dotaHeroesPOJO) {

        Glide
                .with(this.img)
                .load("https://api.opendota.com" + dotaHeroesPOJO.img)
                .into(this.img);
    }


}