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
				+ "20\tRobot drills\n" + "21\tRobot tries to hide\n" + "22\tCreate solar storm\n"
				+ "23\tIce sublimates\n" + "24\tUranium explodes\n" + "\n");
	}

	public void SettlerMovesOnAsteroid() throws Exception {
		System.out.println("SettlerMovesOnAsteroid:");

		Settler settler = new Settler();
		Asteroid a1 = new Asteroid();
		Asteroid a2 = new Asteroid();
		Asteroid a3 = new Asteroid();

		a1.addNeighbour(a2);
		a1.addNeighbour(a3);
		a2.addNeighbour(a1);
		a3.addNeighbour(a1);

		a1.addUnit(settler);

		Asteroid tomb[] = new Asteroid[]{a2,a3};
		
		System.out.print("Az 0-ás vagy 1-es szomszédjára szeretnél menni?");
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		scanner.close();		
		if (index < 0 && index > 1)
			throw new Exception("Ne légy gyökér!");				
		
		settler.move(tomb[index]);	

		if (settler.getAsteroid() == tomb[index]) {
			System.out.println("A teszt sikeres.");
			return;
		} 
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMovesOnGate() {
		System.out.println("SettlerMovesOnGate:");

		Settler settler = new Settler();
		Gate gate = new Gate();

		settler.move(gate);

		if (settler.getReceiver() == gate.getPair()) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	// public void SettlerMinesIce(){}
	// public void SettlerMinesCoal(){}
	// public void SettlerMinesUranium(){}
	// public void SettlerMinesIron(){}

	public void SettlerDrills() throws Exception {
		System.out.println("SettlerDrills");

		Settler settler = new Settler();
		Asteroid a = new Asteroid();

		settler.move(a);

		System.out.print("Hany rétege legyen az aszteroidanak: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();	
		if (layerCount < 1)
			throw new Exception("Ne légy gyökér!");

		a.setLayerCount(layerCount);
		settler.drill();

		if (a.getLayerCount() == layerCount - 1) {
			System.out.println("A teszt sikeres");
			return;
		} 
		System.out.println("A teszt sikertelen");
	}

	public void SettlerTriesToHide() {}
	public void SettlerBuildsGate() {}
	public void SettlerBuildsBase() {}
	public void SettlerBuildsRobot() {}

	//public void SettlerDropsUranium() {}
	//public void SettlerDropsIce() {}
	//public void SettlerDropsCoal() {}
	//public void SettlerDropsIron() {}
	//public void SettlerDropsRobot() {}
	//public void SettlerDropsGate() {}

	public void RobotMovesOnAsteroid() throws Exception {
		System.out.println("SettlerMovesOnAsteroid:");

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

		Asteroid tomb[] = new Asteroid[]{a2,a3,a4,a5};
		
		System.out.print("A robot random választ a 4 szomszéd közül.");

		Random random = new Random();
		int index = random.nextInt(tomb.length);
				
		if (index < 0 && index > 4)
			throw new Exception("Ne légy gyökér!");				
		
		robot.move(tomb[index]);	

		if (robot.getAsteroid() == tomb[index]) {
			System.out.println("A teszt sikeres.");
			return;
		} 
		System.out.println("A teszt sikertelen.");
	}	

	public void RobotMovesOnGate() {
		System.out.println("SettlerMovesOnGate:");

		Robot robot = new Robot();
		Gate gate = new Gate();

		robot.move(gate);

		if (robot.getReceiver() == gate.getPair()) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void RobotDrills() throws Exception {
		System.out.println("RobotDrills");

		Robot robot = new Robot();
		Asteroid a = new Asteroid();

		robot.move(a);

		System.out.print("Hany rétege legyen az aszteroidanak: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();	
		if (layerCount < 1)
			throw new Exception("Ne légy gyökér!");

		a.setLayerCount(layerCount);
		robot.drill();

		if (a.getLayerCount() == layerCount - 1) {
			System.out.println("A teszt sikeres");
			return;
		} 
		System.out.println("A teszt sikertelen");
	}

	public void RobotTriesToHide() {
	}

	public void CreateSolarStrom() {
	}

	public void IceSublimation() {
	}

	public void UraniumExplodes() {
	}
}

public class App {
	public static void main(String[] args) throws Exception {

		Test.TesztMetodusokKiras();
	}
}
