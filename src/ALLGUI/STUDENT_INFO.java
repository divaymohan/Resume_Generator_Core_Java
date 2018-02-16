package ALLGUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import ALLGUI.Student_Dao;
import ALLGUI.UDao;
import ALLGUI.StudentInfo;
import ALLGUI.UserLoginGUI;
import ALLGUI.Student_Dao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class STUDENT_INFO {

	private JFrame frmStudentInfo;
	private JTextField textField;
	private JTextField Fname;
	private JTextField Mname;
	private JTextField Lname;
	private JTextField Birthdate;
	private JTextField txtAbc;
	private JTextField Mobile;
	private JTextField Hobby;
	private JTextField Company;
	private JTextField Placedate;

	/**
	 * Launch the application.
	 */
	public void studentdata() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUDENT_INFO window = new STUDENT_INFO();
					window.frmStudentInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param s 
	 */
	public STUDENT_INFO() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentInfo = new JFrame();
		frmStudentInfo.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frmStudentInfo.setTitle("Student Info");
		frmStudentInfo.setBounds(200, 200, 381, 481);
		frmStudentInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInfo.getContentPane().setLayout(null);
		
		JLabel lblStusentId = new JLabel("Stusent ID ");
		lblStusentId.setBounds(10, 21, 97, 25);
		lblStusentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblStusentId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 57, 97, 25);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(10, 93, 97, 25);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 129, 82, 25);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblLastName);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 165, 82, 25);
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblBirthDate);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 201, 82, 25);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmStudentInfo.getContentPane().add(lblEmail);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobile.setBounds(10, 237, 82, 25);
		frmStudentInfo.getContentPane().add(lblMobile);
		
		JLabel lblHobby = new JLabel("Hobby");
		lblHobby.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHobby.setBounds(10, 273, 82, 25);
		frmStudentInfo.getContentPane().add(lblHobby);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompany.setBounds(10, 309, 82, 25);
		frmStudentInfo.getContentPane().add(lblCompany);
		
		JLabel lblPlaceDate = new JLabel("Place Date");
		lblPlaceDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlaceDate.setBounds(10, 345, 82, 25);
		frmStudentInfo.getContentPane().add(lblPlaceDate);
		
		String a = String.valueOf(UserLoginGUI.student_ID);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(a);
		textField.setBounds(128, 21, 204, 25);
		frmStudentInfo.getContentPane().add(textField);
		textField.setColumns(10);
		
		Fname = new JTextField();
		Fname.setColumns(10);
		Fname.setBounds(128, 61, 204, 25);
		frmStudentInfo.getContentPane().add(Fname);
		
		Mname = new JTextField();
		Mname.setColumns(10);
		Mname.setBounds(128, 97, 204, 25);
		frmStudentInfo.getContentPane().add(Mname);
		
		Lname = new JTextField();
		Lname.setColumns(10);
		Lname.setBounds(128, 133, 204, 25);
		frmStudentInfo.getContentPane().add(Lname);
		
		Birthdate = new JTextField();
		Birthdate.setText("YYYY-MM-DD");
		Birthdate.setColumns(10);
		Birthdate.setBounds(128, 169, 204, 25);
		frmStudentInfo.getContentPane().add(Birthdate);
		try {
			Student_Dao sd = new Student_Dao();
			
			txtAbc = new JTextField();
			txtAbc.setText(sd.getUserEmail(UserLoginGUI.student_ID));
			txtAbc.setEditable(false);
			txtAbc.setColumns(10);
			txtAbc.setBounds(128, 203, 204, 25);
			frmStudentInfo.getContentPane().add(txtAbc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setBounds(128, 241, 204, 25);
		frmStudentInfo.getContentPane().add(Mobile);
		
		Hobby = new JTextField();
		Hobby.setColumns(10);
		Hobby.setBounds(128, 277, 204, 25);
		frmStudentInfo.getContentPane().add(Hobby);
		
		Company = new JTextField();
		Company.setColumns(10);
		Company.setBounds(128, 313, 204, 25);
		frmStudentInfo.getContentPane().add(Company);
		
		Placedate = new JTextField();
		Placedate.setText("YYYY-MM-DD");
		Placedate.setColumns(10);
		Placedate.setBounds(128, 357, 204, 25);
		frmStudentInfo.getContentPane().add(Placedate);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FirstName = Fname.getText();
				String MiddleName = Mname.getText();
				String LastName = Lname.getText();
				String BirthDate = Birthdate.getText();
				String MobileNo = Mobile.getText();
				String Hobbies = Hobby.getText();
				String CompanyName = Company.getText();
				String PlaceDate = Placedate.getText();
				
				int sid = UserLoginGUI.student_ID;
				Student stud = new Student();
				stud.setStudentId(sid);
				
				stud.setFirstName(FirstName);
				stud.setMiddleName(MiddleName);
				stud.setLastName(LastName);
				java.util.Date ud = new java.util.Date(BirthDate);
				java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
				String date=sdf.format(ud);
				stud.setBirthDate(date);
				stud.setMobileNo(Integer.parseInt(MobileNo));
				stud.setHobby(Hobbies);
				stud.setCompany(CompanyName);
				java.util.Date ud1 = new java.util.Date(PlaceDate);
				java.text.SimpleDateFormat sdf1=new java.text.SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
				String date1=sdf.format(ud1);
				stud.setPlaceDate(date1);
				
				JOptionPane.showMessageDialog(null, "Saved.. !!");
				
				
				
				try {
					Student_Dao sd = new Student_Dao();
					stud.setEmailId(sd.getUserEmail(sid));
					sd.update(stud);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(10, 393, 125, 35);
		frmStudentInfo.getContentPane().add(btnNewButton);
	}
}
