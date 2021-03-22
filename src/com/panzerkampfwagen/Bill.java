package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bill {
	class OwnerRecord {
		public OwnerRecord(Item item, Settler owner) {
			this.item = item;
			this.owner = owner;
		}

		Item item;
		Settler owner;
	}

	BuildableItem result;
	private List<Item> need = new ArrayList<>();
	private List<OwnerRecord> have = new ArrayList<>();

	public Bill(BuildableItem result) {
		this.result = result;
		this.need.addAll(List.of(result.getBuildCost()));
	}

	public boolean startBuild(Settler initer) {
		Asteroid as = initer.getAsteroid();
		if (as == null)
			return false;

		Iterator<Unit> sIt = as.getUnits().stream().filter(u -> u instanceof Settler).iterator();
		// TODO: Prompt player
		while (sIt.hasNext() && !tryBuild((Settler) sIt.next())) {
			System.out.println("Hellothere");
		}
		if (need.size() == 0) {
			if (initer.loadCargo(this.result.make())) {
				return true;
			}
		}
		for (OwnerRecord owr : have) {
			owr.owner.loadCargo(owr.item);
		}
		return false;
	}

	private boolean tryBuild(Settler s) {
		if (s == null)
			return false;
		List<Item> inv = s.getInventory();

		List<Item> temp = new ArrayList<>();
		temp.addAll(need);

		List<Item> inventory = new ArrayList<>();
		inventory.addAll(inv);

		for (Item neededItem : temp) {
			for (int i = 0; i < inventory.size(); i++) {
				Item currentItem = inventory.get(i);
				if (currentItem.sameAs(neededItem)) {
					inv.remove(currentItem);
					need.remove(neededItem);
					have.add(new OwnerRecord(currentItem, s));
				}
			}
		}
		return need.size() == 0;
	}
}
