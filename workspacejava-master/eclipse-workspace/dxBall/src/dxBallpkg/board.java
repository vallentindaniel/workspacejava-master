/**
 * 
 */
package dxBallpkg;

/**
 * @author valentin
 *
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class board extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
   	int d_width = gd.getDisplayMode().getWidth()-300;
    int d_height = gd.getDisplayMode().getHeight()-300;
    
    private final int DELAY = 25;
    private int x_mouse; // for navBar
   
    
    ball Ball = new ball();
    private int x_Ball;
  
    private int y_Ball;
    
    private int dx; // for move x_Ball
    private int dy; // for move y_Ball
    private int dx_copy;
    
   
    private int dimension_Ball;
    
    navBar NavBar = new navBar();
    private int x_Bar;
    private int y_Bar;
    private int width_Bar;
    private int height_Bar;
    
    shape Shape = new shape() ;
    private int[] x;
    private int[] y;
    private int[] point;
    
    
    private int max_x;
    private int max_y;
    
   
   
    private boolean Exit = false;
    private boolean Enter = false;
    private boolean Escape = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    
    
    
    
 

    public board() {
        
        initBoard();
    }
    
    private void initBoard() { // initializare pagina
          // MouseXY
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        
        Dimension dimensiune=new Dimension(d_width, d_height);
        setPreferredSize(dimensiune);
      
       
        initGame();
    }
   
    

    private void initGame() {                // init Game with information for start
    	
         // init Ball
    	
    	dx = Ball.dx();
    	dx_copy= dx;
    	
    	dy = Ball.dy();
    	
    	max_x = Ball.max_x();
    	
    	max_y = Ball.max_y();
    	
    	x_Ball = Ball.ball_x();
    	
    	y_Ball = Ball.ball_y();
    	
    	dimension_Ball = Ball.ball_dimension();
    	
    	// init NavBar
    	x_Bar = NavBar.x();                   // set coordonate x for NavBar
    	y_Bar = NavBar.y();                   // set coordonate y for NavBar
    	width_Bar = NavBar.width();
    	height_Bar = NavBar.height();
    	
    	 // init shape
    	 x = Shape.shapes_x(1).clone();        // set coordonate x for shape
         y = Shape.shapes_y(1).clone();        // set coordonate y for shape
    	 point = Shape.shape_point(1).clone(); // set color for shape
    	
    	
    	
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
  

    @Override
    public void paintComponent(Graphics g) { // desenare componenta
        super.paintComponent(g);

        doDrawing(g);
    }
    
    
    private void doDrawing(Graphics g) {      // desenare joc
        
        if (inGame && !Escape) { // here i draw shape
        	
        	Graphics2D g2d = (Graphics2D) g;
            int i;
            dimension_Ball = Ball.ball_dimension();
            
            for(i=0;i<x.length;i++) {                // draw shape
            	if(point[i]>0) {
            		g2d.setColor(Shape.detectColor(point[i]) );
                	g2d.fillRect(50*x[i],50*y[i], 49, 49);
            	}
            	
            }
            
                g2d.setColor(Color.YELLOW);
                g2d.fillOval(x_Ball, y_Ball, 10*dimension_Ball, 10*dimension_Ball); // ball
            
         
            	g2d.setColor(Color.yellow);
            	g2d.fillRect(10+x_Bar,700+y_Bar, width_Bar, height_Bar);
            
            
         		
         	  
            
            
          
    
            
            
            
            Toolkit.getDefaultToolkit().sync();

        } 
        if(Escape) {
        	gamePause(g);
        }
        
        if(!inGame) {

            gameOver(g);
        }        
    }

 private void gamePause(Graphics g) { // joc pierdut
        
        String msg = "Exit game for X";
        String msg2 ="Resume game for Enter ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (d_width - metr.stringWidth(msg)) / 2, d_height / 2);
        g.drawString(msg2, (d_width - metr.stringWidth(msg2)) / 2, d_height / 2+50);
        if(Enter) {
        	Escape=false;
        	Enter=false;
        }
        if(Exit) {
        	System.exit(0);
        }
    }
    
    
    private void gameOver(Graphics g) { // joc pierdut
        
        String msg = "Game Over";
        String msg2 ="Your score is : ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (d_width - metr.stringWidth(msg)) / 2, d_height / 2);
        g.drawString(msg2, (d_width - metr.stringWidth(msg2)) / 2, d_height / 2+50);
    }

    
 

    
    private void move() {  // is used for set action  in game
    
    	x_mouse = MouseInfo.getPointerInfo().getLocation().x; // move anvBar // 1920
    //	int y_mouse=MouseInfo.getPointerInfo().getLocation().y; // 1080
        x_Bar=x_mouse-180;
        int xb1, xb2,xb3,xb4,xb5,xb6,yb1;
        yb1 = 50*y_Bar;
        int x1=width_Bar/6;
        xb1 = x_Bar-10;
        xb2 = xb1+x1+10;
        xb3 = xb2+x1;
        xb4 = xb3+x1;
        xb5 = xb4+x1;
        xb6 = xb5+x1+10;
      // System.out.println(".."+x_mouse+"..."+y_mouse);	
       
        if(xb3 <= x_Ball && x_Ball <= xb4 && y_Ball > yb1-40) {
      	  dx=0;
      	  dy=-dy;
        }
      // 1  2        3  4         5  6 
       
      if( xb1 <= x_Ball && x_Ball <= xb2 && y_Ball > yb1-35) { //margin left
    	  if(dx==0) dx = -dx_copy;
 	      else   dx=(dx>0)?dx_copy:-dx_copy; 
    	  
    	  if(dx>0)
			  dx =(dx>0)?dx:-dx;
		     else
		      dx =(dx>0)?-dx:dx;
		     
		     if(dy>0)
			  dy =(dy>0)?-dy:dy;  
		     else
		    	 dy =(dy>0)?dy:-dy; ;  
      }
      
      if( xb2 < x_Ball && x_Ball < xb3 && y_Ball > yb1-35) { // margin second left
    	  if(dx==0) dx = -dx_copy;
    	     dx= dx/3;
    	   
    	     if(dx>0)
   			  dx =(dx>0)?dx:-dx;
   		     else
   		      dx =(dx>0)?-dx:dx;
   		     
   		     if(dy>0)
   			  dy =(dy>0)?-dy:dy;  
   		     else
   		    	 dy =(dy>0)?dy:-dy; 
            	   
      }
      
      if( xb4 < x_Ball && x_Ball < xb5 && y_Ball > yb1-35) { // margin second rihht
    	   if(dx==0) dx = dx_copy;
    	   dx = dx/3;
    	   
    	   if(dx>0)
 			  dx =(dx>0)?dx:-dx;
 		     else
 		      dx =(dx>0)?-dx:dx;
 		     
 		     if(dy>0)
 			  dy =(dy>0)?-dy:dy;  
 		     else
 		    	 dy =(dy>0)?dy:-dy; 
		  
      }
         
      if( xb5 <= x_Ball && x_Ball <= xb6 && y_Ball > yb1-35) { // margin right
    	     if(dx==0) dx = dx_copy;
    	     else   dx=(dx>0)?dx_copy:-dx_copy; 
    	     
    	     if(dx>0)
			  dx =(dx>0)?dx:-dx;
		     else
		      dx =(dx>0)?-dx:dx;
		     
		     if(dy>0)
			  dy =(dy>0)?-dy:dy;  
		     else
		    	 dy =(dy>0)?dy:-dy;  
      }   
     
       if(x_Ball < 10*dimension_Ball)   dx =(dx>0)?dx:-dx;
       if(x_Ball >= max_x-20)   dx =(dx>0)?-dx:dx;
          
       if(y_Ball < 10*dimension_Ball)   dy =(dy>0)?dy:-dy;
       if(y_Ball >= max_y-20)  dy =(dy>0)?-dy:dy;
          
          
       Ball.set_ball(x_Ball+dx, y_Ball+dy, dimension_Ball);
       
       
      
       x_Ball = Ball.ball_x();
   	
   	   y_Ball = Ball.ball_y();
        
       
        
    }
    
    private void new_direction(int l1, int l2, int h1, int h2) {
    	 int nr=dx;
    	 if(nr<0) nr=-nr;
    	 if(nr <dx_copy) {}
    	 else  dx=(dx>0)?dx_copy:-dx_copy; 
    		
    	 
	     if(dx>0)
		  dx =(dx>0)?dx:-dx;
	     else
	      dx =(dx>0)?-dx:dx;
	     
	     if(dy>0)
		  dy =(dy>0)?-dy:dy;  
	     else
	    	 dy =(dy>0)?dy:-dy;  
             
             
          Ball.set_ball(x_Ball+dx, y_Ball+dy, dimension_Ball);
          
          
         
          x_Ball = Ball.ball_x();
      	
      	  y_Ball = Ball.ball_y();
    }
    
    
    private void kill_shape_squard() {
    	// x, y, point
    	
    	int i,h1,h2,l1,l2;
    	for(i=0;i<x.length;i++) {
    		l1= 50*x[i]-40;
    		l2= 50*x[i]+40;
    		
    		h1= 50*y[i]-40;
    		h2= 50*y[i]+40;
    		if(point[i]>0) 
    		if( l1 <= x_Ball && x_Ball <= l2 && h1 <= y_Ball && y_Ball <= h2 ) {
    			
    			point[i]--;
    			
    			new_direction(l1,l2,h1,h2);
    			break;
    		}
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {  // actiuni ce au loc in joc

        if (inGame) {
        	if(!Escape)
               move();  
        	kill_shape_squard();
        	
            
           
        }
        
        if(Enter == true) {
        	 
        	Enter=false;
        	leftDirection = false;
        	rightDirection = false;
        	upDirection = false;
        	timer.restart();
        	
        }
       
        repaint();
    }


    private class TAdapter extends KeyAdapter {  // valori de la tastatura

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!leftDirection)  ) {
                leftDirection = true;
            }
           

            if ((key == KeyEvent.VK_RIGHT) && (!rightDirection) ) {
                rightDirection = true;
            }
            if ((key == KeyEvent.VK_DOWN) && (!downDirection) ) {
                downDirection = true;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection) && (!upDirection) ) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            
            if ((key == KeyEvent.VK_ENTER) && !Enter) {
                 Enter=true;
                 Escape=false;
            }
            if (key == KeyEvent.VK_ESCAPE ) {
                Escape=true;
                Enter=false;
           }
            if (key == KeyEvent.VK_X && !Exit) {
               Exit=true;
           }
            
            
            
        }
    }
}
