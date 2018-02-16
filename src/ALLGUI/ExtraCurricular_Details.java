package ALLGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ExtraCurricular_Details {
	int student_ID = UserLoginGUI.student_ID;

	private JFrame frmExtracurricularDetails;
	private JTextField textField;
	private JTextField Achievement;
	private JTextField Description;
	private JTextField Date;

	/**
	 * Launch the application.
	 */
	public void ExtraData() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtraCurricular_Details window = new ExtraCurricular_Details();
					window.frmExtracurricularDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExtraCurricular_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExtracurricularDetails = new JFrame();
		frmExtracurricularDetails.setTitle("ExtraCurricular Details");
		frmExtracurricularDetails.setBounds(100, 100, 380, 387);
		frmExtracurricularDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExtracurricularDetails.getContentPane().setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(10, 30, 124, 40);
		frmExtracurricularDetails.getContentPane().add(lblStudentId);
		
		JLabel lblAchievement = new JLabel("Achievement");
		lblAchievement.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAchievement.setBounds(10, 81, 124, 40);
		frmExtracurricularDetails.getContentPane().add(lblAchievement);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 132, 124, 40);
		frmExtracurricularDetails.getContentPane().add(lblDescription);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(10, 183, 124, 40);
		frmExtracurricularDetails.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setText(String.valueOf(student_ID));
		textField.setEditable(false);
		textField.setBounds(144, 30, 167, 32);
		frmExtracurricularDetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		Achievement = new JTextField();
		Achievement.setColumns(10);
		Achievement.setBounds(144, 81, 167, 32);
		frmExtracurricularDetails.getContentPane().add(Achievement);
		
		Description = new JTextField();
		Description.setColumns(10);
		Description.setBounds(144, 138, 167, 32);
		frmExtracurricularDetails.getContentPane().add(Description);
		
		Date = new JTextField();
		Date.setText("YYYY/MM/DD");
		Date.setColumns(10);
		Date.setBounds(144, 195, 167, 32);
		frmExtracurricularDetails.getContentPane().add(Date);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EAchievement = Achievement.getText();
				String EDescription = Description.getText();
				String EDate = Date.getText();
				
				ExtraCurricular Ec = new ExtraCurricular();
				Ec.setAchievement(EAchievement);
				Ec.setDescription(EDescription);
				java.util.Date ud = new java.util.Date(EDate);
				java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
				String date=sdf.format(ud);
				Ec.setDate(date);
				Ec.setStudentId(student_ID);
				
				
				
				
				
				try {
					ExtraCurricularDao Ecd = new ExtraCurricularDao();
					Ecd.update(Ec);
					JOptionPane.showMessageDialog(null, "Saved..!!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 257, 124, 46);
		frmExtracurricularDetails.getContentPane().add(btnNewButton);
	}

}
