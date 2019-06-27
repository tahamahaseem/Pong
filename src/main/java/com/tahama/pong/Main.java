package com.tahama.pong;

import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		//Set ups the games visuals(Background, Menu Screen, Buttons, etc)
		Random background = new Random();
		int num = background.nextInt(4); //picks a random number from 0-3, helps pick random background
		int dimension = 900;//dimensions of the frame
		Background bg = new Background(num, dimension);
		PongFrame pong = new PongFrame(dimension);
		pong.setTitle("| Pong |");
		MenuScreen menu = new MenuScreen(dimension);
		menu.interaction(pong, num);
		pong.add(bg);
		pong.add(menu);
		pong.startGame();//starts the game
	}
}
