package com.panzerkampfwagen;

public abstract class Unit implements InCore {
	protected Controller controller;
	protected Receiver receiver;
	protected boolean onAsteroid;
	protected boolean isHiding = false;

	// #region getters and setters

	public void setAsteroid(Asteroid receiver) {
		System.out.println("setAsteroid");
		this.receiver = receiver;
		this.onAsteroid = true;
	}

	public void setReceiver(Receiver receiver) {
		System.out.println("setReceiver");
		this.receiver = receiver;
		this.onAsteroid = false;
	}

	public Receiver getReceiver() {
		System.out.println("getReceiver");
		return receiver;
	}

	// CoreMat deposit-hoz kell
	public Asteroid getAsteroid() {
		System.out.println("getAsteroid");
		return this.onAsteroid ? (Asteroid) this.receiver : null;
	}

	// #endregion getters and setters

	// #region actions

	public void die() {
		System.out.println("die");
		this.receiver.removeUnit(this);
		this.controller.unitDied();
		Game.getLevel().removeThing(this);
	}

	public void drill() {
		System.out.println("drill");
		if (onAsteroid) {
			Asteroid a = (Asteroid) this.receiver;
			if (a.drill(1) > 0) {
				controller.step();
			}
		}
	}

	// TODO: cleanup
	public void toggleHide() {
		System.out.println("toggleHide");
		if (isHiding) {
			((Asteroid) this.receiver).ejectCore();
			this.isHiding = false;
			controller.step();
			return;
		}
		if (onAsteroid && this.insertToCoreOf((Asteroid) this.receiver)) {
			this.isHiding = true;
			controller.step();
		}
	}

	public void move(Receiver to) {
		System.out.println("move");
		to.addUnit(this);
	}

	// #endregion actions

	// #region event handlers

	public void tick() {
		System.out.println("tick");
		controller.takeTurn();
	}

	public abstract void onReceiverDestroyed();

	public void onSolarStorm() {
		System.out.println("onSolarStorm");
		this.die();
	}

	// #endregion event handlers

	// #region InCore implementation

	@Override
	public boolean extract(Settler miner) {
		System.out.println("Unit.extract");
		if (miner != this) {
			System.out.println("You can't just shove me into the bunk! I have rights.");
			return false;
		}

		this.isHiding = false;
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		System.out.println("Unit.insertToCoreOf");
		this.isHiding = coreOwner.insertCore(this);
		return this.isHiding;
	}

	// #endregion InCore implementation
}
