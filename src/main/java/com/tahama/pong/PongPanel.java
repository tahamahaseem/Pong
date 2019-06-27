package com.tahama.pong;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PongPanel extends Container {
	private ArrayList<IArt> drawings = new ArrayList<>();// an array list that holds all the drawings/components of the
															// game. (Rackets, Ball, Menu Screen, etc)

	public PongPanel() {
		setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that a key was released
			public void keyReleased(KeyEvent e) {
				for (IArt drawable : drawings) {
					drawable.keyReleased(e);
				}
			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that a key was pressed
			public void keyPressed(KeyEvent e) {
				for (IArt drawable : drawings) {
					drawable.keyPressed(e);
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			// lets every drawing(Rackets, Ball, Etc) that the mouse was released
			public void mouseReleased(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseReleased(e);
				}
			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that the mouse was pressed
			public void mousePressed(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mousePressed(e);
				}
			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that the mouse cursor exited
			public void mouseExited(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseExited(e);
				}
			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that the mouse cursor entered
			public void mouseEntered(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseEntered(e);
				}
			}

			@Override
			// lets every drawing(Rackets, Ball, Etc) that the mouse cursor clicked
			public void mouseClicked(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseClicked(e);
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// gives all drawings the ability to be repainted
		try {
			for (IArt drawing : drawings) {
				drawing.draw(g);
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	public void add(IArt drawing) {
		drawings.add(drawing);

	}

}
