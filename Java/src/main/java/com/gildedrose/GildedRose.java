package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (isSulfuras(item)) {
                return; // TODO handle edge case better, but this cleans up the code for now
            }

            item.sellIn--;

            if (isAgedBrie(item)) {
                updateQualityOfAgedBrie(item);
            } else if (isBackstagePasses(item)) {
                updateQualityOfBackstagePasses(item);
            } else {
                updateQualityDefault(item);
            }

            enforceQualityBoundaries(item);
        }
    }

    private boolean isSulfuras(final Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    private boolean isBackstagePasses(final Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }

    private boolean isAgedBrie(final Item item) {
        return "Aged Brie".equals(item.name);
    }

    private void updateQualityDefault(final Item item) {
        if (sellByDatePassed(item)) {
            item.quality = item.quality - 2;
        } else {
            item.quality--;
        }
    }

    private void updateQualityOfAgedBrie(final Item item) {
        if (sellByDatePassed(item)) {
            item.quality = item.quality + 2;
        } else {
            item.quality++;
        }
    }

    private void updateQualityOfBackstagePasses(final Item item) {
        if (sellByDatePassed(item)) {
            item.quality = MINIMUM_QUALITY;
        } else if (item.sellIn >= 5 && item.sellIn < 10) {
            item.quality = item.quality + 2;
        } else if (item.sellIn >= 0 && item.sellIn < 5) {
            item.quality = item.quality + 3;
        } else {
            item.quality++;
        }
    }

    private boolean sellByDatePassed(final Item item) {
        return item.sellIn < 0;
    }

    private void enforceQualityBoundaries(final Item item) {
        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }

        if (item.quality > MAXIMUM_QUALITY) {
            item.quality = MAXIMUM_QUALITY;
        }
    }
}