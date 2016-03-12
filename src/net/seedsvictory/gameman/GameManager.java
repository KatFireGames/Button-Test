package net.seedsvictory.gameman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import net.seedsvictory.entity.player.ButtonInterface;
import net.seedsvictory.entity.player.ClickableButton;
import net.seedsvictory.entity.player.Player;
import net.seedsvictory.gui.Screen;
import net.seedsvictory.gui.SilkScreen;

public class GameManager implements Runnable {

	
	public void run() {
		Font font = null;
		
		try {
			font = new SilkScreen(24);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		Screen win = new Screen("Seeds of Victory");
		
		
		ButtonInterface buttonMgr = new ButtonInterface();
		
		win.getFullScreenWindow().addMouseListener(buttonMgr);
		win.getFullScreenWindow().addMouseMotionListener(buttonMgr);
		
		ClickableButton.createButton("exit", 0, 0, 200, 100);
		
		while(true){
			if(!Player.isGameRunning()){
				win.stopWindow();
				break;
			}
			Graphics g = win.getGraphics();
			if(!ClickableButton.getButtonClicked((int)buttonMgr.getMousePos().getX(), (int)buttonMgr.getMousePos().getY()).equals("exit")){
				g.setColor(Color.RED);
				g.fillRect(0,0,150,100);
			}else{
				g.setColor(Color.lightGray);
				g.fillRect(0, 0, 150, 100);
			}
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString("EXIT", 50, 50);
			win.update();
			if(buttonMgr.getButtonClicked().equals("exit")){
				win.stopWindow();
				break;
			}
			
			try{
				Thread.sleep(50);
			}catch(Exception e){e.printStackTrace();}
		}
	}

}
