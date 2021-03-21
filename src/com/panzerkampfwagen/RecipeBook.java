package com.panzerkampfwagen;

import java.util.Map;
import java.util.HashMap;

public class RecipeBook {
	private static Map<String, BuildableItem> items = new HashMap<String, BuildableItem>();

	static {
		items.put("robot", new Robot());
		items.put("base", new Base());
		items.put("gate", new Gate());
	}

	public static Bill getBill(String itemName) {
		System.out.println("RecipeBook.getBill");
		return new Bill(items.get(itemName));
	}
}
