import java.awt.Color;
import sun.audio.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel 
{
	private Image background; 
	private Font gameFont;
	private Paddle paddleLeft;
	private Paddle paddleRight;
	private Timer timer;
	private Ball ball;
	private int score1 = 0;
	private int score2 = 0;
	
	
	public Board()
	{
		background = new ImageIcon("PongBackground.png").getImage();
		gameFont = new Font("Arial",Font.BOLD,44);
		paddleLeft = new Paddle(35, 263, Color.white,this);
		paddleRight = new Paddle(945,263,Color.white,this);
		ball = new Ball();
		try
	    {
			File f = new File("ARCADE_R.ttf");
			FileInputStream in = new FileInputStream(f);
			Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, in);
			gameFont = dynamicFont.deriveFont(64f);
	     
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Loading Font Didn't Work");
	    }
		this.addKeyListener(new PaddleListener());
		this.setFocusable(true);
		timer = new Timer(50,new MoveBall());
		timer.start();
		System.out.println("hello " + getHeight());
	}
	@Override
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2D = (Graphics2D)g;
		Image zep = new ImageIcon("Zeppellin.png").getImage();
		g2D.drawImage(background, 0, 0, background.getWidth(null), background.getHeight(null),null);
		g2D.drawImage(zep, 0,0,500,500,null);
		g2D.setColor(paddleLeft.getPaddleColor());
		g2D.fill(paddleLeft);
		g2D.setColor(paddleRight.getPaddleColor());
		g2D.fill(paddleRight);
		g2D.setColor(ball.getBallColor());
		g2D.fill(ball);
		g2D.setFont(gameFont);
		int w = g2D.getFontMetrics().stringWidth(""+score1);
		g2D.drawString(""+score1, (int)getWidth()/2-w - 100, 100);
		w = g2D.getFontMetrics().stringWidth("" + score2);
		g2D.drawString(""+score2, (int)getWidth()/2 + 100,100);
		System.out.println("Getting Painted" + paddleLeft.getWidth() + getHeight());
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(background.getWidth(null), background.getHeight(null));
	}



	class PaddleListener implements KeyListener
	{
	
		@Override
		public void keyTyped(KeyEvent e)
		{
			if(e.getKeyChar()=='a' && paddleLeft.getY()>15)
			{
				paddleLeft.moveUp();
			}
			if(e.getKeyChar()=='z' && paddleLeft.getY()+paddleLeft.getHeight()<569)
			{
				paddleLeft.moveDown();
			}
			if(e.getKeyChar()=='k' && paddleRight.getY()>15)
			{
				System.out.println("K" + paddleRight.getY());
				paddleRight.moveUp();
				
			}
			if(e.getKeyChar()=='m' && paddleRight.getY()+paddleRight.getHeight()<569)
			{
				paddleRight.moveDown();
			}
			repaint();
			
		}
	
		@Override
		public void keyPressed(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}

	}
	
	class MoveBall implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(ball.getX()<15)
			{
				ball.setDx(1);
				score2++;
			}
			if(paddleLeft.intersects(ball))
				ball.setDx(1);
			if(ball.getX() > 969)
			{
				ball.setDx(-1);
				score1++;
			}
			if(paddleRight.intersects(ball))
				ball.setDx(-1);
			if(ball.getY() > 569)
				ball.setDy(-1);
			if(ball.getY() < 15)
				ball.setDy(1);
			ball.move();
			repaint();
			
		}
	}
	
}