package z_direction;


import java.awt.EventQueue;
import javax.swing.JFrame;

public class direction extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public direction() {
        
        initUI();
    }
	
    
    private void initUI() {
        
        add(new board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new direction();
            ex.setVisible(true);
        });
    }
}