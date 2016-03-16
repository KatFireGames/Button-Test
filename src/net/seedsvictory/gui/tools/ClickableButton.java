package net.seedsvictory.gui.tools;

public abstract class ClickableButton {
	
	private volatile static int[] buttonArrayX = new int[0], buttonArrayY = new int[0],
			buttonArrayMaxX = new int[0], buttonArrayMaxY = new int[0];
	private volatile static String[] names = new String[0];
	
	public static void createButton(String name, int x, int y, int maxX, int maxY){
		int[] tempIntX = new int[buttonArrayX.length+1], tempIntY = new int[buttonArrayX.length+1],
			tempIntMaxX = new int[buttonArrayX.length+1], tempIntMaxY = new int[buttonArrayX.length+1];
		String[] tempString = new String[names.length+1];
		
		if(names.length != 0){
			System.arraycopy(names, 0, tempString, 0, names.length);
			System.arraycopy(buttonArrayX, 0, tempIntX, 0, buttonArrayX.length);
			System.arraycopy(buttonArrayY, 0, tempIntY, 0, buttonArrayY.length);
			System.arraycopy(buttonArrayMaxX, 0, tempIntMaxX, 0, buttonArrayMaxX.length);
			System.arraycopy(buttonArrayMaxY, 0, tempIntMaxY, 0, buttonArrayMaxY.length);
		}
		
		tempIntX[tempIntX.length-1] = x;
		tempIntY[tempIntY.length-1] = y;
		tempIntMaxX[tempIntMaxX.length-1] = maxX;
		tempIntMaxY[tempIntMaxY.length-1] = maxY;
		tempString[tempString.length-1] = name;
		
		buttonArrayX = tempIntX;
		buttonArrayY = tempIntY;
		buttonArrayMaxX = tempIntMaxX;
		buttonArrayMaxY = tempIntMaxY;
		names = tempString;
	}
	
	public static void clearButtons(){
		int[] tempInt = new int[0];
		buttonArrayX = tempInt;
		String[] tempString = new String[0];
		names = tempString;
	}
	
	public static String getButtonClicked(int x, int y){
		for(int i = 0; i < names.length; i++){
			if(x >= buttonArrayX[i] && y >= buttonArrayY[i]){
				if(x <= (buttonArrayX[i]+buttonArrayMaxX[i]) && y <= (buttonArrayY[i]+buttonArrayMaxY[i])){
					return names[i];
				}
			}
		}
		return "none";
	}
}
