package com.panzerkampfwagen;

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
}
