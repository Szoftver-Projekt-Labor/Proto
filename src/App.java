import java.util.Random;
import java.util.Scanner;
import com.panzerkampfwagen.*;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		// Teszt esetek kiválasztása
		int optionNumber;
		while (true) {
			App testSuite = new App();
			TesztMetodusokKiras();
			System.out.print("Melyik teszt fusson? ");
			optionNumber = scanner.nextInt();
			if (optionNumber < 1 || optionNumber > 24) {
				break;
			}
			testSuite.functions[optionNumber - 1].run();
		}
		scanner.close();
	}

	// Teszt eseteket egy lsitába szedtük és index szerűen hivatkozunk rájuk
	Functions[] functions = new Functions[] { this::SettlerMovesOnAsteroid, this::SettlerMovesOnGate,
			this::SettlerMinesIce, this::SettlerMinesCoal, this::SettlerMinesUranium, this::SettlerMinesIron,
			this::SettlerDrills, this::SettlerTriesToHide, this::SettlerBuildsGate, this::SettlerBuildsBase,
			this::SettlerBuildsRobot, this::SettlerDropsUranium, this::SettlerDropsIce, this::SettlerDropsCoal,
			this::SettlerDropsIron, this::SettlerDropsRobot, this::SettlerDropsGate, this::RobotMovesOnAsteroid,
			this::RobotMovesOnGate, this::RobotDrills, this::RobotTriesToHide, this::CreateSolarStorm, this::IceSublimation,
			this::UraniumExplodes };

	public interface Functions {
		void run() throws Exception;
	}

	// Kíírja az általunk megírt teszt metódusokat és elmagyaráza röviden a
	// használatott
	public static void TesztMetodusokKiras() {
		System.out.println("\nItt lathatoak a tesztesetekhez tartozo sorszamok\n"
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

		// Megkérdezzük a felhasználótól melyik szomszédos Aszteroidára szeretne menni
		// FONTOSS!!! Figyelj, hogy jó indexet adj meg, mert a program csúnyán
		// leszid!
		System.out.print("Az 0-ás vagy 1-es szomszédjára szeretnél menni?");
		int index = scanner.nextInt();
		if (index < 0 && index > 1)
			throw new Exception("Ne légy gyökér!");

		// A telepes a kiválasztott aszteroidára utazik
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
		Asteroid ateroid = new Asteroid();
		Settler settler = new Settler();
		settler.move(ateroid);
		settler.loadCargo(new Item[] { new Iron(), new Iron(), new Ice(), new Uranium()});
		settler.build("gate");
		settler.dropCargo(settler.getInventory().size()-1);
		settler.dropCargo(settler.getInventory().size()-1);

		// A robotot átküldjük a kapu párjára
		Gate targetGate = (Gate) settler.getReceiver().getNeighbour(0);
		settler.move(targetGate);

		// Ha a settler a kapu párját kapja jelenlegi helyzetnek a rálépés után a teszt
		// sikeres.
		if (settler.getReceiver() == targetGate.getPair()) {
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
		// Feltöltjük az Aszteroida magját a megfelelő nyersanyaggal
		i.insertToCoreOf(a);

		// Megkérdezzük a felhasználótól milyen vastag kérgű aszteroidát szeretnénk
		// FONTOSS!! Valós réteg méretet adj meg mert másképp beszól a program
		// ˘\(°-°)/˘
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		// Kéreg beállítás
		a.setLayerCount(layerCount);
		// Bányászat
		s.mine();

		// Akkor sikeres a tesztünk ha az anyag bekerült az inventoryba
		// és eltűnt az aszteroida közepéből
		if (a.getCore() == null && s.getInventory().get(0) == i) {
			System.out.println("A teszt sikeres.");
			return;
		}
		if (layerCount > 0) {
			System.out.println("Ugye nem gondoltad, hogy ilyen adatokkal ki fogod bányászni?");
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
		// Feltöltjük az Aszteroida magját a megfelelő nyersanyaggal
		c.insertToCoreOf(a);

		// Megkérdezzük a felhasználótól milyen vastag kérgű aszteroidát szeretnénk
		// FONTOSS!! Valós réteg méretet adj meg mert másképp beszól a program
		// ˘\(°-°)/˘
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();
		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		// Kéreg beállítás
		a.setLayerCount(layerCount);
		// Bányászat
		s.mine();

		// Akkor sikeres a tesztünk ha az anyag bekerült az inventoryba
		// és eltűnt az aszteroida közepéből
		if (a.getCore() == null && s.getInventory().get(0) == c) {
			System.out.println("A teszt sikeres.");
			return;
		}
		if (layerCount > 0) {
			System.out.println("Ugye nem gondoltad, hogy ilyen adatokkal ki fogod bányászni?");
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
		// Feltöltjük az Aszteroida magját a megfelelő nyersanyaggal
		u.insertToCoreOf(a);

		// Megkérdezzük a felhasználótól milyen vastag kérgű aszteroidát szeretnénk
		// FONTOSS!! Valós réteg méretet adj meg mert másképp beszól a program
		// ˘\(°-°)/˘
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();

		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		// Kéreg beállítás
		a.setLayerCount(layerCount);
		// Bányászat
		s.mine();

		// Akkor sikeres a tesztünk ha az anyag bekerült az inventoryba
		// és eltűnt az aszteroida közepéből
		if (a.getCore() == null && s.getInventory().get(0) == u) {
			System.out.println("A teszt sikeres.");
			return;
		}
		if (layerCount > 0) {
			System.out.println("Ugye nem gondoltad, hogy ilyen adatokkal ki fogod bányászni?");
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
		// Feltöltjük az Aszteroida magját a megfelelő nyersanyaggal
		i.insertToCoreOf(a);

		// Megkérdezzük a felhasználótól milyen vastag kérgű aszteroidát szeretnénk
		// FONTOSS!! Valós réteg méretet adj meg mert másképp beszól a program
		// ˘\(°-°)/˘
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();

		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		// Kéreg beállítás
		a.setLayerCount(layerCount);
		// Bányászat
		s.mine();

		// Akkor sikeres a tesztünk ha az anyag bekerült az inventoryba
		// és eltűnt az aszteroida közepéből
		if (a.getCore() == null && s.getInventory().get(0) == i) {
			System.out.println("A teszt sikeres.");
			return;
		}
		if (layerCount > 0) {
			System.out.println("Ugye nem gondoltad, hogy ilyen adatokkal ki fogod bányászni?");
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
		int layerCount = scanner.nextInt();

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
		csicska.move(a);
		a.setLayerCount(0);

		// A program megkérdezi a felhasználót, hogy mikor megpróbál
		// elbújni a telepes akkor a mag legyen-e üres
		System.out.print("Az Aszteroida magja legyen üres? (true/false)");
		boolean b = scanner.nextBoolean();

		if (!b) {
			csicska.toggleHide();
		}

		// Settler megpróbál elbújni
		settler.toggleHide();

		if (settler.isHiding() == b) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerBuildsGate() {
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Settler s2 = new Settler();
		s.move(a);
		s2.move(a);
		s.loadCargo(new Item[] { new Uranium(), new Iron()});
		s2.loadCargo(new Item[] { new Iron(), new Ice() });

		s.build("gate");

		if (s.getInventory().get(0) instanceof Gate) {
			System.out.println("Sikeres teszt.");
			return;
		}
		System.out.println("Fail.");
	}

	public void SettlerBuildsBase() {
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Settler s2 = new Settler();
		s.move(a);
		s2.move(a);
		s.loadCargo(new Item[] { new Uranium(), new Coal(), new Uranium(),new Uranium(), new Iron(), new Coal()});
		s2.loadCargo(new Item[] { new Iron(), new Iron(), new Coal(), new Ice(), new Ice(), new Ice(), new Coal()});

		s.build("base");

		if (s.getInventory().get(0) instanceof Base) {
			System.out.println("Sikeres teszt.");
			return;
		}
		System.out.println("Fail.");
	}

	public void SettlerBuildsRobot() {
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Settler s2 = new Settler();
		s.move(a);
		s2.move(a);
		s.loadCargo(new Item[] { new Uranium(), new Iron()});
		s2.loadCargo(new Item[] { new Coal(), new Uranium() });

		s.build("robot");

		if (s.getInventory().get(0) instanceof Robot) {
			System.out.println("Sikeres teszt.");
			return;
		}
		System.out.println("Fail.");
	}

	public void SettlerDropsUranium() {
		System.out.println("SettlerDropsUranium:");

		// A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Uranium u = new Uranium();
		Asteroid a = new Asteroid();

		s.move(a);
		// A LoadCArgo működésének tesztelése
		s.loadCargo(u);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != u) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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
		// A LoadCArgo működésének tesztelése
		s.loadCargo(i);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != i) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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
		// A LoadCArgo működésének tesztelése
		s.loadCargo(c);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != c) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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
		// A LoadCArgo működésének tesztelése
		s.loadCargo(i);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != i) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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
		// A LoadCArgo működésének tesztelése
		s.loadCargo(r);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != r) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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
		// A LoadCArgo működésének tesztelése
		s.loadCargo(g);

		// LoadCargo tesztrész ha esetleg hibát dob akkor az itt jelentkezik
		if (s.getInventory().get(0) != g) {
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");

		// Az kiválasztott Item kidobása az inventoryból
		s.dropCargo(0);

		// A dropCargo tesztjének vizsgálatának kiértékelése
		// Sikeres ha az inventorynk üres lesz a teszt végére
		if (s.getInventory().size() == 0) {
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

		// Az "AI" kiválasztja az Aszteroida szomszédjai közöl 1-et random
		// és arra küldi a robotot
		System.out.print("A robot random választ a 4 szomszéd közül.");
		Random random = new Random();
		int index = random.nextInt(tomb.length);

		if (index < 0 && index > 4)
			throw new Exception("Hiba");
		// A robot a kiválasztott aszteroidára utazik
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
		// Mivel a robot nem tud építeni az inicializáláshoz, ezért egy settler fog
		Asteroid ateroid = new Asteroid();
		Settler settler = new Settler();
		Robot robot = new Robot();
		settler.move(ateroid);
		settler.loadCargo(new Item[] { new Iron(), new Iron(), new Ice(), new Uranium()});
		settler.build("gate");
		settler.dropCargo(settler.getInventory().size()-1);
		settler.dropCargo(settler.getInventory().size()-1);

		// A robotot átküldjük a kapu párjára
		Gate targetGate = (Gate) settler.getReceiver().getNeighbour(0);
		robot.move(targetGate);

		// Ha a robot a kapu párját kapja jelenlegi helyzetnek a rálépés után a teszt
		// sikeres.
		if (robot.getReceiver() == targetGate.getPair()) {
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
		int layerCount = scanner.nextInt();

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
		csicska.move(a);
		a.setLayerCount(0);

		// A program megkérdezi a felhasználót, hogy mikor megpróbál
		// elbújni a robot akkor a mag legyen-e üres
		System.out.print("Az Aszteroida magja legyen üres? (true/false)");
		boolean b = scanner.nextBoolean();

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
		String s = scanner.nextLine();

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

			if (!Game.getLevel().removeThing(settler)) {
				System.out.println("A teszt sikeres.");
				return;
			}
			System.out.println("A teszt sikertelen.");

			break;
		case "telepes":
			settler.toggleHide();
			robot.die();

			if (!Game.getLevel().removeThing(robot)) {
				System.out.println("A teszt sikeres.");
				return;
			}
			System.out.println("A teszt sikertelen.");

			break;
		case "senki":
			settler.die();
			robot.die();

			if (!Game.getLevel().removeThing(settler) && !Game.getLevel().removeThing(robot)) {
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

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Ice cm = new Ice();
		cm.insertToCoreOf(a);
		MaterialOre core = new MaterialOre(cm);

		core.insertToCoreOf(a);

		Game.getLevel().addThing(a);

		// Az Aszteroida rétegszámát beállítjuk
		// Ha nem 0 és valid érték lett megadva akkor beállításra kerül
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();

		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		// Megkérdezzük, hogy az Aszteroidánk legyen e napközelben vagy sem,
		// Dönthet a kedves kolléga erről :)
		System.out.print("Közel van-e a naphoz az aszteroida?(true/false) ");
		boolean closeToSun = scanner.nextBoolean();

		a.setCloseToSun(closeToSun);

		// Léptetjük a kátékunkat egy körrel
		// ami hatására végbe mennek a változások
		Game.getLevel().tickThings();

		// Teszt kiértékelése a felhasználó választásai alapján
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

		// A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Uranium cm = new Uranium();
		MaterialOre core = new MaterialOre(cm);
		Settler s = new Settler();
		Robot r = new Robot();

		core.insertToCoreOf(a);
		s.move(a);
		r.move(a);

		Game.getLevel().addThing(a);
		Game.getLevel().addThing(s);
		Game.getLevel().addThing(r);

		// Az Aszteroida rétegszámát beállítjuk
		// Ha nem 0 és valid érték lett megadva akkor beállításra kerül
		System.out.print("Hány rétege legyen az aszteroidának: ");
		int layerCount = scanner.nextInt();

		if (layerCount < 0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		// Megkérdezzük, hogy az Aszteroidánk legyen e napközelben vagy sem,
		// Dönthet a kedves kolléga erről :)
		System.out.print("Közel van-e a naphoz az aszteroida?(true/false) ");
		boolean closeToSun = scanner.nextBoolean();

		a.setCloseToSun(closeToSun);

		// Kibányászuk az Uránt az adott feltételek alapján
		a.extractCore(s);

		// Teszt kiértékelése a felhasználó választásai alapján
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
