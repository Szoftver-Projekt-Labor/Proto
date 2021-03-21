package com.panzerkampfwagen;

public class Iron extends CoreMaterial {
	@Override
	public boolean sameAs(Item other) {
		System.out.println("Iron.sameAs");
		return other instanceof Iron;
	}
}
