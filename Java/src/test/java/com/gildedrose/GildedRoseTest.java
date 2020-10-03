package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("The name does not change after updating quality")
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
    @DisplayName("SellIn lowers of all items")
    void sellInLowersOfAllItems() {
        Item[] items = {
                new Item("foo", 1, 10),
                new Item("bar", -10, 20),
                new Item("Something that random that will never be picked", 10000, 30)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(-11, app.items[1].sellIn);
        assertEquals(9999, app.items[2].sellIn);
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
    @DisplayName("The quality of an item is never negative")
    void qualityNeverNegative() {
        Item[] items = { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Quality lowers of all items")
    void qualityLowersOfAllItems() {
        Item[] items = {
                new Item("foo", 1, 10),
                new Item("bar", -10, 20),
                new Item("Something that random that will never be picked", 10000, 30)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(18, app.items[1].quality);
        assertEquals(29, app.items[2].quality);
    }

    @Test
    @DisplayName("Null items are ignored")
    void nullItemsAreIgnored() {
        Item[] items = {
                new Item("foo", 1, 10),
                null
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    @DisplayName("When item name is null, the quality is still decreased by default amount")
    void itemNameIsNull() {
        Item[] items = {new Item(null, 1, 10),};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Nested
    @DisplayName("Quality of Aged Brie")
    class AgedBrieQuality {
        @Test
        @DisplayName("increases by one when sellIn is positive")
        void increasesByOneWhenSellInPositive() {
            Item[] items = { new Item("Aged Brie", 1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(11, app.items[0].quality);
        }

        @Test
        @DisplayName("increase by two when sellIn is zero")
        void increasesByTwoWhenSellInZero() {
            Item[] items = { new Item("Aged Brie", 0, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
        }

        @Test
        @DisplayName("increases by two when sellIn is negative")
        void increasesByTwoWhenSellInNegative() {
            Item[] items = { new Item("Aged Brie", -1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
        }
    }

    @Test
    @DisplayName("the quality of an item is never more than 50")
    void qualityOfItemNeverMoreThan50() {
        Item[] items = { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Nested
    @DisplayName("Sulfuras")
    class Sulfuras {
        @Test
        @DisplayName("does not decrease in sellIn")
        void doesNotDecreasInSellIn() {
            Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(1, app.items[0].sellIn);
        }

        @Test
        @DisplayName("does not decrease in quality")
        void doesNotDecreasInQuality() {
            Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(80, app.items[0].quality);
        }
    }



    @Nested
    @DisplayName("Quality of backstage passes ")
    class BackStagePassesQuality {
        @Test
        @DisplayName("increases by one when sellIn above 10")
        void increasesByOneWhenSellInAboveTen() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(11, app.items[0].quality);
        }


        @Test
        @DisplayName("increases by two when sellIn is 10")
        void increasesByTwoWhenSellInIsTen() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
        }

        @Test
        @DisplayName("increases by two when sellIn is between 5 and 10")
        void increasesByTwoWhenSellInIsBetweenFiveAndTen() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
        }

        @Test
        @DisplayName("increases by three when sellIn is 5")
        void increasesByThreeWhenSellInIsFive() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(13, app.items[0].quality);
        }

        @Test
        @DisplayName("increases by three when sellIn is between 0 and 5")
        void increasesByThreeWhenSellInIsBetweenZeroAndFive() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(13, app.items[0].quality);
        }

        @Test
        @DisplayName("drops to 0 when sellIn is 0")
        void dropsToZeroWhenSellInIsZero() {
            Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        @DisplayName("drops to 0 when sellIn is negative")
        void dropsToZeroWhenSellInIsNegative() {
            Item[] items = { new Item("Backstage passes to a heavy metal concert", -1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    @DisplayName("Quality of conjured items")
    class ConjuredItemsQuality {
        @Test
        @DisplayName("decreases by two (twice as fast as normal) when sellIn is positive")
        void decreasesByTwoWhenSellInPositive() {
            Item[] items = { new Item("Conjured Mana Cake", 1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(8, app.items[0].quality);
        }

        @Test
        @DisplayName("increase by four (twice as fast as normal) when sellIn is zero")
        void decreasesByFourWhenSellInZero() {
            Item[] items = { new Item("Conjured Pizza", 0, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(6, app.items[0].quality);
        }

        @Test
        @DisplayName("decreases by four (twice as fast as normal) when sellIn is negative")
        void decreasesByFourWhenSellInNegative() {
            Item[] items = { new Item("Conjured Sword of Zorg", -1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(6, app.items[0].quality);
        }

        @Test
        @DisplayName("is never negative")
        void qualityOfItemNeverMoreThan50() {
            Item[] items = { new Item("Conjured Code", -1, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

    }
}
