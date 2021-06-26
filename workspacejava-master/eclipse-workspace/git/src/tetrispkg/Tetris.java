package tetrispkg;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Tetris extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tetris() {
        
        initUI();
    }
	
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Tetris();
            ex.setVisible(true);
        });
    }
}