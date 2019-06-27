package com.tahama.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Background extends Art {
	private BufferedImage Background;
	private String scene;
	private int d;
	private double c = 255;

	public Background(int num, int d) {
		this.d = d;
		if (num == 0) {
			scene = "../../../images/NightTime.png";
		} else if (num == 1) {
			scene = "../../../images/RainyDay.jpg";
		} else if (num == 2) {
			scene = "../../../images/DayTime.png";
		} else {
			scene = "../../../images/SunRise.png";
		}//selects random background

		try {
			URL Url = Background.class.getResource(scene);
			Background = ImageIO.read(Url);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Background, d - (d + 50), d - (d + 50), d + 100, d + 500, null);//draws the background
		g.setColor(Color.BLACK);//adding a black border around the frame
		g.fillRect(0, 0, d, 15);
		g.fillRect(0, d - 42, d, 15);
		g.fillRect(0, 0, 15, d);
		g.fillRect(d - 20, 0, 15, d);
		if (c > 1)//this allows the game to have black fade out effect, when game is opened

		{
			g.setColor(new Color(0, 0, 0, (int) c));
			g.fillRect(0, 0, d, d);
			c -= 0.2;
		}
	}
}
