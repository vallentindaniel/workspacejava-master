package z_direction;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private final int B_WIDTH = 900;
    private final int B_HEIGHT = 900;
    
    private final int DELAY = 2;
    
    private int R; // radius circle
    
    private int x; // coordonate for ball
    private int y; // coordonate for ball
    
    private int xa;  // x adaos
    private int ya; 
    private int xa_c;
    
    private int x_shape;
    
    
    private int[] xs;
    private int[] ys;
    private int[] colors;
    private int[] point_shape;
    
    
    private boolean startGame;
    private boolean gameOver;
    
    
    
   
    
   
   
    
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

        addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        initGame();
    }
   
    private Color detectColor(int nr) {
    	if(nr==1) return Color.blue;
     	if(nr==2) return Color.GRAY;
     	if(nr==3) return Color.YELLOW;
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
   

    private void initGame() {   // initializare joc
    	startGame=false;
    	gameOver=false;
    	x=400;
    	y=525;
    	xa=-1;
    	xa_c=-1;
    	ya=1;
    	R=10; // radius circle
    	
    	
    	// for shape
    	x_shape=0;
    	
    	    xs= new int[]      {1,2,3,4,5,6,7,8,2, 3, 4, 5, 6, 7, 3, 4, 5, 6, 4, 5 };
    	    ys= new int[]      {1,1,1,1,1,1,1,1,2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4 };
    	point_shape= new int[] {10,10,10,10,10,10,10,20,20, 10, 10, 10, 10, 20, 20, 10, 10, 20, 10, 10 };
    	    colors = new int[] {1,2,9,4,5,6,7,8,9,10,11,12,13, 8, 7, 6, 5, 4, 3, 2 };    	
    	
    	
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
  

    @Override
    public void paintComponent(Graphics g) { // desenare componenta
        super.paintComponent(g);

        doDrawing(g);
    }
    
    
    private void doDrawing(Graphics g) {      // desenare joc
        
        if (inGame) { // here i draw shape
        	
        	Graphics2D g2d = (Graphics2D) g;
            int i;
            
          
            
            
            
          
            	g2d.setColor(Color.YELLOW);
        		g2d.fillRect(10+5*(6+x_shape),10+50*15, 220, 20);
        		
           
            
           g2d.setColor(Color.RED); 
           g2d.fillOval(x, y, 2*R, 2*R); // ball
           
           for(i=0;i<xs.length;i++) {
        	   if( point_shape[i] >0 ) {
        		   g2d.setColor(detectColor(colors[i]) );
              		g2d.fillRect(10+50*xs[i],10+50*ys[i], 50, 50);
        	   }
           }
            
            int k=0;
            g2d.setColor(new Color(0,0,0));
            for(i=1;i<=17;i++) {
            	if( i==1 || i==15) {
            	 g2d.drawLine(10+k, 10, 10+k, 810); // colum
            	}
            	if( i==1 || i==17) {
            	 g2d.drawLine(10, 10+k, 710, 10+k); // line
            	}
            	k+=50;
            }
            
            
            
            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) { // joc pierdut
        
        String msg = "Game Over";
        String msg2 ="Your score is : ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(msg2, (B_WIDTH - metr.stringWidth(msg2)) / 2, B_HEIGHT / 2+50);
    }

    
   private void calculate_position() {
	   int i;
	   int nr1 = 5*(6+x_shape);
	   int nr2 = 220+5*(6+x_shape);
	   
	   
	   int nr3 =10+50*15-35; // 760
	   int nr4 = (x-10)/50;
	   int nr5 = (y-10)/50;
	   
	   
	   
	   if(y<510) {
		   //System.out.println(y+"...");
		   for(i=0;i<xs.length;i++) {
			  
			   
			   if( point_shape[i]>0 ) {
				   
				   System.out.println(xs[i]+"..."+nr4);
				   if(xs[i] == nr4 && ys[i]==nr5) {
					  
					        if(xa>0)
							  xa =(xa>0)?xa:-xa;
						     else
						    	 xa =(xa>0)?-xa:xa;
						     
						     if(ya>0)
							  ya =(ya>0)?-ya:ya;  
						     else
						    	 ya =(ya>0)?ya:-ya;
				   }
				        
						  
			   }
		   }
		   
	   }

	  if(y>=nr3 && nr1<=x && x<=nr2) {
		  // System.out.println(y+"... da");
		   
			  
		     if(xa>0)
			  xa =(xa>0)?xa:-xa;
		     else
		    	 xa =(xa>0)?-xa:xa;
		     
		     if(ya>0)
			  ya =(ya>0)?-ya:ya;  
		     else
		    	 ya =(ya>0)?ya:-ya;   
		  
	  }
	  else if(y >nr3+30) gameOver=true;
	  else {
		  xa= xa_c;
		  
		   if(x-25<=R) { 
			   xa =(xa>0)?xa:-xa;
			   xa_c =(xa_c>0)?xa_c:-xa_c;
		   
		   }
		   if(x>=700-R) {
			   xa =(xa>0)?-xa:xa;
			   xa_c =(xa_c>0)?-xa_c:xa_c;
			   
		   }
		   
		   if(y-25<=R)  ya =(ya>0)?ya:-ya;
		   if(y>=800-R)  ya =(ya>0)?-ya:ya;   
	  }
	  
	  
	  
	 
	  //System.out.println(nr1+"..."+x+"..."+nr2);
	   
	   x+=xa;
	   y+=ya;
   }
   
    private void eliminate_shape() { 
    	int i,a,b;
    	for(i=0;i<xs.length;i++) {
    		a=10+50*xs[i];  // coordonate for xs
    		b=10+50*ys[i];  // coordonate for ys
    		//System.out.println(b+"..."+y);
    		if( (a > x-60 && a < x) && (b > y-60 && b< y) ) {
    			point_shape[i]--;
    		}
    			
    	}
    	
    }
    
   

    
    private void move() {  // is used for set action  in game
    	
    	int nr1 = 5*(6+x_shape);
 	    int nr2 = 220+5*(6+x_shape);
    		
    		if (upDirection) { // for rotate object
    			if(startGame) startGame=false;
    			else  startGame=true;
    			upDirection=false;
        	}
    		
    		
    		if(leftDirection) { // move object to the left
        		leftDirection=false;
        		rightDirection=false;
        		if(nr1>=25)
        		x_shape-=5;
        		
        	}
        	
        	if(rightDirection) { // move object to the right
        		leftDirection=false;
        		rightDirection=false;
        		if(nr2<690)
        		x_shape+=5;	
        	}
        	
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {  // actiuni ce au loc in joc

        if (inGame) {
        	
        	if(startGame && !gameOver)
        	  calculate_position(); 
            move();           // is used for to move Shape in different position
            eliminate_shape();
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
            
            if ((key == KeyEvent.VK_ENTER) && inGame == false ) {
                 Enter=true;
                 Escape=false;
            }
            if (key == KeyEvent.VK_ESCAPE ) {
                Escape=true;
                Enter=false;
           }
            
            
            
        }
    }
}


