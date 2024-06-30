package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameComponents extends JPanel implements KeyListener,ActionListener{

	boolean play = false;
	boolean pause = false;
	int score = 0;
	
	int bricks = 24;
	int delay = 8;
	
	Timer timer = new Timer(delay,this);
	
	int playerX = 310;
	int paddleW = 100;
	
	int ballposX = 120;
	int ballposY = 350;
	int ballXdir = -1;
	int ballYdir = -2;
	
	ArrayList<PowerUps> powerUps = new ArrayList<>();
	
	Clip clip;
	
	Map map = new Map(3,8);
	
	GameComponents(){
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		timer.start();
		
		loadSound("Sound.wav");
		
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(1, 1, 792, 592);
		
		map.draw((Graphics2D) g);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD,25));
		g.drawString("Score: "+score, 670, 30);
		
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0, 0, 784, 3);
		g.fillRect(784,0,3,592);
		
		g.setColor(Color.darkGray);
		g.fillRect(playerX, 550, paddleW,8);
		
		g.setColor(Color.blue);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		for(PowerUps powerUp : powerUps) {
			powerUp.draw(g);
		}
		
		if(ballposY > 570) {
			
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("Game Over, Score: "+score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD,20));
			g.drawString("Press Enter to Restart", 230, 350);
			
		}
		
		if(bricks <=0) {
			
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("You Won, Score: "+score, 190,300);
			g.drawString("Press Enter to Restart",230,350);
			
		}
		
		g.dispose();
		
	}
	
	public void loadSound(String string) {
		
		try {
			
			File sound = new File(string);
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(play && !pause) {
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,paddleW,8))) {
				
				ballYdir = -ballYdir;
				playSound();
				
			}
			
			 A: for (int i = 0; i < map.map.length; i++) {
	                for (int j = 0; j < map.map[0].length; j++) {
	                    if (map.map[i][j] > 0) {
	                        int brickX = j * map.brickW + 80;
	                        int brickY = i * map.brickH + 50;
	                        int brickWidth = map.brickW;
	                        int brickHeight = map.brickH;

	                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
	                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
	                        Rectangle brickRect = rect;

	                        if (ballRect.intersects(brickRect)) {
	                            map.setBrickValue(0, i, j);
	                            bricks--;
	                            score += 10;
	                            
	                            if (Math.random() < 0.1) {
	                                powerUps.add(new PowerUps(brickX + brickWidth / 2 - 10, brickY, 1)); // Type 1 power-up
	                            }

	                            if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
	                                ballXdir = -ballXdir;
	                            } else {
	                                ballYdir = -ballYdir;
	                            }

	                            playSound();
	                            break A;
	                        }
	                    }
	                }          
			 }
			 
			 for (PowerUps powerUp : powerUps) {
				 
				 if(powerUp.isVisible) {
					 powerUp.y += 1;
					 
					 if(new Rectangle(playerX,550,paddleW,8).intersects(new Rectangle(powerUp.x,powerUp.y,powerUp.width,powerUp.height))) {
						 powerUp.isVisible = false;
						 applyPowerUp(powerUp.type);
					 }
					 
					 
					 if(powerUp.y >570) {
						 powerUp.isVisible = false;
					 }
				 }
			 }
			 
			 ballposX +=ballXdir;
				ballposY += ballYdir;
				
				if(ballposX<0) {
					ballXdir = -ballXdir;
				}
				
				if(ballposY < 0) {
					ballYdir = -ballYdir;
				}
				
				if(ballposX > 760) {
					ballXdir = -ballXdir;
				}
		}
		
		repaint();
		
	}

	private void applyPowerUp(int type) {
		
		switch(type) {
			case 1 :
				paddleW = 150;
				break;
				
			case 2 : 
				ballXdir *= 2;
				ballYdir *= 2;
				break;
			
		}
	}

	public void playSound() {
		
		if(clip != null) {
			clip.setFramePosition(0);
			clip.start();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRigth();
			}
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			if(playerX <10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				restartGame();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_P) {
			pause = !pause;
			if(pause) {
				timer.stop();
			}
			else {
				timer.start();
			}
		}
		
	}

	public void restartGame() {
		
		play = true;
		ballposX = 120;
		ballposY = 350;
		ballXdir = -1;
		ballYdir = -2;
		playerX = 310;
		score = 0;
		bricks = 21;
		paddleW = 100;
		map = new Map(3,7);
		powerUps.clear();
		repaint();
		
		
	}

	private void moveLeft() {
		
		play = true;
		playerX -=20;
		
	}

	private void moveRigth() {
		
		play = true;
		playerX +=20;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
