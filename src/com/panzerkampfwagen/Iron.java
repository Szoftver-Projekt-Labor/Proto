package com.panzerkampfwagen;

public class Iron extends CoreMaterial {
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Iron;
	}
}
