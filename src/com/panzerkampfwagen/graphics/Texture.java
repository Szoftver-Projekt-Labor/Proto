package com.panzerkampfwagen.graphics;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

public class Texture {
    public Image asteroidImage;
    public Image asteroidCoalImage;
    public Image asteroidEmptyImage;
    public Image asteroidIceImage;
    public Image asteroidIronImage;
    public Image asteroidMiniImage;
    public Image asteroidRobotImage;
    public Image asteroidSettlerImage;
    public Image asteroidStatusBarImage;
    public Image asteroidUfoImage;
    public Image asteroidUraniumImage;
    public Image asteroidButtonsImage;
    public Image coalIconImage;
    public Image gateIconImage;
    public Image gateMiniImage;
    public Image gateMiniSillyImage;
    public Image iceIconImage;
    public Image ironIconImage;
    public Image normalBackgroundImage;
    public Image proximityBackgroundImage;
    public Image proximitySolarStormBackgroundImage;
    public Image robotIconImage;
    public Image rocketTextureImage;
    public Image settlerIconImage;
    public Image solarStormBackgroundImage;
    public Image ufoIconImage;
    public Image unitsImage;
    public Image uraniumIconImage;

    public Texture() {
        try {
            asteroidImage = ImageIO.read(new File("assets\\Asteroid.png"));
            asteroidCoalImage = ImageIO.read(new File("assets\\AsteroidCoal.png"));
            asteroidEmptyImage = ImageIO.read(new File("assets\\AsteroidEmpty.png"));
            asteroidIceImage = ImageIO.read(new File("assets\\AsteroidIce.png"));
            asteroidIronImage = ImageIO.read(new File("assets\\AsteroidIron.png"));
            asteroidMiniImage = ImageIO.read(new File("assets\\AsteroidMini.png"));
            asteroidRobotImage = ImageIO.read(new File("assets\\AsteroidRobot.png"));
            asteroidSettlerImage = ImageIO.read(new File("assets\\AsteroidSettler.png"));
            asteroidStatusBarImage = ImageIO.read(new File("assets\\AsteroidStatusBar.png"));
            asteroidUfoImage = ImageIO.read(new File("assets\\AsteroidUfo.png"));
            asteroidUraniumImage = ImageIO.read(new File("assets\\AsteroidUranium.png"));
            asteroidButtonsImage = ImageIO.read(new File("assets\\AsteroidButtons.png"));
            coalIconImage = ImageIO.read(new File("assets\\CoalIcon.png"));
            gateIconImage = ImageIO.read(new File("assets\\GateIcon.png"));
            gateMiniImage = ImageIO.read(new File("assets\\GateMini.png"));
            gateMiniSillyImage = ImageIO.read(new File("assets\\GateMiniSilly.png"));
            iceIconImage = ImageIO.read(new File("assets\\IceIcon.png"));
            ironIconImage = ImageIO.read(new File("assets\\IronIcon.png"));
            normalBackgroundImage = ImageIO.read(new File("assets\\NormalBackground.png"));
            proximityBackgroundImage = ImageIO.read(new File("assets\\ProximityBackground.png"));
            proximitySolarStormBackgroundImage = ImageIO.read(new File("assets\\ProximitySolarStormBackground.png"));
            robotIconImage = ImageIO.read(new File("assets\\RobotIcon.png"));
            rocketTextureImage = ImageIO.read(new File("assets\\RocketTexture.png"));
            settlerIconImage = ImageIO.read(new File("assets\\SettlerIcon.png"));
            solarStormBackgroundImage = ImageIO.read(new File("assets\\SolarStormBackground.png"));
            ufoIconImage = ImageIO.read(new File("assets\\UfoIcon.png"));
            unitsImage = ImageIO.read(new File("assets\\Units.png"));
            uraniumIconImage = ImageIO.read(new File("assets\\UraniumIcon.png"));            
        } catch (Exception e) {
            //TODO: handle exception
        }        
    }
}
