package com.panzerkampfwagen.graphics;

import java.awt.*;
import javax.swing.*;

class ImagePanel extends JPanel {

	private Image img;
  
	public ImagePanel(String img) {
	  this(new ImageIcon(img).getImage());
	}
  
	public ImagePanel(Image img) {
	  this.img = img;
	  Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	  setPreferredSize(size);
	  setMinimumSize(size);
	  setMaximumSize(size);
	  setSize(size);
	  setLayout(null);
	}
  
	public void paintComponent(Graphics g) {
	  g.drawImage(img, 0, 0, null);
	}  
}
public class Layout extends JFrame {

	public Layout(String name) {
		super(name);
		setResizable(false);
	}

	@Override
	public void paint(Graphics g) {  
		super.paint(g);
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("Asteroid.png");  
        g.drawImage(i, 120,100,this);          
    }

	public void addComponentsToPane(final Container pane) {
		// Panels
		// UpperPanel és részei
		JPanel UpperPanel = new JPanel();
		UpperPanel.setLayout(new GridLayout(2, 1));
		JPanel AsteroidStatusPanel = new JPanel();
		AsteroidStatusPanel.setLayout(new GridLayout(1, 1));
		JPanel InventoryPanel = new JPanel();
		InventoryPanel.setLayout(new GridLayout(1, 13));
		UpperPanel.add(AsteroidStatusPanel);
		UpperPanel.add(InventoryPanel);
		UpperPanel.setMinimumSize(new Dimension((int) (700), (int) (100)));

		// LowerPanel és részei
		JPanel LowerPanel = new JPanel();
		LowerPanel.setLayout(new GridLayout(2, 1));
		JPanel UnitsPanel = new JPanel();
		UnitsPanel.setLayout(new GridLayout(1, 1));
		JPanel Controls = new JPanel();
		Controls.setLayout(new GridLayout(1, 6));
		LowerPanel.add(UnitsPanel);
		LowerPanel.add(Controls);
		LowerPanel.setMinimumSize(new Dimension((int) (700), (int) (100)));
		
		// LowerPanel Buttons
		JButton DrillButton = new JButton("Drill");
		JButton MineButton = new JButton("Mine");
		JButton HideButton = new JButton("Hide");
		JButton BuildRobotButton = new JButton("Build Robot");
		JButton BuildGateButton = new JButton("Build Gate");
		JButton BuildBaseButton = new JButton("Build Base");

		// MiddlePanel és részei
		JPanel BackGroundPanel = new JPanel();
		BackGroundPanel.setLayout(new GridLayout(1, 1));
		JPanel AsteroidsPanel = new JPanel();
		AsteroidsPanel.setLayout(new GridLayout(5, 5));
		AsteroidsPanel.setBounds(100, 100, 500, 500);
		JPanel MiddlePanel = new JPanel();	
		
		ImagePanel normalBackground = new ImagePanel(new ImageIcon("assets/normalBackground.png").getImage());
		BackGroundPanel.add(normalBackground);

		MiddlePanel.setLayout(new OverlayLayout(MiddlePanel));
		MiddlePanel.setMaximumSize(new Dimension((int) (700), (int) (700)));
		MiddlePanel.add(BackGroundPanel);
		MiddlePanel.add(AsteroidsPanel);
		

		// Set up components preferred size
		AsteroidStatusPanel.setMinimumSize(new Dimension((int) (700), (int) (50)));
		InventoryPanel.setMinimumSize(new Dimension((int) (700), (int) (50)));
		//InventoryPanel.setMaximumSize(new Dimension((int) (700), (int) (50)));
		BackGroundPanel.setMinimumSize(new Dimension((int) (700), (int) (700)));
		AsteroidsPanel.setMinimumSize(new Dimension((int) (500), (int) (500)));
		//AsteroidsPanel.setMaximumSize(new Dimension((int) (500), (int) (500)));
		UnitsPanel.setMinimumSize(new Dimension((int) (700), (int) (50)));
		Controls.setMinimumSize(new Dimension((int) (700), (int) (50)));

		ImagePanel status = new ImagePanel(new ImageIcon("assets/AsteroidStatusBar.png").getImage());
		JButton b1 = new JButton("Aszteroid Status");
		b1.add(status);
		AsteroidStatusPanel.add(b1);

		ImagePanel units = new ImagePanel(new ImageIcon("assets/Units.png").getImage());
		JButton b2 = new JButton("Units");
		b2.add(units);
		UnitsPanel.add(b2);
		
		// Add buttons to experiment with Grid Layout
		
		for (Integer i = 1; i < 26; i++) {
			ImagePanel asteroid = new ImagePanel(new ImageIcon("assets/AsteroidMini.png").getImage());
			JButton b = new JButton(i.toString());
			//b.setMinimumSize(new Dimension((int) (150), (int) (150)));
			b.add(asteroid);
			AsteroidsPanel.add(b);
		}
		
		
		for (Integer i = 1; i < 14; i++) {
			ImagePanel coalIcon = new ImagePanel(new ImageIcon("assets/CoalIcon.png").getImage());
			JButton b = new JButton(i.toString());
			b.add(coalIcon);
			InventoryPanel.add(b);
		}

		// Add controls to set up horizontal and vertical gaps
		Controls.add(DrillButton);
		Controls.add(MineButton);
		Controls.add(HideButton);
		Controls.add(BuildRobotButton);
		Controls.add(BuildGateButton);
		Controls.add(BuildBaseButton);

		//Kepek	
		/*	
		ImagePanel normalBackground = new ImagePanel(new ImageIcon("assets/normalBackground.png").getImage());
		BackGroundPanel.add(normalBackground);
		ImagePanel asteroidStatusBar = new ImagePanel(new ImageIcon("assets/AsteroidStatusBar.png").getImage());
		AsteroidStatusPanel.add(asteroidStatusBar);
		ImagePanel inventory = new ImagePanel(new ImageIcon("assets/RocketTexture.png").getImage());
		InventoryPanel.add(inventory);
		ImagePanel units = new ImagePanel(new ImageIcon("assets/Units.png").getImage());
		UnitsPanel.add(units);
		ImagePanel buttons = new ImagePanel(new ImageIcon("assets/Buttons.png").getImage());
		Controls.add(buttons);
		*/

		// Tájolás
		pane.add(UpperPanel, BorderLayout.NORTH);
		pane.add(MiddlePanel, BorderLayout.CENTER);
		pane.add(LowerPanel, BorderLayout.SOUTH);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method is invoked from
	 * the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		Layout frame = new Layout("Asteroid Mining");
		frame.setMinimumSize(new Dimension((int) (700), (int) (900)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		// Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		// Display the window.
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
