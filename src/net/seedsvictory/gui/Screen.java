package net.seedsvictory.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JFrame;

public class Screen{
	
	private static GraphicsDevice vc;
	
	private static Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
	
	private static int width, height;
	
	private static JFrame frame;
	
	public Screen(String title){
		
		frame = new JFrame();
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		vc = env.getDefaultScreenDevice();
		
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		frame.setTitle(title);
		frame.setName(title);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setIgnoreRepaint(true);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon);
		
		vc.setFullScreenWindow(frame);
		vc.setDisplayMode(getCorrectDisplayMode());
		
		frame.createBufferStrategy(2);
	}
	
	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	
	public Graphics getGraphics(){
		return vc.getFullScreenWindow().getBufferStrategy().getDrawGraphics();
	}
	
	public GraphicsDevice getDevice(){
		return vc;
	}
	
	public void stopWindow(){
		frame.dispose();
		vc.setFullScreenWindow(null);
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	protected GraphicsDevice getGraphicsDevice(){
		return vc;
	}
	
	protected DisplayMode getDisplayMode(){
		return vc.getDisplayMode();
	}
	
	public void update(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			BufferStrategy s = w.getBufferStrategy();
			if(!s.contentsLost()){
				s.show();
			}
		}
	}
	
	private DisplayMode getCorrectDisplayMode(){
		DisplayMode[] modes = vc.getDisplayModes();
		
		if(System.getProperty("os.name").contains("Windows")){
			
			for(int i = 0; i < modes.length; i++){
				
				if(modes[i].getWidth() == width && modes[i].getHeight() == height){
					if(modes[i].getBitDepth() == 32){
						return modes[i];
					}
				}
				
			}
		}
		
		for(int i = 0; i < modes.length; i++){
			
			if(modes[i].getWidth() == width && modes[i].getHeight() == height){
				
				return modes[i];
				
			}
			
		}
			
		return null;
	}
	
	protected void registerKeyListener(KeyListener k){
		frame.addKeyListener(k);
		
	}
	
	protected void registerMouseListener(MouseListener m){
		frame.addMouseListener(m);
		
	}
	
	protected void registerMouseMotionListener(MouseMotionListener m){
		frame.addMouseMotionListener(m);
		
	}
	
	protected void registerMouseWheelListener(MouseWheelListener m){
		frame.addMouseWheelListener(m);
		
	}
}
