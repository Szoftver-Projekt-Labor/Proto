package com.panzerkampfwagen.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.Utils;
import com.panzerkampfwagen.units.Settler;

public class Player extends Controller {
	protected Map<String, Command> commands = new HashMap<>();
	protected String name;

	public Player(String name) {
		this.name = name;
		commands.put("status", this::status);
		commands.put("move", this::move);
		commands.put("toggle_hide", this::toggleHide);
		commands.put("mine", this::mine);
		commands.put("drop", this::drop);
		commands.put("build", this::build);
		commands.put("list", this::list);
		commands.put("end", this::end);
	}

	private void cliPrompt() {
		System.out.print(name + ">");
	}

	public boolean prompt(String question) {
		System.out.println(question + " (y/anything_else)");
		cliPrompt();
		String answer = Utils.scanner.nextLine();
		return answer.equals("y");
	}

	@Override
	public void takeTurn() {
		super.takeTurn();
		String answer[];
		do {
			cliPrompt();
			answer = Utils.scanner.nextLine().split(" ");
			Command c = commands.get(answer[0]);
			if (c == null) {
				System.out.println("Ismeretlen parancs.");
				continue;
			}
			if (answer.length > 1) {
				c.execute(Arrays.copyOfRange(answer, 1, answer.length));
				continue;
			}
			c.execute();
			Game.gfx.draw((Settler)this.unit);

		} while (this.steps > 0);
	}

	// TODO: remove this from the graphic version
	@Override
	public void step() {
	}

	// #region commands
	@FunctionalInterface
	interface Command {
		public void execute(String... params);
	}

	private void status(String... params) {
		System.out.println(unit.status());
	}

	public void move(String... params) {
		if (params.length == 0)
			return;
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
		if (params.length == 0)
			return;
		int index = Integer.parseInt(params[0]);
		((Settler) unit).dropCargo(index);
	}

	private void build(String... params) {
		if (params.length == 0)
			return;
		((Settler) unit).build(params[0]);
	}

	private void end(String... params) {
		this.steps = 0;
	}

	private void list(String... params) {
		if (params.length == 0)
			return;
		switch (params[0]) {
		case "inventory":
			System.out.println(Utils.joinList(((Settler) unit).getInventory()));
			return;
		case "gate_inventory":
			System.out.println(Utils.joinList(((Settler) unit).getGateInventory()));
			return;
		case "destinations":
			System.out.println(Utils.joinList(((Settler) unit).getReceiver().getNeighbours()));
			return;
		}
	}
	// #endregion
}
