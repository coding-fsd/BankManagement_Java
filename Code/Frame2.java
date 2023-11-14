import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.Color;


public class Frame2 {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/microproject";
	static final String USER = "root";
	static final String PASS = "";
	
	Connection con = null;
	PreparedStatement stmt = null;
	
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField name;
	private JTextField age;
	private JTextField mobile;
	private JTextField address;
	private JTextField username;
	private JTextField password;
	private JTextField cpassword;

	/**
	 * Launch the application.
	 */
	public static void create() {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(44, 62, 80));
		frame.setBounds(100, 100, 474, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel.setBounds(31, 38, 88, 42);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Age:");
		lblNewLabel_1.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_1.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_1.setBounds(31, 125, 88, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Enter Mobile:");
		lblNewLabel_2.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_2.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_2.setBounds(31, 211, 99, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Enter Address:");
		lblNewLabel_3.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_3.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_3.setBounds(31, 296, 107, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Enter Username:");
		lblNewLabel_4.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_4.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_4.setBounds(31, 381, 136, 42);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Enter Password:");
		lblNewLabel_5.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_5.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_5.setBounds(31, 470, 113, 42);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL,USER,PASS);
					if(name.getText().equals("") || age.getText().equals("") || address.getText().equals("") || mobile.getText().equals("") || username.getText().equals("") || password.getText().equals(""))
					{
						 JOptionPane.showMessageDialog(null, "Please fill in all the details");
					}
					else 
					{
						String pass = password.getText();
						String cpass = cpassword.getText();
						int age1 = Integer.parseInt(age.getText());
						if(age1<18)
						{
							JOptionPane.showMessageDialog(null, "Age cannot be less than 18");
						}
						else if(mobile.getText().length()<10 || mobile.getText().length()>10)
						{
							JOptionPane.showMessageDialog(null, "Invalid mobile number");
						}
						else
						{
							if(pass.equals(cpass))
							{
								 stmt = con.prepareStatement("insert into bank (Name,Age,Address,Mobile,Username,Password,CPassword) values(?,?,?,?,?,?,?)");
								 stmt.setNString (1, name.getText());
								 stmt.setString (2, age.getText());
								 stmt.setString   (3, address.getText());
								 stmt.setString (4, mobile.getText());
								 stmt.setString (5, username.getText());	
								 stmt.setString (6, password.getText());
								 stmt.setString (7, cpassword.getText());
								 stmt.execute();
								 JOptionPane.showMessageDialog(null, "Account Created");
								 stmt.close();
								 frame.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Passwords do not match");
							}
					        	
				
						}
						
					}
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 15));
		btnNewButton.setBounds(105, 608, 124, 42);
		frame.getContentPane().add(btnNewButton);
		
		name = new JTextField();
		name.setFont(new java.awt.Font("Tahoma", 0, 15));
		name.setForeground(new java.awt.Color(228, 241, 254));
		name.setBackground(new java.awt.Color(108, 122, 137));
		name.setBounds(175, 38, 124, 42);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new java.awt.Font("Tahoma", 0, 15));
		age.setForeground(new java.awt.Color(228, 241, 254));
		age.setBackground(new java.awt.Color(108, 122, 137));
		age.setBounds(175, 125, 124, 42);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		mobile = new JTextField();
		mobile.setFont(new java.awt.Font("Tahoma", 0, 15));
		mobile.setForeground(new java.awt.Color(228, 241, 254));
		mobile.setBackground(new java.awt.Color(108, 122, 137));
		mobile.setBounds(175, 211, 124, 42);
		frame.getContentPane().add(mobile);
		mobile.setColumns(10);
		
		address = new JTextField();
		address.setFont(new java.awt.Font("Tahoma", 0, 15));
		address.setForeground(new java.awt.Color(228, 241, 254));
		address.setBackground(new java.awt.Color(108, 122, 137));
		address.setBounds(175, 296, 124, 42);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		username = new JTextField();
		username.setFont(new java.awt.Font("Tahoma", 0, 15));
		username.setForeground(new java.awt.Color(228, 241, 254));
		username.setBackground(new java.awt.Color(108, 122, 137));
		username.setBounds(175, 381, 124, 42);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new java.awt.Font("Tahoma", 0, 15));
		password.setForeground(new java.awt.Color(228, 241, 254));
		password.setBackground(new java.awt.Color(108, 122, 137));
		password.setBounds(175, 470, 124, 42);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password:");
		lblNewLabel_6.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_6.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_6.setBounds(31, 544, 135, 42);
		frame.getContentPane().add(lblNewLabel_6);
		
		cpassword = new JPasswordField();
		cpassword.setFont(new java.awt.Font("Tahoma", 0, 15));
		cpassword.setForeground(new java.awt.Color(228, 241, 254));
		cpassword.setBackground(new java.awt.Color(108, 122, 137));
		cpassword.setBounds(175, 544, 124, 42);
		frame.getContentPane().add(cpassword);
		cpassword.setColumns(10);
	}
}
