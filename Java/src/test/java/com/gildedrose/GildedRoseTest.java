package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("The name does not change after update quality")
    void nameDoesNotChange() {
        Item[] items = { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("SellIn lowers when updating quality")
    void sellInLowersWhenUpdatingQuality() {
        Item[] items = { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    @DisplayName("When sellIn is positive, the quality decreases by one")
    void whenSellInPositiveQualityDecreasesByOne() {
        Item[] items = { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is zero, the quality decreases by two")
    void whenSellInZeroQualityDecreasesByTwo() {
        Item[] items = { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is negative, the quality decreases by two")
    void whenSellInNegativeQualityDecreasesByTwo() {
        Item[] items = { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    @DisplayName("The quality of an item is not negative after update quality")
    void qualityNotNegative() {
        Item[] items = { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("when sellIn is positive, Aged Brie quality increases by one")
    void whenSellInPositiveAgedBrieQualityIncreasesByOne() {
        Item[] items = { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("when sellIn is zero, Aged Brie increases double in quality")
    void whenSellInZeroAgedBrieQualityIncreasesDouble() {
        Item[] items = { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("when sellIn is negative, Aged Brie increases double in quality")
    void whenSellInNegativeAgedBrieQualityIncreasesDouble() {
        Item[] items = { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("the quality of an item is never more than 50")
    void qualityOfItemNeverMoreThan50() {
        Item[] items = { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    @DisplayName("Sulfuras does not decrease in quality")
    void sulfurasDoesNotDecreasInQuality() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn above 10, backstage passes quality increases by one")
    void whenSellInAboveTenThenBackstagePassQualityIncreasesByOne() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }


    @Test
    @DisplayName("When sellIn is 10, backstage passes quality increases by two")
    void whenSellInIsTenThenBackstagePassQualityIncreasesByTwo() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is between 5 and 10, backstage passes quality increases by two")
    void whenSellInIsBetweenFiveAndTenThenBackstagePassQualityIncreasesByTwo() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is 5, backstage passes quality increases by three")
    void whenSellInIsFiveThenBackstagePassQualityIncreasesByThree() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is between 0 and 5, backstage passes quality increases by three")
    void whenSellInIsBetweenZeroAndFiveThenBackstagePassQualityIncreasesByThree() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is 0, backstage passes quality drops to zero")
    void whenSellInIsZeroThenBackstagePassQualityDropsToZero() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellIn is negative, backstage passes quality drops to zero")
    void whenSellInIsNegativeThenBackstagePassQualityDropsToZero() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
