package com.panzerkampfwagen.graphics;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Background extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Textures.getTexture("NormalBackground"), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
