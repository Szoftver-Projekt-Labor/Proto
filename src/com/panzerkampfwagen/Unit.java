package com.panzerkampfwagen;

public abstract class Unit implements InCore, AllEventCompatible {
	protected Controller controller;
	protected Receiver receiver;
	protected boolean onAsteroid;
	protected boolean hiding = false;

	// #region getters and setters

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setAsteroid(Asteroid receiver) {
		this.receiver = receiver;
		this.onAsteroid = true;
	}

	// CoreMat deposit-hoz kell
	public Asteroid getAsteroid() {
		return this.onAsteroid ? (Asteroid) this.receiver : null;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
		this.onAsteroid = false;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public boolean isHiding() {
		return hiding;
	}

	// #endregion getters and setters

	// #region actions

	public void die() {
		this.controller.unitDied();
		this.receiver.removeUnit(this);
		Level.unsubscribeAll(this);
	}

	public void drill() {
		if (onAsteroid) {
			Asteroid a = (Asteroid) this.receiver;
			if (a.drill(1) > 0) {
				controller.step();
			}
		}
	}

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

	public void move(Receiver to) {
		this.receiver.removeUnit(this);
		if (to.addUnit(this)) {
			controller.step();
		}
	}

	// #endregion actions

	// #region event handlers

	public void tick() {
		controller.takeTurn();
	}

	public abstract void onReceiverDestroyed();

	public void onSolarStorm() {
		if (!hiding)
			this.die();
	}

	// #endregion event handlers

	// #region InCore implementation

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

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		this.hiding = coreOwner.insertCore(this);
		return this.hiding;
	}

	// #endregion InCore implementation
}
