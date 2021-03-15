package com.panzerkampfwagen;

import java.util.Random;

public class Robot extends Unit implements BuildableItem {
	@Override
	public void onReceiverDestroyed() {
		Receiver[] destinations = this.receiver.getNeighbours();
		int randomDest = new Random().nextInt(destinations.length);

		this.receiver.removeUnit(this);
		destinations[randomDest].addUnit(this);
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
	public boolean dropItem(Settler dropper) {
		dropper.getReceiver().addUnit(this);
		Game.getLevel().addThing(this);
		return true;
	}

	@Override
	public Item[] getBill() {
		return new Item[] { new Iron(), new Coal(), new Uranium() };
	}
}
