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

	public static BuildableItem getItem(String itemName) {
		return items.get(itemName);
	}
}