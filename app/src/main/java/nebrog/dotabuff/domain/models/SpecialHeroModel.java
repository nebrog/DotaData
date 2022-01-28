package nebrog.dotabuff.domain.models;

import java.util.List;

public class SpecialHeroModel {

   public final String heroName;
   public final Integer winTurbo;
   public final String iconHero;
   public final List<String> itemsStart;
   public final List<String> itemsEarly;
   public final List<String> itemsMid;
   public final List<String> itemsLate;

   public SpecialHeroModel(
           String heroName,
           Integer winTurbo,
           String iconHero,
           List<String> itemsStart,
           List<String> itemsEarly,
           List<String> itemsMid,
           List<String> itemsLate
   ) {
      this.heroName = heroName;
      this.winTurbo = winTurbo;
      this.iconHero = iconHero;
      this.itemsStart = itemsStart;
      this.itemsEarly = itemsEarly;
      this.itemsMid = itemsMid;
      this.itemsLate = itemsLate;
   }

   @Override
   public String toString() {
      return "SpecialHeroModel{" +
              "heroName='" + heroName + '\'' +
              ", winTurbo=" + winTurbo +
              ", iconHero='" + iconHero + '\'' +
              ", itemsStart=" + itemsStart +
              ", itemsEarly=" + itemsEarly +
              ", itemsMid=" + itemsMid +
              ", itemsLate=" + itemsLate +
              '}';
   }
}
