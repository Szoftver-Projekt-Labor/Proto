package com.panzerkampfwagen.units;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.controllers.Controller;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Bányászni tudó egységeket reprezentálja.
 */
public abstract class Miner extends Unit {

	public abstract void draw(Graphics g, Layout l, Texture t);

	/**
	 * @param r A Receiver amin az egység indul
	 */
	public Miner(Controller c, Receiver r) {
		super(c, r);
	}

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 */
	public abstract boolean loadCargo(Item item);

	/**
	 * Ha aszteroidán van az egység, van magja és van hely az inventory-ban, akkor
	 * azt kibányássza.
	 */
	public void mine() {
		Asteroid a = this.getAsteroid();
		if (a != null && a.getCore() != null && a.extractCore(this)) {
			// controller.step();
		}
	}
}
