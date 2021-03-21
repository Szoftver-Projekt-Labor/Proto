package com.panzerkampfwagen;

public interface BuildableItem extends Item {
	public Item[] getBuildCost();

	public BuildableItem[] make();
}
