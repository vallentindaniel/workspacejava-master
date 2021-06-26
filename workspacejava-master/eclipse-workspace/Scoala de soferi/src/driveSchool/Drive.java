/**
 * 
 */
package driveSchool;


import java.awt.EventQueue;


/**
 * @author valentin
 *
 */
public class Drive {

	/**
	 * @param args
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
