package nebrog.dotabuff.domain.interactors;

import java.util.List;

import nebrog.dotabuff.data.api.OpenDotaApi;
import nebrog.dotabuff.data.models.DotaHeroDto;
import nebrog.dotabuff.data.models.DotaItemDto;
import nebrog.dotabuff.data.models.DotaItemPopularityDto;
import nebrog.dotabuff.domain.models.DotaHero;
import retrofit2.Call;

/**
 * @author Дмитрий Трубников on 12.01.2022
 */
public class OpenDotaInteractor {

    private OpenDotaApi openDotaApi; // TODO: Положить в переменную

    public DotaHero getHero(final String heroId) {
        DotaHeroDto heroDto = openDotaApi.loadHero(heroId);
        List<DotaItemDto> items = openDotaApi.loadItems();
        DotaItemPopularityDto itemPopularityDto = openDotaApi.getItemPopularity(heroId);

        DotaHero dotaHero = new DotaHero(
                heroDto.heroId,
                "https://api.opendota.com/" + heroDto.tailImageUrl,
                0,
                0,
                0,
                itemPopularityDto.itemsPopularity.keySet(),
                // ...
        );

        return dotaHero;
    }
}
