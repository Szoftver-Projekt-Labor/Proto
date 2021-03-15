package com.panzerkampfwagen.other;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.itemization.BuildableItem;
import com.panzerkampfwagen.itemization.Item;
import com.panzerkampfwagen.itemization.Struts;
import com.panzerkampfwagen.units.Settler;

public class Base implements BuildableItem {
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Base;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		return false;
	}

	@Override
	public BuildableItem[] make() {
		Game.victory();
		return new Base[] { new Base() };
	}

	@Override
	public Item[] getBill() {
		return new Item[] { new Struts(), new Struts(), new Struts(), new Struts() };
	}
}
