package nebrog.dotabuff.domain.models;

import java.util.List;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public class DotaHero {

    public String heroId;
    public String heroImage; // https://api.opendota.com/ + DotaHeroDto#tailImageUrl
    public Integer kill;
    public Integer death;
    public Integer assistance;
    public List<DotaItem> startItems;
    public List<DotaItem> earlyItems;
    public List<DotaItem> midItems;
    public List<DotaItem> lateItems;

    public DotaHero(
        String heroId,
        String heroImage,
        Integer kill,
        Integer death,
        Integer assistance,
        List<DotaItem> startItems,
        List<DotaItem> earlyItems,
        List<DotaItem> midItems,
        List<DotaItem> lateItems
    ) {

    }
}
