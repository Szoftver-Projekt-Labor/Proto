package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.itemization.Item;

public class Iron extends CoreMaterial {
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Iron;
	}
}
