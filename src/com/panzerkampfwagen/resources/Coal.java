package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;
import com.panzerkampfwagen.units.Settler;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 * Szenet reprezentál, nyersanyagfajta.
 */
public class Coal extends CoreMaterial {

	/**
	 * Megnézi, hogy az other Coal típusú-e
	 * 
	 * @param other az item, amivel az összehasonlítás történik
	 * @return az összehasonlítás eredménye (true=ha az item szén)
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Coal;
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t){
		g.drawImage(t.asteroidCoalImage, 200, 350, l.centerPanel);
	}

	public void drawInventory(Graphics g, Layout l, Texture t, Settler s){
		int index = 0;
		for(var v : s.getInventory()){		
			if(v.equals(this)){
				l.inventorySlotok.get(index).setIcon(new ImageIcon(t.asteroidCoalImage));
			}
			index++;
		}	
	}
}
