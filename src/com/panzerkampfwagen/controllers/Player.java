package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Utils;
import com.panzerkampfwagen.units.Settler;

public class Player extends Controller {
	protected String name;

	public Player(String name) {
		this.name = name;
	}

	private void cliPrompt() {
		System.out.print(name + ">");
	}

	public boolean prompt(String question) {
		System.out.print(question + " (y/anything_else)");
		cliPrompt();
		String answer = Utils.scanner.nextLine();
		return answer.equals("y");
	}

	@Override
	public void takeTurn() {
		super.takeTurn();
		String answer;
		do {
			cliPrompt();
			answer = Utils.scanner.nextLine();

		} while (this.steps > 0);
	}

	// TODO: remove this from the graphic version
	@Override
	public void step() {
	}

	// #region commands
	private void status(String... params) {

	}
	// #endregion
}
