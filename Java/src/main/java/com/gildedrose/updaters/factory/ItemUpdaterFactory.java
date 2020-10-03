package com.gildedrose.updaters.factory;

import com.gildedrose.Item;
import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.impl.AgedBrieUpdater;
import com.gildedrose.updaters.impl.BackStagePassesUpdater;
import com.gildedrose.updaters.impl.DefaultItemUpdater;
import com.gildedrose.updaters.impl.LegendaryItemUpdater;

public class ItemUpdaterFactory {
    public static ItemUpdater create(final Item item) {
        return switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> new LegendaryItemUpdater();
            case "Aged Brie" -> new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackStagePassesUpdater(item);
            default -> new DefaultItemUpdater(item);
        };
    }

}
