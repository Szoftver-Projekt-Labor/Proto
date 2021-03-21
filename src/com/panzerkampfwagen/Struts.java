package com.panzerkampfwagen;

public class Struts implements BuildableItem {
	@Override
	public boolean sameAs(Item other) {
		System.out.println("Struts.sameAs");
		return other instanceof Struts;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		System.out.println("Struts.dropItem");
		return false;
	}

	@Override
	public Item[] getBill() {
		System.out.println("Struts.getBill");
		return new Item[] { new Coal(), new Iron(), new Ice(), new Uranium() };
	}

	@Override
	public BuildableItem[] make() {
		System.out.println("Struts.make");
		return new BuildableItem[] { new Struts() };
	}
}
