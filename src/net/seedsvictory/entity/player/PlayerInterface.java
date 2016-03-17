package net.seedsvictory.entity.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInterface implements KeyListener {
	
	private static volatile boolean right = false, left = false, up = false, down = false;
	
	public boolean[] getDirections(){
		boolean[] out = {right, left, up, down};
		return out;
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT: right= true;
		break;
		case KeyEvent.VK_LEFT: left = true;
		break;
		case KeyEvent.VK_UP: up = true;
		break;
		case KeyEvent.VK_DOWN: down = true;
		break;
		}
	}

	
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:right= false;
		break;
		case KeyEvent.VK_LEFT:left = false;
		break;
		case KeyEvent.VK_UP:up = false;
		break;
		case KeyEvent.VK_DOWN:down = false;
		break;
		}
	}

}
