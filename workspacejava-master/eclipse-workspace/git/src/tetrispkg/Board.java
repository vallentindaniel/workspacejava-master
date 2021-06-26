package tetrispkg;


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
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int B_WIDTH = 900;
    private final int B_HEIGHT = 900;
    
    private final int DELAY = 140;
    
    private final int ALL_DOTS=125;
    
    private   int x[] = new int[ALL_DOTS];  // are used for to set coordonate for Shape
    private   int y[] = new int[ALL_DOTS];  // and here
    
    public int[][][] xS = new int[8][5][5];
	public int[][][] yS = new int[8][5][5];
    
    private int[] Xd ;   // is used for set coordonate for all shape who are down
    private int[] Yd ;
    private int[] listColor;
    private int color;
    
    private  int xy[] = new int[ALL_DOTS]; // is used for set to null shape, when gameover;
    
    private int yP; // y position
    private int xP;
    private int xP_C;
    private int min; // is used for calculate distance  up to bottom of page
    private int nr_shape;
    
   
   
    private int number;
    
   
   
    
    private boolean Enter = false;
    private boolean Escape = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    
    
    
    
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
   

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() { // initializare pagina

        addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        initGame();
    }
    private void initShape() {
    	 xS[1][1]= new int[] {0,0,0,0};         // orizintal
    	 yS[1][1]= new int[] {4,5,6,7};
    	
    	 xS[1][2]= new int[] {0, 1, 2, 3};         // vertical
    	 yS[1][2]= new int[] {4, 4, 4, 4};
    	 
    	 xS[2][1]= new int[] {0,0,0,1};         //  ##  
    	 yS[2][1]= new int[] {4,5,6,4};         //  #
    	 
    	 xS[2][2]= new int[] {0,1,2,0};         //   ## 
    	 yS[2][2]= new int[] {4,4,4,3};         //    #
    	 
    	 xS[2][3]= new int[] {1,1,1,0};         //  #
    	 yS[2][3]= new int[] {4,5,6,6};         // ##
    	 
    	 xS[2][4]= new int[] {0,1,2,2};         // #
    	 yS[2][4]= new int[] {4,4,4,5};         // ##
    	 
    	 xS[3][1]= new int[] {0,1,2,0};         // linie
    	 yS[3][1]= new int[] {4,4,4,3};
    }

   

    private void initGame() {   // initializare joc
    	xP_C=0;
    	min=15;
    	yP=0;
        xP=0;
        initShape();
        next_shape();
               Xd = new int[] { 15,15,15,15,15,15,15,15,15,15,15,15 };
               Yd = new int[] {  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11 };
        listColor = new int[] {  13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13 };
       
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
            for(i=0;i<x.length;i++) {
            	g2d.setColor(detectColor(color));
        		g2d.fillRect(10+50*( y[i] + yP ),10+50*(x[i] +xP), 50, 50);
        		System.out.println(x[i] +xP+"..."+xP+"..."+xP_C);
            }
            
           
           
            for(i=0;i<Xd.length;i++) {      		
        		g2d.setColor(detectColor(listColor[i]));
    
        		  g2d.fillRect(10+50*Yd[i],10+50*Xd[i], 50, 50);
        		  
        		  
              }
            
            int k=0;
            g2d.setColor(new Color(0,0,0));
            for(i=1;i<=17;i++) {
            	if(i<=13) g2d.drawLine(10+k, 10, 10+k, 810); // colum
            	g2d.drawLine(10, 10+k, 610, 10+k); // line
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

    
    
    private void Shapes(int nr) {
    	
    	
    	Random rnn = new Random();
    	int nrr=rnn.nextInt(11)+1;
    	
    	if(nrr==1) color= nrr; 
     	if(nrr==2) color= nrr;
     	if(nrr==3) color= nrr;
     	if(nrr==4) color= nrr;
     	if(nrr==5) color= nrr;
     	if(nrr==6) color= nrr;
     	if(nrr==7) color= nrr;
     	if(nrr==8) color= nrr;
     	if(nrr==9) color= nrr;
     	if(nrr==10) color= nrr;
     	if(nrr==11) color= nrr;
     	if(nrr==12) color= nrr;
    	
    	
     	
    	 
    	
    	
    	
        x=xS[2][1].clone();
        y=yS[2][1].clone();
        
                           
    }
    
    
    
    
    
    private void placeShape() {  // Calculate scores and set new Shape
    	
    	
    	
    	
    }
    
    private int max(int[] ve) {
    	int i,l1= ve.length;
    	int max=0;
    	for(i=0;i<l1;i++) {
    		if(ve[i] > max) max = ve[i];
    		
    	}
    	
    	return max;
    }
    
    private void RotateShape(){
    	
    	int l1 = xS.length;
    	int l2 = yS.length;
    	int l3 = xS[2][1].length;
    	int max2,max1 =  max(x);
    	if((Arrays.equals(xS[2][nr_shape], x)  && Arrays.equals(yS[2][nr_shape], y)  ) || ( Arrays.equals(xS[2][4], x)  && Arrays.equals(yS[2][4], y) )   ) {
    		nr_shape++;
    		y= new int[l3];
    		x= new int[l3];
    		x=xS[2][nr_shape].clone();
    		y=yS[2][nr_shape].clone();
    		max2=max(x);
    		if(max2>max1) {
    			xP_C=max2-max1;
    		}
    		
    	}
    	
    	if(nr_shape == l3) nr_shape=0;
    	
    	
    	
    	
    	
    	
    }

    
    private void move() {  // is used for set action  in game
    	
    		
    		if(downDirection) {
        		
    			number++;
        		if( number%2==0)
        	    	xP++; // move shape with an case down
        	}
        	else {
        		number++;
        		if( number%5==0)
        	    	xP++; // move shape with an case down
        	}
    		
    		
    		if (upDirection) { // for rotate object
    	    	  upDirection=false;
    	    	  xP-=xP_C;
    			RotateShape();	
        	}
        	if(leftDirection) { // move object to the left
        		leftDirection= false;
        		downDirection = false;
        		if(y[0]+yP >0)
        		yP--;
        		
        	}
        	
        	if(rightDirection) { // move object to the right
        		rightDirection=false;
        		downDirection = false;
        		if(y[3]+yP <11)
        		yP++;
        		
        	}
        	
    		
    		
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
    private void next_shape() {
    	// random  shape
    	nr_shape=1;
    	Random rn = new Random();
    	int nr=rn.nextInt(5)+1;
    	Shapes(nr);	
    }
    
    private boolean Verification(int[] x1, int[] y1, int[] x2, int[] y2 ) {
    	int l2 = x2.length;      // Xd   
    	
    	
    	int i; // xP, yP
    	 int xxP,yyP;
    	 xxP = xP+1;
    	 yyP = yP;
    	for(i=0;i<l2;i++) {
    		
    		if(x1[0]+xxP == x2[i] && y1[0]+yyP == y2[i]) min=0;
    		if(x1[1]+xxP == x2[i] && y1[1]+yyP == y2[i]) min=0;
    		if(x1[2]+xxP == x2[i] && y1[2]+yyP == y2[i]) min=0;
    		if(x1[3]+xxP == x2[i] && y1[3]+yyP == y2[i]) min=0;
    		
    		
    		if(min <= 0) return true;
    	}
    	//System.out.println(min);
    	min=15;
    	if(min <= 0) return true;
    	
    	return false;
    }
    
    
    private void checkCollision() { // daca sa lovit de ceva
    		
    		if( Verification(x,y,Xd,Yd)) {
    			int i;
        	  int l1 = x.length;
        	  int l2 = Xd.length;
        	  
        	  for(i=0;i<l1;i++) {
        		  x[i]+= xP;
        		  y[i]+= yP;
        	  }
        	  
        	  
    			int[] result1 = new int[l1+l2];
    			int[] result2 = new int[l1+l2];
    			int[] colorCopy = new int[l1+l2];
    			
    			System.arraycopy(Xd, 0, result1, 0, l2);
    	        System.arraycopy(x, 0, result1, l2, l1);
    	        
    	        System.arraycopy(Yd, 0, result2, 0, l2);
    	        System.arraycopy(y, 0, result2, l2, l1);
    			
        		int l5 = listColor.length;
        		int l6 = colorCopy.length;
        		for(i=0;i<l6;i++) {
        			if(i<l5) {
        				colorCopy[i]=listColor[i];
        			}
        			else colorCopy[i]=color;
        		}
                
        		
        		int l3  = result1.length;
        		int l4 = result2.length;
        		
        		listColor = new int[l6];
        		Xd = new int[l3];
        		Yd = new int[l4];

        		listColor = colorCopy.clone();
        		Xd = result1.clone();
        		Yd = result2.clone();
        		
        		
        		xP=0;
        		yP=0;
        		x=new int[ALL_DOTS];
        		y=new int[ALL_DOTS];
        		min = 15;
        		downDirection = false;
        		upDirection = false;
        		rightDirection = false;
        		leftDirection = false;
        		next_shape();	
    		}
    		
    		
    		
    		
    		
    		
    	
    	
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {  // actiuni ce au loc in joc

        if (inGame) {
        	checkCollision(); // is used for to limit the work area 
            placeShape();     // is used for to set location of Shape
            move();           // is used for to move Shape in different position
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