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
	public Item[] getBuildCost() {
		System.out.println("Base.getBuildCost");
		return new Item[] { new Coal(), new Coal(), new Coal(), new Ice(), new Ice(), new Ice(), new Iron(), new Iron(),
				new Iron(), new Uranium(), new Uranium(), new Uranium() };
	}
}
