package net.seedsvictory.gameman;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import net.seedsvictory.entity.player.Player;
import net.seedsvictory.gui.Screen;
import net.seedsvictory.gui.SilkScreen;
import net.seedsvictory.gui.tools.ButtonInterface;
import net.seedsvictory.gui.tools.ClickableButton;

public class GameManager implements Runnable {

	
	public void run() {
		Font font = null;
		
		try {
			font = new SilkScreen(24);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		Screen win = new Screen("Seeds of Victory");
		
		logo(win);
		
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

	private void logo(Screen win) {
		Image logo = Toolkit.getDefaultToolkit().getImage("icon.png");
	    
		Graphics g = win.getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		int width = win.getWidth();
		int height = win.getHeight();
		
		Composite orig = g2d.getComposite();
		
		for(int i = 0; i<512; i++){
			g2d.setComposite(orig);
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, width, height);
			if(i <= 256){
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)i/256f));
			}else{
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(256f-((float)i-256f))/256f));
			}
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, (width-height)/2, height);
			g2d.fillRect(width-((width-height)/2), 0, (width-height)/2, height);
			g2d.drawImage(logo, (width-height)/2, 0, height, height, null);
			win.update();
			if(i == 256){
				try{
					for(int j = 0; j < 100; j++){
						Thread.sleep(20);win.update();
					}
				}catch(Exception ex){
						ex.printStackTrace();
				}
			}else{
				try{Thread.sleep(2);}catch(Exception ex){ex.printStackTrace();}
			}
			System.out.println(i);
		}
		
		g2d.setComposite(orig);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width, height);
	}

}
