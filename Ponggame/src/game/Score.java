package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle{
	
	static int gWidth;
	static int gHeight;
	
	int player1;
	int player2;

	Score(int gw, int gh){
		
		Score.gWidth = gw;
		Score.gHeight = gh;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		g.drawLine(gWidth/2,0,gWidth/2,gHeight);
		g.drawString(String.valueOf(player1), (gWidth/2)-85, 50);
		g.drawString(String.valueOf(player2), (gWidth/2)+20, 50);
	}
}
