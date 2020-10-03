package com.gildedrose.updaters.impl;

import com.gildedrose.Item;
import com.gildedrose.updaters.AbstractItemUpdater;

public class BackStagePassesUpdater extends AbstractItemUpdater {
    public BackStagePassesUpdater(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (sellByDatePassed()) {
            item.quality = MINIMUM_QUALITY;
        } else if (item.sellIn >= 5 && item.sellIn < 10) {
            item.quality = item.quality + 2;
        } else if (item.sellIn >= 0 && item.sellIn < 5) {
            item.quality = item.quality + 3;
        } else {
            item.quality++;
        }
    }
}
