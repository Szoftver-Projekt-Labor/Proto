package com.panzerkampfwagen;

import java.util.Random;

public class Robot extends Unit implements BuildableItem {
	@Override
	public void onReceiverDestroyed() {
		System.out.println("Robot.onReceiverDestroyed");
		Receiver[] destinations = this.receiver.getNeighbours();
		int randomDest = new Random().nextInt(destinations.length);

		this.receiver.removeUnit(this);
		destinations[randomDest].addUnit(this);
	}

	@Override
	public BuildableItem[] make() {
		System.out.println("Robot.make");
		return new Robot[] { new Robot() };
	}

	@Override
	public boolean sameAs(Item other) {
		System.out.println("Robot.sameAs");
		return other instanceof Robot;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		System.out.println("Robot.dropItem");
		dropper.getReceiver().addUnit(this);
		Game.getLevel().addThing(this);
		return true;
	}

	@Override
	public Item[] getBill() {
		System.out.println("Robot.getBill");
		return new Item[] { new Iron(), new Coal(), new Uranium() };
	}
}
