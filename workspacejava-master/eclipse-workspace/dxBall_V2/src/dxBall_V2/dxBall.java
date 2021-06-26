package dxBall_V2;



import java.awt.EventQueue;
import javax.swing.JFrame;

public class dxBall extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public dxBall() {
        
        initUI();
    }
	
    
    private void initUI() {
        
        add(new board());
        
        setResizable(false);
        pack();
        
        setTitle("DxBall");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new dxBall();
            ex.setVisible(true);
        });
    }
}
