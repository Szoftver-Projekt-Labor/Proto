package com.panzerkampfwagen;

public class Base implements BuildableItem {
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Base;
	}

	@Override
	public boolean dropItem(Unit dropper) {
		return false;
	}

	@Override
	public BuildableItem[] make() {
		Game.victory();
		return new Base[] { new Base() };
	}

	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Coal(), new Coal(), new Coal(), new Ice(), new Ice(), new Ice(), new Iron(), new Iron(),
				new Iron(), new Uranium(), new Uranium(), new Uranium() };
	}
}
