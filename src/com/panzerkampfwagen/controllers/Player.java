package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.units.Settler;

public class Player extends Controller {
	protected Settler unit;

	// TODO: implement
	public boolean prompt(String question) {
		System.out.println(question);

		return true;
	}
}
