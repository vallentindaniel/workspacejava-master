package z_tetris;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
        
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int yi=1;
	public int[][] matrix;
	public int[][][] shapes;
	

	
	public void drowTetris(Graphics g, int[][] matrix) {
		int l,xi=5;
		
		 
	}
	
	
	
	
	
	
	
	

	public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        
        int i,k=0;
        for(i=1;i<=13;i++) {
        	g2d.drawLine(10+k, 10, 10+k, 610);
        	g2d.drawLine(10, 10+k, 610, 10+k);
        	k+=50;
        }
      
        drowTetris(g2d,matrix);  
    }

    @Override
    public void paintComponent(Graphics g) {
                
        super.paintComponent(g);
        doDrawing(g);
    }           
}

public class ColoursEx extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColoursEx() {

        initUI();
    }

    private void initUI() {
        
        add(new Surface());
        
        setTitle("Colours");
        setSize(800, 800);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ColoursEx ex = new ColoursEx();
                ex.setVisible(true);
            }
        });
    }
}