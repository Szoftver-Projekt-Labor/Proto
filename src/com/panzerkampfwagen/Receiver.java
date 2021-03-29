package com.panzerkampfwagen;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

// TODO: No neighbour exception uses
public abstract class Receiver implements Tickable {
	protected List<Receiver> neighbours = new ArrayList<>();

	public Receiver[] getNeighbours() {
		return (Receiver[]) neighbours.toArray();
	}

	public Receiver getNeighbour(int i) {
		if (i >= 0 && i < neighbours.size())
			return neighbours.get(i);
		return null;
	}

	public Receiver getRandomNeighbour() {
		int nNeighbours = this.neighbours.size();
		if (nNeighbours == 0)
			return null;
		return this.neighbours.get(new Random().nextInt(nNeighbours));
	}

	public void addNeighbour(Receiver receiver) {
		this.neighbours.add(receiver);
	}

	public void removeNeighbour(Receiver receiver) {
		this.neighbours.remove(receiver);
	}

	public abstract void addUnit(Unit unit);

	/**
	 * Cleans up after the unit leaves. *Doesn't* change the Unit.receiver
	 * 
	 * @param unit
	 */
	public void removeUnit(Unit unit) {
	}
}
