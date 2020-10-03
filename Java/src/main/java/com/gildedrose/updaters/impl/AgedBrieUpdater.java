package com.gildedrose.updaters.impl;

import com.gildedrose.Item;
import com.gildedrose.updaters.AbstractItemUpdater;

public class AgedBrieUpdater extends AbstractItemUpdater {
    public AgedBrieUpdater(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.quality = sellByDatePassed()
                ? item.quality + DEFAULT_PAST_SELL_BY_DATE_QUALITY_FACTOR
                : item.quality + DEFAULT_QUALITY_FACTOR;
    }
}
