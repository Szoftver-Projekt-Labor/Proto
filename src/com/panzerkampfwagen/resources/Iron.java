package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Item;

import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;
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
}
