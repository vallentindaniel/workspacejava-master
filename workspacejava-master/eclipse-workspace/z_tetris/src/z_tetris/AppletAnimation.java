package z_tetris;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class AppletAnimation extends Applet implements Runnable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[][] matrix;
	
	public int[][] body;
	public Color color;

int xi = -1,yi = 0;

  int delay = 300;

  Thread animatorThread;

  boolean frozen = false;
private KeyEvent e;

  public void init() {
   
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (frozen) {
          frozen = false;
          start();
        } else {
          frozen = true;
          stop();
        }
      }
    });
  }

  public void start() {
    if (!frozen) {
      if (animatorThread == null) {
        animatorThread = new Thread(this);
      }
      animatorThread.start();
    }
  }

  public void stop() {
    animatorThread = null;
  }

  public void run() {
    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    setSize(900, 900);

    long startTime = System.currentTimeMillis();

    Thread currentThread = Thread.currentThread();

    while (currentThread == animatorThread) {
    	xi++;
       
      if(xi==12) { xi=0; yi++;}
      if(yi==12) yi =0;

      repaint();

      try {
        startTime += delay;
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        break;
      }
    }
  }
  
  
 
  
  
  
  
  
  
  public void drowTetris(Graphics g, int[][] matrix) {
	  
	  
	  
	
	 
	    
	 
	  
	  
	  
	  
		int l,c,c2=-1,l2=-1;
		 c=0;
		 l=yi;
		 g.setColor(Color.RED);
		 if(xi <0) xi=0;
		for(c=0;c<=xi;c++) {
			
		
				g.clearRect(10+50*c2, 10+50*l2, 50, 50);
				g.fillRect(10+50*c, 10+50*l, 50, 50);
				
				c2=c;
				l2=l;
				//c++;
		
			
		
			
			
		}

		
		 g.setColor(Color.BLACK);
	   
	     
	     doDrawing(g);
	}
	
	
	

	public void doDrawing(Graphics g) {

      Graphics2D g2d = (Graphics2D) g;

      
      int i,k=0;
      for(i=1;i<=13;i++) {
      	g2d.drawLine(10+k, 10, 10+k, 610);
      	g2d.drawLine(10, 10+k, 610, 10+k);
      	k+=50;
      }
    
     
  }
  
  
  
  

  public void paint(Graphics g) {
      doDrawing(g);
      drowTetris(g,matrix);  
   
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
}






































