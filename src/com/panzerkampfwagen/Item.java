package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Unit;
import com.panzerkampfwagen.graphics.Layout;
import com.panzerkampfwagen.graphics.Texture;

import java.awt.*;

/**
 * Interface, egy itemet reprezentál.
 */
public interface Item extends Thing {

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 * 
	 * @param other az az item, amivel összehasonlítjuk
	 * @return igaz, ha egyezik
	 */
	public boolean sameAs(Item other);

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 * 
	 * @param dropper az a unit, amelyik ledobja
	 * @return igaz, ha sikerült
	 */
	public boolean dropItem(Unit dropper);
	
	public void draw(Graphics g, Layout l, Texture t);
}
