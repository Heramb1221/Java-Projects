package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GPanel extends JPanel implements Runnable{
	
	static final int gWidth = 1000;
	static final int gHeight = (int)(gWidth*(0.5555));
	
	static final Dimension sSize = new Dimension(gWidth,gHeight);
	
	static final int bDia = 20;
	
	static final int pWidth = 25;
	static final int pHeight = 100;
	
	Thread gThread;
	Image image;
	Graphics graphics;
	Random random;
	Padels p1;
	Padels p2;
	Ball ball;
	Score score;
	

	GPanel(){
		
		nPaddles();
		nBall();
		
		score = new Score(gWidth,gHeight);
		
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(sSize);
		
		gThread = new Thread(this);
		gThread.start();
		
		
	}
	
	public void nBall() {
		
		random = new Random();
		
		ball = new Ball((gWidth/2) - (bDia/2),(gHeight/2)-(bDia/2),bDia,bDia);
		
	}
	
	public void nPaddles() {
		
		p1 = new Padels(0,(gHeight/2-(pHeight/2)),pWidth,pHeight,1);
		p2 = new Padels(gWidth-pWidth,(gHeight/2-(pHeight/2)),pWidth,pHeight,2);
		
	}
	
	public void paint(Graphics g) {
		
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		
		p1.draw(g);
		p2.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	
	public void move() {
		
		p1.move();
		p2.move();
		ball.move();
		
	}
	
	public void cCollision() {
		
		if(ball.y <= 0) {
			ball.setYdir(-ball.yvel);
		}
		if(ball.y >= (gHeight-bDia)) {
			ball.setYdir(-ball.yvel);
		}
		
		
		if(ball.intersects(p1)) {
			ball.xvel = Math.abs(ball.xvel);
			ball.xvel++;
			if(ball.yvel >0) {
				ball.yvel++;
			}
			else {
				ball.yvel--;
			}
			ball.setXdir(ball.xvel);
			ball.setYdir(ball.yvel);
		}
		
		if(ball.intersects(p2)) {
			ball.xvel = Math.abs(ball.xvel);
			ball.xvel++;
			if(ball.yvel >0) {
				ball.yvel++;
			}
			else {
				ball.yvel--;
			}
			ball.setXdir(-ball.xvel);
			ball.setYdir(ball.yvel);
		}
		
		
		if(p1.y<=0) {
			p1.y = 0;
		}
		if(p1.y>=(gHeight-pHeight)) {
			p1.y = gHeight-pHeight;
		}
		
		if(p2.y<=0) {
			p2.y = 0;
		}
		if(p2.y>=(gHeight-pHeight)) {
			p2.y = gHeight-pHeight;
		}
		
		
		if(ball.x<= 0) {
			
			score.player2++;
			nPaddles();
			nBall();
			
		}
		if(ball.x>= gWidth-bDia) {
			
			score.player1++;
			nPaddles();
			nBall();
			
		}
		
	}
	
	public void run() {
		
		long lTime = System.nanoTime();
		double aTicks = 60;
		double ns = 1000000000/aTicks;
		double delta = 0;
		
		while(true) {
			
			long now = System.nanoTime();
			delta +=(now-lTime)/ns;
			lTime = now;
			if(delta >=1) {
				move();
				cCollision();
				repaint();
				delta--;
				
			}
			
		}
		
		
	}
	
	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			p1.keyPressed(e);
			p2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			p1.keyReleased(e);
			p2.keyReleased(e);
		}
	}
}
