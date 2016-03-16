package net.seedsvictory.gui;

import java.awt.Font;
import java.io.File;

public class SilkScreen extends Font{
	private static final long serialVersionUID = 6773485L;
	
	
	
	public SilkScreen(int size) {
		super("SilkScreen", Font.PLAIN, size);
		try {
			Font.createFont(PLAIN, new File("silk.ttf"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
