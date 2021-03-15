package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

import com.panzerkampfwagen.receivers.Receiver;
import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.environment.Sun;
import com.panzerkampfwagen.mining.CoreMaterial;

public class Level {
	List<Receiver> receivers = new ArrayList<>();
	List<Sun> suns = new ArrayList<>();
	List<Unit> units = new ArrayList<>();
	List<CoreMaterial> coreMaterials = new ArrayList<>();

	int settlerCount;

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

	public void addThing(Receiver receiver) {
		receivers.add(receiver);
	}

	public void addThing(Unit unit) {
		units.add(unit);
	}
}
