package com.panzerkampfwagen;

public class Robot extends Unit implements BuildableItem {
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	@Override
	public BuildableItem[] make() {
		return new Robot[] { new Robot() };
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Robot;
	}

	@Override
	public boolean dropItem(Unit dropper) {
		dropper.getReceiver().addUnit(this);
		Level.subscribeAll(this);
		return true;
	}

	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Iron(), new Coal(), new Uranium() };
	}
}
