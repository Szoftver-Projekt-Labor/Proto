package com.panzerkampfwagen.itemization;

import java.util.Map;
import java.util.HashMap;

import com.panzerkampfwagen.other.Base;
import com.panzerkampfwagen.receivers.Gate;
import com.panzerkampfwagen.units.Robot;

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
