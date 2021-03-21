package com.panzerkampfwagen;

public class Coal extends CoreMaterial {

	@Override
	public boolean sameAs(Item other) {
		System.out.println("Coal.sameAs");
		return other instanceof Coal;
	}
}
