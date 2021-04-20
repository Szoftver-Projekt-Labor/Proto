package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Unit;

/**
 * Bázist reprezentálja.
 */
public class Base implements BuildableItem {

	/**
	 * Megvizsgálja, hogy az adott item amivel összehasonlítjuk, az bázis-e.
	 * 
	 * @param other az item, amivel az összehasonlítás történik
	 * @return az összehasonlítás eredménye (true=ha az item egy bázis)
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Base;
	}

	/**
	 * Lerakná a bázist, de nincs értelme.
	 * 
	 * @param dropper aki eldobja a bázist
	 * @return false
	 */
	@Override
	public boolean dropItem(Unit dropper) {
		return false;
	}

	/**
	 * Megépíti a bázist, meghívódik a Game.victory() metódus és véget ér a játék.
	 * 
	 * @return a felépített bázis
	 */
	@Override
	public Base[] make() {
		Game.victory();
		return new Base[] { new Base() };
	}

	/**
	 * Visszaadja a bázishoz szükséget alapanyagokat.
	 * 
	 * @return a bázishoz szükséges alapanyagok
	 */
	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Coal(), new Coal(), new Coal(), new Ice(), new Ice(), new Ice(), new Iron(), new Iron(),
				new Iron(), new Uranium(), new Uranium(), new Uranium() };
	}
}
