package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Padels extends Rectangle{
	
	int id;
	int yVel;
	int speed = 10;
	
	Padels(int x, int y, int pwidth, int pheight, int id){
		
		super(x,y,pwidth,pheight);
		this.id = id;
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		switch(id) {
		case 1 : 
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYdir(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYdir(speed);
				move();
			}
			break;
		
		case 2 : 
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYdir(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYdir(speed);
				move();
			}
			break;
		
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		switch(id) {
		case 1 : 
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYdir(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYdir(0);
				move();
			}
			break;
		
		case 2 : 
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYdir(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYdir(0);
				move();
			}
			break;
		
		}
		
	}
	
	public void setYdir(int ydir) {
		
		yVel = ydir;
		
	}
	
	public void move() {
		
		y = y+yVel;
		
	}
	
	public void draw(Graphics g) {
		
		if(id == 1) {
			
			g.setColor(Color.blue);
			
			
		}
		else {
			g.setColor(Color.red);
		}
		g.fillRect(x,y,width,height);
		
	}

}
