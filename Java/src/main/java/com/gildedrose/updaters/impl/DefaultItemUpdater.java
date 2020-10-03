package com.gildedrose.updaters.impl;

import com.gildedrose.Item;
import com.gildedrose.updaters.AbstractItemUpdater;

public class DefaultItemUpdater extends AbstractItemUpdater {
    public DefaultItemUpdater(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (sellByDatePassed()) {
            item.quality = item.quality - 2;
        } else {
            item.quality--;
        }
    }
}
