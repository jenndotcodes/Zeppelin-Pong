import java.awt.Color;
import java.awt.geom.Rectangle2D;



public class Ball extends Rectangle2D.Double
{
	private Color ballColor;
	private int dx, dy;
	public Ball()
	{
		this.ballColor = Color.white;
		this.width=15;
		this.height=15;
		this.x = 100;
		this.y=100;
		this.setDx(-1);
		this.setDy(1);
	}
	
	public void move()
	{
	
			x+=dx*10;
			y+=dy*10;
	}
	public Color getBallColor()
	{
		return ballColor;
	}
	public void setBallColor(Color ballColor)
	{
		this.ballColor = ballColor;
	}

	public int getDx()
	{
		return dx;
	}

	public void setDx(int dx)
	{
		this.dx = dx;
	}

	public int getDy()
	{
		return dy;
	}

	public void setDy(int dy)
	{
		this.dy = dy;
	}
	
}
