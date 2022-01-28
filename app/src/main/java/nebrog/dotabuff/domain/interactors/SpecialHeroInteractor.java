package nebrog.dotabuff.domain.interactors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Single;
import nebrog.dotabuff.data.api.DotaAPI;
import nebrog.dotabuff.data.models.HeroStatsPOJO;
import nebrog.dotabuff.data.models.ItemListPOJO;
import nebrog.dotabuff.domain.models.SpecialHeroModel;

public class SpecialHeroInteractor {


    private final DotaAPI dotaAPI = DotaAPI.SINGLETON;


    public Single<SpecialHeroModel> loadHero(int id) {

        Single<SpecialHeroModel> specialHeroModelSingle = Single.zip(
                dotaAPI.loadItemList(),
                dotaAPI.loadItems(id),
                dotaAPI.loadStats(),
                (a, b, c) -> {
                    HeroStatsPOJO hero = findHero(id, c);
                    List<String> startItems = sortItems(b.start_game_items);
                    List<String> earlyItems = sortItems(b.early_game_items);
                    List<String> midItems = sortItems(b.mid_game_items);
                    List<String> lateItems = sortItems(b.late_game_items);
                    List<String> findStartItems = findItems(startItems, a);
                    List<String> findEarlyItems = findItems(earlyItems, a);
                    List<String> findMidItems = findItems(midItems, a);
                    List<String> findLateItems = findItems(lateItems, a);


                    return new SpecialHeroModel(
                            hero.name,
                            hero.turboWin,
                            "https://api.opendota.com" + hero.icon,
                            findStartItems,
                            findEarlyItems,
                            findMidItems,
                            findLateItems
                    );
                }
        );
        return specialHeroModelSingle;
    }

    private List<String> sortItems(Map<String, Integer> typeGame) {
        Set<Map.Entry<String, Integer>> itemsHeroStart = typeGame.entrySet();
        List<Map.Entry<String, Integer>> ihs = new ArrayList<>(itemsHeroStart);
        ihs.sort(new SortItems());
        List<String> list = new ArrayList<>();
        for (int x = 0; x < 6; x++) {
            String itemID = ihs.get(x).getKey();
            list.add(itemID);
        }
        return list;


    }

    private HeroStatsPOJO findHero(int heroId, List<HeroStatsPOJO> heroes) throws Exception {
        for (int x = 0; x < heroes.size(); x++) {
            HeroStatsPOJO heroStatsPOJO = heroes.get(x);
            if (heroStatsPOJO.id == heroId) {
                return heroStatsPOJO;
            }
        }
        throw new Exception();
    }

    private List<String> findItems(List<String> list, Map<String, ItemListPOJO> items) {
        Collection<ItemListPOJO> itemListPOJOS = items.values();
        Map<Integer, String> idImg = new HashMap<>();
        List<String> itemsImg = new ArrayList<>();
        for (ItemListPOJO item : itemListPOJOS) {
            idImg.put(item.id, item.img);
        }
        for (int x = 0; x < list.size(); x++) {
            String m = list.get(x);
            itemsImg.add("https://api.opendota.com" + idImg.get(Integer.valueOf(m)));

        }
        return itemsImg;
    }

    private class SortItems implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            int x = o1.getValue() - o2.getValue();
            return -x;
        }

    }

}



