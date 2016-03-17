package net.seedsvictory.entity.player;

import net.seedsvictory.gui.Screen;

public class PlayerManager implements Runnable{
	
	private static PlayerInterface input;
	private static int width, height;
	
	public PlayerManager(PlayerInterface m, int playerSize, Screen screen){
		input = m;
		width = screen.getWidth();
		height = screen.getHeight();
		Player.initScreenSize(width, height);
		Player.initPos();
		Player.setSize(playerSize);
	}
	
	public void run() {
		while(Player.isGameRunning()){
				
				Player.goDirection(input.getDirections());
				
				try{
					Thread.sleep(25);
				}catch(Exception ex){
					ex.printStackTrace();
				}
		}
	}
	
	public void stopGame(){
		Player.gameRunning = false;
	}
	
	
}
