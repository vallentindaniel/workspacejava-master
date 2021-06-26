package keyboard;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class keyboard {

	public static void main(String[] args) {
		JTextField textField = new JTextField();
		 
		  textField.addKeyListener(new MKeyListener());
		  MKeyListener k = new MKeyListener();
		 
		  
		 
		  JFrame jframe = new JFrame();
		  jframe.setTitle("Project");
		  jframe.add(textField);
		 
		  jframe.setSize(400, 350);
		 
		  jframe.setVisible(true);
	}

}
