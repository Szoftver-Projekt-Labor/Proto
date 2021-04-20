package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Utils;
import com.panzerkampfwagen.units.Settler;

public class Player extends Controller {
	protected Settler unit;
	protected String name;

	public Player(String name) {
		this.name = name;
	}

	public boolean prompt(String question) {
		System.out.print(question + " (y/anything_else)");
		cliPrompt();
		String answer = Utils.scanner.nextLine();
		return answer.equals("y");
	}

	private void cliPrompt() {
		System.out.print(name + ">");
	}
}
