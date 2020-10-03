package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.factory.ItemUpdaterFactory;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .filter(Objects::nonNull)
                .map(ItemUpdaterFactory::create)
                .forEach(ItemUpdater::update);
    }
}