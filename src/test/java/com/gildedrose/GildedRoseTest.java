package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String NONAME = "noname";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

	private void assertUpdateQuality(String name, int sellIn, int quality,
									 int expectedSellIn, int expectedQuality) {
		Item[] items = new Item[]{new Item(name, sellIn, quality)};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(expectedSellIn, items[0].sellIn, "sellIn 불일치");
		assertEquals(expectedQuality, items[0].quality, "quality 불일치");
	}

	@Test
	public void should_be_nothing_when_no_item() {
		Item[] items = new Item[]{};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(0, items.length);
	}


	@Test
	public void normal_item_sellin_0_quality_0() {
		assertUpdateQuality(NONAME, 0, 0, -1, 0);
	}

	@Test
	public void normal_item_sellin_0_quality_1() {
		assertUpdateQuality(NONAME, 0, 1, -1, 0);
	}

	@Test
	public void normal_item_sellin_5_quality_10() {
		assertUpdateQuality(NONAME, 5, 10, 4, 9);
	}


	@Test
	public void sulfuras_sellin_0_quality_80() {
		assertUpdateQuality(SULFURAS, 0, 80, 0, 80);
	}

	@Test
	public void sulfuras_sellin_m2_quality_80() {
		assertUpdateQuality(SULFURAS, -2, 80, -2, 80);
	}

	@Test
	public void agedBrie_sellin_0_quality_0() {
		assertUpdateQuality(AGED_BRIE, 0, 0, -1, 2);
	}

	@Test
	public void agedBrie_sellin_5_quality_10() {
		assertUpdateQuality(AGED_BRIE, 5, 10, 4, 11);
	}

	@Test
	public void agedBrie_sellin_0_quality_50() {
		assertUpdateQuality(AGED_BRIE, 0, 50, -1, 50);
	}


	@Test
	public void backstagePass_sellin_0_quality_0() {
		assertUpdateQuality(BACKSTAGE_PASS, 0, 0, -1, 0);
	}

	@Test
	public void backstagePass_sellin_0_quality_49() {
		assertUpdateQuality(BACKSTAGE_PASS, 0, 49, -1, 0);
	}

	@Test
	public void backstagePass_sellin_12_quality_0() {
		assertUpdateQuality(BACKSTAGE_PASS, 12, 0, 11, 1);
	}

	@Test
	public void backstagePass_sellin_8_quality_10() {
		assertUpdateQuality(BACKSTAGE_PASS, 8, 10, 7, 12);
	}

	@Test
	public void backstagePass_sellin_3_quality_10() {
		assertUpdateQuality(BACKSTAGE_PASS, 3, 10, 2, 13);
	}

}