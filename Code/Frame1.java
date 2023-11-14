import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class Frame1 {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/microproject";
	static final String USER = "root";
	static final String PASS = "";
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(44, 62, 80));
		frame.setBounds(100, 100, 562, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frame2 f2 = new Frame2();
				f2.create();
			}
		});
		btnNewButton.setBounds(185, 129, 170, 68);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Existing User");
		btnNewButton_1.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton_1.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton_1.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frame3 f3 = new Frame3();
				f3.login();
				
			}
		});
		btnNewButton_1.setBounds(185, 239, 170, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton_2.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton_2.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 frame.dispose();
			}
		});
		btnNewButton_2.setBounds(185, 351, 170, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("   Welcome to IDFC");
		lblNewLabel.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(185, 50, 170, 55);
		frame.getContentPane().add(lblNewLabel);
	}
}
