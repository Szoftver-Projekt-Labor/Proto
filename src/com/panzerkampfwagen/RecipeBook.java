package com.panzerkampfwagen;

import java.util.Map;
import java.util.HashMap;

public class RecipeBook {
	private static Map<String, BuildableItem> items = new HashMap<String, BuildableItem>();

	static {
		items.put("robot", new Robot());
		items.put("base", new Base());
		items.put("gate", new Gate());
		items.put("struts", new Struts());
	}

	public static BuildableItem getItem(String itemName) {
		System.out.println("RecipeBook.getItem");
		return items.get(itemName);
	}
}
