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
import net.seedsvictory.entity.player.PlayerInterface;
import net.seedsvictory.entity.player.PlayerManager;
import net.seedsvictory.gui.Screen;
import net.seedsvictory.gui.SilkScreen;
import net.seedsvictory.gui.VisualAssetManager;
import net.seedsvictory.gui.tools.ButtonInterface;
import net.seedsvictory.gui.tools.ClickableButton;

public class GameManager implements Runnable {
	
	private static boolean menuSetup = true;
	
	private static Thread assetManager, game, entityManager, particleManager, playerManager;
	private static PlayerManager playerMgr;
	
	private static Color swap = Color.BLUE;
	
	public void run() {
		
		System.out.println("Found directory to be: " + Player.rootDir);
		
		Font font = null;
		
		try {
			font = new SilkScreen(24);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		VisualAssetManager.addAsset("Button_Small.png", "b_small");
		VisualAssetManager.addAsset("Quit_Symbol.png", "quit");
		VisualAssetManager.addAsset("Button_Small_Inverted.png", "bi_small");
		
		Screen win = new Screen("Seeds of Victory");
		
		logo(win);
		
		ButtonInterface buttonMgr = new ButtonInterface();
		PlayerInterface playerInt = new PlayerInterface();
		
		win.getFullScreenWindow().addMouseListener(buttonMgr);
		win.getFullScreenWindow().addMouseMotionListener(buttonMgr);
		
		win.getFullScreenWindow().addKeyListener(playerInt);
		
		playerMgr = new PlayerManager(playerInt, 50, win);
		playerManager = new Thread(playerMgr);
		
		playerManager.start();
		
		while(true){
			if(!Player.isGameRunning()){
				break;
			}
			
			Graphics g = win.getGraphics();
			
			if(menuSetup){
				ClickableButton.createButton("exit", 0, 0, 64, 64);
				ClickableButton.createButton("color", 64, 0, 64, 64);
				menuSetup = false;
			}
			
			g.setColor(Color.BLACK);
			g.fillRect(0,0,win.getWidth(),win.getHeight());
			g.setColor(swap);
			g.fillRect((int)Player.getPlayerPos().getX()-25, (int)Player.getPlayerPos().getY()-25, 50, 50);
			
			if(!buttonMgr.getButtonClicked().equals("none")){
				switch(buttonMgr.getButtonClicked()){
				case "exit":
					win.stopWindow();
					playerMgr.stopGame();
				break;
				
				case "color":
					if(swap == Color.BLUE){swap = Color.RED;}
					else{swap = Color.BLUE;}
				break;
					
				}
				buttonMgr.clearButton();
			}
			
			if(ClickableButton.getButtonClicked((int)buttonMgr.getMousePos().getX(), (int)buttonMgr.getMousePos().getY()) == "exit"){
				
				g.drawImage(VisualAssetManager.getImage("bi_small"), 0, 0, 64, 64, null);
			
			}else{
				
				g.drawImage(VisualAssetManager.getImage("b_small"), 0, 0, 64, 64, null);
				
			}
			
			if(ClickableButton.getButtonClicked((int)buttonMgr.getMousePos().getX(), (int)buttonMgr.getMousePos().getY()) == "color"){
				
				g.drawImage(VisualAssetManager.getImage("bi_small"), 64, 0, 64, 64, null);
			
			}else{
				
				g.drawImage(VisualAssetManager.getImage("b_small"), 64, 0, 64, 64, null);
				
			}
			
			g.drawImage(VisualAssetManager.getImage("quit"), 0, 0, 64, 64, null);
			
			win.update();
			
			try{
				
				Thread.sleep(10);
				
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
		}
		win.stopWindow();
		System.out.println(Player.isGameRunning());
		try {
			playerManager.join();
		} catch (Exception e) {
			e.printStackTrace();
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
				try{
					Thread.sleep(2);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		
		g2d.setComposite(orig);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width, height);
	}

}
