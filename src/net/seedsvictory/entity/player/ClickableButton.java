package net.seedsvictory.entity.player;

public abstract class ClickableButton {
	
	private static int[][] buttonArray = new int[4][0];
	private static String[] names = new String[0];
	
	public static void createButton(String name, int x, int y, int maxX, int maxY){
		int[][] tempInt = new int[4][buttonArray[1].length+1];
		String[] tempString = new String[names.length+1];
		if(names.length != 0){
			System.arraycopy(buttonArray, 0, tempInt, 0, buttonArray.length-1);
			System.arraycopy(names, 0, tempString, 0, names.length-1);
		}
		tempInt[0][tempInt[0].length-1] = x;
		tempInt[1][tempInt[1].length-1] = y;
		tempInt[2][tempInt[2].length-1] = maxX;
		tempInt[3][tempInt[3].length-1] = maxY;
		tempString[tempString.length-1] = name;
		buttonArray = tempInt;
		names = tempString;
	}
	
	public static void clearButtons(){
		int[][] tempInt = new int[4][0];
		buttonArray = tempInt;
		String[] tempString = new String[0];
		names = tempString;
	}
	
	public static String getButtonClicked(int x, int y){
		for(int i = 0; i < names.length; i++){
			if(x >= buttonArray[0][i] && y >= buttonArray[1][i]){
				if(x <= buttonArray[0][i]+buttonArray[2][i] && y <= buttonArray[1][i]+buttonArray[3][i]){
					return names[i];
				}
			}
		}
		return "none";
	}
}
