/**
 * 
 */
package dxBall_V2;

/**
 * @author valentin
 *
 */
public class ball {
	
	private position poz = new position();
	private int  size;
    
	
	public ball()
	{
		poz.SetY(0);
		poz.SetX(0);
		size = 3;
	}
	
	public void setBall(int x, int y, int size) {
		poz.SetY(y);
		poz.SetX(x);
		this.size = size;
	}
	
	public int GetX_Ball()
	{
		return poz.GetX(); 
	}
	
	public int GetY_Ball()
	{
		return poz.GetY();
	}
	
	public int GetSize_Ball() 
	{
		return size;	
	}
	
}
