package com.panzerkampfwagen;

public class Struts implements BuildableItem {
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Struts;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		return false;
	}

	@Override
	public Item[] getBill() {
		return new Item[] { new Coal(), new Iron(), new Ice(), new Uranium() };
	}

	@Override
	public BuildableItem[] make() {
		return new BuildableItem[] { new Struts() };
	}
}
