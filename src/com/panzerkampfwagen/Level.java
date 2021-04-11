package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private static List<Tickable> tickables = new ArrayList<>();
	private static List<SolarSensitive> solarSensitives = new ArrayList<>();
	private static int settlerCount;

	public static void tickThings() {
		List<Tickable> tempTickables = List.copyOf(tickables);
		for (Tickable t : tempTickables)
			t.tick();
	}

	/**
	 * @param source which sun
	 * @param from   Start angle in radians
	 * @param to     End angle in radians
	 */
	public static void solarStormTime(/* Sun source, double from, double to */) {
		List<SolarSensitive> temp = List.copyOf(solarSensitives);
		for (SolarSensitive s : temp)
			s.onSolarStorm();
	}

	public static void addSettler(Settler settler) {
		subscribeAll(settler);
		++Level.settlerCount;
	}

	/**
	 * Unit.die() unsubscribes
	 */
	public static void removeSettler() {
		if (--Level.settlerCount == 0) {
			Game.defeat();
		}
	}

	public static void subscribeTick(Tickable thing) {
		tickables.add(thing);
	}

	public static void unsubscribeTick(Tickable thing) {
		tickables.remove(thing);
	}

	public static void subscribeSolarStorm(SolarSensitive s) {
		solarSensitives.add(s);
	}

	public static void unsubscribeSolarStorm(SolarSensitive s) {
		solarSensitives.remove(s);
	}

	public static void subscribeAll(AllEventCompatible a) {
		subscribeTick(a);
		subscribeSolarStorm(a);
	}

	public static void unsubscribeAll(AllEventCompatible a) {
		unsubscribeTick(a);
		unsubscribeSolarStorm(a);
	}

	public static void clear() {
		tickables.clear();
		solarSensitives.clear();
	}
}
