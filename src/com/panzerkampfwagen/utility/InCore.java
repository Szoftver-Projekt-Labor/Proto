package com.panzerkampfwagen.utility;

import com.panzerkampfwagen.receivers.Asteroid;
import com.panzerkampfwagen.units.Settler;

public interface InCore {
	public boolean extract(Settler miner);

	public boolean insertToCoreOf(Asteroid coreOwner);
}
