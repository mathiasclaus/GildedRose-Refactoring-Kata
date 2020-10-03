package com.gildedrose.updaters.impl;

import com.gildedrose.Item;
import com.gildedrose.updaters.AbstractItemUpdater;

public class AgedBrieUpdater extends AbstractItemUpdater {
    public AgedBrieUpdater(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (sellByDatePassed()) {
            item.quality = item.quality + 2;
        } else {
            item.quality++;
        }
    }
}
