package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private List<Receiver> receivers = new ArrayList<>();
	private List<Sun> suns = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();
	private List<CoreMaterial> coreMaterials = new ArrayList<>();

	private int settlerCount;

	public void tickThings() {
		System.out.println("tickThings");
		for (Receiver receiver : receivers)
			receiver.tick();
		for (Sun sun : suns)
			sun.tick();
		for (Unit unit : units)
			unit.tick();
	}

	public void solarStormTime() {
		System.out.println("solarStormTime");
		for (Unit unit : units)
			unit.onSolarStorm();
	}

	public void onSettlerDies() {
		System.out.println("onSettlerDies");
		if (--this.settlerCount == 0) {
			Game.defeat();
		}
	}

	public void removeThing(Receiver receiver) {
		System.out.println("removeThing(Receiver)");
		receivers.remove(receiver);
	}

	public void removeThing(Unit unit) {
		System.out.println("removeThing(Unit)");
		units.remove(unit);
	}

	public void removeThing(CoreMaterial coreMaterial) {
		System.out.println("removeThing(CoreMaterial)");
		coreMaterials.remove(coreMaterial);
	}

	public void addThing(Receiver receiver) {
		System.out.println("addThing(Receiver)");
		receivers.add(receiver);
	}

	public void addThing(Unit unit) {
		System.out.println("addThing(Unit)");
		units.add(unit);
	}

	public void addThing(CoreMaterial coreMaterial) {
		System.out.println("addThing(CoreMaterial)");
		coreMaterials.add(coreMaterial);
	}

	public void clear() {
		System.out.println("clear");
		receivers.clear();
		suns.clear();
		units.clear();
		coreMaterials.clear();
	}
}
