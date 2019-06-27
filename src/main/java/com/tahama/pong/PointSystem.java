package com.tahama.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PointSystem extends Art {

	private Ball pong;
	private int counter = 0;
	private int dimension;
	private String side;
	private int wins = 0;
	private Racket racket;
	private int x;
	private int y;
	private boolean input = false;
	private int lost = 0;
	private int thickness;
	private double i = 255;
	private double boxX;
	private double winnerX;
	private String swipeDirection = "FADING INTO GAME";
	private boolean gameover = true;
	private int buttonWidth = 300;
	private int buttonHeight = 80;
	private int r = 100;
	private int q = 100;
	// holds the coordinates of the buttons and their text
	private int quitBoxY;
	private int quitX;
	private int quitY;
	private int spacing;
	private int restartBoxY;
	private int restartX;
	private int restartY;
	private boolean hide = false;

	public PointSystem(Racket r, Ball ball, int d, String s, int x, int y) {
		this.x = x;
		this.y = y;
		spacing = d / 4;
		racket = r;
		pong = ball;
		dimension = d;
		side = s;
		thickness = 4;
		boxX = d / 2 - buttonWidth / 2 - dimension - dimension / 2;
		winnerX = (dimension / 2 - 355) - dimension - dimension / 2;
		restartBoxY = d / 2;
		restartX = d / 2 - 100 - dimension - dimension / 2;
		restartY = d / 2 + 55;
		quitBoxY = restartBoxY + spacing;
		quitX = d / 2 - 55 - dimension - dimension / 2;
		quitY = restartY + spacing;
	}

	@Override
	public void draw(Graphics g) {

		if (input == false) { // Draws all the tips
			g.setColor(new Color(255, 255, 255, 255));
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 50));
			g.drawString("CONTROLS", dimension / 2 - 125, dimension / 10 + 80);
			g.drawString("v", dimension - 95, dimension - 140);
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 70));
			g.drawString("^", dimension - 100, dimension / 10 + 100);
			g.drawString("|", dimension - 92, dimension / 10 + 110);
			g.drawString("|", dimension - 92, dimension - 150);
			g.drawString("W", 70, dimension / 10 + 100);
			g.drawString("S", 70, dimension - 150);
			g.setColor(new Color(0, 255, 255, 255));
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 80));
			g.drawString("FIRST TO 4 POINTS", dimension / 2 - 328, dimension / 2);
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
			g.drawString("WINS!", dimension / 2 - 80, dimension / 2 + 60);

		}
		if (hide == false) { // draws the score, designs, and text on the pong game screen
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect((dimension / 2) - 2, 0, 3, dimension);
			g.fillRect(30, 30, dimension / 4, thickness);
			g.fillRect(30, 30, thickness, dimension / 4);
			g.fillRect(dimension - 35, 30, -dimension / 4, thickness);
			g.fillRect(dimension - 35, 30, thickness, dimension / 4);
			g.fillRect(30, dimension - 60, thickness, -dimension / 4);
			g.fillRect(30, dimension - 60, dimension / 4, thickness);
			g.fillRect(dimension - 35, dimension - 60, thickness, -dimension / 4);
			g.fillRect(dimension - 31, dimension - 60, -dimension / 4, thickness);
			g.setColor(new Color(255, 255, 255, 120));
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 100));
			g.drawChars("01234".toCharArray(), wins, 1, x, y);
			g.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
			g.drawString("PLAYER 1", 50, 70);
			g.drawString("PLAYER 2", dimension - 180, 70);
		} // makes buttons so user can restart or quit the game
		drawButton(g, "RESTART", (int) restartX, (int) restartY, (int) boxX, (int) restartBoxY, (int) r);
		drawButton(g, "QUIT", (int) quitX, (int) quitY, (int) boxX, (int) quitBoxY, (int) q);
		if (wins == 4 || lost == 4) {// checks if there was a winner
			if (gameover) {
				SoundManager.sound("Whoosh 1.wav");
			}
			gameover = false;
			WinnerFound(g);// Tells who the winner is and lets user decide if they want to restart or quit

		}
		if (pong.getCenterX() > dimension + 10) {// checks if ball went out of bounds to the right
			if (side.equals("RIGHT")) {
				SoundManager.sound("Win Beep.wav");
			}
			reset(); // resets the rackets and ball
			pong.setiX(1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} // gives points to winner
			if (side.equals("LEFT")) {
				wins++;
			}
			if (side.equals("RIGHT")) {
				lost++;

			}

		}

		else if (pong.getCenterX() < -10) {// checks if ball went out of bounds to the left
			if (side.equals("LEFT")) {
				SoundManager.sound("Win Beep.wav");
			}
			reset();// resets the rackets and ball
			pong.setiX(-1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // gives points to winner
			if (side.equals("RIGHT")) {
				wins++;
			}
			if (side.equals("LEFT")) {
				lost++;

			}
		}
		g.setColor(new Color(0, 0, 0, (int) i));
		g.fillRect(0, 0, dimension, dimension);
		// after play is pressed it fades out of black
		if ((i != 0) && (swipeDirection.equals("FADING INTO GAME"))) {
			i--;
			if ((i == 0) && (swipeDirection.equals("FADING INTO GAME"))) {
				swipeDirection = "RIGHT";
			}
		}
	}

	private void drawButton(Graphics g, String t, int x, int y, int boxX, int boxY, int opacity) {
		// makes buttons
		g.setColor(new Color(0, 0, 0, (int) opacity));
		g.fillRect(boxX, boxY, buttonWidth, buttonHeight);
		g.setColor(new Color(0, 0, 0, (int) i));
		g.drawRect(boxX, boxY, buttonWidth, buttonHeight);
		g.setColor(new Color(255, 255, 255, (int) i));
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 50));
		g.drawString(t, x, y);
	}

	private void WinnerFound(Graphics g) {
		reset();// resets the rackets and the ball
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 100));
		if (wins == 4) {// determines who won
			if (side.equals("LEFT")) {
				g.setColor(new Color(255, 0, 0, 255));
				g.drawString("PLAYER 1 WON!!", (int) winnerX, dimension / 2 - 100);
			}
			if (side.equals("RIGHT")) {
				g.setColor(new Color(255, 255, 0, 255));
				g.drawString("PLAYER 2 WON!!", (int) winnerX, dimension / 2 - 100);
			}

		}
		// if restart is pressed tells game to reset everything
		if (swipeDirection.equals("LEFT")) {
			if (counter == dimension / 2) {
				swipeDirection = "NO SWIPE";
				counter = 0;
			} else {
				counter += 2;
				swipeLeft(6);
				if (i <= 0) {
					gameRestarted();//resets all variables

				}
			}//right transition effect occurs and displays the options the user has which are restart or quit
		} else if (swipeDirection.equals("RIGHT")) {
			if (counter == dimension / 2) {
				swipeDirection = "NO SWIPE";
				counter = 0;
			} else {
				counter += 2;
				swipeRight(6);
			}
		}

	}

	private void gameRestarted() {//resets the whole game, after restart is pressed
		hide = false;
		gameover = true;
		lost = 0;
		wins = 0;
		input = false;
		swipeDirection = "RIGHT";
		reset();
		i = 0;
		pong.setiX(1);
		r = 100;
		q = 100;
		counter = 0;

	}

	private void swipeLeft(int rate) {
		//when swiping left, buttons move to the left by subtracting their X coordinate
		boxX -= rate;
		winnerX -= rate;
		restartX -= rate;
		quitX -= rate;
		if (i != 0) {
			i -= 0.2;
		}
	}

	private void swipeRight(int rate) {
		//when swiping right, buttons move to the right by adding their X coordinate
		hide = true;
		boxX += rate;
		winnerX += rate;
		restartX += rate;
		quitX += rate;
		if (i != 200) {
			i += 0.2;
		}

	}

	private void reset() {//resets ball and rackets
		pong.setX((dimension / 2) - 10);
		pong.setY((dimension / 2) - pong.getRadius());
		racket.setY((dimension / 2) - (racket.getHeight() / 2));
		pong.setiY(0);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		input = true;//checks if a key was pressed
	}

	@Override
	public void mousePressed(MouseEvent e) {
		r = 100;
		q = 100;
		//checks if quit was clicked
		if ((e.getPoint().getX() >= boxX) && (e.getPoint().getY() >= quitBoxY)) {
			if ((e.getPoint().getX() <= boxX + buttonWidth) && ((e.getPoint().getY() <= quitBoxY + buttonHeight))) {
				q = 255;
				System.exit(0);//closes the game

			}
		}
		//checks if restart was clicked
		else if ((e.getPoint().getX() >= boxX) && ((e.getPoint().getY() >= restartBoxY))) {
			if ((e.getPoint().getX() <= boxX + buttonWidth) && ((e.getPoint().getY() <= restartBoxY + buttonHeight))) {
				r = 255;
				swipeDirection = "LEFT";
				swipeLeft(6);//tells game to transition back to the game play
				gameover = true;
			}
		}
	}
}
