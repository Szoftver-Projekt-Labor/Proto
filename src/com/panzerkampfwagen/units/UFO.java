package com.panzerkampfwagen.units;

import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.controllers.AI_Alien;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * UFO-t reprezentál. Képes mozgásra meg bányászásra.
 */
public class UFO extends Miner {
	/**
	 * @param r A Receiver amin az egység indul
	 */
	public UFO(AI_Alien c, Receiver r) {
		super(c, r);
		Level.subscribeTick(this);
	}

	/**
	 * Ha elpusztított receiveren van, akkor egy véletlen szomszédra kerül át.
	 */
	@Override
	public void onReceiverDestroyed() {
		this.move(this.receiver.getRandomNeighbour());
	}

	/**
	 * Felveszi a nyersanyagot és az megszűnik létezni.
	 * 
	 * @param item a felvett item
	 * @return sikerült-e (spoiler: igen)
	 */
	@Override
	public boolean loadCargo(Item item) {
		return true;
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t){
		g.drawImage(t.asteroidUfoImage, 200, 350, l.centerPanel);
	}

	public void drawIF_On_Asteroid(Graphics g, Layout l, Texture t){
		g.drawImage(t.ufoIconImage, 0, 100, l.centerPanel);
	}
}
