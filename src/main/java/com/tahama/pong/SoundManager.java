package com.tahama.pong;

import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundManager {
	public static void sound(String file) {
		InputStream music;
		try {
			music = MenuScreen.class.getResourceAsStream("../../../music/" + file);
			AudioStream audio = new AudioStream(music);
			AudioPlayer.player.start(audio);
		} catch (Exception e) {
		}
	}
}
