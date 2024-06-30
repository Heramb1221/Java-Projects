package game;

import java.awt.Color;
import java.awt.Graphics;

public class PowerUps {

	public boolean isVisible;
	public int y;
	public int x;
	public int width;
	public int height;
	public int type;

	public PowerUps(int x, int y, int type) {
		
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 20;
		this.isVisible = true;
		this.type = type;
		
	}

	public void draw(Graphics g) {
		
		if(isVisible) {
			switch(type) {
			case 1 :
				g.setColor(Color.orange);
				break;
				
			case 2 :
				g.setColor(Color.green);
				break;
			}
			
			g.fillRect(x, y, width, height);
				
		}
		
	}

}
