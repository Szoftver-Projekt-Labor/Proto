package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Inteface, az építhető tárgyak megvalósításáért felel.
 */
public interface BuildableItem extends Item {
	public Item[] getBuildCost();

	public boolean onMake(Settler creator);
	
	public void draw(Graphics g, Layout l, Texture t);
}
