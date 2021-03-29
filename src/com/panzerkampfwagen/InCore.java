package com.panzerkampfwagen;

public interface InCore {
	public boolean extract(Miner miner);

	public boolean insertToCoreOf(Asteroid coreOwner);
}
