/**
 * 
 */
package dxBallpkg;

import java.awt.Color;

/**
 * @author valentin
 *
 */
public class shape {
	private int[][] x;
	private int[][] y;
	private int[][] point;
	
	shape() { // constructor
		x = new int[][]{      {3,4,5,6,3,4,5,6}, {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18} };
		y = new int[][]{      {2,2,2,2,3,3,3,3}, {6,6,6,6,6,6, 6, 6, 6, 6, 6, 6, 6, 6, 6} };	
		point = new int[][]{  {3,2,3,2,1,3,2,1}, {2,2,2,2,2,3, 2, 2, 2, 2, 2, 2, 2, 2, 3} };
	}
	
	public int[] shapes_x(int nr) {
		return x[nr];
	}
	
	public int[] shapes_y(int nr) {
		return y[nr];
	}
	public int[] shape_point(int nr) {
		return point[nr];
	}
	
	 public Color detectColor(int nr) {
	    	if(nr==1) return Color.GRAY;
	     	if(nr==2) return Color.BLUE;
	     	if(nr==3) return Color.red;
	     	if(nr==4) return Color.MAGENTA;
	     	if(nr==5) return Color.ORANGE;
	     	if(nr==6) return Color.gray;
	     	if(nr==7) return Color.RED;
	     	if(nr==8) return Color.blue;
	     	if(nr==9) return Color.RED;
	     	if(nr==10) return Color.yellow;
	     	if(nr==11) return Color.RED;
	     	if(nr==12) return Color.magenta;
	    	if(nr==13) return Color.BLACK;
	     	else return null;
	    }
	
	protected void finalize() {
		System.out.println("object is destroyed");
	}
	
	
}
