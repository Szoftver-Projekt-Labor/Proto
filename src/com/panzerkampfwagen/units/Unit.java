package com.panzerkampfwagen.units;

import com.panzerkampfwagen.AllEventCompatible;
import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.InCore;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.controllers.Controller;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Az egységeket reprezentálja. Lehet telepes, robot vagy UFO.
 */
public abstract class Unit implements InCore, AllEventCompatible {
	protected Controller controller;
	protected Receiver receiver;
	protected boolean onAsteroid;
	protected boolean hiding = false;

	public abstract void draw(Graphics g, Layout l, Texture t);

	/**
	 * @param r A Receiver amin az egység indul
	 */
	public Unit(Controller c, Receiver r) {
		this.receiver = r;
		this.controller = c;
		if (c != null) {
			c.setUnit(this);
		}

		if (r != null) {
			r.addUnit(this);
		}
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * Beállítja a controllert.
	 * 
	 * @param controller a beállítandó controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Visszaadja az aszteroidát, amin van.
	 * 
	 * @return az aszteroida (vagy null ha nincs)
	 */
	public Asteroid getAsteroid() {
		return this.onAsteroid ? (Asteroid) this.receiver : null;
	}

	/**
	 * Beállítja a receiver értékét.
	 * 
	 * @param receiver a beállítandó receiver
	 */
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
		this.onAsteroid = false;
	}

	/**
	 * Visszaadja a receivert.
	 * 
	 * @return a receiver (vagy null ha nincs)
	 */
	public Receiver getReceiver() {
		return receiver;
	}

	/**
	 * Visszaadja, hogy elbújt-e.
	 * 
	 * @return elbújt e (true ha igen)
	 */
	public boolean isHiding() {
		return hiding;
	}

	/**
	 * Meghal a unit.
	 */
	public void die() {
		this.controller.unitDied();
		this.receiver.removeUnit(this);
		Level.unsubscribeAll(this);
	}

	/**
	 * Kifúr egy réteget a köpenyből.
	 */
	public void drill() {
		if (onAsteroid) {
			Asteroid a = (Asteroid) this.receiver;
			if (a.drill(1) > 0) {
				controller.step();
			}
		}
	}

	/**
	 * Ha már elbújt, akkor már nem lesz elbújva. De ha nem, akkor elbújik.
	 */
	public void toggleHide() {
		if (hiding) {
			this.extract(null);
			controller.step();
			return;
		}
		if (onAsteroid && this.insertToCoreOf((Asteroid) this.receiver)) {
			controller.step();
		}
	}

	/**
	 * Átmozog egy másik receiverre.
	 * 
	 * @param receiver a cél receiver
	 */
	public void move(Receiver to) {
		this.receiver.removeUnit(this);
		if (to.addUnit(this)) {
			controller.step();
		}
	}

	// #endregion actions

	// #region event handlers

	/**
	 * Tick hatására a meghívja a controller takeTurn függvényét.
	 */
	public void tick() {
		controller.takeTurn();
	}

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 */
	public abstract void onReceiverDestroyed();

	/**
	 * Ha nincs elbújva, akkor meghal. Napviharba kerül.
	 */
	public void onSolarStorm() {
		if (!hiding)
			this.die();
	}

	// #endregion event handlers

	// #region InCore implementation

	/**
	 * Beállítja, hogy melyik aszteroidán van.
	 * 
	 * @param receiver a beállítandó aszteroida
	 */
	public void setAsteroid(Asteroid asteroid) {
		this.receiver = asteroid;
		this.onAsteroid = true;
	}

	/**
	 * Kibányássza a nyersanyagot.
	 * 
	 * @param miner aki bányássza ki
	 * @return sikerült e (true ha igen)
	 */
	@Override
	public boolean extract(Miner miner) {
		if (miner != null) {
			System.out.println("You can't just shove me into the bunk! I have rights.");
			return false;
		}

		this.hiding = false;
		((Asteroid) this.receiver).ejectCore();
		return true;
	}

	/**
	 * Unit belemegy a magba.
	 * 
	 * @param coreOwner a cél aszteroida
	 * @return sikerül e (true ha igen)
	 */
	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		this.hiding = coreOwner.insertCore(this);
		return this.hiding;
	}

	// #endregion InCore implementation

	/**
	 * @return the status of the object
	 */
	@Override
	public String status() {
		return this + ":\n\tcontroller: " + controller + "\n\treceiver: " + receiver + "\n\thiding: " + hiding;
	}
}
