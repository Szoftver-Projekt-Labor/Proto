package com.panzerkampfwagen;

import java.util.List;
import java.util.Random;

import com.panzerkampfwagen.units.Unit;

import java.util.ArrayList;

// TODO: NoNeighbourException uses
/**
 * Mezőt reprezentál.
 */
public abstract class Receiver implements Tickable {
	protected List<Receiver> neighbours = new ArrayList<>();

	/**
	 * Visszaadja az adott receiver szomszédainak a listáját.
	 * 
	 * @return receiver szomszédainak a listája
	 */
	public Receiver[] getNeighbours() {
		return (Receiver[]) neighbours.toArray();
	}

	/**
	 * Visszaadja a paraméterben megadott indexű szomszédot
	 * 
	 * @param i szomszéd indexe
	 * @return receiver szomszédja
	 */
	public Receiver getNeighbour(int i) {
		if (i >= 0 && i < neighbours.size())
			return neighbours.get(i);
		return null;
	}

	/**
	 * Visszaad egy véletlen szomszédot.
	 * 
	 * @return receiver szomszédja
	 */
	public Receiver getRandomNeighbour() {
		int nNeighbours = this.neighbours.size();
		if (nNeighbours == 0)
			return null;
		return this.neighbours.get(new Random().nextInt(nNeighbours));
	}

	/**
	 * Hozzáad egy új szomszédot.
	 * 
	 * @param receiver új szomszéd
	 */
	public void addNeighbour(Receiver receiver) {
		this.neighbours.add(receiver);
	}

	/**
	 * Eltávolít egy szomszédot
	 * 
	 * @param receiver eltávolítandó szomszéd
	 */
	public void removeNeighbour(Receiver receiver) {
		this.neighbours.remove(receiver);
	}

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 */
	public abstract boolean addUnit(Unit unit);

	/**
	 * Cleans up after the unit leaves. *Doesn't* change the Unit.receiver
	 * 
	 * @param unit
	 */
	public void removeUnit(Unit unit) {
	}
}
