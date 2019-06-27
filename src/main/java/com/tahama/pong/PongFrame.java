package com.tahama.pong;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PongFrame extends JFrame {
	private PongPanel pane;
	private int MusicDuration = 0;

	public PongFrame(int d) {
		setSize(d, d);
		setResizable(false);
		setLayout(new FlowLayout());
		setVisible(true);
		pane = new PongPanel();
		setContentPane(pane);
		pane.setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void add(IArt drawing) {
		pane.add(drawing);

	}

	public void startGame() {
		SoundManager.sound("Historic.wav");
		while (true) {
			pane.repaint();
			try {
				Thread.sleep(3);
				MusicDuration = MusicDuration + 3;
				if (MusicDuration == 170000) {
					SoundManager.sound("Historic.wav");
					MusicDuration = 0;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
