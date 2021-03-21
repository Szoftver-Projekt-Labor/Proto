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

		//A teszt esetünk környezetének inicializálása
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

		//A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Gate gate = new Gate();

		settler.move(gate);

		if (settler.getReceiver() == gate.getPair()) {
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesIce() throws Exception{
		System.out.println("SettlerMinesIce:");

		//A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Ice i = new Ice();

		s.move(a);
		a.insertCore(i);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if(layerCount<0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if(a.getCore()==null && s.getInventory()[0]==i){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesCoal() throws Exception{
		System.out.println("SettlerMinesCoal:");

		//A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Coal c = new Coal();

		s.move(a);
		a.insertCore(c);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if(layerCount<0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if(a.getCore()==null && s.getInventory()[0]==c){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesUranium() throws Exception{
		System.out.println("SettlerMinesUranium:");

		//A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Uranium u = new Uranium();

		s.move(a);
		a.insertCore(u);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if(layerCount<0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if(a.getCore()==null && s.getInventory()[0]==u){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}
	
	public void SettlerMinesIron() throws Exception{
		System.out.println("SettlerMinesIron:");

		//A teszt esetünk környezetének inicializálása
		Asteroid a = new Asteroid();
		Settler s = new Settler();
		Iron i = new Iron();

		s.move(a);
		a.insertCore(i);

		System.out.print("Hány rétege legyen az aszteroidának: ");
		Scanner scanner = new Scanner(System.in);
		int layerCount = scanner.nextInt();
		scanner.close();
		if(layerCount<0)
			throw new Exception("Ne légy gyökér!");
		a.setLayerCount(layerCount);

		s.mine();

		if(a.getCore()==null && s.getInventory()[0]==i){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}
	
	public void SettlerDrills() throws Exception {
		System.out.println("SettlerDrills");

		//A teszt esetünk környezetének inicializálása
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

	public void SettlerTriesToHide() {
		System.out.println("SettlerTriesToHide");

		//A teszt esetünk környezetének inicializálása
		Settler settler = new Settler();
		Settler csicska = new Settler();
		Asteroid a = new Asteroid();

		settler.move(a);
		a.setLayerCount(0);

		System.out.print("Az Aszteroida magaj legyen üres? (true/false)");
		Scanner scanner = new Scanner(System.in);
		boolean b = scanner.nextBoolean();
		scanner.close();

		if(!b){
			csicska.toggleHide();
		}

		settler.toggleHide();

		if(settler.isHiding() == b){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerBuildsGate() {}
	public void SettlerBuildsBase() {}
	public void SettlerBuildsRobot() {}

	public void SettlerDropsUranium(){
		System.out.println("SettlerDropsUranium:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Uranium u = new Uranium();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(u);

		if(s.getInventory()[0]!=u){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");	
	}

	public void SettlerDropsIce(){
		System.out.println("SettlerDropsIce:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Ice i = new Ice();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(i);

		if(s.getInventory()[0]!=i){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}
	
	public void SettlerDropsCoal(){
		System.out.println("SettlerDropsCoal:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Coal c = new Coal();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(c);

		if(s.getInventory()[0]!=c){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsIron(){
		System.out.println("SettlerDropsIron:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Iron i = new Iron();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(i);

		if(s.getInventory()[0]!=i){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}
	
	public void SettlerDropsRobot(){
		System.out.println("SettlerDropsRobot:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Robot r = new Robot();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(r);

		if(s.getInventory()[0]!=r){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerDropsGate(){
		System.out.println("SettlerDropsGate:");

		//A teszt esetünk környezetének inicializálása
		Settler s = new Settler();
		Gate g = new Gate();
		Asteroid a = new Asteroid();

		s.move(a);
		s.loadCargo(g);

		if(s.getInventory()[0]!=g){
			System.out.println("Az inicializacioval gond van.");
			return;
		}
		System.out.println("Az inicializacio sikeres.");
		
		s.dropCargo(0);

		if(s.getInventory()[0]==null){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void RobotMovesOnAsteroid() throws Exception {
		System.out.println("SettlerMovesOnAsteroid:");

		//A teszt esetünk környezetének inicializálása
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

		//A teszt esetünk környezetének inicializálása
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

		//A teszt esetünk környezetének inicializálása
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
		System.out.println("RobotTriesToHide");

		//A teszt esetünk környezetének inicializálása
		Robot robot = new Robot();
		Settler csicska = new Settler();
		Asteroid a = new Asteroid();

		robot.move(a);
		a.setLayerCount(0);

		System.out.print("Az Aszteroida magja legyen üres? (true/false)");
		Scanner scanner = new Scanner(System.in);
		boolean b = scanner.nextBoolean();
		scanner.close();

		if(!b){
			csicska.toggleHide();
		}

		robot.toggleHide();

		if(robot.isHiding() == b){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void CreateSolarStorm() throws Exception{
		System.out.println("CreateSolarStorm");

		//A teszt esetünk környezetének inicializálása
		Game game = new Game();
		Level level = new Level();
		Sun sun = new Sun();
		Asteroid a = new Asteroid();
		Settler settler = new Settler();
		Robot robot = new Robot();

		//game.
		level.addThing(a);
		level.addThing(settler);
		level.addThing(robot);
		a.addUnit(settler);
		a.addUnit(robot);
		a.setLayerCount(0);

		System.out.print("A robot/telepes/senki se bujjon el az aszteroidában? (robot/telepes/senki)");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();

		while(sun.getTimeTillStorm() != 0){
			sun.tick();
		}

		switch (s) {
			case "robot":
				robot.toggleHide();
				settler.die();

				if(){
					System.out.println("A teszt sikeres.");
					return;
				}
				System.out.println("A teszt sikertelen.");

				break;
			case "telepes":
				settler.toggleHide();
				robot.die();

				if(){
					System.out.println("A teszt sikeres.");
					return;
				}
				System.out.println("A teszt sikertelen.");

				break;
			case "senki":
				settler.die();
				robot.die();

				if(){
					System.out.println("A teszt sikeres.");
					return;
				}
				System.out.println("A teszt sikertelen.");

				break;		
			default:
				throw new Exception("Elirtad Sry! Próbáld újra!");
		}		
	}

	public void IceSublimation() {
	}

	public void UraniumExplodes() {
	}

/*
Megtelt a tárhelyem,
Nem fér belém több emlék,
Érzelemalkalmazás játszik velem,
S még száz lenne, mit telepítenék.
.
Ingyenes vírusirtó tart tisztán.
Mindent megállít, amit nem kellene,
S a reklámok a Spotify lejátszási listán
Zavarnak, de nincs mit tenni ellene.
.
Lassulok és gyorsan merülök,
Ha nem cselekszem gyorsan,
Az eldobott flopi sorsára kerülök,
Haszontalanul heverve a porban.
.
Visszaállítanám magam a kezdetekre,
A tudatlan, gyári beállításra,
De szükségem van az emlékekre,
Az érzelmekre és semmi másra.
.
Emlék, érzés... ezek lassítanak,
De ezek is tesznek azzá, aki vagyok.
Az adatok szinte kettéhasítanak,
Elromlani én nem akarok.
.
Minden személyes adat és minden letöltött alkalmazás törlődni fog.
Helyreállításunkra nem lesz lehetőség...
.
.
Törli mindet?
.
.
Törlés.
*/
}

public class App {
	public static void main(String[] args) throws Exception {

		Test.TesztMetodusokKiras();
	}
}
