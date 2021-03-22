package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public abstract class Receiver {
	protected List<Receiver> neighbours = new ArrayList<>();

	public Receiver[] getNeighbours() {
		System.out.println("getNeighbours");
		return (Receiver[]) neighbours.toArray();
	}

	public Receiver getNeighbour(int i) {
		System.out.println("getNeighbour");
		if (i >= 0 && i < neighbours.size())
			return neighbours.get(i);
		return null;
	}

	public abstract void addUnit(Unit unit);

	public abstract void removeUnit(Unit unit);

	public void addNeighbour(Receiver receiver) {
		System.out.println("addNeighbour");
		this.neighbours.add(receiver);
	}

	public void removeNeighbour(Receiver receiver) {
		System.out.println("removeNeighbour");
		this.neighbours.remove(receiver);
	}

	public void tick() {
		System.out.println("tick");
		// Recalculate neighbours
	}
}
