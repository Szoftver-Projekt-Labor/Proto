package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public class Settler extends Unit {
	private List<Item> inventory = new ArrayList<>(10);

	public Item[] getInventory() {
		return (Item[]) inventory.toArray();
	}

	public void build(String what) {
		// TODO: check inventory
	}

	public void mine() {
		Asteroid a = this.getAsteroid();
		if (a != null && a.getCore() != null && a.extractCore(this)) {
			this.controller.step();
		}
	}

	public boolean loadCargo(Item item) {
		boolean res = this.inventory.size() < 10;
		if (res) {
			this.inventory.add(item);
		}
		return res;
	}

	public boolean dropCargo(int slot) {
		boolean res = false;
		try {
			Item item = this.inventory.get(slot);
			res = item != null && item.dropItem(this);
			if (res) {
				this.inventory.remove(item);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		return res;
	}

	@Override
	public void onReceiverDestroyed() {
		this.die();
	}

	@Override
	public void die() {
		super.die();
		Game.getLevel().onSettlerDies();
	}
}
