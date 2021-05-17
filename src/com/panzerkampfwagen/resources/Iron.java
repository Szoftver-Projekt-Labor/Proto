package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Item;

import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;
import com.panzerkampfwagen.units.Settler;

import java.awt.*;

import javax.swing.ImageIcon;
/**
 * Vasat reprezentál, nyersanyag.
 */
public class Iron extends CoreMaterial {

	/**
	 * Megnézi, hogy az other Iron típusú-e.
	 * 
	 * @param other amivel összehasonlítjuk
	 * @return igaz, ha egyezik
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Iron;
	}

	@Override
	public void draw(Graphics g, Layout l, Texture t){
		g.drawImage(t.asteroidIronImage, 200, 350, l.centerPanel);
	}

	public void drawInventory(Graphics g, Layout l, Texture t, Settler s){
		int index = 0;
		for(var v : s.getInventory()){		
			if(v.equals(this)){
				l.inventorySlotok.get(index).setIcon(new ImageIcon(t.asteroidIronImage));
			}
			index++;
		}	
	}
}
