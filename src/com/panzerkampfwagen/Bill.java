package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	BuildableItem result;

	public Bill(BuildableItem result) {
		this.result = result;
		this.need.addAll(List.of(result.getBuildCost()));
	}

	List<Item> need = new ArrayList<>();

	List<OwnerRecord> have = new ArrayList<>();

	public void tryBuild(Settler s) {
		s.getInventory();
	}

	class OwnerRecord {
		Item item;
		Settler owner;
	}
}
