package nebrog.dotabuff.ui.heroes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import nebrog.dotabuff.R;
import nebrog.dotabuff.domain.models.HeroAttr;

class AttrViewHolder extends RecyclerView.ViewHolder {

    private final TextView attribute;
    private final ImageView attrImg;


    AttrViewHolder(ViewGroup parent){
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.agi_str_int, parent, false));
        attribute = itemView.findViewById(R.id.atrr_name);
        attrImg = itemView.findViewById(R.id.attr_img);
    }

    public void setAttribute(HeroAttr attr){
        switch (attr){
            case AGILITY:
                attrImg.setImageResource(attr.icon);
                attribute.setText(R.string.agi);
                break;
            case STRENGTH:
                attrImg.setImageResource(attr.icon);
                attribute.setText(R.string.str);
                break;
            case INTELLIGENCE:
                attrImg.setImageResource(attr.icon);
                attribute.setText(R.string.intel);
                break;
        }
    }
}