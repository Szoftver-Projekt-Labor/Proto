package com.panzerkampfwagen.itemization;

import com.panzerkampfwagen.units.Settler;

public interface Item {
	public boolean sameAs(Item other);

	public boolean dropItem(Settler dropper);
}
