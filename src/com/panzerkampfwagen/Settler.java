package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public class Settler extends Unit {
	private List<Item> inventory = new ArrayList<>(10);

	public Item[] getInventory() {
		System.out.println("getInventory");
		return (Item[]) inventory.toArray();
	}

	public void build(String what) {
		System.out.println("build");
		// TODO: check inventory
	}

	public void mine() {
		System.out.println("mine");
		Asteroid a = this.getAsteroid();
		if (a != null && a.getCore() != null && a.extractCore(this)) {
			this.controller.step();
		}
	}

	public boolean loadCargo(Item item) {
		System.out.println("loadCargo");
		boolean res = this.inventory.size() < 10;
		if (res) {
			this.inventory.add(item);
		}
		return res;
	}

	public boolean dropCargo(int slot) {
		System.out.println("dropCargo");
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
		System.out.println("Settler.onReceiverDestroyed");
		this.die();
	}

	@Override
	public void die() {
		System.out.println("Settler.die");
		super.die();
		Game.getLevel().onSettlerDies();
	}
}
