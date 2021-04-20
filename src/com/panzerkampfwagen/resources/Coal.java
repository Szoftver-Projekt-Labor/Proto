package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Item;

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
}
