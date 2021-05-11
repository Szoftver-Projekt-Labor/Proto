package com.panzerkampfwagen.graphics;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Game;
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
	public JButton DrillButton = new JButton("Drill");
	public JButton MineButton = new JButton("Mine");
	public JButton HideButton = new JButton("Hide");
	public JButton BuildRobotButton = new JButton("Build Robot");
	public JButton BuildGateButton = new JButton("Build Gate");
	public JButton BuildBaseButton = new JButton("Build Base");	
	//Inventory buttons
	public JButton slot1 = new JButton("1");
	public JButton slot2 = new JButton("2");
	public JButton slot3 = new JButton("3");
	public JButton slot4 = new JButton("4");
	public JButton slot5 = new JButton("5");
	public JButton slot6 = new JButton("6");
	public JButton slot7 = new JButton("7");
	public JButton slot8 = new JButton("8");
	public JButton slot9 = new JButton("9");
	public JButton slot10 = new JButton("10");
	public JButton slot11 = new JButton("11");
	public JButton slot12 = new JButton("12");
	public JButton slot13 = new JButton("13");
	public ArrayList<JButton> inventorySlotok = new ArrayList<JButton>();
	//neighbor buttons	
	public JButton back = new JButton("<");
	public JButton forward = new JButton(">");
	public JButton slotn1 = new JButton("1");
	public JButton slotn2 = new JButton("2");
	public JButton slotn3 = new JButton("3");
	public JButton slotn4 = new JButton("4");
	public JButton slotn5 = new JButton("5");
	public JButton slotn6 = new JButton("6");
	public JButton slotn7 = new JButton("7");
	public JButton slotn8 = new JButton("8");
	public JButton slotn9 = new JButton("9");
	public JButton slotn10 = new JButton("10");
	public JButton slotn11 = new JButton("11");
	public ArrayList<JButton> neighborSlotok = new ArrayList<JButton>();
	private int page = 0;
	private Settler currentActiveSettler;
	private Asteroid currentMainAsteroid;
	private Graphics g = this.getGraphics();

	public void draw(Settler s){
		currentActiveSettler = s;
		Receiver r = s.getAsteroid();
		Asteroid a;
		if(r != null){
			a = (Asteroid)r;			
		}
		else{
			r = s.getReceiver();
			a = (Asteroid) r.getRandomNeighbour();
		}
		currentMainAsteroid = a;
		a.draw(g, this, pic);
		a.draw(g, this, pic, page);
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
			controlsPanel.add(DrillButton);
			controlsPanel.add(MineButton);
			controlsPanel.add(HideButton);
			controlsPanel.add(BuildRobotButton);
			controlsPanel.add(BuildGateButton);
			controlsPanel.add(BuildBaseButton);

			DrillButton.addActionListener(e -> {
				currentActiveSettler.drill();
			});
			MineButton.addActionListener(e -> {
				currentActiveSettler.mine();
			});
			HideButton.addActionListener(e -> {
				currentActiveSettler.toggleHide();
			});
			BuildRobotButton.addActionListener(e -> {
				currentActiveSettler.build("robot");;
			});
			BuildGateButton.addActionListener(e -> {
				currentActiveSettler.build("gate");;
			});
			BuildBaseButton.addActionListener(e -> {
				currentActiveSettler.build("base");;
			});
		controlsPanel.setPreferredSize(new Dimension(700, 50));
		}

		//Inventory Panel
		{
		inventory.setLayout(new GridLayout(1,13));			
				inventory.add(slot1);
				inventory.add(slot2);
				inventory.add(slot3);
				inventory.add(slot4);
				inventory.add(slot5);
				inventory.add(slot6);
				inventory.add(slot7);
				inventory.add(slot8);
				inventory.add(slot9);
				inventory.add(slot10);
				inventory.add(slot11);
				inventory.add(slot12);
				inventory.add(slot13);
				
				inventorySlotok.add(slot1);	
				inventorySlotok.add(slot2);	
				inventorySlotok.add(slot3);	
				inventorySlotok.add(slot4);	
				inventorySlotok.add(slot5);	
				inventorySlotok.add(slot6);	
				inventorySlotok.add(slot7);	
				inventorySlotok.add(slot8);	
				inventorySlotok.add(slot9);	
				inventorySlotok.add(slot10);	
				inventorySlotok.add(slot11);
				inventorySlotok.add(slot12);
				inventorySlotok.add(slot13);
		inventory.setPreferredSize(new Dimension(700, 50));
		}

		//Inventory Panel
		{	
		neighbours.setLayout(new GridLayout(1,13));
				neighbours.add(back);
				neighbours.add(slotn1);			
				neighbours.add(slotn2);			
				neighbours.add(slotn3);			
				neighbours.add(slotn4);			
				neighbours.add(slotn5);			
				neighbours.add(slotn6);			
				neighbours.add(slotn7);			
				neighbours.add(slotn8);			
				neighbours.add(slotn9);			
				neighbours.add(slotn10);			
				neighbours.add(slotn11);
				neighbours.add(forward);
				
				neighborSlotok.add(back);
				neighborSlotok.add(slotn1);	
				neighborSlotok.add(slotn2);	
				neighborSlotok.add(slotn3);	
				neighborSlotok.add(slotn4);	
				neighborSlotok.add(slotn5);	
				neighborSlotok.add(slotn6);	
				neighborSlotok.add(slotn7);	
				neighborSlotok.add(slotn8);	
				neighborSlotok.add(slotn9);	
				neighborSlotok.add(slotn10);	
				neighborSlotok.add(slotn11);
				neighborSlotok.add(forward);

				back.addActionListener(e -> {
					if(page>0)
							page-=1;
						currentMainAsteroid.draw(g, Game.gfx, pic, page);
					}
				);
				forward.addActionListener(e -> {
					if(((page-1)*11)>currentMainAsteroid.getNeighbours().size())
							page+=1;
						currentMainAsteroid.draw(g, Game.gfx, pic, page);
					}
				);
				for(int i=1; i<neighborSlotok.size()-1; i++){
					neighborSlotok.get(i).addActionListener(e -> {
						currentActiveSettler.getPlayer().move(Integer.toString(page+neighborSlotok.size()));
					});
				}

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
