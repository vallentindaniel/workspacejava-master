/**
 * 
 */
package dxBallpkg;

/**
 * @author valentin
 *
 */
public class navBar {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	navBar(){
		width=20*18;
		height=50;
		x=5;
		y=20;
	}
	public void setBar( int x, int y, int width, int height )
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int x()
	{
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	protected void finalize() {
		System.out.println("object is destroyed");
	}
	
	
	

}














