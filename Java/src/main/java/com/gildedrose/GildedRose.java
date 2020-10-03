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
            if (!isAgedBrie(item) && !isBackstagePasses(item)) {
                if (item.quality > MINIMUM_QUALITY) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality = item.quality + 1;

                    if (isBackstagePasses(item)) {
                        updateQualityOfBackstagePasses(item);
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < MINIMUM_QUALITY) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        if (item.quality > MINIMUM_QUALITY) {
                            if (!isSulfuras(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = MINIMUM_QUALITY;
                    }
                } else {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
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
        if (item.sellIn <= 10) {
            if (item.quality < MAXIMUM_QUALITY) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn <= 5) {
            if (item.quality < MAXIMUM_QUALITY) {
                item.quality = item.quality + 1;
            }
        }
    }

}