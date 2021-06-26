package snakePakage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 
class MKeyListener extends KeyAdapter {
	public int key_nr;
 
    @Override
    public void keyPressed(KeyEvent event) {
         this.key_nr = event.getExtendedKeyCode();
         //System.out.println(event.getExtendedKeyCode());
 
    }
    public int keyValue() {
    	return this.key_nr;
    }
}


