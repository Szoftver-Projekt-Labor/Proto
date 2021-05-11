package com.panzerkampfwagen;

import com.panzerkampfwagen.resources.Coal;
import com.panzerkampfwagen.resources.Ice;
import com.panzerkampfwagen.resources.Iron;
import com.panzerkampfwagen.resources.Uranium;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

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
	 * @return true
	 */
	@Override
	public boolean onMake(Settler creator) {
		Game.victory();
		return true;
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

	@Override
	public String status() {
		return "You shouldn't see this. If you do, something went terribly wrong.";
	}

	@Override 
	public void draw(Graphics g, Layout l, Texture t, Settler s){
		
	}
}
