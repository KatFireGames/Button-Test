package net.seedsvictory.gui.tools;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ButtonInterface implements MouseListener, MouseMotionListener, KeyListener {
	
	private volatile static String buttonClicked = "none";
	private static int x, y;
	
	public String getButtonClicked(){
		return buttonClicked;
	}
	
	public void clearButton(){
		buttonClicked = "none";
	}
	
	public Point getMousePos(){
		return new Point(x, y);
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}

	
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1){
			buttonClicked = ClickableButton.getButtonClicked(e.getX(), e.getY());
			System.out.println(buttonClicked);
			System.out.println("X: " + e.getX() + " | Y: " + e.getY());
		}
	}

	
	public void mousePressed(MouseEvent e) {
		

	}

	
	public void mouseReleased(MouseEvent e) {
		

	}

	
	public void mouseEntered(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	
	public void mouseExited(MouseEvent e) {
		

	}


	
	public void keyTyped(KeyEvent e) {
		
		
	}


	
	public void keyPressed(KeyEvent e) {
		
	}


	
	public void keyReleased(KeyEvent e) {
		
		
	}

}
