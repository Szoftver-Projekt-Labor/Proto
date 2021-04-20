package com.panzerkampfwagen.units;

import java.util.List;

import com.panzerkampfwagen.Gate;
import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.RecipeBook;
import com.panzerkampfwagen.controllers.Player;

import java.util.ArrayList;

/**
 * Telepest reprezentál. Képes mozogni, fúrni, bányászni, építeni. Játékos
 * irányítja. Ha az aszteroida felrobban, vagy nem bújik el napvihar elől, akkor
 * meghal.
 */
public class Settler extends Miner {
	private List<Item> inventory = new ArrayList<>(10);
	private List<Gate> gateInventory = new ArrayList<>(3);

	/**
	 * @param r A Receiver amin az egység indul
	 */
	public Settler(Player c, Receiver r) {
		super(c, r);
		Level.addSettler(this);
	}

	/**
	 * Visszaadja az inventory tartalmát.
	 * 
	 * @return az inventory tartalma
	 */
	public List<Item> getInventory() {
		return inventory;
	}

	/**
	 * A paraméterben megkapott itemet megépít a telepes.
	 * 
	 * @param what a megépítendő item neve
	 */
	public void build(String what) {
		if (RecipeBook.getBill(what).startBuild(this)) {
			controller.step();
		}
	}

	/**
	 * Ha az inventoryban van hely, akkor felveszi az itemeket.
	 * 
	 * @param items felvevendő itemek
	 * @return sikerült e (true ha igen)
	 */
	public boolean loadCargo(Item[] items) {
		if (this.inventory.size() > 10 - items.length)
			return false;
		for (Item item : items) {
			this.inventory.add(item);
		}
		return true;
	}

	/**
	 * Ha az inventoryban van hely, akkor felveszi az itemet.
	 * 
	 * @param item felvevendő item
	 * @return sikerült e (true ha igen)
	 */
	public boolean loadCargo(Item item) {
		if (this.inventory.size() >= 10)
			return false;
		return this.inventory.add(item);
	}

	/**
	 * A paraméterben megkapott indexű elemet eldobja.
	 * 
	 * @param slot eldobandó item indexe
	 * @return sikerült e (true ha igen)
	 */
	public boolean dropCargo(int slot) {
		try {
			Item item = this.inventory.get(slot);
			if (item.dropItem(this)) {
				return this.inventory.remove(item);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		return false;
	}

	/**
	 * Betölt egy kapupárt.
	 * 
	 * @param gates betöltendő kapupár
	 * @return sikerült e (true ha igen)
	 */
	public boolean loadGates(Gate[] gates) {
		if (gates.length != 2 || gateInventory.size() > 1)
			return false;

		for (Gate gate : gates)
			this.gateInventory.add(gate);

		return true;
	}

	/**
	 * A paraméterként kapott slotban levő kaput lerakja.
	 * 
	 * @param slot lerakandó kapu indexe
	 * @return sikerült e (true ha igen)
	 */
	public boolean dropGate(int slot) {
		try {
			Gate gate = this.gateInventory.get(slot);
			if (gate.dropItem(this)) {
				return this.gateInventory.remove(gate);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		return false;
	}

	/**
	 * A telepes halála felrobbant receiver miatt.
	 */
	@Override
	public void onReceiverDestroyed() {
		this.die();
	}

	/**
	 * A telepes halála esetén töröljük a levelről.
	 */
	@Override
	public void die() {
		super.die();
		Level.removeSettler();
	}

	/**
	 * Request status. Implemented from "Thing".
	 */
	@Override
	public String status() {
		return toString() + ":\n" + "controller: " + controller + "\n" + super.toString();
	}
}
