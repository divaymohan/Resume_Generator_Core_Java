package ALLGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ALLGUI.Login;
//import ALLGUI.UserDAO;
import ALLGUI.UDao;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import ALLGUI.registers;
import ALLGUI.STUDENT_INFO;
import ALLGUI.Deshboard;
import ALLGUI.Student_Dao;
public class UserLoginGUI {
	
	
	Student stud = new Student();
	public static int student_ID;
	private JFrame frame;
	private JTextField Username;
	private JPasswordField password;
	public static int studentID ; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI window = new UserLoginGUI();
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
	public UserLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setBackground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(10, 41, 135, 50);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setBounds(10, 102, 135, 50);
		frame.getContentPane().add(lblPassword);
		
		Username = new JTextField();
		Username.setBounds(114, 41, 200, 50);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(114, 102, 200, 50);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = Username.getText();
				String psd = password.getText();
				
				
				
				//UserDAO u;
				try( UserDAO dao = new UserDAO();)
				{
					
					
					Login login = new Login();
					login.setUsername(uname);
					login.setPassword(psd);
					if(dao.getUserRole(login.getUsername())){
						admin_dashboard admin = new admin_dashboard();
						admin.Adminmain();
					}
					else{
					
				
					if(dao.loginValidateEmail(login.getUsername(),login.getPassword())){
						
						Deshboard deshboard = new Deshboard();
						deshboard.manu();
						Student_Dao sd = new Student_Dao();
						
						student_ID = Integer.parseInt(sd.getUser(login.getUsername()));
						
						
						
						
					}
					
					else{
						JOptionPane.showMessageDialog(frame, "Login UnSuccessfully..!!");

					}
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
								
				
							}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(22, 189, 181, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				registers r = new registers();
				r.register();
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(254, 189, 123, 50);
		frame.getContentPane().add(btnNewButton_1);
	}
	public int ReturnStudentID(){
		return student_ID;
	}
}
