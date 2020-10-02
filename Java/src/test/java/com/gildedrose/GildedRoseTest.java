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
    @DisplayName("When sellin is positive, the quality decreases by one")
    void whenSellinPositiveQualityDecreasesByOne() {
        Item[] items = { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellin is zero, the quality decreases by two")
    void whenSellinZeroQualityDecreasesByTwo() {
        Item[] items = { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    @DisplayName("When sellin is negative, the quality decreases by two")
    void whenSellinNegativeQualityDecreasesByTwo() {
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
    @DisplayName("when sellin is positive, Aged Brie quality increases by one")
    void whenSellinPositiveAgedBrieQualityIncreasesByOne() {
        Item[] items = { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("when sellin is zero, Aged Brie increases double in quality")
    void whenSellinZeroAgedBrieQualityIncreasesDouble() {
        Item[] items = { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    @DisplayName("when sellin is negative, Aged Brie increases double in quality")
    void whenSellinNegativeAgedBrieQualityIncreasesDouble() {
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

}
