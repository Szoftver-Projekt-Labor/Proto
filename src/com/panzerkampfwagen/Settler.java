package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public class Settler extends Miner {
	private List<Item> inventory = new ArrayList<>(10);

	public List<Item> getInventory() {
		return inventory;
	}

	public void build(String what) {
		if (RecipeBook.getBill(what).startBuild(this)) {
			// controller.step();
		}
	}

	public boolean loadCargo(Item[] items) {
		if (this.inventory.size() > 10 - items.length)
			return false;
		for (Item item : items) {
			this.inventory.add(item);
		}
		return true;
	}

	public boolean loadCargo(Item item) {
		if (this.inventory.size() >= 10)
			return false;
		return this.inventory.add(item);
	}

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

	@Override
	public void onReceiverDestroyed() {
		this.die();
	}

	@Override
	public void die() {
		super.die();
		Level.removeSettler();
	}
}
