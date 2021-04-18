package com.panzerkampfwagen;

/**
 * UFO-t reprezentál. Képes mozgásra meg bányászásra.
 */
public class UFO extends Miner {

	/**
	 * @param r A Receiver amin az egység indul
	 */
	public UFO(Receiver r) {
		super(r);
		Level.subscribeTick(this);
	}

	/**
	 * Ha elpusztított receiveren van, akkor egy véletlen szomszédra kerül át.
	 */
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	/**
	 * Felveszi a nyersanyagot és az megszűnik létezni.
	 * 
	 * @param item a felvett item
	 * @return sikerült e (true ha igen)
	 */
	@Override
	public boolean loadCargo(Item item) {
		return true;
	}
}
