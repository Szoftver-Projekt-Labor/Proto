package com.panzerkampfwagen;

/**
 * Inteface, az építhető tárgyak megvalósításáért felel.
 */
public interface BuildableItem extends Item {
	public Item[] getBuildCost();

	public BuildableItem[] make();
}
