package net.seedsvictory.entity.player;

import java.awt.event.KeyEvent;

import net.seedsvictory.gui.Screen;
import net.seedsvictory.gui.tools.InputManager;

public class PlayerManager implements Runnable{
	
	private static InputManager input;
	private static int width, height;
	
	public PlayerManager(InputManager m, Screen screen){
		input = m;
		width = screen.getWidth();
		height = screen.getHeight();
		Player.initPos(width, height);
	}
	
	public void run() {
		for(int i = 0; i < 1; i++){
			if(input.getIsKeyPressed()){
				switch(input.getKeyPressed()){
				
				case KeyEvent.VK_RIGHT:
					Player.right(width);
				break;
				
				case KeyEvent.VK_LEFT:
					Player.left(0);
				break;
				
				case KeyEvent.VK_UP:
					Player.up(0);
				break;
				
				case KeyEvent.VK_DOWN:
					Player.down(height);
				break;
				
				}
				try{
					Thread.sleep(50);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			if(Player.isGameRunning()){
				i--;
			}
		}
	}
	
	public void stopGame(){
		Player.gameRunning = false;
	}
	
	
}
