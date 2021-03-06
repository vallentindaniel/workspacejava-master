/**
 * 
 */
package dxBallpkg;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author valentin
 *
 */
public class ball 
{
	
	private int x;
	private int dx;
	private int max_x;
	private int y;
	private int dy;
	private int max_y;
	
	
	private int dimension;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	ball() // initialize x and y
	{
		dx = (int) screenSize.getWidth();
		dx/=150;
		
		dy = (int) screenSize.getHeight();
		dy/=150;
		
		x=(int) screenSize.getWidth();
		max_x = x-30;
		x=(x-30)/2;
		x=-x;
		y=(int) screenSize.getHeight();
		max_y = y-30;
		y=(y-30)/2+y/4;
		
		dimension=3;
	}
	
	public void set_ball(int x, int y, int dimension) // det new coordonate
	{    
		this.x=x;
		this.y=y;
		this.dimension= dimension;
	}
	
	public int ball_x()  // return coordonate x for ball
	{
		return x;
	}
	public int ball_y()  // return coordonate y for ball 
	{
		return y;
	}
	public int dx() {
		return dx;
	}
	public int dy() {
		return dy;
	}
	public int max_x() {
		return max_x;
	}
	public int max_y() {
		return max_y;
	}
	
	
	
	public int ball_dimension() {
		return dimension;
	}
	
	protected void finalize() 
	{
		System.out.println("object is destroyed");
	}
}
