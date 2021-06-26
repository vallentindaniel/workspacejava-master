/**
 * 
 */
package tetrispkg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author valentin
 *
 */







public class Keyboard extends KeyAdapter {
	
	
	    private boolean Enter = false;
	    private boolean Escape = false;
	    private boolean leftDirection = false;
	    private boolean rightDirection = false;
	    private boolean upDirection = false;
	    private boolean downDirection = false;
	    private boolean inGame = true;

	
	
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






public class keyy{
	
		 public void  keys() {
			 super.Keyboard();
		 }
	
}



















