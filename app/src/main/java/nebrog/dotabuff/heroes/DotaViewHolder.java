package nebrog.dotabuff.heroes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import nebrog.dotabuff.R;

public class DotaViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        ImageView attribute;
        TextView idHeroes;
        TextView nameHeroes;
        TextView typeAttack;

        DotaViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);

        }


    }