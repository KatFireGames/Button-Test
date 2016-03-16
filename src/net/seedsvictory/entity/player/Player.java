package net.seedsvictory.entity.player;

import java.awt.Point;

public abstract class Player {
	
	protected volatile static boolean gameRunning = true;
	
	public static String rootDir = System.getProperty("user.dir");
	
	private static Point playerPos;
	
	private static int hp, maxHp;
	
	public static Point getPlayerPos(){
		return playerPos;
	}
	
	public static void initPos(int x, int y){
		playerPos = new Point(x/2, y/2);
	}
	
	public static boolean isGameRunning(){
		return gameRunning;
	}
	
	public static void addHp(int i){
		if(hp + i > maxHp){
			hp = maxHp;
		}else{
			hp = hp + i;
		}
	}
	
	public static void subHp(int i){
		if(hp - i < 0){
			hp = 0;
		}else{
			hp = hp - i;
		}
	}
	
	public static void up(int minY){
		if(playerPos.y > minY){
			playerPos = new Point(playerPos.x, playerPos.y - 10);
		}
	}
	
	public static void down(int maxY){
		if(playerPos.y < maxY){
		playerPos = new Point(playerPos.x, playerPos.y + 10);
		}
	}
	
	public static void right(int maxX){
		if(playerPos.x < maxX){
			playerPos = new Point(playerPos.x + 10, playerPos.y);
		}
	}
	
	public static void left(int minX){
		if(playerPos.x > minX){
			playerPos = new Point(playerPos.x - 10, playerPos.y);
		}
	}
}
