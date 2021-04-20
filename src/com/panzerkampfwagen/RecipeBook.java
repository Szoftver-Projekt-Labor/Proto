package com.panzerkampfwagen;

import java.util.Map;

import com.panzerkampfwagen.units.Robot;

import java.util.HashMap;

/**
 * Egy string-hez rendel egy BuidableItemet.
 */
public class RecipeBook {
	private static Map<String, BuildableItem> items = new HashMap<String, BuildableItem>();

	/**
	 * Inicalizálja az items-t.
	 */
	static {
		items.put("robot", new Robot(null, null));
		items.put("base", new Base());
		items.put("gate", new Gate());
	}

	/**
	 * Visszaadja a paraméterben kapott item receptjét.
	 * 
	 * @param itemName az item neve (aminek kell a receptje)
	 * @return új recept az itemről
	 */
	public static Bill getBill(String itemName) {
		return new Bill(items.get(itemName));
	}
}
