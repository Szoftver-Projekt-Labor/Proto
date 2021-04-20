package com.panzerkampfwagen.controllers;

import java.util.List;

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

	private void move(String... params) {
		if(params.length == 0) return;
		int index = Integer.parseInt(params[0]);
		unit.move(unit.getReceiver().getNeighbour(index));
	}

	private void toggleHide(String... params) {
		unit.toggleHide();
	}

	private void mine(String... params) {
		((Settler) unit).mine();
	}

	private void drop(String... params) {
		if(params.length == 0) return;
		int index = Integer.parseInt(params[0]);
		((Settler) unit).dropCargo(index);
	}

	private void build(String... params) {
		if(params.length == 0) return;
		((Settler)unit).build(params[0]);
	}

	private void list(String... params){
		switch (params[0]) {
			case "inventory":
				System.out.println(Utils.joinList(((Settler) unit).getInventory()));
				return;

			case "gate_inventory":
				System.out.println(Utils.joinList(((Settler) unit).getGateInventory()));
				return;

			case "destinations":
				System.out.println(Utils.joinList(List.of(((Settler) unit).getReceiver().getNeighbours())));
				return;
		}
	}
	// #endregion
}
