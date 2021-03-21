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
		} else System.out.println("A teszt sikertelen.");		 
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
		} else System.out.println("A teszt sikertelen.");
	}

	public void SettlerMinesIce(){}
	public void SettlerMinesCoal(){}
	public void SettlerMinesUranium(){}
	public void SettlerMinesIron(){}
	public void SettlerDrills(){}
	public void SettlerTriestoHide(){}
	public void SettlerBuildsGate(){}
	public void SettlerBuildsBase(){}
	public void SettlerBuildsRobot(){}
	public void SettlerDropsUranium(){}
	public void SettlerDropsIce(){}
	public void SettlerDropsCoal(){}
	public void SettlerDropsIron(){}
	public void SettlerDropsRobot(){}
	public void SettlerDropsGate(){}
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
