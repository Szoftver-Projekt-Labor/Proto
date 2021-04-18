package com.panzerkampfwagen;

/**
 * Robotot reprezentál. Képes mozogni, fúrni. Telepes megépítheti őt.
 */
public class Robot extends Unit implements BuildableItem {

	/**
	 * @param r A Receiver amin az egység indul
	 */
	public Robot(Receiver r) {
		super(r);
	}

	/**
	 * Ha felrobban a receiver amin van, átkerül egy véletlen szomszédra.
	 */
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	/**
	 * Megépül a robot.
	 * 
	 * @return új robot
	 */
	@Override
	public BuildableItem[] make() {
		return new Robot[] { new Robot(null) };
	}

	/**
	 * Megvizsgálja, hogy az adott item amivel összehasonlítjuk, az robot-e.
	 * 
	 * @param other a hasonlítandó item
	 * @return ugyanolyan e (true ha igen)
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Robot;
	}

	/**
	 * Unit lerakja a robotot.
	 * 
	 * @param dropper az egység aki lerakja
	 * @return sikerült e (true ha igen)
	 */
	@Override
	public boolean dropItem(Unit dropper) {
		dropper.getReceiver().addUnit(this);
		Level.subscribeAll(this);
		return true;
	}

	/**
	 * Visszaadja a robot építéséhez szükséges alapanyagokat.
	 * 
	 * @return robot építéséhez szükséges alapanyagok tömbje
	 */
	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Iron(), new Coal(), new Uranium() };
	}
}
