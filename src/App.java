import java.util.Random;
import java.util.Scanner;
import com.panzerkampfwagen.*;

class Test {

	public static void TesztMetodusokKiras() {
		System.out.println("Itt lathatoak a tesztesetekhez tartozo sorszamok\n"
				+ "Futtatáshoz kérjuk a teszt sorszamat beírni a konzolra\n" + "1\tSettler moves on asteroid\n"
				+ "2\tSettler moves on gate\n" + "3\tSettler mines ice\n" + "4\tSettler mines coal\n"
				+ "5\tSettler mines uranium\n" + "6\tSettler mines iron\n" + "7\tSettler drills\n"
				+ "8\tSettler tries to hide\n" + "9\tSettler builds gate\n" + "10\tSettler builds base\n"
				+ "11\tSettler builds robot\n" + "12\tSettler drops uranium\n" + "13\tSettler drops ice\n"
				+ "14\tSettler drops coal\n" + "15\tSettler drops iron\n" + "16\tSettler drops robot\n"
				+ "17\tSettler drops gate\n" + "18\tRobot moves on asteroid\n" + "19\tRobot moves on gate\n"
				+ "20\tRobot drills\n" + "21\tRobot tries to hide\n" + "22\tCreate solar storm\n" + "23\tIce sublimates\n"
				+ "24\tUranium explodes\n" + "\n");
	}

	public void SettlerMovesOnAsteroid() throws Exception {
		System.out.println("SettlerMovesOnAsteroid:");

		// A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Asteroid a1 = new Asteroid();
		Asteroid a2 = new Asteroid();
		Asteroid a3 = new Asteroid();

		a1.addNeighbour(a2);
		a1.addNeighbour(a3);
		a2.addNeighbour(a1);
		a3.addNeighbour(a1);

		a1.addUnit(settler);

		Asteroid tomb[] = new Asteroid[] { a2, a3 };

		System.out.print("Az 0-ás vagy 1-es szomszédjára szeretnél menni?");
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		scanner.close();
		if (index < 0 && index > 1)
			throw new Exception("Ne légy gyökér!");

		settler.move(tomb[index]);

		// Ha oda is ér a teszt sikeres és boldogak vagyunk!
		if (settler.getAsteroid() == tomb[index]) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMovesOnGate() {
		System.out.println("SettlerMovesOnGate:");

		// A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Gate gate = new Gate();

		// A robotot átküldjük a kapu párjára
		settler.move(gate);

		// Ha a robot a kapu párját kapja jelenlegi helyzetnek a rálépés után a teszt
		// sikeres.
		if (settler.getReceiver() == gate.getPair()) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesIce() throws Exception {
		System.out.println("SettlerMinesIce:");

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Ice i = new Ice();

		s.move(a);
		a.insertCore(i);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if (a.getCore() == null && s.getInventory().get(0) == i) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesCoal() throws Exception {
		System.out.println("SettlerMinesCoal:");

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Coal c = new Coal();

		s.move(a);
		a.insertCore(c);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if (a.getCore() == null && s.getInventory().get(0) == c) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesUranium() throws Exception {
		System.out.println("SettlerMinesUranium:");

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Uranium u = new Uranium();

		s.move(a);
		a.insertCore(u);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if (a.getCore() == null && s.getInventory().get(0) == u) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesIron() throws Exception {
		System.out.println("SettlerMinesIron:");

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Iron i = new Iron();

		s.move(a);
		a.insertCore(i);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if (a.getCore() == null && s.getInventory().get(0) == i) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDrills() throws Exception {
		System.out.println("SettlerDrills");

		// A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Asteroid a = new Asteroid();

		settler.move(a);

		// Megkérdezzük a felhasználótól milyen vastagságú aszteroidát szeretne,
		// amit aztán vígán fúrcikázhat :)
		// FONTOSS!!! Figyelj, hogy jó réteg méretet adsz meg, mert a program csúnyán
		// leszid!
		System.out.print("Hany rétege legyen az aszteroidanak: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 1)
			throw new Exception("Ne légy gyökér!");

		// A megfelelő kéreg beállítás után a robot megfúrja az Aszteroida kérgét
		a.setLayerCount(layerCount);
		settler.drill();

		// Megvizsgáljuk, hogy valóban csökkent-e a kéreg szám, döntünk a teszt
		// kimeneteléről.
		if (a.getLayerCount() == layerCount - 1) {
			System.out.println("A teszt sikeres");
			return;
		}
		System.out.println("A teszt sikertelen");
	}

	public void SettlerTriesToHide() {
		System.out.println("SettlerTriesToHide");

		// A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Settler csicska = new Settler();
		Asteroid a = new Asteroid();

		settler.move(a);
		a.setLayerCount(0);

		// A program megkérdezi a felhasználót, hogy mikor megpróbál
		// elbújni a telepes akkor a mag legyen-e üres
		System.out.print("Az Aszteroida magaj legyen üres? (true/false)");
		Scanner scanner = new Scanner(System.in);
		boolean b = scanner.nextBoolean();
		scanner.close();

		if (!b) {
			csicska.toggleHide();
		}

		// Robot megpróbál elbújni
		settler.toggleHide();

		if (settler.isHiding() == b) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerBuildsGate() {
	}

	public void SettlerBuildsBase() {
	}

	public void SettlerBuildsRobot() {
	}

	public void SettlerDropsUranium() {
		System.out.println("SettlerDropsUranium:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Uranium u = new Uranium();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(u);

		if (s.getInventory().get(0) != u) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsIce() {
		System.out.println("SettlerDropsIce:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Ice i = new Ice();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(i);

		if (s.getInventory().get(0) != i) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsCoal() {
		System.out.println("SettlerDropsCoal:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Coal c = new Coal();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(c);

		if (s.getInventory().get(0) != c) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsIron() {
		System.out.println("SettlerDropsIron:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Iron i = new Iron();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(i);

		if (s.getInventory().get(0) != i) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsRobot() {
		System.out.println("SettlerDropsRobot:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Robot r = new Robot();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(r);

		if (s.getInventory().get(0) != r) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsGate() {
		System.out.println("SettlerDropsGate:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Gate g = new Gate();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(g);

		if (s.getInventory().get(0) != g) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		s.dropCargo(0);

		if (s.getInventory().get(0) == null) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void RobotMovesOnAsteroid() throws Exception {
		System.out.println("SettlerMovesOnAsteroid:");

		// A teszt esetünk környezetének inicializálása
		Robot robot = new Robot();
		Asteroid a1 = new Asteroid();
		Asteroid a2 = new Asteroid();
		Asteroid a3 = new Asteroid();
		Asteroid a4 = new Asteroid();
		Asteroid a5 = new Asteroid();

		a1.addNeighbour(a2);
		a1.addNeighbour(a3);
		a1.addNeighbour(a4);
		a1.addNeighbour(a5);
		a2.addNeighbour(a1);
		a3.addNeighbour(a1);
		a4.addNeighbour(a1);
		a5.addNeighbour(a1);
		a1.addUnit(robot);

		Asteroid tomb[] = new Asteroid[] { a2, a3, a4, a5 };

		System.out.print("A robot random választ a 4 szomszéd közül.");
		Random random = new Random();
		int index = random.nextInt(tomb.length);

		if (index < 0 && index > 4)
			throw new Exception("Hiba");

		robot.move(tomb[index]);

		// Ha oda is ér a teszt sikeres és boldogak vagyunk!
		if (robot.getAsteroid() == tomb[index]) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void RobotMovesOnGate() {
		System.out.println("SettlerMovesOnGate:");

		// A teszt esetünk környezetének inicializálása
		Robot robot = new Robot();
		Gate gate = new Gate();

		// A robotot átküldjük a kapu párjára
		robot.move(gate);

		// Ha a robot a kapu párját kapja jelenlegi helyzetnek a rálépés után a teszt
		// sikeres.
		if (robot.getReceiver() == gate.getPair()) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void RobotDrills() throws Exception {
		System.out.println("RobotDrills");

		// A teszt esetünk környezetének inicializálása
		Robot robot = new Robot();
		Asteroid a = new Asteroid();

		robot.move(a);

		// Megkérdezzük a felhasználótól milyen vastagságú aszteroidát szeretne,
		// amit aztán vígán fúrcikázhat :)
		// FONTOSS!!! Figyelj, hogy jó réteg méretet adsz meg, mert a program csúnyán
		// leszid!
		System.out.print("Hany rétege legyen az aszteroidanak: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 1)
			throw new Exception("Ne légy gyökér!");

		// A megfelelő kéreg beállítás után a robot megfúrja az Aszteroida kérgét
		a.setLayerCount(layerCount);
		robot.drill();

		// Megvizsgáljuk, hogy valóban csökkent-e a kéreg szám, döntünk a teszt
		// kimeneteléről.
		if (a.getLayerCount() == layerCount - 1) {
			System.out.println("A teszt sikeres");
			return;
		}
		System.out.println("A teszt sikertelen");
	}

	public void RobotTriesToHide() {
		System.out.println("RobotTriesToHide");

		// A teszt esetünk környezetének inicializálása
		Robot robot = new Robot();
		Settler csicska = new Settler();
		Asteroid a = new Asteroid();

		robot.move(a);
		a.setLayerCount(0);

		// A program megkérdezi a felhasználót, hogy mikor megpróbál
		// elbújni a robot akkor a mag legyen-e üres
		System.out.print("Az Aszteroida magja legyen üres? (true/false)");
		Scanner scanner = new Scanner(System.in);
		boolean b = scanner.nextBoolean();
		scanner.close();

		if (!b) {
			csicska.toggleHide();
		}

		// Robot megpróbál elbújni
		robot.toggleHide();

		if (robot.isHiding() == b) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void CreateSolarStorm() throws Exception {
		System.out.println("CreateSolarStorm");

		// A teszt esetünk környezetének inicializálása
		Sun sun = new Sun();
		Asteroid a = new Asteroid();
		Settler settler = new Settler();
		Robot robot = new Robot();

		Game.getLevel().addThing(a);
		Game.getLevel().addThing(settler);
		Game.getLevel().addThing(robot);
		settler.move(a);
		robot.move(a);
		// Itt már eleve úgy tüntetjük fel, hogy az aszteroidáhpz
		// tartozó kéreg szám az 0, mert itt nem az a lényeg.
		a.setLayerCount(0);

		// Bekér a felhasználótól egy stringet, a stringben a felhasználónak azt kell
		// megadnia hogy ki legyen elbújva az aszteroidában a zárójelben látható
		// karakterisztikával.
		System.out.print("A robot/telepes/senki se bujjon el az aszteroidában? (robot/telepes/senki)");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();

		// A Nap Vissza számol, hogy mennyi kör múlva lesz napvihar.
		while (sun.getTimeTillStorm() != 0) {
			sun.tick();
		}

		// Ha a visszaszámláló 0-hoz ér akkor a felhasználói döntés alapján a következők
		// történhetnek:
		// a= ha a robot van elbújva, ő túl éli de a telepes meghal
		// b= ha a telepes van elbújva a robot hal meg a telepes éli túl
		// c= senki nem bújik el, a robot és a telepes is meghal
		// EXCEPTION= valamit elírtál, nem követted a karakterisztikát
		switch (s) {
		case "robot":
			robot.toggleHide();
			settler.die();

			if (Game.getLevel().removeThing(settler)) {
				System.out.println("A teszt sikeres.");
				return;
			}
			System.out.println("A teszt sikertelen.");

			break;
		case "telepes":
			settler.toggleHide();
			robot.die();

			if (Game.getLevel().removeThing(robot)) {
				System.out.println("A teszt sikeres.");
				return;
			}
			System.out.println("A teszt sikertelen.");

			break;
		case "senki":
			settler.die();
			robot.die();

			if (Game.getLevel().removeThing(settler) && Game.getLevel().removeThing(robot)) {
				System.out.println("A teszt sikeres.");
				return;
			}
			System.out.println("A teszt sikertelen.");

			break;
		default:
			throw new Exception("Elirtad Sry! Próbáld újra!");
		}
	}

	public void IceSublimation() throws Exception {
		System.out.println("SettlerMinesIce:");

		Asteroid a = new Asteroid();
		CoreMaterial cm = new Ice();
		cm.insertToCoreOf(a);
		MaterialOre core = new MaterialOre(cm);

		core.insertToCoreOf(a);

		Game.getLevel().addThing(a);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		System.out.print("Közel van-e a naphoz az aszteroida? ");
		scanner = new Scanner(System.in);
		boolean closeToSun = scanner.nextBoolean();
		scanner.close();
		a.setCloseToSun(closeToSun);

		Game.getLevel().tickThings();

		if (layerCount == 0 && closeToSun == true) {
			if (Game.getLevel().removeThing(cm)) {
				System.out.println("A teszt sikertelen.");
				return;
			}
			System.out.println("A teszt sikeres.");
			return;
		}
		if (Game.getLevel().removeThing(cm)) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void UraniumExplodes() throws Exception {
		System.out.println("SettlerMinesIce:");

		Asteroid a = new Asteroid();
		CoreMaterial cm = new Uranium();
		cm.insertToCoreOf(a);
		MaterialOre core = new MaterialOre(cm);
		Settler s = new Settler();
		Robot r = new Robot();

		core.insertToCoreOf(a);
		s.move(a);
		r.move(a);

		Game.getLevel().addThing(a);
		Game.getLevel().addThing(s);
		Game.getLevel().addThing(r);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		System.out.print("Közel van-e a naphoz az aszteroida? ");
		scanner = new Scanner(System.in);
		boolean closeToSun = scanner.nextBoolean();
		scanner.close();
		a.setCloseToSun(closeToSun);

		a.extractCore(s);

		if (layerCount == 0 && closeToSun == true) {
			if (Game.getLevel().removeThing(a)) {
				System.out.println("A teszt sikertelen.");
				return;
			}
			System.out.println("A teszt sikeres.");
			return;
		}
		if (Game.getLevel().removeThing(a)) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}
}

public class App {
	static Test test = new Test();

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int optionNumber;
		while (true) {
			Test.TesztMetodusokKiras();
			System.out.print("Melyik teszt fusson? ");
			optionNumber = scanner.nextInt();
			if (optionNumber < 1 || optionNumber > 24) {
				break;
			}
			functions[optionNumber - 1].run();
		}
		scanner.close();
	}

	static Functions[] functions = new Functions[] { test::SettlerMovesOnAsteroid, test::SettlerMovesOnGate,
			test::SettlerMinesIce, test::SettlerMinesCoal, test::SettlerMinesUranium, test::SettlerMinesIron,
			test::SettlerDrills, test::SettlerTriesToHide, test::SettlerBuildsGate, test::SettlerBuildsBase,
			test::SettlerBuildsRobot, test::SettlerDropsUranium, test::SettlerDropsIce, test::SettlerDropsCoal,
			test::SettlerDropsIron, test::SettlerDropsRobot, test::SettlerDropsGate, test::RobotMovesOnAsteroid,
			test::RobotMovesOnGate, test::RobotDrills, test::RobotTriesToHide, test::CreateSolarStorm, test::IceSublimation,
			test::UraniumExplodes };

	public interface Functions {
		void run() throws Exception;
	}
}
