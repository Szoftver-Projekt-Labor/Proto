package com.panzerkampfwagen;

public interface BuildableItem extends Item {
	public Item[] getBill();

	public BuildableItem[] make();
}
