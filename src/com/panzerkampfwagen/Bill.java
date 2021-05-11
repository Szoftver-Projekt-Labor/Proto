package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.controllers.Player;

/**
 * A legyártható tárgyak receptjéért felel. Kör végén megszűnik, ha nem sikerül
 * összegyűjteni a hozzávalókat.
 */
public class Bill {
	class OwnerRecord {
		public OwnerRecord(Item item, Settler owner) {
			this.item = item;
			this.owner = owner;
		}

		public final Item item;
		public final Settler owner;
	}

	private BuildableItem result;
	private List<Item> need = new ArrayList<>();
	private List<OwnerRecord> have = new ArrayList<>();

	/**
	 * A Bill konstruktora beállítja a result és a need értékét.
	 * 
	 * @param result a megépítendő item
	 */
	public Bill(BuildableItem result) {
		this.result = result;
		this.need.addAll(List.of(result.getBuildCost()));
	}

	/**
	 * Amíg a tryBuild fut, közben eltünteti az építéshez szükséges alapanyagokat
	 * 
	 * @param initer az építést kezdeményező telepes
	 * @return a művelet sikeressége (false=nem sikerült)
	 */
	public boolean startBuild(Settler initer) {
		Asteroid asteroid = initer.getAsteroid();
		if (asteroid == null)
			return false;

		Iterator<Unit> sIt = asteroid.getUnits().stream().filter(u -> u instanceof Settler).iterator();
		while (sIt.hasNext() && !tryBuild(initer, (Settler) sIt.next()))
			;
		if (need.size() == 0 && this.result.onMake(initer)) {
			return true;
		}
		for (OwnerRecord owr : have) {
			owr.owner.loadCargo(owr.item);
		}
		return false;
	}

	/**
	 * Ha aszteroidán van és megvannak az alapanyagok az építéshez és van elég helye
	 * az inventory-jában, akkor legyártja az itemet.
	 * 
	 * @param s az építéssel próbálkozó telepes
	 * @return a művelet sikeressége (false=nem sikerült)
	 */
	private boolean tryBuild(Settler initer, Settler s) {
		if (s != initer
				&& (s == null || !((Player) s.getController()).prompt("Szia testvér! Kéne egy kis nyers_anyag buszjegyre.")))
			return false;

		List<Item> tempNeed = new ArrayList<>();
		tempNeed.addAll(need);

		List<Item> inventory = s.getInventory();
		List<Item> tempInv = new ArrayList<>();
		tempInv.addAll(inventory);

		for (Item neededItem : tempNeed) {
			for (int i = 0; i < tempInv.size(); i++) {
				Item currentItem = tempInv.get(i);
				if (currentItem.sameAs(neededItem)) {
					inventory.remove(currentItem);
					need.remove(neededItem);
					have.add(new OwnerRecord(currentItem, s));
				}
			}
		}
		return need.size() == 0;
	}
}
