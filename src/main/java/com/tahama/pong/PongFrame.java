package com.tahama.pong;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PongFrame extends JFrame {
	private PongPanel pane;

	public PongFrame(int d) {
		setSize(d, d);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout());
		setVisible(true);
		pane = new PongPanel();
		setContentPane(pane);
		pane.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//creates Frame and Pane
	}

	public void add(IArt drawing) {
		pane.add(drawing);

	}

	public void startGame() {
		SoundManager.sound("Silence At Sunlight.wav",true);//plays music
		while (true) {
			pane.repaint();//repaints everything in the game
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
