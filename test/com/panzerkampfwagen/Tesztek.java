package com.panzerkampfwagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tesztek {
  static Scanner scanner = new Scanner(System.in);
  /////////////////////////////////////// Változók
  /////////////////////////////////////// /////////////////////////////////////////
  private Iron iron;
  private Coal coal;
  private Ice ice;
  private Uranium uranium;

  private Asteroid a1;
  private Asteroid a2;
  private Asteroid a3;
  private Asteroid a4;
  private Asteroid a5;
  private Asteroid a6;
  private Asteroid a7;
  private Asteroid a8;

  private Gate g1 = new Gate();
  private Gate g2 = new Gate();

  private Settler s1 = new Settler();
  private Settler s2 = new Settler();
  private Robot r1 = new Robot();
  private UFO u1 = new UFO();

  /////////////////////////////////////// File kezelő metódusok
  /////////////////////////////////////// /////////////////////////////////////////
  public static void Createtxt(String teszteset) {
    try {
      File file = new File(teszteset);
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getName());
      } else {
        System.out.println("A File már létezik.");
      }
    } catch (IOException e) {
      System.out.println("Hiba keletkezett a keletkezésnél!");
      e.printStackTrace();
    }
  }

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

  /////////////////////////////////////// Információs
  /////////////////////////////////////// /////////////////////////////////////////

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
        + "Teszteset8\tEgy telepes épít egy teleportkapu párt, majd elhelyezi a két kaput és átmegy rajta.\n" + "\n");
  }

  // Teszt eseteket egy lsitába szedtük és index szerűen hivatkozunk rájuk
  Functions[] functions = new Functions[] { this::Teszteset1, this::Teszteset2, this::Teszteset3, this::Teszteset4,
      this::Teszteset5, this::Teszteset6, this::Teszteset7, this::Teszteset8 };

  public interface Functions {
    void run() throws Exception;
  }

  /////////////////////////////////////// InIt
  /////////////////////////////////////// /////////////////////////////////////////

  public void InIt() {
    // Magtipusok
    iron = new Iron();
    coal = new Coal();
    ice = new Ice();
    uranium = new Uranium();

    // Aszteroidák
    a1 = new Asteroid(2, iron);
    a1.addNeighbour(a2);
    a1.addNeighbour(a6);
    a2 = new Asteroid(3, coal);
    a2.addNeighbour(a1);
    a2.addNeighbour(a3);
    a2.addNeighbour(a4);
    a2.addNeighbour(a5);
    a3 = new Asteroid(2, ice);
    a3.addNeighbour(a2);
    a3.addNeighbour(a4);
    a3.addNeighbour(a8);
    a4 = new Asteroid(1, uranium);
    a1.addNeighbour(a2);
    a1.addNeighbour(a3);
    a1.addNeighbour(a7);
    a1.addNeighbour(a8);
    a5 = new Asteroid(3, iron);
    a1.addNeighbour(a2);
    a1.addNeighbour(a6);
    a6 = new Asteroid(2, coal);
    a1.addNeighbour(a1);
    a1.addNeighbour(a5);
    a1.addNeighbour(a7);
    a7 = new Asteroid(0, ice);
    a1.addNeighbour(a4);
    a1.addNeighbour(a6);
    a1.addNeighbour(a8);
    a8 = new Asteroid(0, uranium);
    a1.addNeighbour(a3);
    a1.addNeighbour(a4);
    a1.addNeighbour(a7);

    // Teleport kapuk
    a1.addNeighbour(g1);
    a8.addNeighbour(g2);

    // Unitok
    Settler s1 = new Settler();
    s1.move(a1);
    s1.loadCargo(iron);
    s1.loadCargo(iron);
    s1.loadCargo(ice);
    s1.loadCargo(uranium);
    s2.move(a3);
    r1.move(a7);
    u1.move(a6);
  }

  /////////////////////////////////////// Tesztek
  /////////////////////////////////////// /////////////////////////////////////////

  public void Teszteset1() {
    InIt();

    s1.move(a2);
    s2.move(a1);
    r1.move(a8);
    u1.move(a7);
  }

  public void Teszteset2() {
    InIt();

    s1.drill();
    r1.drill();
  }

  public void Teszteset3() {
    InIt();

    s1.drill();
    s1.drill();
    s1.mine();
    u1.move(a1);
    u1.mine();
    s2.mine();
  }

  public void Teszteset4() {
    InIt();

    s2.move(a8);
    r1.move(a8);
    a8.setCloseToSun(true);
    a4.setCloseToSun(true);
    a3.setCloseToSun(true);
    a7.setCloseToSun(true);
    // statusz s2
    // statusz r1
    // statusz a8
    // statusz a1
    // statusz a4
    // statusz a7
  }

  public void Teszteset5() {
    InIt();

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
    // statusz g1
    // statusz s1
    // statusz r1
    // statusz u1
    // statusz a8
  }

  public void Teszteset6() {
    InIt();

    s1.build("Robot");
    s2.build("Robot");
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
    // statusz s1
    // statusz s2
    s1.build("Robot");
    // statusz s1
    // statusz s2
  }

  public void Teszteset7() {
    InIt();

    a8.setCloseToSun(true);
    s2.move(a8);
    s2.mine();
    a7.setCloseToSun(true);
    s2.move(a7);
    s2.dropCargo(0);
    // statusz a7
    // statusz s2
    a7.setCloseToSun(false);
    s2.dropCargo(0);
    s2.loadCargo(uranium);
    a7.setCloseToSun(true);
    s2.loadCargo(uranium);
    s2.dropCargo(0);
    a7.setCloseToSun(true);
    // statusz a7
    // statusz s2
  }

  public void Teszteset8() {
    InIt();

    s1.build("gate");
    s1.dropGate(0);
    s1.move(g3);
    // statusz g3
    s1.move(a1);
    s1.move(a2);
    s1.move(a3);
    s1.dropGate(1);
    // statusz g3
    // statusz g4
    s1.move(g4);
    // statusz s1
    s1.move(a1);
  }

  /////////////////////////////////////// Main
  /////////////////////////////////////// /////////////////////////////////////////
  public static void main(String[] args) throws Exception {

    // Teszt txt fájlok létrehozása
    Createtxt("Teszteset1_in");
    Createtxt("Teszteset2_in");
    Createtxt("Teszteset3_in");
    Createtxt("Teszteset4_in");
    Createtxt("Teszteset5_in");
    Createtxt("Teszteset6_in");
    Createtxt("Teszteset7_in");
    Createtxt("Teszteset8_in");
    Createtxt("Teszteset1_out");
    Createtxt("Teszteset2_out");
    Createtxt("Teszteset3_out");
    Createtxt("Teszteset4_out");
    Createtxt("Teszteset5_out");
    Createtxt("Teszteset6_out");
    Createtxt("Teszteset7_out");
    Createtxt("Teszteset8_out");

    // Teszt esetek kiválasztása
    int optionNumber;
    while (true) {
      Tesztek testSuite = new Tesztek();
      TesztMetodusokLista();
      System.out.print("Melyik teszt fusson? ");
      optionNumber = scanner.nextInt();
      if (optionNumber < 1 || optionNumber > 8) {
        break;
      }
      testSuite.functions[optionNumber - 1].run();
    }
    scanner.close();

  }
}
