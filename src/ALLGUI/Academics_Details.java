package ALLGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import ALLGUI.UserLoginGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;
public class Academics_Details {
	

	int student_ID = UserLoginGUI.student_ID;
	private JFrame frame;
	private JTextField StudentID;
	private JTextField Institute;
	private JTextField University;
	private JTextField YearOfPassing;
	private JTextField Score;

	/**
	 * Launch the application.
	 */
	public void Academics() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Academics_Details window = new Academics_Details();
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
	public Academics_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 47, 108, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblExam = new JLabel("Exam");
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExam.setBounds(10, 90, 108, 38);
		frame.getContentPane().add(lblExam);
		
		JLabel lblInstitute = new JLabel("Institute");
		lblInstitute.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstitute.setBounds(10, 139, 108, 38);
		frame.getContentPane().add(lblInstitute);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUniversity.setBounds(10, 188, 108, 38);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblYearOfPassing = new JLabel("Year Of Passing");
		lblYearOfPassing.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYearOfPassing.setBounds(10, 237, 108, 38);
		frame.getContentPane().add(lblYearOfPassing);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(10, 286, 108, 38);
		frame.getContentPane().add(lblScore);
		
		
		StudentID = new JTextField();
		StudentID.setText(String.valueOf(student_ID));
		StudentID.setEditable(false);
		StudentID.setBounds(140, 47, 187, 31);
		frame.getContentPane().add(StudentID);
		StudentID.setColumns(10);
		
		Institute = new JTextField();
		Institute.setColumns(10);
		Institute.setBounds(140, 145, 187, 31);
		frame.getContentPane().add(Institute);
		
		University = new JTextField();
		University.setColumns(10);
		University.setBounds(140, 199, 187, 31);
		frame.getContentPane().add(University);
		
		YearOfPassing = new JTextField();
		YearOfPassing.setColumns(10);
		YearOfPassing.setBounds(140, 248, 187, 31);
		frame.getContentPane().add(YearOfPassing);
		
		Score = new JTextField();
		Score.setColumns(10);
		Score.setBounds(140, 297, 187, 31);
		frame.getContentPane().add(Score);
		
			
		Choice Exam = new Choice();
		Exam.addItem("SSC");
		Exam.addItem("HSC");
		Exam.addItem("Diploma");
		Exam.addItem("SEM1");
		Exam.addItem("SEM2");
		Exam.addItem("SEM3");
		Exam.addItem("SEM4");
		Exam.addItem("SEM5");
		Exam.addItem("SEM6");
		Exam.addItem("SEM7");
		Exam.addItem("SEM8");
		Exam.setBounds(140, 90, 187, 20);
		frame.getContentPane().add(Exam);
		frame.setBounds(100, 100, 390, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String institute = Institute.getText();
				String university = University.getText();
				String Yob = YearOfPassing.getText();
				String score = Score.getText();
				String sid = StudentID.getText();
				String exam = Exam.getSelectedItem();
				
				try {
					AcademicsDao ad = new AcademicsDao();
					Academics ac = new Academics();
					ac.setStudentId(student_ID);
					ac.setUniversity(university);
					ac.setInstitute(institute);
					ac.setScore(score);
					ac.setYearOfPassing(Yob);
					ac.setExam(exam);
					ac.setID(ad.getUser(student_ID));
					
					
					ad.update(ac);
					
					JOptionPane.showMessageDialog(null, "Saved..!!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 348, 128, 49);
		frame.getContentPane().add(btnNewButton);
	
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
