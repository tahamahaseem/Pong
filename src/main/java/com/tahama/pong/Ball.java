package com.tahama.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Art {

	private int x = 0;
	private int y = 0;
	private int iX = 1;
	private int iY = 0;
	private int diameter = 16;
	private int radius;
	private int centerX;
	private int centerY;
	private int frameWidth;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getiX() {
		return iX;
	}

	public void setiX(int iX) {
		this.iX = iX;
	}

	public int getiY() {
		return iY;
	}

	public void setiY(int iY) {
		this.iY = iY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public Ball(int d) {
		x = (d / 2) - 10;
		y = (d / 2) - diameter / 2;
		frameWidth = d;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x - 3, y - 3, diameter + 6, diameter + 6);
		g.setColor(Color.WHITE);
		g.fillOval(x, y, diameter, diameter);
		x += iX;
		y += iY;
		radius = diameter / 2;
		centerX = x + radius;
		centerY = y + radius;
		if (y + radius <= 20) {
			iY = iY * -1;
		}
		if (y + diameter >= frameWidth - 40) {
			iY = iY * -1;
		}

	}
}
