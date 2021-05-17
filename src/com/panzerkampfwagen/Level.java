package com.panzerkampfwagen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.panzerkampfwagen.controllers.AI_Alien;
import com.panzerkampfwagen.controllers.Player;
import com.panzerkampfwagen.resources.Coal;
import com.panzerkampfwagen.resources.Ice;
import com.panzerkampfwagen.resources.Iron;
import com.panzerkampfwagen.resources.Uranium;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.UFO;

/**
 * Pályáért felel és az azon lévő objektumokért.
 */
public class Level {
	private static List<Tickable> tickables = new OurLinkedList<Tickable>();
	private static List<SolarSensitive> solarSensitives = new OurLinkedList<SolarSensitive>();
	private static int settlerCount = 0;

	/**
	 * Meghívja a tickelhető objektumok tick függvényét.
	 */
	public static void tickThings() {
		for (Iterator<Tickable> it = tickables.iterator(); it.hasNext(); ) {
			Tickable t = it.next();
			t.tick();
		}
	}

	// TODO: Implement for graphic version
	/**
	 * Meghívja azon Napvihar érzékeny objektumokon az onSolarStormot, amik
	 * beleesnek a from-to szög intervallumba a Nap körül.
	 * 
	 * @param sun  melyik nap
	 * @param from kezdő szög radiánban
	 * @param to   Ezáró szög radiánban
	 */
	public static void solarStormTime(/* Sun sun, double from, double to */) {
		Random random = new Random();
		for (Iterator<SolarSensitive> it = solarSensitives.iterator(); it.hasNext(); ) {
			SolarSensitive s = it.next();
			if (random.nextDouble() < 0.5)
				s.onSolarStorm();
		}
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

	public static void generate(){
		List<Asteroid> asteroids = new LinkedList<>();
		Random r = new Random(System.currentTimeMillis());
		int from = r.nextInt(2)+3;
		int to = r.nextInt(3)+from+2;
		Sun sun = new Sun(from, to);
		int n = r.nextInt(30)+20;
		for(int i=0; i<n; i++){
			asteroids.add(new Asteroid(r.nextInt(15)+1, new Ice()));
		}
		n = r.nextInt(30)+20;
		for(int i=0; i<n; i++){
			asteroids.add(new Asteroid(r.nextInt(15)+1, new Iron()));
		}
		n = r.nextInt(30)+20;
		for(int i=0; i<n; i++){
			asteroids.add(new Asteroid(r.nextInt(15)+1, new Coal()));
		}
		n = r.nextInt(30)+20;
		for(int i=0; i<n; i++){
			asteroids.add(new Asteroid(r.nextInt(15)+1, new Uranium()));
		}
		for (Asteroid asteroid : asteroids) {
			n= 1 + (int) ((asteroids.size()-2)* r.nextDouble());
			for(int i=0; i<n; i++){
				Asteroid a = asteroids.get(r.nextInt(asteroids.size()));
				if(a!=asteroid && !asteroid.getNeighbours().contains(a)){
					a.addNeighbour(asteroid);
					asteroid.addNeighbour(a);
				}
			}
		}
		n = r.nextInt(3)+2;
		for(int i=0;i<n; i++){
			Asteroid a = asteroids.get(r.nextInt(asteroids.size()));
			Player p = new Player("Player "+ Integer.toString(i+1));
			Settler s= new Settler(p, a);
			a.addUnit(s);
		}
		for(int i=0;i<n*3; i++){
			Asteroid a = asteroids.get(r.nextInt(asteroids.size()));
			AI_Alien ai = new AI_Alien();
			UFO u = new UFO(ai, a);
			a.addUnit(u);
		}
	}
}
