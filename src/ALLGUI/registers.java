package ALLGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import ALLGUI.UserLogin;
import ALLGUI.UserDAO;
import ALLGUI.UDao;

public class registers {
	

	private JFrame frame;
	private JTextField Username;
	private JPasswordField passwordField;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public void register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registers window = new registers();
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
	public registers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Choice Role = new Choice();
		Role.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				String text=Role.getSelectedItem();
				
				if(text=="student")
				{
					JOptionPane.showMessageDialog(null, "THIS IS STUDENT");
				}
			}
		});
		Role.add("administator");
		Role.add("Student");
		Role.setBounds(180, 160, 184, 34);
		frame.getContentPane().add(Role);
		
		JLabel lblNewLabel = new JLabel("Role      :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 150, 141, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 28, 200, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		Username = new JTextField();
		Username.setBounds(180, 45, 176, 33);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 84, 200, 50);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = Username.getText();
				String psd = Password.getText();
				String role = Role.getSelectedItem();
				
				try( UserDAO dao = new UserDAO())
				{

					Login login = new Login();
					login.setUsername(uname);
					login.setPassword(psd);
					login.setRole(role);
					
					dao.RegisterUser(login);
					
				}
				catch(Exception E){
					System.out.println(E.getStackTrace());
				}
				
				
				if(role == "Student"){
					JOptionPane.showMessageDialog(null, "This is Student..!!");
					
				}
				else{
					JOptionPane.showMessageDialog(null, "This is Admin..!!");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(145, 201, 117, 49);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(268, 143, -17, 20);
		frame.getContentPane().add(passwordField);
		
		Password = new JPasswordField();
		Password.setBounds(178, 101, 176, 33);
		frame.getContentPane().add(Password);
	}
}
