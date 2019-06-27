package com.tahama.pong;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PongPanel extends Container {
	private ArrayList<IArt> drawings = new ArrayList<>();

	public PongPanel() {
		setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				for (IArt drawable : drawings) {
					drawable.keyReleased(e);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				for (IArt drawable : drawings) {
					drawable.keyPressed(e);
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseReleased(e);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mousePressed(e);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseExited(e);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				for (IArt drawable : drawings) {
					drawable.mouseEntered(e);
				}
			}

			@Override
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
