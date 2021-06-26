package shape_generator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;  
  
public class DisplayGraphics extends Canvas{
	
	public DisplayGraphics() {
	}  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {  
        g.drawString("Hello",40,40);  
        setBackground(Color.BLUE);  
        g.fillRect(130, 30,100, 80);  
       g.drawImage(null, 100, 400, 100, 80, 23, 23, 23, 23, Color.ORANGE, null);
      
          
    }  
        public static void main(String[] args) {  
        	JFrame frame = new JFrame();
        	frame.setSize(300, 400);
        	frame.setTitle("Tetris");
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setVisible(true); 
    }  
  
}  