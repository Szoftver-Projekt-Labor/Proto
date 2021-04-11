package com.panzerkampfwagen;

public interface Item {
	public boolean sameAs(Item other);

	public boolean dropItem(Unit dropper);
}
