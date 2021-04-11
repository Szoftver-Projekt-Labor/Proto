package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public class Asteroid extends Receiver {
	protected List<Unit> units = new ArrayList<>();
	private int layerCount;
	private InCore core;
	private boolean closeToSun = false;

	public Asteroid(int layerCount, InCore core) {
		this.layerCount = layerCount;
		this.core = core;
	}

	// #region getters and setters

	public List<Unit> getUnits() {
		return units;
	}

	public int getLayerCount() {
		return layerCount;
	}

	public InCore getCore() {
		return core;
	}

	// TODO: Make dynamic
	public void setCloseToSun(boolean closeToSun) {
		this.closeToSun = closeToSun;
	}

	// TODO: Implement
	public boolean isCloseToSun() {
		return closeToSun;
	}

	// #endregion getters and setters

	/**
	 * Drills nLayers off the asteroid
	 * 
	 * Allows multiple layers in case we have to implement nukes
	 * 
	 * @param nLayers number of layers to drill
	 * @return the number of layers drilled
	 */
	public int drill(int nLayers) {
		if (layerCount >= nLayers) {
			this.layerCount -= nLayers;
		} else {
			nLayers = this.layerCount;
			this.layerCount = 0;
		}
		return nLayers;
	}

	public boolean extractCore(Miner miner) {
		if (this.layerCount != 0 || this.core == null) {
			return false;
		}

		return this.core.extract(miner);
	}

	public void ejectCore() {
		this.core = null;
	}

	public boolean insertCore(InCore core) {
		if (this.core != null || this.layerCount != 0)
			return false;
		this.core = core;
		return true;
	}

	public void destroy() {
		for (Unit unit : this.units) {
			unit.onReceiverDestroyed();
		}
		for (Receiver neighbour : this.neighbours) {
			neighbour.removeNeighbour(this);
		}
		Level.unsubscribeTick(this);
	}

	@Override
	public void addUnit(Unit unit) {
		this.units.add(unit);
		unit.setAsteroid(this);
	}

	@Override
	public void removeUnit(Unit unit) {
		this.units.remove(unit);
	}

	@Override
	public void tick() {
		// TODO: Implement
	}
}
