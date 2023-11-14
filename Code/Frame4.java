import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.table.*;
import java.awt.Color;

public class Frame4 {

	private JFrame frame;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JTextField deposit;
	private JLabel lblNewLabel_1;
	private JTextField withdraw;


	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/microproject";
	static final String USER = "root";
	static final String PASS = "";
	
	Connection con = null;
	PreparedStatement stmt = null;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */
	public static void loggedin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 window = new Frame4(username, password);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param password2 
	 * @param username2 
	 * @param username 
	 */


	static JTextField username = null;
	static JTextField password = null;
	
	public Frame4(JTextField username, JTextField password)
	{
		initialize();
		initComponents();
		this.username = username;
		this.password = password;
		
	}
	
	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(44, 62, 80));
		frame.setBounds(100, 100, 487, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Logged Out Successfully");
				frame.dispose();
				
			}
		});
		btnNewButton.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton.setBounds(46, 398, 144, 42);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_3 = new JButton("Balance");
		btnNewButton_3.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton_3.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt = con.prepareStatement("SELECT Balance from bank WHERE Username = ?");
					stmt.setString(1, username.getText());
					ResultSet rs = stmt.executeQuery();
					if(rs.next())
					{
						String balance = rs.getString("Balance");
						JOptionPane.showMessageDialog(btnNewButton_3, "Balance: "+balance);
						
					}	
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton_3.setBounds(46, 299, 144, 42);
		frame.getContentPane().add(btnNewButton_3);
		
		lblNewLabel = new JLabel("Enter amount that is to be deposited");
		lblNewLabel.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel.setBounds(10, 10, 250, 54);
		frame.getContentPane().add(lblNewLabel);
		
		deposit = new JTextField();
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		deposit.setBounds(46, 64, 144, 42);
		deposit.setFont(new java.awt.Font("Tahoma", 0, 15));
		deposit.setBackground(new java.awt.Color(108, 122, 137));
		deposit.setForeground(new java.awt.Color(228, 241, 254));
		frame.getContentPane().add(deposit);
		deposit.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Enter amount that is to be withdrawn");
		lblNewLabel_1.setForeground(new java.awt.Color(236, 240, 241));
		lblNewLabel_1.setFont(new java.awt.Font("Tahoma", 0, 15));
		lblNewLabel_1.setBounds(10, 146, 255, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		withdraw = new JTextField();
		withdraw.setBounds(46, 205, 144, 42);
		withdraw.setFont(new java.awt.Font("Tahoma", 0, 15));
		withdraw.setBackground(new java.awt.Color(108, 122, 137));
		withdraw.setForeground(new java.awt.Color(228, 241, 254));
		frame.getContentPane().add(withdraw);
		withdraw.setColumns(10);
		
		btnNewButton_1 = new JButton("Deposit");
		btnNewButton_1.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton_1.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL,USER,PASS);
					if(deposit.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter in the amount");
					}
					else
					{
						stmt = con.prepareStatement("SELECT Balance from bank WHERE Username = ?");
						stmt.setString(1, username.getText());
						ResultSet rs = stmt.executeQuery();
						if(rs.next())
						{
							
							String balance = rs.getString("Balance");
							String d = deposit.getText();
							String u = username.getText();
							int d1 = Integer.parseInt(d);
							int b1 = Integer.parseInt(balance);
							if(d1<0 || d1 == 0)
							 {
							    	JOptionPane.showMessageDialog(null, "Invalid input");
									frame.dispose();
									Frame4 f4 = null;
									f4.loggedin();
							}
							else
							{
								int ans = b1+d1;
								String ans1 = Integer.toString(ans);
								stmt = con.prepareStatement("update bank set Balance=? WHERE Username=? ");
								stmt.setString (1, ans1);
								stmt.setString (2, u);
								stmt.execute();
								JOptionPane.showMessageDialog(null, "Money successfully deposited");
								JOptionPane.showMessageDialog(null, "Updated Balance is: "+ans);
								frame.dispose();
								Frame4 f4 = null;
								f4.loggedin();
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
		btnNewButton_1.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton_1.setBounds(263, 64, 144, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Withdraw");
		btnNewButton_2.setForeground(new java.awt.Color(236, 240, 241));
		btnNewButton_2.setBackground(new java.awt.Color(34, 167, 240));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL,USER,PASS);
					if(withdraw.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter in the amount");
					}
					else
					{
						stmt = con.prepareStatement("SELECT Balance from bank WHERE Username = ?");
						stmt.setString(1, username.getText());
						ResultSet rs = stmt.executeQuery();
						if(rs.next())
						{
							String balance = rs.getString("Balance");
							String w = withdraw.getText();
							String u = username.getText();
							int w1 = Integer.parseInt(w);
							int b1 = Integer.parseInt(balance);
						    if(w1<0 || w1 == 0)
						    {
						    	JOptionPane.showMessageDialog(null, "Invalid input");
								frame.dispose();
								Frame4 f4 = null;
								f4.loggedin();
						    }
						    else
						    {
						    	int ans = b1-w1;
								if(ans<0)
								{
									JOptionPane.showMessageDialog(null, "Insufficient Balance");
									frame.dispose();
									Frame4 f4 = null;
									f4.loggedin();
								}
								else
								{
									String ans1 = Integer.toString(ans);
									stmt = con.prepareStatement("update bank set Balance=? WHERE Username=? ");
									stmt.setString (1, ans1);
									stmt.setString (2, u);
									stmt.execute();
									JOptionPane.showMessageDialog(null, "Money successfully withdrawn");
									JOptionPane.showMessageDialog(null, "Updated Balance is: "+ans1);
									frame.dispose();
									Frame4 f4 = null;
									f4.loggedin();
								}
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
		btnNewButton_2.setFont(new java.awt.Font("Tahoma", 1, 14));
		btnNewButton_2.setBounds(263, 205, 144, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		
	}
}
