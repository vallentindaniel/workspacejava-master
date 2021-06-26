package snakePackage;


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
    private int Steps = 50;
    
  
    
    private final int DELAY = 340;
    
    private final int ALL_DOTS=145;
    
    
    private  int x[] = new int[ALL_DOTS];
    private  int y[] = new int[ALL_DOTS];
    private  int xy[] = new int[ALL_DOTS];
    
   private int nrl;
   private int nrc;
   
   private int x_dead;
   private int y_dead;
   
    private int x_food ;
    private int y_food ;
    private int Scores;
    
    private boolean Enter = false;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
   

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() { // initializare pagina

        addKeyListener(new TAdapter());
        setBackground(Color.darkGray);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        initGame();
    }

   

    private void initGame() {   // initializare joc
    	
    	Scores=1;
    	x[0]=0;
    	y[0]=0;
    
    	nrl=1;
    	nrc=1;
        
        next_food();
       
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
            for(i=0;i<Scores;i++) {      		
            		if(i==0) {
            			g2d.setColor(Color.RED);
        				g2d.fillRect(10+y[i], 10+x[i], 50, 50);
            			
            		}
            		else{
            			if(i%2==0)g2d.setColor(Color.YELLOW);
            			else g2d.setColor(Color.GREEN);
            			g2d.fillRect(10+y[i], 10+x[i], 50, 50);
            			
            		}
            }
            
            g2d.setColor(Color.RED);
			g2d.fillRect(10+Steps*(y_food-1), 10+Steps*(x_food-1), 50, 50);

            

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) { // joc pierdut
        
        String msg = "Game Over";
        String msg2 ="Your score is : "+Scores;
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(msg2, (B_WIDTH - metr.stringWidth(msg2)) / 2, B_HEIGHT / 2+50);
    }

    
    
    
    private void checkApple() {  // Scores and new food
         if(nrl == x_food && nrc == y_food) {
        	 Scores++;
        	 x[Scores]=x_food;
        	 y[Scores]=y_food;
             next_food();
         }      
    }

    
    private void move() {  // misca te
    	
    	for(int z=Scores; z>0;z--) {
    		x[z]=x[(z-1)];
    		y[z]=y[(z-1)];
    	}
    	
    	if (upDirection) {
    	    nrl--;
    		x[0]-=Steps;
    	}
    	if (downDirection) {
    		nrl++;
    		x[0]+=Steps;
    	}
    	if(leftDirection) {
    		nrc--;
    		y[0]-=Steps;
    	}
    	if(rightDirection) {
    		nrc++;
    		y[0] +=Steps;
    	}
    	
    	
    	
    	
    	
    	
    	
        
        
    }
    
    
    private void next_food() {
    	 Random rn = new Random();
    	 int i=0,k=0;
        while(i<=k) {
    		 x_food = rn.nextInt(11)+1;
        	 y_food = rn.nextInt(11)+1;
        	 if(x[i] == x_food || y[i] == y_food) k++;
         i++;	
        } 
        
    }

    
    private void checkCollision() { // daca sa lovit de ceva
    	int i;
    	for(i=Scores;i>0;i--) {
    		if(i > 3 && x[i] == x[0] && y[i] == y[0] ) {
    			 inGame=false;
    		}
    	}
       x_dead=35;
       y_dead=35;
       if(nrl<=0 || nrl >x_dead)  inGame=false;
      
       if(nrc<=0 || nrc >y_dead) inGame=false;  
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {  // actiuni ce au loc in joc

        if (inGame) {
        	checkCollision();
            checkApple();
            move();
        }
        if(Enter == true) {
        	inGame=true;  
        	Enter=false;
        	leftDirection = false;
        	rightDirection = true;
        	upDirection = false;
        	downDirection = false;
        	
        	Scores=1;
        	nrl=1;
        	nrc=1;
        	x=xy;
        	y=xy;
        
        	x[0]=0; y[0]=0;  
        	
        }
        repaint();
    }

    
    
    
    
    
    private class TAdapter extends KeyAdapter {  // valori de la tastatura

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection) && (!leftDirection)  ) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)   && (!rightDirection) ) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection) && (!upDirection) ) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection) && (!downDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            
            if ((key == KeyEvent.VK_ENTER) && inGame == false ) {
                 Enter=true;
            }
            
            
            
        }
    }
}








