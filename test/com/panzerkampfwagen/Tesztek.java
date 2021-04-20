package com.panzerkampfwagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.panzerkampfwagen.controllers.AI_Alien;
import com.panzerkampfwagen.controllers.AI_RoBot;
import com.panzerkampfwagen.controllers.Player;
import com.panzerkampfwagen.resources.Coal;
import com.panzerkampfwagen.resources.Ice;
import com.panzerkampfwagen.resources.Iron;
import com.panzerkampfwagen.resources.Uranium;
import com.panzerkampfwagen.units.Robot;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.UFO;

public class Tesztek {
	// #region Fields
	private Iron iron1;
	private Iron iron2;
	private Coal coal1;
	private Coal coal2;
	private Ice ice1;
	private Ice ice2;
	private Uranium uranium1;
	private Uranium uranium2;

	private Asteroid a1;
	private Asteroid a2;
	private Asteroid a3;
	private Asteroid a4;
	private Asteroid a5;
	private Asteroid a6;
	private Asteroid a7;
	private Asteroid a8;

	private Gate g1;
	private Gate g2;

	private Settler s1;
	private Settler s2;
	private Robot r1;
	private UFO u1;

	private Sun sun;

	// #endregion

	// #region File kezelés

	/*
	 * public static void Createtxt(String teszteset) { try { File file = new
	 * File(teszteset); if (file.createNewFile()) {
	 * System.out.println("File created: " + file.getName()); return; }
	 * System.out.println("A File már létezik."); return; } catch (IOException e) {
	 * System.out.println("Hiba keletkezett egy fájl létrehozásánál!");
	 * e.printStackTrace(); } }
	 */

	public static void Readtxt(String teszteset) {
		try {

			File file = new File(teszteset);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
			}
			scanner.close();

		} catch (FileNotFoundException e) {

			System.out.println("Fájl nem beolvasható.");
			e.printStackTrace();

		}
	}

	public static void Writetxt(String teszteset, String sor) {
		try {
			FileWriter writer = new FileWriter(teszteset);
			writer.write(sor);
			writer.close();
			System.out.println("Sikeresen a felülírás");
		} catch (IOException e) {
			System.out.println("HIBA! HIBA! HIBAAAAAAAAAAAAAAAAAA!.");
			e.printStackTrace();
		}
	}

	public static void Deletetxt(String teszteset) {
		File myObj = new File(teszteset);
		if (myObj.delete()) {
			System.out.println("TÖRÖLT FILE: " + myObj.getName());
		} else {
			System.out.println("Nem sikerült törölni a fájlt.");
		}
	}

	// #endregion

	// #region Információs

	public static void TesztMetodusokLista() {
		System.out.println("\nItt lathatoak a tesztesetekhez tartozo sorszamok\n"
				+ "Futtatáshoz kérjuk a teszt sorszamat beírni a konzolra\n"
				+ "Teszteset1\tEgy telepes, robot és UFO szomszédos aszteroidára mozognak.\n"
				+ "Teszteset2\tEgy telepes és robot fúr az aszteroidán.\n"
				+ "Teszteset3\tEgy telepes és UFO bányászik az aszteroidán.\n"
				+ "Teszteset4\tAz urán és a jég napközelbe kerül, az urán felrobban, a jég elolvad, a telepes meghal a robbanásban, a robot szomszédos aszteroidára kerül.\n"
				+ "Teszteset5\tNapvihar éri az egyik aszteroidát és teleportkaput, az aszteroidán levő egységeket elkapja a napvihar, ha nem bújtak el. A teleportkapu megkergül és a visszafelé utazó telepest nem ugyanoda teszi ki, ahonnan előtte indult.\n"
				+ "Teszteset6\tA telepesek és egy robot együttes erővel összegyűjtenek elegendő nyersanyagot egy újabb robot megépítésére.\n"
				+ "Teszteset7\tEgy telepes, kibányászik egy urániumot, majd addig dobálja, amíg fel nem robban.\n"
				+ "Teszteset8\tEgy telepes épít egy teleportkapu párt, majd elhelyezi a két kaput és átmegy rajta.\n"
				+ "Teszteset9 (sandbox)\t játék\n");
	}

	// Teszt eseteket egy listába szedtük és index szerűen hivatkozunk rájuk
	Functions[] functions = new Functions[] { this::Teszteset1, this::Teszteset2, this::Teszteset3, this::Teszteset4,
			this::Teszteset5, this::Teszteset6, this::Teszteset7, this::Teszteset8, this::Teszteset_sandbox };

	public interface Functions {
		void run() throws Exception;
	}

	// #endregion

	// #region Init

	public void Init() {
		sun = new Sun(10, 10);

		// Magtipusok
		iron1 = new Iron();
		iron2 = new Iron();
		coal1 = new Coal();
		coal2 = new Coal();
		ice1 = new Ice();
		ice2 = new Ice();
		uranium1 = new Uranium();
		uranium2 = new Uranium();

		// Aszteroidák
		a1 = new Asteroid(2, iron1);
		a2 = new Asteroid(3, coal1);
		a3 = new Asteroid(2, ice1);
		a4 = new Asteroid(1, uranium1);
		a5 = new Asteroid(3, iron2);
		a6 = new Asteroid(2, coal2);
		a7 = new Asteroid(0, ice2);
		a8 = new Asteroid(0, uranium2);

		a1.addNeighbour(a2);
		a2.addNeighbour(a1);

		a1.addNeighbour(a6);
		a6.addNeighbour(a1);

		a2.addNeighbour(a3);
		a3.addNeighbour(a2);

		a2.addNeighbour(a4);
		a4.addNeighbour(a2);

		a2.addNeighbour(a5);
		a5.addNeighbour(a2);

		a3.addNeighbour(a4);
		a4.addNeighbour(a3);

		a3.addNeighbour(a8);
		a8.addNeighbour(a3);

		a4.addNeighbour(a7);
		a7.addNeighbour(a4);

		a4.addNeighbour(a8);
		a8.addNeighbour(a4);

		a5.addNeighbour(a6);
		a6.addNeighbour(a5);

		a6.addNeighbour(a7);
		a7.addNeighbour(a6);

		a7.addNeighbour(a8);
		a8.addNeighbour(a7);

		// Unitok
		s1 = new Settler(new Player("Móricka"), a1);
		s1.loadCargo(new Iron());
		s1.loadCargo(new Iron());
		s1.loadCargo(new Ice());
		s1.loadCargo(new Uranium());
		// A g2 kaput valakinek le kell dobni
		s2 = new Settler(new Player("Béla"), a8);
		r1 = new Robot(new AI_RoBot(), a7);
		u1 = new UFO(new AI_Alien(), a6);

		// Teleport kapuk
		Gate g1g2[] = new Gate().make();
		g1 = g1g2[0];
		g2 = g1g2[1];
		g1.dropItem(s1);
		g2.dropItem(s2);

		// g2 a helyén, mehetünk a3-ra
		s2.move(a3);
	}

	// #endregion

	// #region Tesztesetek

	public void Teszteset1() {
		Init();

		s1.move(a2);
		s2.move(a1);
		r1.move(a8);
		u1.move(a7);
	}

	public void Teszteset2() {
		Init();

		s1.drill();
		r1.drill();
	}

	public void Teszteset3() {
		Init();

		s1.drill();
		s1.drill();
		s1.mine();
		u1.move(a1);
		u1.mine();
		s2.mine();
	}

	public void Teszteset4() {
		Init();

		s2.move(a8);
		r1.move(a8);
		a8.setCloseToSun(true);
		a4.setCloseToSun(true);
		a3.setCloseToSun(true);
		a7.setCloseToSun(true);
		// status s2
		// status r1
		// status a8
		// status a1
		// status a4
		// status a7
	}

	public void Teszteset5() {
		Init();

		s1.move(g1);
		s1.move(a8);
		r1.move(a8);
		u1.move(a7);
		u1.move(a8);
		s1.toggleHide();
		s1.mine();
		s1.toggleHide();
		// storm g1
		// storm a8
		// status g1
		// status s1
		// status r1
		// status u1
		// status a8
	}

	public void Teszteset6() {
		Init();

		s1.build("robot");
		s2.build("robot");
		s1.drill();
		s2.move(a4);
		r1.move(a4);
		s1.drill();
		r1.drill();
		s2.mine();
		s1.mine();
		s2.move(a2);
		s2.drill();
		s1.move(a2);
		s2.drill();
		s1.drill();
		s2.mine();
		// status s1
		// status s2
		s1.build("robot");
		// status s1
		// status s2
	}

	public void Teszteset7() {
		Init();

		a8.setCloseToSun(true);
		s2.move(a8);
		s2.mine();
		a7.setCloseToSun(true);
		s2.move(a7);
		s2.dropCargo(0);
		// status a7
		// status s2
		a7.setCloseToSun(false);
		s2.dropCargo(0);
		s2.mine();
		s2.dropCargo(0);
		a7.setCloseToSun(true);
		s2.mine();
		s2.dropCargo(0);
		a7.setCloseToSun(true);
		// status a7
		// status s2
	}

	public void Teszteset8() {
		Init();

		s1.build("gate");
		s1.dropCargo(0);
		List<Receiver> ns1 = s1.getAsteroid().getNeighbours();
		Gate g3 = (Gate) ns1.get(ns1.size() - 1);
		s1.move(g3);
		// status g3
		s1.move(a1);
		s1.move(a2);
		s1.move(a3);
		s1.dropCargo(0);
		// status g3
		List<Receiver> ns2 = s1.getAsteroid().getNeighbours();
		Gate g4 = (Gate) ns2.get(ns2.size() - 1);
		// status g4
		s1.move(g4);
		// status s1
		s1.move(a1);
	}

	public void Teszteset_sandbox() {
		Init();
		Game.play();
	}

	// #endregion

	public static void main(String[] args) throws Exception {
		// Teszt txt fájlok létrehozása
		/*
		 * Createtxt("Teszteset1_in"); Createtxt("Teszteset2_in");
		 * Createtxt("Teszteset3_in"); Createtxt("Teszteset4_in");
		 * Createtxt("Teszteset5_in"); Createtxt("Teszteset6_in");
		 * Createtxt("Teszteset7_in"); Createtxt("Teszteset8_in");
		 * Createtxt("Teszteset1_out"); Createtxt("Teszteset2_out");
		 * Createtxt("Teszteset3_out"); Createtxt("Teszteset4_out");
		 * Createtxt("Teszteset5_out"); Createtxt("Teszteset6_out");
		 * Createtxt("Teszteset7_out"); Createtxt("Teszteset8_out");
		 */

		// Teszt esetek kiválasztása
		int optionNumber;
		while (true) {
			Tesztek testSuite = new Tesztek();
			TesztMetodusokLista();
			System.out.print("Melyik teszt fusson? ");
			optionNumber = Utils.scanner.nextInt();
			Utils.scanner.nextLine();
			if (optionNumber < 1 || optionNumber > 9) {
				break;
			}
			testSuite.functions[optionNumber - 1].run();
		}
		Utils.scanner.close();
	}
}
