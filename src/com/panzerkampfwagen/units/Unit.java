package com.panzerkampfwagen.units;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.utility.InCore;
import com.panzerkampfwagen.receivers.Asteroid;
import com.panzerkampfwagen.receivers.Receiver;
import com.panzerkampfwagen.controllers.Controller;

public abstract class Unit implements InCore {
	protected Controller controller;
	protected Receiver receiver;
	protected boolean onAsteroid;
	protected boolean isHiding = false;

	// #region getters and setters

	public void setAsteroid(Asteroid receiver) {
		this.receiver = receiver;
		this.onAsteroid = true;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
		this.onAsteroid = false;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	// CoreMat deposit-hoz kell
	public Asteroid getAsteroid() {
		return this.onAsteroid ? (Asteroid) this.receiver : null;
	}

	// #endregion getters and setters

	// #region actions

	public void die() {
		this.receiver.removeUnit(this);
		this.controller.unitDied();
		Game.getLevel().removeThing(this);
	}

	public void drill() {
		if (onAsteroid) {
			Asteroid a = (Asteroid) this.receiver;
			if (a.drill(1) > 0) {
				controller.step();
			}
		}
	}

	// TODO: cleanup
	public void toggleHide() {
		Asteroid a = (Asteroid) this.receiver;
		if (isHiding) {
			a.ejectCore();
			this.isHiding = false;
			controller.step();
			return;
		}
		if (onAsteroid && this.insertToCoreOf(a)) {
			controller.step();
		}
	}

	public void move(Receiver to) {
		// Change onAsteroid
	}

	// #endregion actions

	// #region event handlers

	public void tick() {
		controller.takeTurn();
	}

	public abstract void onReceiverDestroyed();

	public void onSolarStorm() {
		this.die();
	}

	// #endregion event handlers

	// #region InCore implementation

	@Override
	public boolean extract(Settler miner) {
		if (miner != this) {
			System.out.println("You can't just shove me into the bunk! I have rights.");
			return false;
		}

		this.isHiding = false;
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		this.isHiding = coreOwner.insertCore(this);
		return this.isHiding;
	}

	// #endregion InCore implementation
}
