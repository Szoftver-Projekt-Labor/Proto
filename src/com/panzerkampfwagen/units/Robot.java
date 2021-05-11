package com.panzerkampfwagen.units;

import com.panzerkampfwagen.BuildableItem;
import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.controllers.AI_RoBot;
import com.panzerkampfwagen.resources.Coal;
import com.panzerkampfwagen.resources.Iron;
import com.panzerkampfwagen.resources.Uranium;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Robotot reprezentál. Képes mozogni, fúrni. Telepes megépítheti őt.
 */
public class Robot extends Unit implements BuildableItem {
	/**
	 * @param r A Receiver amin az egység indul
	 */
	public Robot(AI_RoBot c, Receiver r) {
		super(c, r);
	}

	/**
	 * Ha felrobban a receiver amin van, átkerül egy véletlen szomszédra.
	 */
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	/**
	 * Megépül a robot.
	 * 
	 * @return új robot
	 */
	@Override
	public boolean onMake(Settler creator) {
		return creator.loadCargo(new Robot(null, null));
	}

	/**
	 * Megvizsgálja, hogy az adott item amivel összehasonlítjuk, az robot-e.
	 * 
	 * @param other a hasonlítandó item
	 * @return ugyanolyan e (true ha igen)
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Robot;
	}

	/**
	 * Unit lerakja a robotot.
	 * 
	 * @param dropper az egység aki lerakja
	 * @return sikerült e (true ha igen)
	 */
	@Override
	public boolean dropItem(Unit dropper) {
		dropper.getReceiver().addUnit(this);
		Level.subscribeAll(this);
		this.controller = new AI_RoBot();
		this.controller.setUnit(this);
		return true;
	}

	/**
	 * Visszaadja a robot építéséhez szükséges alapanyagokat.
	 * 
	 * @return robot építéséhez szükséges alapanyagok tömbje
	 */
	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Iron(), new Coal(), new Uranium() };
	}

	@Override
	public boolean extract(Miner miner) {
		this.hiding = false;
		((Asteroid) this.receiver).ejectCore();
		return true;
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t, Settler s){
		g.drawImage(t.asteroidRobotImage, 200, 350, l.centerPanel);
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t) {
		g.drawImage(t.asteroidRobotImage, 200, 350, l.centerPanel);
		
	}	

	public void drawIF_On_Asteroid(Graphics g, Layout l, Texture t){
		g.drawImage(t.robotIconImage, 0, 0, l.centerPanel);
	}	
}
