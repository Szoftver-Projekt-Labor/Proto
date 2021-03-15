package com.panzerkampfwagen;

public class Coal extends CoreMaterial {

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Coal;
	}
}
