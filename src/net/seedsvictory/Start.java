package net.seedsvictory;

import net.seedsvictory.gameman.GameManager;

public class Start {
	
	private static Thread game;
	
	public static void main(String[] args){
		
		game = new Thread(new GameManager());
		
		game.start();
		
		try {
			game.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
