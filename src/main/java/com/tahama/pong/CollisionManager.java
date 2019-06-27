package com.tahama.pong;

public class CollisionManager {

	public void collideLeft(Ball ball, int x, int y, int width, int height) {
		int ballY = ball.getCenterY();
		int ballR = ball.getRadius();
		int lDistance = ball.getCenterX() - (x + width);
		if (lDistance <= ballR && ball.getCenterX() >= (x + width)) {
			if ((ballY + ballR >= y) && (ballY - ballR <= y + height)) {
				ball.setiX(ball.getiX() * -1);
				if ((ballY >= (y + (height / 2) - 4)) && (ballY <= (y + (height / 2) + 4))) {
					ball.setiY(ball.getiY() * 0);
				} else if (ballY < (y + height / 2)) {
					if (ballY < (y + height / 4)) {
						ball.setiY(ball.getiY() * 0 - 2);
					} else {
						ball.setiY(ball.getiY() * 0 - 1);
					}
				} else if (ballY > (y + height / 2)) {
					if (ballY > (3 * (y + height) / 4)) {
						ball.setiY(ball.getiY() * 0 + 2);
					} else {
						ball.setiY(ball.getiY() * 0 + 1);
					}
				}
			}
		}
	}

	public void collideRight(Ball ball, int x, int y, int width, int height) {
		int ballY = ball.getCenterY();
		int ballR = ball.getRadius();
		int rDistance = x - (ball.getCenterX());
		if (rDistance <= ballR && ball.getCenterX() <= x) {
			if ((ballY >= y) && (ballY <= y + height)) {
				ball.setiX(ball.getiX() * -1);
				if ((ballY >= (y + (height / 2) - 4)) && (ballY <= (y + (height / 2) + 4))) {
					ball.setiY(ball.getiY() * 0);
				} else if (ballY < (y + height / 2)) {
					if (ballY < (y + height / 4)) {
						ball.setiY(ball.getiY() * 0 - 2);
					} else {
						ball.setiY(ball.getiY() * 0 - 1);
					}
				} else if (ballY > (y + height / 2)) {
					if (ballY > (3 * y + height / 2)) {
						ball.setiY(ball.getiY() * 0 + 2);
					} else {
						ball.setiY(ball.getiY() * 0 + 1);
					}
				}
			}
		}
	}
}
