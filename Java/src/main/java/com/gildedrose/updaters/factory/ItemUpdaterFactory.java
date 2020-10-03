package com.gildedrose.updaters.factory;

import com.gildedrose.Item;
import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.impl.AgedBrieUpdater;
import com.gildedrose.updaters.impl.BackStagePassesUpdater;
import com.gildedrose.updaters.impl.ConjuredItemUpdater;
import com.gildedrose.updaters.impl.DefaultItemUpdater;
import com.gildedrose.updaters.impl.LegendaryItemUpdater;

public class ItemUpdaterFactory {
    public static ItemUpdater create(final Item item) {
        if (item.name == null) {
            return new DefaultItemUpdater(item);
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new LegendaryItemUpdater();
        } else if ("Aged Brie".equals(item.name)) {
            return new AgedBrieUpdater(item);
        } else if (item.name.startsWith("Backstage passes")) {
            return new BackStagePassesUpdater(item);
        } else if (item.name.startsWith("Conjured")) {
            return new ConjuredItemUpdater(item);
        } else {
            return new DefaultItemUpdater(item);
        }
    }
}
