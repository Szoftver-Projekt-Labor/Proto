package com.panzerkampfwagen.graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Textures {

	private static final Map<String, Image> images = new HashMap<>();

	static {

		importAs("Asteroid", "assets/Asteroid.png");
		importAs("AsteroidCoal", "assets/AsteroidCoal.png");
		importAs("AsteroidEmpty", "assets/AsteroidEmpty.png");
		importAs("AsteroidIce", "assets/AsteroidIce.png");
		importAs("AsteroidIron", "assets/AsteroidIron.png");
		importAs("AsteroidMini", "assets/AsteroidMini.png");
		importAs("AsteroidRobot", "assets/AsteroidRobot.png");
		importAs("AsteroidSettler", "assets/AsteroidSettler.png");
		importAs("AsteroidStatusBar", "assets/AsteroidStatusBar.png");
		importAs("AsteroidUfo", "assets/AsteroidUfo.png");
		importAs("AsteroidUranium", "assets/AsteroidUranium.png");
		importAs("Buttons", "assets/Buttons.png");
		importAs("CoalIcon", "assets/CoalIcon.png");
		importAs("GateMiniSilly", "assets/GateMiniSilly.png");
		importAs("IceIcon", "assets/IceIcon.png");
		importAs("IronIcon", "assets/IronIcon.png");
		importAs("NormalBackground", "assets/NormalBackground.png");
		importAs("ProximityBackground", "assets/ProximityBackground.png");
		importAs("ProximitySolarStormBackground", "assets/ProximitySolarStormBackground.png");
		importAs("RobotIcon", "assets/RobotIcon.png");
		importAs("RocketTextures", "assets/RocketTextures.png");
		importAs("SettlerIcon", "assets/SettlerIcon.png");
		importAs("SolarStormBackground", "assets/SolarStormBackground.png");
		importAs("UfoIcon", "assets/UfoIcon.png");
		importAs("Units", "assets/Units.png");
		importAs("UraniumIcon", "assets/UraniumIcon.png");
	}

	private static void importAs(String name, String url) {
		try {
			images.put(name, ImageIO.read(new File(url)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Image getTexture(String name) {
		return images.get(name);
	}
}
