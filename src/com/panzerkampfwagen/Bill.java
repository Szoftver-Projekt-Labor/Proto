package com.panzerkampfwagen;

import java.util.ArrayList;
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

	public void tryBuild(Settler s) {
		List<Item> inv = s.getInventory();
		for (Item neededItem : need) {
			for (int i = 0; i < inv.size(); i++) {
				Item currentItem = inv.get(i);
				if (currentItem.sameAs(neededItem)) {
					inv.remove(currentItem);
					need.remove(neededItem);
				}
			}
		}
	}
}
