package com.panzerkampfwagen.graphics;

import java.awt.*;
import javax.swing.*;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Receiver;
import com.panzerkampfwagen.units.Settler;

public class Layout extends JFrame {
	public Texture pic = new Texture();
	public JPanel upperPanel = new JPanel();
	public JPanel lowerPanel = new JPanel();
	public JPanel asteroidStatusBar = new JPanel();
	public JPanel controlsPanel = new JPanel();	
	public JPanel inventory = new JPanel();
	public JPanel neighbours = new JPanel();	
	public JPanel centerPanel = new JPanel();

	public void draw(Settler s){
		Graphics g = this.getGraphics();
		Receiver r = s.getAsteroid();
		if(r != null){
			Asteroid a = (Asteroid)r;
			a.draw(g, this, pic);			
		}
		else{
			r = s.getReceiver();
			//Teleport kaput rajzol
		}
	}

	public Layout(String name) {
		super(name);
		setResizable(false);
	}

	public void addComponentsToPane(final Container pane) {
		//UpperPanel		
		{
		upperPanel.setLayout(new GridLayout(2,1));
		upperPanel.setPreferredSize(new Dimension(700, 100));
		}

		//LowerPanel		
		{
		lowerPanel.setLayout(new GridLayout(2,1));
		lowerPanel.setPreferredSize(new Dimension(700, 100));
		}

		//StatusBar Készítés		
		{
		asteroidStatusBar.setLayout(new GridLayout(1,1));
			JButton statuszBar = new JButton("Statusz Bar");
			asteroidStatusBar.add(statuszBar);
		asteroidStatusBar.setPreferredSize(new Dimension(700, 50));
		}

		//Gombok Készítése		
		{
		controlsPanel.setLayout(new GridLayout(1,6));
			JButton DrillButton = new JButton("Drill");
			JButton MineButton = new JButton("Mine");
			JButton HideButton = new JButton("Hide");
			JButton BuildRobotButton = new JButton("Build Robot");
			JButton BuildGateButton = new JButton("Build Gate");
			JButton BuildBaseButton = new JButton("Build Base");
			controlsPanel.add(DrillButton);
			controlsPanel.add(MineButton);
			controlsPanel.add(HideButton);
			controlsPanel.add(BuildRobotButton);
			controlsPanel.add(BuildGateButton);
			controlsPanel.add(BuildBaseButton);
		controlsPanel.setPreferredSize(new Dimension(700, 50));
		}

		//Inventory Panel
		{
		inventory.setLayout(new GridLayout(1,13));
			for (Integer i = 1; i < 14; i++) {
				JButton slot = new JButton(i.toString());
				inventory.add(slot);
			}
		inventory.setPreferredSize(new Dimension(700, 50));
		}

		//Inventory Panel
		{	
		neighbours.setLayout(new GridLayout(1,13));
			JButton back = new JButton("<");
			neighbours.add(back);
			for (Integer i = 2; i < 13; i++) {				
				JButton slot = new JButton(i.toString());
				neighbours.add(slot);
			}
			JButton forward = new JButton(">");
			neighbours.add(forward);
		neighbours.setPreferredSize(new Dimension(700, 50));
		}	
		
		//Middle elem
		{		
			centerPanel.setLayout(new GridLayout(1,1));
			centerPanel.setPreferredSize(new Dimension(700, 700));
			pane.add(centerPanel);
		}	

		upperPanel.add(asteroidStatusBar);
		upperPanel.add(inventory);
		lowerPanel.add(neighbours);
		lowerPanel.add(controlsPanel);

		pane.add(upperPanel, BorderLayout.NORTH);
		pane.add(lowerPanel, BorderLayout.SOUTH);		
	}

	/**
	 * GUI Készítés, frame beállítása
	 */
	private static void createAndShowGUI() {
		Layout frame = new Layout("Asteroid Mining");
		frame.setPreferredSize(new Dimension((int) (700), (int) (900)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		frame.addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void init() {
		try {			
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
