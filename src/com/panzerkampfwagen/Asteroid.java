package com.panzerkampfwagen;

import java.util.List;
import java.util.ArrayList;

public class Asteroid extends Receiver {
	protected List<Unit> units = new ArrayList<>();
	private int layerCount;
	private InCore core;
	private boolean closeToSun = false;

	// #region getters and setters

	public List<Unit> getUnits() {
		return units;
	}

	public int getLayerCount() {
		System.out.println("getLayerCount");
		return layerCount;
	}

	public void setLayerCount(int layerCount) {
		System.out.println("setLayerCount");
		this.layerCount = layerCount;
	}

	public InCore getCore() {
		System.out.println("getCore");
		return core;
	}

	public void setCore(InCore core) {
		System.out.println("setCore");
		this.core = core;
	}

	public void setCloseToSun(boolean closeToSun) {
		System.out.println("setCloseToSun");
		this.closeToSun = closeToSun;
	}

	public boolean isCloseToSun() {
		System.out.println("isCloseToSun");
		return closeToSun;
		// TODO: Implement
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
		System.out.println("drill");
		if (layerCount >= nLayers) {
			this.layerCount -= nLayers;
		} else {
			nLayers = this.layerCount;
			this.layerCount = 0;
		}
		return nLayers;
	}

	public boolean extractCore(Settler miner) {
		System.out.println("extractCore");
		if (this.layerCount != 0 || this.core == null) {
			return false;
		}

		return this.core.extract(miner);
	}

	public void ejectCore() {
		System.out.println("ejectCore");
		// TODO: verify integrity
		this.core = null;
	}

	public boolean insertCore(InCore core) {
		System.out.println("insertCore");
		if (this.core != null || this.layerCount != 0)
			return false;
		this.core = core;
		return true;
	}

	public void destroy() {
		System.out.println("destroy");
		for (Unit unit : this.units) {
			unit.onReceiverDestroyed();
		}
		for (Receiver neighbour : this.neighbours) {
			neighbour.removeNeighbour(this);
		}
		Game.getLevel().removeThing(this);
	}

	@Override
	public void addUnit(Unit unit) {
		System.out.println("Asteroid.addUnit");
		this.units.add(unit);
		unit.setAsteroid(this);
	}

	@Override
	public void removeUnit(Unit unit) {
		System.out.println("Asteroid.removeUnit");
		this.units.remove(unit);
	}
}
