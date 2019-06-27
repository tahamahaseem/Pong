package com.tahama.pong;

public class CollisionManager {//In charge of checking whether the ball has hit a racket

	public void collideLeft(Ball ball, int x, int y, int width, int height) {//checks if the ball hit the left racket
		int ballY = ball.getCenterY();
		int ballR = ball.getRadius();
		int lDistance = ball.getCenterX() - (x + width);
		if (lDistance <= ballR && ball.getCenterX() >= (x + width)) {//checks if the ball hit the racket
			if ((ballY + ballR >= y) && (ballY - ballR <= y + height)) { // checks if the ball has the same Y coordinate as the racket
				ball.setiX(ball.getiX() * -1);// tells the ball to move to the opposite direction
				if ((ballY >= (y + (height / 2) - 4)) && (ballY <= (y + (height / 2) + 4))) {//checks if ball is hitting middle of the racket
					ball.setiY(ball.getiY() * 0);
				} else if (ballY < (y + height / 2)) {//checks if ball is hitting upper part of the racket
					if (ballY < (y + height / 4)) {//checks if the ball is hitting the top most segment of the racket
						ball.setiY(ball.getiY() * 0 - 2);
					} else {
						ball.setiY(ball.getiY() * 0 - 1);
					}
				} else if (ballY > (y + height / 2)) {//checks if ball is hitting below part of the racket
					if (ballY > (3 * (y + height) / 4)) {//checks if the ball is hitting the top most segment of the racket
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
		if (rDistance <= ballR && ball.getCenterX() <= x) {//checks if the ball hit the racket
			if ((ballY >= y) && (ballY <= y + height)) {// checks if the ball has the same Y coordinate as the racket
				ball.setiX(ball.getiX() * -1);// tells the ball to move to the opposite direction
				if ((ballY >= (y + (height / 2) - 4)) && (ballY <= (y + (height / 2) + 4))) {//checks if ball is hitting middle of the racket
					ball.setiY(ball.getiY() * 0);
				} else if (ballY < (y + height / 2)) {//checks if ball is hitting upper part of the racket
					if (ballY < (y + height / 4)) {//checks if the ball is hitting the top most segment of the racket
						ball.setiY(ball.getiY() * 0 - 2);
					} else {
						ball.setiY(ball.getiY() * 0 - 1);
					}
				} else if (ballY > (y + height / 2)) {//checks if ball is hitting below part of the racket
					if (ballY > (3 * y + height / 2)) {//checks if the ball is hitting the top most segment of the racket
						ball.setiY(ball.getiY() * 0 + 2);
					} else {
						ball.setiY(ball.getiY() * 0 + 1);
					}
				}
			}
		}
	}
}
