package net.seedsvictory.gui.tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputManager implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	private static int keyTyped, keyPressed;
	private static boolean mousePressed = false, mouseClicked = false, isKeyPressed = false, isKeyTyped = false;
	private static int buttonPressed, buttonClicked;
	
	public boolean getIsKeyPressed(){
		return isKeyPressed;
	}
	
	public boolean getIsMousePressed(){
		return mousePressed;
	}
	
	public int getKeyPressed(){
		return keyPressed;
	}
	
	public int getKeyTyped(){
		return keyTyped;
	}
	
	public int getMouseButtonClicked(){
		return buttonClicked;
	}
	
	public int getMouseButtonPressed(){
		return buttonPressed;
	}
	
	public void keyTyped(KeyEvent e) {
		keyTyped = e.getKeyCode();
		isKeyTyped = true;
		isKeyTyped = false;
	}

	
	public void keyPressed(KeyEvent e) {
		keyPressed = e.getKeyCode();
		isKeyPressed = true;
	}

	
	public void keyReleased(KeyEvent e) {
		isKeyPressed = false;

	}

	
	public void mouseWheelMoved(MouseWheelEvent e) {

	}

	
	public void mouseDragged(MouseEvent e) {
		

	}

	
	public void mouseMoved(MouseEvent e) {
		

	}

	
	public void mouseClicked(MouseEvent e) {
		buttonPressed = e.getButton();
		mouseClicked = true;
		mouseClicked = false;
	}

	
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		buttonPressed = e.getButton();
	}

	
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}

	
	public void mouseEntered(MouseEvent e) {
		

	}

	
	public void mouseExited(MouseEvent e) {
		

	}

}
