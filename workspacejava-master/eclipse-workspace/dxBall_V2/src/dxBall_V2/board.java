package dxBall_V2;






import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
   	int d_width = gd.getDisplayMode().getWidth();
    int d_height = gd.getDisplayMode().getHeight();
    
    private final int DELAY = 25;
   
   
   
    private boolean Exit = false;
    private boolean Enter = false;
    private boolean Escape = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    
    
    private String[][] str;
    private int l1;
    private int c1;
    
    
    
    
 

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
    	
        int l,c;
        str = new String[16][10];
       
    	for(l=1;l<=15;l++) 
      	  for(c=1;c<=9;c++)
      	  {
      		  if((l == 1 || l==8 || l== 15 ) && (c == 1 || c== 9)) str[l][c] ="O";
      		  
      		  else if(l==1 || l == 15) str[l][c] = "_";
      		  else if(c== 1 || c == 9) str[l][c] = ".";
      		  else if(l== 2 && c == 2) { str[l][c] = "#";  l1=l; c1=c;             }
      		  else str[l][c]=".";		  
      	  }
    	
    	
    	
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
        	
        	
            int l,c;
                      
        	g.setColor(Color.YELLOW);
        	g.fillOval(10, 10, 30, 30);
        	
        	// 15*9=  45+90 = 135
        	
        	for(l=1;l<=15;l++) 
        	  for(c=1;c<=9;c++)
        		g.drawString(str[l][c], 10+50*c, 10+50*l);
        	
         		
         	  
            
            
          
    
            
            
            
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
    
    	// str[2][2];
    	
    	if(upDirection) {
     	   upDirection = false;
            if(1<l1-1 && l1-1 <15) {
         	   str[l1-1][c1]=str[l1][c1];
        		   str[l1][c1]="0";
        		   l1--;   
            }
     	}
    	
    	if(downDirection) {
    	   downDirection = false;
           if(1<l1+1 && l1+1 <15) {
        	   str[l1+1][c1]=str[l1][c1];
       		   str[l1][c1]="0";
       		   l1++;   
           }
    	}
    	
    	
    	
    	if(rightDirection) {
     	   rightDirection = false;
            if(c1+1>1 && c1+1 < 9) {
         	   str[l1][c1+1]=str[l1][c1];
        		   str[l1][c1]="0";
        		   c1++;   
            }
     	}
    	
    	

    	if(leftDirection) {
     	   leftDirection = false;
            if(c1-1>1 && c1-1 <9) {
         	   str[l1][c1-1]=str[l1][c1];
        		   str[l1][c1]="0";
        		   c1--;   
            }
     	}
    	
    	
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {  // actiuni ce au loc in joc

        if (inGame) {
        	if(!Escape)
               move();  
        
        	
            
           
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