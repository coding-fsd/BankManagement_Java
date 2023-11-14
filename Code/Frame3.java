import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frame3 {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/microproject";
	static final String USER = "root";
	static final String PASS = "";
	
	Connection con = null;
	PreparedStatement stmt = null;

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
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
	public Frame3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(44, 62, 80));
		frame.setBounds(100, 100, 450, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel.setBounds(50, 67, 111, 42);
		frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new java.awt.Font("Tahoma", 0, 15));
		username.setBounds(160, 67, 136, 42);
		username.setBackground(new java.awt.Color(108, 122, 137));
		username.setForeground(new java.awt.Color(228, 241, 254));
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_1.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_1.setBounds(50, 150, 111, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setFont(new java.awt.Font("Tahoma", 0, 15));
		password.setBounds(160, 150, 136, 42);
		password.setBackground(new java.awt.Color(108, 122, 137));
		password.setForeground(new java.awt.Color(228, 241, 254));
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL,USER,PASS);
					if(username.getText().equals("") || password.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please fill in all the details");
					}
					else
					{
						stmt = con.prepareStatement("Select Username, Password from bank where Username=? and Password=?");
						 stmt.setString(1, username.getText());
		                 stmt.setString(2, password.getText());
						 ResultSet rs = stmt.executeQuery();
						 if(rs.next())
						 {
								 Frame4 f4 = new Frame4(username,password);
								 f4.loggedin();
								 frame.dispose();
						 }
						 else
						 {
								 JOptionPane.showMessageDialog(null, "Username/Password incorrect");
								 frame.dispose();
								 Frame3 f3 = new Frame3();
								 f3.login();
						 }
					}
					
						 
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton.setBounds(150, 250, 150, 42);
		frame.getContentPane().add(btnNewButton);
	}

}
