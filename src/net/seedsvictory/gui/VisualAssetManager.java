package net.seedsvictory.gui;

import java.awt.Image;
import java.awt.Toolkit;

public abstract class VisualAssetManager {
	
	private volatile static Image imagenotfound = Toolkit.getDefaultToolkit().getImage("imagenotfound.png");
	private volatile static Image[] assets = new Image[0];
	private volatile static String[] names = new String[0];
	
	public static void addAsset(Image img, String unlocName){
		Image[] temp = new Image[assets.length+1];
		String[] tempStr = new String[names.length+1];
		
		if(names.length != 0){
			System.arraycopy(assets, 0, temp, 0, assets.length);
			System.arraycopy(names, 0, tempStr, 0, names.length);
		}
		
		temp[temp.length-1] = img;
		tempStr[tempStr.length-1] = unlocName;
		
		assets = temp;
		names = tempStr;
		
		System.out.println("[INFO:VAM] Loaded " + names[names.length-1] + " (" + img.toString() + ")");
		System.out.println("[INFO:VAM] In slot: " + names.length + "\n");
	}
	
	public static void addAsset(String imageFile, String unlocName){
		Image[] temp = new Image[assets.length+1];
		String[] tempStr = new String[names.length+1];
		
		if(names.length != 0){
			System.arraycopy(assets, 0, temp, 0, assets.length);
			System.arraycopy(names, 0, tempStr, 0, names.length);
		}
		
		temp[temp.length-1] = Toolkit.getDefaultToolkit().getImage(imageFile);
		tempStr[tempStr.length-1] = unlocName;
		
		assets = temp;
		names = tempStr;
		
		System.out.println("[INFO:VAM] Loaded " + names[names.length-1] + " (" + imageFile + ")");
		System.out.println("[INFO:VAM] In slot: " + names.length + "\n");
	}
	
	public static Image getImage(String unlocName){
		for(int i = 0; i < names.length; i++){
			if(names[i] == unlocName){
				return assets[i];
			}
		}
		
		return imagenotfound;
		
	}
	
}
