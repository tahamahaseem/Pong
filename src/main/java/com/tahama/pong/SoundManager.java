package com.tahama.pong;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundManager {
	public static void sound(String file) {
		sound(file, false);
	}

	/**
	 * http://www.java2s.com/Code/Java/Development-Class/AnexampleofloadingandplayingasoundusingaClip.htm
	 */
	public static void sound(String file, boolean endless) {
		//plays background music
		InputStream music;
		try {
			music = MenuScreen.class.getResourceAsStream("../../../music/" + file);
			AudioInputStream sound = AudioSystem.getAudioInputStream(music);

			DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(sound);
			clip.start();
			if (endless) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);//Continuously loops the music after it finishes each time
			}
		} catch (Exception e) {
		}
	}
}
