package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Tickable;
import com.panzerkampfwagen.units.Miner;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

import javax.swing.ImageIcon;
/**
 * Jégvizet reprezentál, nyersanyagfajta.
 */
public class Ice extends CoreMaterial implements Tickable {

	/**
	 * Ha napközelben van és nincs köpeny, akkor eltűnik.
	 */
	@Override
	public void tick() {
		if (this.asteroid.getLayerCount() == 0 && this.asteroid.isCloseToSun()) {
			this.ejectThis();
			Level.unsubscribeTick(this);
		}
	}

	@Override
	public void setAsteroid(Asteroid asteroid) {
		super.setAsteroid(asteroid);
		Level.subscribeTick(this);
	}

	/**
	 * Kibányássza a nyersanyagot a miner.
	 * 
	 * @param miner az a Miner, aki kibányássza
	 * @return igaz, ha sikerült
	 */
	@Override
	public boolean extract(Miner miner) {
		if (!super.extract(miner))
			return false;
		Level.unsubscribeTick(this);
		return true;
	}

	/**
	 * Beállít egy új aszteroidát tulajdonosként.
	 * 
	 * @param coreOwner az új tulajdonos
	 * @return igaz, ha sikerült
	 */
	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!super.insertToCoreOf(coreOwner))
			return false;
		Level.subscribeTick(this);
		return true;
	}

	/**
	 * Megnézi, hogy az other Ice típusú-e.
	 * 
	 * @param other amivel összehasonlítjuk
	 * @return igaz, ha egyezik
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Ice;
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t){
		g.drawImage(t.asteroidIceImage, 200, 350, l.centerPanel);
	}

	public void drawInventory(Graphics g, Layout l, Texture t, Settler s){
		int index = 0;
		for(var v : s.getInventory()){		
			if(v.equals(this)){
				l.inventorySlotok.get(index).setIcon(new ImageIcon(t.asteroidIceImage));
			}
			index++;
		}	
	}
}
