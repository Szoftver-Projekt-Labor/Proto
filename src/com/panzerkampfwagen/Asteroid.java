package com.panzerkampfwagen;

import java.util.List;

import com.panzerkampfwagen.units.Miner;
import com.panzerkampfwagen.units.Unit;

import java.util.ArrayList;

/**
 * Mezőt reprezentál, erre léphetnek a játékosok, robotok, UFO-k.
 */
public class Asteroid extends Receiver {
	protected List<Unit> units = new ArrayList<>();
	private int layerCount;
	private InCore core;
	private boolean closeToSun = false;

	/**
	 * Az aszteroida konstruktora
	 * 
	 * @param layerCount az aszteroida köpenyének rétegszáma
	 * @param core       az aszteroida magjában lévő objektum
	 */
	public Asteroid(int layerCount, InCore core) {
		this.layerCount = layerCount;
		this.core = core;
		core.setAsteroid(this);
		Level.subscribeTick(this);
	}

	/**
	 * Visszaadja az aszteroidán lévő egységek listáját.
	 * 
	 * @return lista az aszteroidán levő Unitok-ról
	 */
	public List<Unit> getUnits() {
		return units;
	}

	/**
	 * Visszaadja az aszteroida kéregeinek a számát
	 * 
	 * @return az aszteroida kérgeinek száma
	 */
	public int getLayerCount() {
		return layerCount;
	}

	/**
	 * Visszaadja az aszteroidához tartozó magot.
	 * 
	 * @return az aszteroida magja
	 */
	public InCore getCore() {
		return core;
	}

	// TODO: Implement for graphic version
	/**
	 * Beállítja az aszteroida closeToSun attribútumát az adott értékre.
	 * 
	 * @param closeToSun az aszteroida napközelségének értéke (true=napközelben van,
	 *                   false=nincs napközelben)
	 */
	public void setCloseToSun(boolean closeToSun) {
		this.closeToSun = closeToSun;
	}

	/**
	 * Visszaadja az aszteroida napközelségének értékét
	 * 
	 * @return closeToSun (true=napközelben van, false=nincs napközelben)
	 */
	public boolean isCloseToSun() {
		return closeToSun;
	}

	// #endregion getters and setters

	/**
	 * A paraméterben megadott értékkel csökkenti az aszteroida köpenyét, ha az
	 * érték nem nagyobb, mint a rétegszám.
	 * 
	 * @param nLayers kifúrandó rétegek száma
	 * @return kifúrt rétegek száma
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

	/**
	 * Ha a kéregszám 0, akkor kiszedi a magot és a paraméterben megadott minernek
	 * adja.
	 * 
	 * @param miner a telepes, aki megkapja a magot
	 * @return a művelet sikeressége (false=nem sikerült kiszedni a magot)
	 */
	public boolean extractCore(Miner miner) {
		if (this.layerCount != 0 || this.core == null) {
			return false;
		}

		return this.core.extract(miner);
	}

	/**
	 * Üregessé teszi a magot.
	 */
	public void ejectCore() {
		this.core = null;
	}

	/**
	 * Ha az aszteroida üreges és nincs kérge, akkor a paraméterben megadott típust
	 * behelyezi az aszteroidába.
	 * 
	 * @param core a magba helyezendő típus
	 * @return a művelet sikeressége (false=nem sikerült)
	 */
	public boolean insertCore(InCore core) {
		if (this.core != null || this.layerCount != 0)
			return false;
		this.core = core;
		return true;
	}

	/**
	 * Elpusztítja az aszteroidát és törli a level listájából.
	 */
	public void destroy() {
		for (Unit unit : this.units) {
			unit.onReceiverDestroyed();
		}
		for (Receiver neighbour : this.neighbours) {
			neighbour.removeNeighbour(this);
		}
		Level.unsubscribeTick(this);
	}

	/**
	 * Hozzáad egy egységet az aszteroidához.
	 * 
	 * @param unit az aszteroidához adandó egység
	 * @return a művelet sikeressége (false=nem sikerült)
	 */
	@Override
	public boolean addUnit(Unit unit) {
		this.units.add(unit);
		unit.setAsteroid(this);
		return true;
	}

	/**
	 * Eltávolít egy egységet az aszteroidáról.
	 * 
	 * @param unit az aszteroidáról törlendő egység
	 */
	@Override
	public void removeUnit(Unit unit) {
		this.units.remove(unit);
	}

	/**
	 * Aszteroidán a Tick eseményt valósítja meg.
	 */
	@Override
	public void tick() {
		// TODO: Implement for graphic version
	}

	/**
	 * @return the status of the object
	 */
	@Override
	public String status() {
		return super.status() + "\n\tlayerCount: " + layerCount + "\n\tcore: " + core + "\n\tcloseToSun: " + closeToSun
				+ "\n\tunits: " + Utils.joinList(units);
	}
}
