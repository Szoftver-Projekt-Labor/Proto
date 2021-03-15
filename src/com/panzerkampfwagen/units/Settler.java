package com.panzerkampfwagen.units;

import java.util.List;
import java.util.ArrayList;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.itemization.Item;

public class Settler extends Unit {
	private List<Item> inventory = new ArrayList<>(10);

	public List<Item> getInventory() {
		return inventory;
	}

	@Override
	public void onReceiverDestroyed() {
		this.die();
	}

	@Override
	public void die() {
		Level l = Game.getLevel();
		l.removeThing(this);
		l.onSettlerDies();
	}
}
