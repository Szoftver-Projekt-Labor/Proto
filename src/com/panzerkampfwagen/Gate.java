package com.panzerkampfwagen;

import java.lang.ref.WeakReference;

import com.panzerkampfwagen.resources.Ice;
import com.panzerkampfwagen.resources.Iron;
import com.panzerkampfwagen.resources.Uranium;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Egy olyan speciális mezőt reprezentál, amire ha rálépünk, akkor egy másikon
 * találjuk magunkat.
 */
public class Gate extends Receiver implements BuildableItem, AllEventCompatible {
	protected WeakReference<Gate> pair;
	private boolean on = false;
	private boolean placed = false;
	private boolean damaged = false;

	/**
	 * Visszaadja a kapu párját.
	 * 
	 * @return a kapu párja
	 */
	public Gate getPair() {
		return this.pair.get();
	}

	/**
	 * A kapunak új szomszédot állít be.
	 */
	private void changeAnchor() {
		Asteroid anchor = (Asteroid) this.neighbours.get(0);
		this.neighbours.remove(0);
		this.neighbours.add(anchor.getRandomNeighbour());
	}

	/**
	 * Ha a kapu be van kapcsolva, akkor rálép az egység.
	 * 
	 * @param unit egy egység amit hozzáad
	 * @return igaz, ha van rajta unit
	 */
	@Override
	public boolean addUnit(Unit unit) {
		if (this.on) {
			unit.setReceiver(this.pair.get());
			return true;
		}
		return false;
	}

	@Override
	public void removeUnit(Unit unit) {
	}

	/**
	 * Eltávolítja a paraméterben megadott szomszédját.
	 * 
	 * @param receiver kapu vagy aszteroida, amit eltávolítunk
	 */
	@Override
	public void removeNeighbour(Receiver receiver) {
		this.changeAnchor();
	}

	// #region Event handlers

	/**
	 * Ha sérült a kapu, akkor folyamatosan változtatja a szomszédját.
	 */
	@Override
	public void tick() {
		if (!this.damaged)
			return;
		this.changeAnchor();
	}

	/**
	 * Átállítja a damaged attribútomot true-ra
	 */
	@Override
	public void onSolarStorm() {
		this.damaged = true;
	}

	// #endregion

	// #region Item & BuildableItem implementations

	/**
	 * Gate típusú-e a paraméterben megadott item.
	 * 
	 * @param other item, amivel összehasonlítja
	 * @return igaz, ha egyezés van
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Gate;
	}

	/**
	 * Lehelyezi a kaput.
	 * 
	 * @param dropper az az egység, amelyik lehelyezi
	 * @return igaz, ha sikerült letenni
	 */
	@Override
	public boolean dropItem(Unit dropper) {
		Level.subscribeAll(this);
		this.placed = true;
		Gate pair = this.pair.get();
		if (pair.placed) {
			this.on = true;
			pair.on = true;
		}
		this.tick();

		Asteroid anchor = dropper.getAsteroid();
		if (anchor == null)
			return false;
		this.addNeighbour(anchor);
		anchor.addNeighbour(this);
		return true;
	}

	/**
	 * Készít egy kapupárt.
	 * 
	 * @return sikerült-e betölteni a kapukat a telepes inventory-jába
	 */
	@Override
	public boolean onMake(Settler creator) {
		Gate[] pairOfGates = new Gate[2];
		pairOfGates[0] = new Gate();
		pairOfGates[1] = new Gate();

		pairOfGates[0].pair = new WeakReference<Gate>(pairOfGates[1]);
		pairOfGates[1].pair = new WeakReference<Gate>(pairOfGates[0]);

		return creator.loadGates(pairOfGates);
	}

	/**
	 * Szükséges nyersanyagokat adja meg az építéshez.
	 * 
	 * @return a szükséges nyersanyagok
	 */
	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Iron(), new Iron(), new Ice(), new Uranium() };
	}

	// #endregion

	/**
	 * @return the status of the object
	 */
	@Override
	public String status() {
		return super.status() + "\n\tpair: " + pair + "\n\ton: " + on + "\n\tplaced: " + placed + "\n\tdamaged: " + damaged;
	}

	@Override 
	public void draw(Graphics g, Layout l, Texture t, Settler s){
		int index = 0;
		for(var v : s.getInventory()){		
			if(v.equals(this)){
				l.inventorySlotok.get(index).setIcon(new ImageIcon(t.asteroidIceImage));
			}
			index++;
		}
	}
}
