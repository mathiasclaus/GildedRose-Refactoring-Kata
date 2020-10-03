package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item)) {
                return; // TODO handle edge case better, but this cleans up the code for now
            }

            item.sellIn--;

            if (qualityIncreasesByAge(item)) {
                item.quality++;

                if (isBackstagePasses(item)) {
                    updateQualityOfBackstagePasses(item);
                }
            } else {
                item.quality--;
            }


            if (sellByDatePassed(item)) {
                if (qualityIncreasesByAge(item)) {
                    if (isBackstagePasses(item)) {
                        item.quality = MINIMUM_QUALITY;
                    } else {
                        item.quality++;
                    }
                } else {
                    item.quality--;
                }
            }

            if (item.quality < MINIMUM_QUALITY) {
                item.quality = MINIMUM_QUALITY;
            }

            if (item.quality > MAXIMUM_QUALITY) {
                item.quality = MAXIMUM_QUALITY;
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    private boolean isBackstagePasses(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }

    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.name);
    }

    private void updateQualityOfBackstagePasses(Item item) {
        if (item.sellIn < 10) {
            item.quality++;
        }

        if (item.sellIn < 5) {
            item.quality++;
        }
    }

    private boolean qualityIncreasesByAge(Item item) {
        return isAgedBrie(item) || isBackstagePasses(item);
    }

    private boolean sellByDatePassed(Item item) {
        return item.sellIn < 0;
    }

}