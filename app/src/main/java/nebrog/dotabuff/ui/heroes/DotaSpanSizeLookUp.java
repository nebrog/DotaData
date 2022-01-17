package nebrog.dotabuff.ui.heroes;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.Collection;

import nebrog.dotabuff.data.models.DotaHeroesPOJO;

public class DotaSpanSizeLookUp extends GridLayoutManager.SpanSizeLookup {
    private final Integer numberOfColumns;
    private int str = 0;
    private int agi = 0;
    private int intel = 0;

    DotaSpanSizeLookUp(Integer numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public void setHeroes(Collection<DotaHeroesPOJO> heroes) {
        str = 0;
        agi = 0;
        intel = 0;

        for (DotaHeroesPOJO hero : heroes) {
            if (hero.primaryAttr.equals("str")) {
                str++;
            }
            if (hero.primaryAttr.equals("agi")) {
                agi++;
            }
            if (hero.primaryAttr.equals("int")) {
                intel++;
            }
        }
    }

    @Override
    public int getSpanSize(int position) {
        if (position == 0) {
            return numberOfColumns;
        }
        if (position == agi + 1) {
            return numberOfColumns;
        }
        if (position == str + 1 + agi + 1) {
            return numberOfColumns;
        }
        return 1;
    }
}
