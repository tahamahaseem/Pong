package com.tahama.pong;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface IArt extends MouseListener, KeyListener {

	void draw(Graphics g);

}
