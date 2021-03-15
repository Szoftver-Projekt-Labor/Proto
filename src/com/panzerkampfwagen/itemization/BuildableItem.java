package com.panzerkampfwagen.itemization;

public interface BuildableItem extends Item {
	public Item[] getBill();

	public BuildableItem[] make();
}
