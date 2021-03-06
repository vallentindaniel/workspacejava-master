package driveSchool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;








import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Board extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField textField_3;
	private JTextField textField_4;
	private boolean contor1 = true;
	private boolean contor2 = true; 
	
	
	public JPanel Login()
	{
		JPanel panel = new JPanel();
		panel.setBounds(164, 102, 650, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(254, 12, 70, 15);
		panel.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(40, 73, 93, 15);
		panel.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(40, 117, 93, 15);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 71, 139, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(151, 115, 139, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.setBounds(40, 173, 117, 25);
		panel.add(btnLogin_1);
		
		JLabel lblNuAiUn = new JLabel("Nu ai un cont?");
		lblNuAiUn.setBounds(151, 242, 117, 15);
		panel.add(lblNuAiUn);
		
		
		
		
		return panel;
	}
	
	
	
	
	

	/**
	 * Create the frame.
	 */
	
	
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = Login();
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contor2) {
					lblLogin.setText("Register");
					lblNuAiUn.setText("Ai un cont?");
					btnRegister.setText("Login");
					btnLogin_1.setText("Register");
					
					contor2 = false;
				}
				else
				{
					lblLogin.setText("Login");
					lblNuAiUn.setText("Nu ai un cont?");
					btnRegister.setText("Register");
					btnLogin_1.setText("Login");
				
					contor2 = true;
				}
				
				
			}
		});
		btnRegister.setBounds(340, 237, 117, 25);
		panel.add(btnRegister);
	
		
		
		
		
		
		 panel.show(false);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				lblLogin.setText("Login");
				lblNuAiUn.setText("Nu ai un cont?");
				btnRegister.setText("Register");
				btnLogin_1.setText("Login");
				contor2 = true;
				 
				if(contor1)
				{
					contor1=false;
				panel.show(true);
				}
				else 
				{
					contor1=true;
					panel.show(false);
				}
			}
		});
		
		
		
	
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(btnLogin);
		
		setJMenuBar(menuBar);
		
	
		
		
	}
	
	
}
