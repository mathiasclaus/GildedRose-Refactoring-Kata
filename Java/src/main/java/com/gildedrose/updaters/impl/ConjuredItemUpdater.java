package com.gildedrose.updaters.impl;

import com.gildedrose.Item;
import com.gildedrose.updaters.AbstractItemUpdater;

public class ConjuredItemUpdater extends AbstractItemUpdater {
    public ConjuredItemUpdater(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.quality = sellByDatePassed()
                ? item.quality - 2 * DEFAULT_PAST_SELL_BY_DATE_QUALITY_FACTOR
                : item.quality - 2 * DEFAULT_QUALITY_FACTOR;
    }
}
