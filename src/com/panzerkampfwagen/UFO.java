package com.panzerkampfwagen;

public class UFO extends Miner {
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	@Override
	public boolean loadCargo(Item item) {
		return true;
	}
}
