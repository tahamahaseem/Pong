package com.tahama.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class MenuScreen extends Art {
	private int d;
	private String author = "BY TAHAMA HASEEM";
	private String title = "| PONG |";
	private String Game = "Game Programed By Tahama Haseem";
	private String Music = "Music Produced By Tahama Haseem";
	private String Art = "Art Created By Tahama Haseem";
	private double i = 0;
	private double f = 0;
	private double p = 0;
	private double c = 0;
	private double q = 0;
	private double b = 0;
	private int counter = 0;
	private int buttonWidth = 300;
	private int buttonHeight = 80;
	private int spacing;
	private double creatorX;
	private double titleX;
	private double GameX;
	private double MusicX;
	private double ArtX;
	private double boxX;
	private double playBoxY;
	private double creditBoxY;
	private double quitBoxY;
	private double playX;
	private double playY;
	private double creditX;
	private double creditY;
	private double quitX;
	private double quitY;
	private double backX;
	private double backY;
	private double backBoxX;
	private double backBoxY;
	private String swipeDirection = "NO SWIPE";
	private String side = "Menu";
	private PongFrame pong;
	private int num;
	private Object state = "FadeIn";

	public MenuScreen(int d) {
		this.d = d;
		spacing = d / 4;
		titleX = d / 2 - 175;
		creatorX = 20;
		boxX = d / 2 - buttonWidth / 2;
		playBoxY = d / 4;
		creditBoxY = playBoxY + spacing;
		quitBoxY = creditBoxY + spacing;
		playX = d / 2 - 60;
		playY = d / 4 + 55;
		creditX = d / 2 - 97;
		creditY = d / 4 + 55 + spacing;
		quitX = d / 2 - 55;
		quitY = d / 4 + 55 + spacing * 2;
		backX = (quitX - 10) + d + (d / 2);
		backY = quitY;
		backBoxX = boxX + d + (d / 2);
		backBoxY = quitBoxY;
		GameX = titleX + d + (d / 2) - 155;
		MusicX = titleX + d + (d / 2) - 140;
		ArtX = titleX + d + (d / 2) - 100;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0, 250, 250, (int) i));
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 100));
		g.drawString(title, (int) titleX, d / 10 + 50);
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		g.drawString(author, (int) creatorX, d - 50);
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
		g.drawString(Game, (int) GameX, d / 10);
		g.drawString(Music, (int) MusicX, d / 10 + 200);
		g.drawString(Art, (int) ArtX, d / 10 + 400);

		drawButton(g, "PLAY", (int) playX, (int) playY, (int) boxX, (int) playBoxY, (int) p);
		drawButton(g, "CREDITS", (int) creditX, (int) creditY, (int) boxX, (int) creditBoxY, (int) c);
		drawButton(g, "QUIT", (int) quitX, (int) quitY, (int) boxX, (int) quitBoxY, (int) q);
		drawButton(g, "BACK", (int) backX, (int) backY, (int) backBoxX, (int) backBoxY, (int) b);
		fadeOut();
		g.setColor(new Color(0, 0, 0, (int) f));
		g.fillRect(0, 0, d, d);
		if (side.equals("Play")) {
			fadeIntoGame();
		}
		if (p <= 100) {
			p += 0.2;
			c += 0.2;
			q += 0.2;
			b += 0.2;
		}
		if (swipeDirection.equals("LEFT")) {
			if (counter == d / 2) {
				swipeDirection = "NO SWIPE";
				counter = 0;
			} else {
				counter += 2;
				swipeLeft(6);
			}
		} else if (swipeDirection.equals("RIGHT")) {
			if (counter == d / 2) {
				swipeDirection = "NO SWIPE";
				counter = 0;
			} else {
				counter += 2;
				swipeRight(6);
			}
		}
	}

	private void drawButton(Graphics g, String t, int x, int y, int boxX, int boxY, int opacity) {
		g.setColor(new Color(0, 0, 0, (int) opacity));
		g.fillRect(boxX, boxY, buttonWidth, buttonHeight);
		g.setColor(new Color(0, 0, 0, (int) i));
		g.drawRect(boxX, boxY, buttonWidth, buttonHeight);
		g.setColor(new Color(255, 255, 255, (int) i));
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 50));
		g.drawString(t, x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		q = 100;
		c = 100;
		p = 100;
		b = 100;
		if (side.equals("Menu")) {
			if ((e.getPoint().getX() >= boxX) && ((e.getPoint().getY() >= quitBoxY))) {
				if ((e.getPoint().getX() <= boxX + buttonWidth) && ((e.getPoint().getY() <= quitBoxY + buttonHeight))) {
					q = 255;
					System.exit(0);
				}
			} else if ((e.getPoint().getX() >= boxX) && ((e.getPoint().getY() >= creditBoxY))) {
				if ((e.getPoint().getX() <= boxX + buttonWidth)
						&& ((e.getPoint().getY() <= creditBoxY + buttonHeight))) {
					c = 255;
					side = "Credits";
					swipeDirection = "LEFT";
					SoundManager.sound("Whoosh 1.wav");
				}
			} else if ((e.getPoint().getX() >= boxX) && ((e.getPoint().getY() >= playBoxY))) {
				if ((e.getPoint().getX() <= boxX + buttonWidth) && ((e.getPoint().getY() <= playBoxY + buttonHeight))) {
					p = 255;
					swipeDirection = "RIGHT";
					SoundManager.sound("Whoosh 1.wav");
					side = "Play";
				}
			}
		} else if (side.equals("Credits")) {
			if ((e.getPoint().getX() >= backBoxX) && ((e.getPoint().getY() >= backBoxY))) {
				if ((e.getPoint().getX() <= backBoxX + buttonWidth)
						&& ((e.getPoint().getY() <= backBoxY + buttonHeight))) {
					b = 255;
					side = "Menu";
					swipeDirection = "RIGHT";
					SoundManager.sound("Whoosh 1.wav");
				}
			}
		}
	}

	private void fadeIntoGame() {
		if (f <= 254 && state.equals("FadeIn")) {
			f++;
		} else {
			new StartPong(pong, d, num);
			side = "NONE";
			f = 0;
		}
	}

	private void fadeOut() {
		if (i <= 255) {
			i += 0.2;
		}
	}

	private void swipeLeft(double rate) {
		titleX -= rate;
		GameX -= rate;
		MusicX -= rate;
		ArtX -= rate;
		creatorX -= rate;
		boxX -= rate;
		playX -= rate;
		creditX -= rate;
		quitX -= rate;
		backX -= rate;
		backBoxX -= rate;
	}

	private void swipeRight(double rate) {
		titleX += rate;
		GameX += rate;
		MusicX += rate;
		ArtX += rate;
		creatorX += rate;
		boxX += rate;
		playX += rate;
		creditX += rate;
		quitX += rate;
		backX += rate;
		backBoxX += rate;
	}

	public void interaction(PongFrame pong, int n) {
		this.pong = pong;
		num = n;
	}
}
