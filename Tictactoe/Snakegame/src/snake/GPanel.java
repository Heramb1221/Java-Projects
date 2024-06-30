package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GPanel extends JPanel implements ActionListener{
	
	static final int sWidth = 600;
	static final int sHeight = 600;
	
	static final int uSize = 25;
	
	static final int gUnits =(sWidth*sHeight)/uSize;
	
	static final int delay = 75;
	
	final int x[] = new int[gUnits];
	final int y[] = new int[gUnits];
	
	int bParts = 6;
	
	int aEaten;
	int aX;
	int aY;
	
	char dir = 'R';
	
	boolean run = false;
	
	Timer timer ;
	Random random;
	
	GPanel(){
		
		random = new Random();
		
		this.setPreferredSize(new Dimension(sWidth,sHeight));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		
		sGame();
		
	}
	
	public void sGame() {
		
		nApple();
		
		run = true;
		
		timer = new Timer(delay,this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		draw(g);
		
	}

	public void draw(Graphics g) {
		
		if(run) {
			
			g.setColor(Color.red);
			g.fillOval(aX, aY, uSize, uSize);
			
			for(int i =0;i< bParts;i++) {
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], uSize, uSize);
				}
				
				else{
					g.setColor(new Color(45,180,0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], uSize, uSize);
				}
				
			}
			
			g.setColor(Color.magenta);
			g.setFont(new Font("Ink Free",Font.BOLD,40));
			FontMetrics m = getFontMetrics(g.getFont());
			g.drawString("Score: "+aEaten,(sWidth - m.stringWidth("Score: "+aEaten))/2, g.getFont().getSize());
			
		}
		else {
			gOver(g);
		}
		
	}
	
	public void nApple() {
		
		aX = random.nextInt((int)(sWidth/uSize))*uSize;
		aY = random.nextInt((int)(sHeight/uSize))*uSize;
		
	}
	
	public void move() {
		
		for(int i = bParts;i>0;i--) {
			
			x[i] = x[i-1];
			y[i] = y[i-1];
			
		}
		
		switch(dir) {
		
		case 'U' : 
			y[0] = y[0] - uSize;
			break;
			
		case 'D' : 
			y[0] = y[0] + uSize;
			break;
			
		case 'L' : 
			x[0] = x[0] - uSize;
			break;
			
		case 'R' : 
			x[0] = x[0] + uSize;
			break;
		
		}
		
	}
	
	public void cApple() {
		
		if((x[0] == aX) && (y[0] == aY)) {
			
			bParts++;
			aEaten++;
			nApple();
			
		}
		
	}
	
	public void cCollision() {
		
		for(int i = bParts;i>0;i--)	{
			if(x[0] == x[i] && y[0] == y[i]) {
				run = false;	
			}
		}
		
		if(x[0]<0) {
			run = false;
			
		}
		
		if(x[0]>sWidth) {
			run = false;
		}
		
		if(y[0]<0) {
			run = false;
		}
		
		if(x[0]>sHeight) {
			run = false;
		}
		
		if(run == false) {
			timer.stop();
		}
		
	}
	
	public void gOver(Graphics g) {
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics m1 = getFontMetrics(g.getFont());
		g.drawString("Game Over",(sWidth - m1.stringWidth("Game Over"))/2, sHeight/2);
		
		g.setColor(Color.magenta);
		g.setFont(new Font("Ink Free",Font.BOLD,40));
		FontMetrics m2 = getFontMetrics(g.getFont());
		g.drawString("Score: "+aEaten,(sWidth - m2.stringWidth("Score: "+aEaten))/2, g.getFont().getSize());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(run) {
			
			move();
			
			cApple();
			
			cCollision();
			
		}
		
		repaint();		
	}

	public class MyKeyAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT :
				if(dir != 'R') {
					dir = 'L';
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				if(dir != 'L') {
					dir = 'R';
				}
				break;
				
			case KeyEvent.VK_UP :
				if(dir != 'D') {
					dir = 'U';
				}
				break;
				
			case KeyEvent.VK_DOWN :
				if(dir != 'U') {
					dir = 'D';
				}
				break;
			
			}
			
		}
		
	}
	
}
