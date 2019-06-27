package com.tahama.pong;

import java.awt.event.KeyEvent;

public class StartPong {
	private Ball ball;
	private Racket racket1;
	private PointSystem score1;
	private PointSystem score2;
	private PongFrame pong;
	private int dimension;
	private int num;
	private Racket racket2;

	public StartPong(PongFrame p, int d, int n) {
		pong = p;
		dimension = d;
		num = n;
		ball = new Ball(dimension);
		racket1 = new Racket(65, 3 * dimension / 8, num, 150, KeyEvent.VK_W, KeyEvent.VK_S, "LEFT", dimension);
		racket1.interaction(ball);
		racket2 = new Racket(dimension - 75, 3 * dimension / 8, num, 150, KeyEvent.VK_UP, KeyEvent.VK_DOWN, "RIGHT",
				dimension);
		racket2.interaction(ball);
		score1 = new PointSystem(racket2, ball, dimension, "RIGHT", (dimension / 2) + 30, 100);
		score2 = new PointSystem(racket1, ball, dimension, "LEFT", (dimension / 2) - 90, 100);
		pong.add(racket1);
		pong.add(racket2);
		pong.add(ball);
		pong.add(score1);
		pong.add(score2);

	}
}
