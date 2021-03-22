package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private List<Receiver> receivers = new ArrayList<>();
	private List<Sun> suns = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();
	private List<CoreMaterial> coreMaterials = new ArrayList<>();

	private int settlerCount;

	// TODO: Nobody needs this in prod
	public int test_getUnitCount() {
		return units.size();
	}

	public void tickThings() {
		System.out.println("tickThings");
		// TODO: Test concurrency
		List<Receiver> tempReceivers = List.copyOf(receivers);
		for (Receiver receiver : tempReceivers)
			receiver.tick();
		for (Sun sun : suns)
			sun.tick();
		List<Unit> tempUnits = new ArrayList<>();
		tempUnits.addAll(units);
		for (Unit unit : tempUnits)
			unit.tick();
		List<CoreMaterial> tempCoreMaterial = List.copyOf(coreMaterials);
		for (CoreMaterial coreMaterial : tempCoreMaterial)
			coreMaterial.tick();
	}

	public void solarStormTime() {
		System.out.println("solarStormTime");
		List<Unit> tempUnits = List.copyOf(units);
		for (Unit unit : tempUnits)
			unit.onSolarStorm();
	}

	public void onSettlerDies() {
		System.out.println("onSettlerDies");
		if (--this.settlerCount == 0) {
			Game.defeat();
		}
	}

	public boolean removeThing(Receiver receiver) {
		System.out.println("removeThing(Receiver)");
		return receivers.remove(receiver);
	}

	public boolean removeThing(Unit unit) {
		System.out.println("removeThing(Unit)");
		return units.remove(unit);
	}

	public boolean removeThing(CoreMaterial coreMaterial) {
		System.out.println("removeThing(CoreMaterial)");
		return coreMaterials.remove(coreMaterial);
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
