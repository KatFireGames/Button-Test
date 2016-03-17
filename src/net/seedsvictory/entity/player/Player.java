package net.seedsvictory.entity.player;

import java.awt.Point;

public abstract class Player {
	
	protected volatile static boolean gameRunning = true;
	
	public static final String rootDir = System.getProperty("user.dir");
	
	private static Point playerPos;
	
	private static int hp, maxHp;
	
	private static int x, y;
	
	private static int size;
	
	public static Point getPlayerPos(){
		return playerPos;
	}
	
	public static void initPos(){
		playerPos = new Point((x/2)-((x/2)%10), (y/2)-((y/2)%10));
	}
	
	protected static void initScreenSize(int maxX, int maxY){
		x = maxX;
		y = maxY;
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

	public static void setSize(int playerSize) {
		size = playerSize;
		
	}

	protected static void goDirection(boolean[] directions) {
		if(directions.length == 4){
			int tmpX = (int)playerPos.getX();
			int tmpY = (int)playerPos.getY();
			if(directions[0] && tmpX < x-(size/2)){tmpX = tmpX + 5;}
			if(directions[1] && tmpX > 0+(size/2)){tmpX = tmpX - 5;}
			if(directions[2] && tmpY > 0+(size/2)){tmpY = tmpY - 5;}
			if(directions[3] && tmpY < y-(size/2)){tmpY = tmpY + 5;}
			playerPos = new Point(tmpX, tmpY);
		}
	}
}
