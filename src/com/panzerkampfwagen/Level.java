package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

import com.panzerkampfwagen.receivers.Receiver;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.mining.CoreMaterial;
import com.panzerkampfwagen.other.Sun;

public class Level {
	private List<Receiver> receivers = new ArrayList<>();
	private List<Sun> suns = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();
	private List<CoreMaterial> coreMaterials = new ArrayList<>();

	private int settlerCount;

	public void tickThings() {
		for (Receiver receiver : receivers)
			receiver.tick();
		for (Sun sun : suns)
			sun.tick();
		for (Unit unit : units)
			unit.tick();
	}

	public void solarStormTime() {
		for (Unit unit : units)
			unit.onSolarStorm();
	}

	public void onSettlerDies() {
		if (--this.settlerCount == 0) {
			Game.defeat();
		}
	}

	public void removeThing(Receiver receiver) {
		receivers.remove(receiver);
	}

	public void removeThing(Unit unit) {
		units.remove(unit);
	}

	public void removeThing(CoreMaterial coreMaterial) {
		coreMaterials.remove(coreMaterial);
	}

	public void addThing(Receiver receiver) {
		receivers.add(receiver);
	}

	public void addThing(Unit unit) {
		units.add(unit);
	}

	public void addThing(CoreMaterial coreMaterial) {
		coreMaterials.add(coreMaterial);
	}
}
