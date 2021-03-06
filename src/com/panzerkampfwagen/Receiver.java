package com.panzerkampfwagen;

import java.util.List;
import java.util.Random;

import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.util.ArrayList;
import java.awt.*;

// TODO: NoNeighbourException uses
/**
 * Mezőt reprezentál.
 */
public abstract class Receiver implements Tickable {
	protected List<Receiver> neighbours = new ArrayList<>();

	public abstract void drawNeighbour(Graphics g, Layout l, Texture t, Integer slot);

	public void draw(Graphics g, Layout l, Texture t, Integer page){
		int d = (page-1)*11;
		int p =neighbours.size()- (neighbours.size()%d);
		int max = Integer.max(p+11, neighbours.size());
		for(int i= p; i< max; i++){
			neighbours.get(i).drawNeighbour(g, l, t, i-p+1);
		}
	}

	/**
	 * Visszaadja az adott receiver szomszédainak a listáját.
	 * 
	 * @return receiver szomszédainak a listája
	 */
	public List<Receiver> getNeighbours() {
		return neighbours;
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
	 * Cleans up after the unit leaves.
	 * 
	 * @param unit
	 */
	public abstract void removeUnit(Unit unit);

	/**
	 * @return the status of the object
	 */
	@Override
	public String status() {
		return this + ":\n\tneighbours: " + Utils.joinList(neighbours);
	}
}
