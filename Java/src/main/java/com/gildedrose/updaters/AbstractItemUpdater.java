package com.gildedrose.updaters;

import com.gildedrose.Item;

public abstract class AbstractItemUpdater implements ItemUpdater{
    private static final int MAXIMUM_QUALITY = 50;
    protected static final int MINIMUM_QUALITY = 0;
    protected static final int DEFAULT_QUALITY_FACTOR = 1;
    protected static final int DEFAULT_PAST_SELL_BY_DATE_QUALITY_FACTOR = 2;

    protected final Item item;

    public AbstractItemUpdater(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
        enforceQualityBoundaries();
    }

    protected abstract void updateQuality();

    protected boolean sellByDatePassed() {
        return item.sellIn < 0;
    }

    private void updateSellIn() {
        item.sellIn--;
    }

    private void enforceQualityBoundaries() {
        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }

        if (item.quality > MAXIMUM_QUALITY) {
            item.quality = MAXIMUM_QUALITY;
        }
    }
}
