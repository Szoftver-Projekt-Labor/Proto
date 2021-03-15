package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.itemization.Item;

public class Coal extends CoreMaterial {

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Coal;
	}
}
