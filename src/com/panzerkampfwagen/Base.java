package com.panzerkampfwagen;

public class Base implements BuildableItem {
	@Override
	public boolean sameAs(Item other) {
		System.out.println("Base.sameAs");
		return other instanceof Base;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		System.out.println("Base.dropItem");
		return false;
	}

	@Override
	public BuildableItem[] make() {
		System.out.println("Base.make");
		Game.victory();
		return new Base[] { new Base() };
	}

	@Override
	public Item[] getBill() {
		System.out.println("Base.getBill");
		return new Item[] { new Struts(), new Struts(), new Struts(), new Struts() };
	}
}
