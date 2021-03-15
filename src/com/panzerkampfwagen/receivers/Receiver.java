package com.panzerkampfwagen.receivers;

import java.util.List;
import java.util.ArrayList;

import com.panzerkampfwagen.units.Unit;

public abstract class Receiver {
	protected List<Receiver> neighbours = new ArrayList<>();

	public Receiver[] getNeighbours() {
		return (Receiver[]) neighbours.toArray();
	}

	public abstract void addUnit(Unit unit);

	public abstract void removeUnit(Unit unit);

	public void addNeighbour(Receiver receiver) {
		this.neighbours.add(receiver);
	}

	public void removeNeighbour(Receiver receiver) {
		this.neighbours.remove(receiver);
	}

	public void tick() {
		// Recalculate neighbours
	}
}
