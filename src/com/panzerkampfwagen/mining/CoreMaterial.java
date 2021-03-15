package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.utility.InCore;

public abstract class CoreMaterial implements InCore {
	public abstract boolean onMined(Settler setter);

	public void tick() {
	}
}
