package com.piatra.play;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class Game_start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_start window = new Game_start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game_start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 153, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 26, 889, 402);
		frame.getContentPane().add(panel_1);
		frame.setBounds(100, 100, 1000, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		

		 prepare.f1(panel_1,frame, 100, 100);
		 panel_1.setLayout(null);
		
		
		
		

		
	}
}
