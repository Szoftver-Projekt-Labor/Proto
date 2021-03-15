package com.panzerkampfwagen.receivers;

import java.util.List;
import java.util.ArrayList;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.utility.InCore;

public class Asteroid extends Receiver {
	protected List<Unit> units = new ArrayList<>();
	private int layerCount;
	private InCore core;

	// #region getters and setters

	public int getLayerCount() {
		return layerCount;
	}

	public InCore getCore() {
		if (layerCount == 0)
			return core;
		return null;
	}

	public boolean isCloseToSun() {
		// TODO: Implement
		return true;
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

	public boolean extractCore(Settler miner) {
		if (this.layerCount != 0 || this.core == null) {
			return false;
		}

		return this.core.extract(miner);
	}

	public void ejectCore() {
		// TODO: verify integrity
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
		Game.getLevel().removeThing(this);
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
}
