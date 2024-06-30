package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{
	
	Random random;
	int xvel;
	int yvel;
	int ispeed = 2;

	public Ball(int x, int y, int width, int height) {
		
		super(x,y,width,height);
		random = new Random();
		
		int rXdir = random.nextInt(2);
		
		if(rXdir == 0) {
			rXdir--;
		}
		
		setXdir(rXdir*ispeed);
		
		int rYdir = random.nextInt(2);
		
		if(rYdir == 0) {
			rYdir--;
		}
		
		setYdir(rYdir*ispeed);
	}

	public void setXdir(int randomX) {
		
		xvel = randomX;
		
	}
	
	public void setYdir(int randomY) {
		
		yvel = randomY;
		
	}
	
	public void move() {
		
		x += xvel;
		y += yvel;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.fillOval(x,y,height,width);
		
	}
}
