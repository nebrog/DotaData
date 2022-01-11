package nebrog.dotabuff.models;

import androidx.annotation.DrawableRes;

import nebrog.dotabuff.R;

public enum HeroAttr {
    AGILITY(R.drawable.agility_attribute_symbol),
    STRENGTH(R.drawable.strength_attribute_symbol),
    INTELLIGENCE(R.drawable.intelligence_attribute_symbol);

    @DrawableRes
    public final int icon;

    HeroAttr(@DrawableRes int icon){
        this.icon = icon;
    }
}
