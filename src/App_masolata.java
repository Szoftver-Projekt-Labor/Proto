import java.util.Scanner;
import com.panzerkampfwagen.*;

class Test_copy {
	
	public static void TesztMetodusokKiras() {
		System.out.println(
			"Itt lathatoak a tesztesetekhez tartozo sorszamok"
			+"Futtatáshoz kérjuk a teszt sorszamat beírni a konzolra"
			+"1\tSettler moves on asteroid\n"
			+"2\tSettler moves on gate\n"
			+"3\tSettler mines ice\n"
			+"4\tSettler mines coal\n"
			+"5\tSettler mines uranium\n"
			+"6\tSettler mines iron\n"
			+"7\tSettler drills\n"
			+"8\tSettler tries to hide\n"
			+"9\tSettler builds gate\n"
			+"10\tSettler builds base\n"
			+"11\tSettler builds robot\n"
			+"12\tSettler drops uranium\n"
			+"13\tSettler drops ice\n"
			+"14\tSettler drops coal\n"
			+"15\tSettler drops iron\n"
			+"16\tSettler drops robot\n"
			+"17\tSettler drops gate\n"
			+"18\tRobot moves on asteroid\n"
			+"19\tRobot moves on gate\n"
			+"20\tRobot drills\n"
			+"21\tRobot tries to hide\n"
			+"22\tCreate solar storm\n"
			+"23\tIce sublimates\n"
			+"24\tUranium explodes\n"
			+"\n"
		);	
	}

	public void SettlerMovesOnAsteroid() {
		System.out.println("SettlerMovesOnAsteroid:");

		Settler settler = new Settler();
		Asteroid a1 = new Asteroid();
		Asteroid a2 = new Asteroid();

		a1.addNeighbour(a2);
		a2.addNeighbour(a1);

		a1.addUnit(settler);
		settler.move(a2);

		if(settler.getAsteroid() == a2){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");	 
	}

	public void SettlerMovesOnGate(){
		System.out.println("SettlerMovesOnGate:");

		Settler settler = new Settler();
		Asteroid a1 = new Asteroid();
		Asteroid a2 = new Asteroid();

		a1.addNeighbour(a2);
		a2.addNeighbour(a1);

		a1.addUnit(settler);
		settler.move(a2);

		if(settler.getAsteroid() == a2){
			System.out.println("A teszt sikeres.");
			return;
		}
		System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesIce() throws Exception{
		System.out.println("SettlerMinesIce:");

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
	public void SettlerDrills(){}
	public void SettlerTriestoHide(){}
	public void SettlerBuildsGate(){}
	public void SettlerBuildsBase(){}
	public void SettlerBuildsRobot(){}

	public void SettlerDropsUranium(){
		System.out.println("SettlerDropsUranium:");

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
	
	public void RobotMovesOnAsteroid(){}
	public void RobotMovesOnGate(){}
	public void RobotDrills(){}
	public void RobotTriestoHide(){}
	public void CreateSolarStrom(){}
	public void IceSublimation(){}
	public void UraniumExplodes(){}
	}

public class App_masolata {
	public static void main(String[] args) throws Exception {
		
		Test.TesztMetodusokKiras();			
	}
}
