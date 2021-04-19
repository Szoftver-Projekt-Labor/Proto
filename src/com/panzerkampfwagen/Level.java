package com.panzerkampfwagen;

import java.util.ArrayList;
import java.util.List;

/**
 * Pályáért felel és az azon lévő objektumokért.
 */
public class Level {
	private static List<Tickable> tickables = new ArrayList<>();
	private static List<SolarSensitive> solarSensitives = new ArrayList<>();
	private static int settlerCount = 0;

	/**
	 * Meghívja a tickelhető objektumok tick függvényét.
	 */
	public static void tickThings() {
		List<Tickable> tempTickables = List.copyOf(tickables);
		for (Tickable t : tempTickables)
			t.tick();
	}

	// TODO: implement
	/**
	 * Meghívja azon Napvihar érzékeny objektumokon az onSolarStormot, amik
	 * beleesnek a from-to szög intervallumba a Nap körül.
	 * 
	 * @param sun  melyik nap
	 * @param from kezdő szög radiánban
	 * @param to   Ezáró szög radiánban
	 */
	public static void solarStormTime(/* Sun sun, double from, double to */) {
		List<SolarSensitive> temp = List.copyOf(solarSensitives);
		for (SolarSensitive s : temp)
			s.onSolarStorm();
	}

	/**
	 * Hozzáad egy telepest a játékhoz.
	 * 
	 * @param settler melyik telepest adja hozzá
	 */
	public static void addSettler(Settler settler) {
		subscribeAll(settler);
		++Level.settlerCount;
	}

	/**
	 * Eltávolít egy telepest a játékból. Vizsgálja a telepesek számát, mert ha 0,
	 * akkor véget vet a játéknak.
	 */
	public static void removeSettler() {
		if (--Level.settlerCount == 0) {
			Game.defeat();
		}
	}

	/**
	 * Feliratkozik a tick függvényre.
	 * 
	 * @param thing amire feliratkozik
	 */
	public static void subscribeTick(Tickable thing) {
		tickables.add(thing);
	}

	/**
	 * Leiratkozik a tick függvényről.
	 * 
	 * @param thing amiről leiratkozik
	 */
	public static void unsubscribeTick(Tickable thing) {
		tickables.remove(thing);
	}

	/**
	 * Feliratkozik a solarStorm függvényre.
	 * 
	 * @param s amire feliratkozik
	 */
	public static void subscribeSolarStorm(SolarSensitive s) {
		solarSensitives.add(s);
	}

	/**
	 * Leiratkozik a solarStorm függvényről.
	 * 
	 * @param s amiről leiratkozik
	 */
	public static void unsubscribeSolarStorm(SolarSensitive s) {
		solarSensitives.remove(s);
	}

	/**
	 * Feliratkozik a tick és a solarStorm függvényekre.
	 * 
	 * @param a amire feliratkozik
	 */
	public static void subscribeAll(AllEventCompatible a) {
		subscribeTick(a);
		subscribeSolarStorm(a);
	}

	/**
	 * Leiratkozik a tick és a solarStorm függvényekről.
	 * 
	 * @param a amiről leiratkozik
	 */
	public static void unsubscribeAll(AllEventCompatible a) {
		unsubscribeTick(a);
		unsubscribeSolarStorm(a);
	}

	/**
	 * Cleareli a Tickable és a SolarSensitive listát.
	 */
	public static void clear() {
		tickables.clear();
		solarSensitives.clear();
		settlerCount = 0;
	}
}
