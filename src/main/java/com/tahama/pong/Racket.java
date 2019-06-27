package com.tahama.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Racket extends Art {
	private int x;
	private int y;
	private int playerColor;
	private int key1;
	private int key2;
	private boolean moveUp;
	private boolean moveDown;
	private int height = 0;

	private int width = 10;
	private Ball pong;
	private String playerSide;
	private int dimension;

	private CollisionManager cm = new CollisionManager();

	public Racket(int posX, int posY, int num, int h, int Up, int Down, String side, int d) {
		x = posX;
		playerColor = num;
		height = h;
		key1 = Up;
		key2 = Down;
		playerSide = side;
		dimension = d;
		y = dimension / 2 - height / 2;
	}

	@Override
	public void draw(Graphics g) {
		// checks whether the ball hit the left or right racket
		if (playerSide.equals("LEFT")) {
			cm.collideLeft(pong, x, y, width, height);
		} else if (playerSide.equals("RIGHT")) {
			cm.collideRight(pong, x, y, width, height);
		}
		if (moveUp) {// when the up keys are pressed, racket will go up
			y -= 2;
			if (y < 16) {
				y += 2;
			}
		} else if (moveDown) {// when the down keys are pressed, racket will go down
			y += 2;
			if (y + height > dimension - 42) {

				y -= 2;
			}
		} // checks which background is on. Depending on the background set, the rackets
			// colors will set according to that
		if (playerColor == 0) {
			g.setColor(new Color(0, 255, 255, 150));
		} else if (playerColor == 1) {
			g.setColor(new Color(0, 0, 0, 150));
		} else if (playerColor == 2) {
			g.setColor(new Color(255, 255, 0, 150));
		} else {
			g.setColor(new Color(150, 50, 60, 200));
		}

		g.fillRect(x, y, width, height);// makes racket
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void keyReleased(KeyEvent e) {//checks if up or down keys were released
		if (e.getKeyCode() == key1) {
			moveUp = false;

		} else if (e.getKeyCode() == key2) {
			moveDown = false;

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {//checks if up or down keys were pressed
		if (e.getKeyCode() == key1) {
			moveUp = true;

		} else if (e.getKeyCode() == key2) {
			moveDown = true;

		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void interaction(Ball ball) {
		pong = ball;

	}
}
