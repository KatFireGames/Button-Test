package net.seedsvictory;

import net.seedsvictory.gameman.GameManager;

public class Start {
	
	private static Thread gameManager;
	
	public static void main(String[] args){
		
		gameManager = new Thread(new GameManager());
		
		gameManager.start();
		
		try {
			gameManager.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
