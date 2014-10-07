import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.Timer;


public class Paddle extends Rectangle2D.Double 
{
	private Color paddleColor;
	private Board board;
	
	
	public Paddle(double x, double y, Color color, Board board)
	{
		super(x,y,20,150);
		this.setPaddleColor(color);
		this.board = board;
		
	}
	public Color getPaddleColor()
	{
		return paddleColor;
	}
	public void setPaddleColor(Color paddleColor)
	{
		this.paddleColor = paddleColor;
	}
	
	public void moveUp()
	{
		y-=30;
	}
	
	public void moveDown()
	{
		y+=30;
	
	}
	

}
