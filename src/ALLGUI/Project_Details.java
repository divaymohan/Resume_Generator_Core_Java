package ALLGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Project_Details {
	int Student_ID = ALLGUI.UserLoginGUI.student_ID;
	private JFrame frmProjectDetails;
	private JTextField StudentID;
	private JTextField TeamSize;
	private JTextField Duration;
	private JTextField Technology;
	private JTextField Title;
	private JTextField Description;

	/**
	 * Launch the application.
	 */
	public void project() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project_Details window = new Project_Details();
					window.frmProjectDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectDetails = new JFrame();
		frmProjectDetails.setTitle("Project Details");
		frmProjectDetails.setBounds(100, 100, 380, 481);
		frmProjectDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectDetails.getContentPane().setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(10, 11, 110, 44);
		frmProjectDetails.getContentPane().add(lblStudentId);
		
		JLabel lblProjectType = new JLabel("Project Type");
		lblProjectType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjectType.setBounds(10, 66, 110, 44);
		frmProjectDetails.getContentPane().add(lblProjectType);
		
		JLabel lblTeamSize = new JLabel("Team Size");
		lblTeamSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeamSize.setBounds(10, 121, 110, 44);
		frmProjectDetails.getContentPane().add(lblTeamSize);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuration.setBounds(10, 176, 110, 44);
		frmProjectDetails.getContentPane().add(lblDuration);
		
		JLabel lblTechnology = new JLabel("Technology");
		lblTechnology.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTechnology.setBounds(10, 231, 110, 44);
		frmProjectDetails.getContentPane().add(lblTechnology);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(10, 286, 110, 44);
		frmProjectDetails.getContentPane().add(lblTitle);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 341, 110, 44);
		frmProjectDetails.getContentPane().add(lblDescription);
		
		
		StudentID = new JTextField();
		StudentID.setEditable(false);
		StudentID.setText(String.valueOf(Student_ID));
		StudentID.setBounds(141, 18, 169, 34);
		frmProjectDetails.getContentPane().add(StudentID);
		StudentID.setColumns(10);
		
		TeamSize = new JTextField();
		TeamSize.setColumns(10);
		TeamSize.setBounds(141, 135, 169, 34);
		frmProjectDetails.getContentPane().add(TeamSize);
		
		Duration = new JTextField();
		Duration.setColumns(10);
		Duration.setBounds(141, 190, 169, 34);
		frmProjectDetails.getContentPane().add(Duration);
		
		Technology = new JTextField();
		Technology.setColumns(10);
		Technology.setBounds(141, 245, 169, 34);
		frmProjectDetails.getContentPane().add(Technology);
		
		Title = new JTextField();
		Title.setColumns(10);
		Title.setBounds(141, 300, 169, 34);
		frmProjectDetails.getContentPane().add(Title);
		
		Description = new JTextField();
		Description.setColumns(10);
		Description.setBounds(141, 355, 169, 34);
		frmProjectDetails.getContentPane().add(Description);
		
		Choice choice = new Choice();
		choice.add("TE_Project");
		choice.add("BE_Project");
		choice.add("Extra_Project");
		choice.setBounds(141, 80, 169, 34);
		frmProjectDetails.getContentPane().add(choice);
	
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ptype  = choice.getSelectedItem();
				//System.out.println(choice.getSelectedItem());
				String teamsize = TeamSize.getText();
				String duration = Duration.getText();
				String tech = Technology.getText();
				String title = Title.getText();
				String description = Description.getText();
				
				try {
					ProjectDao pd = new ProjectDao();
					Project pr = new Project();
					pr.setStudentId(Student_ID);
					pr.setProjectType(Ptype);
					pr.setTeamSize(Integer.parseInt(teamsize));
					pr.setDuration(duration);
					pr.setDescription(description);
					pr.setID(pd.getUser(Student_ID));
					pr.setTechnology(tech);
					pr.setTitle(title);
					
					pd.update(pr);
					
					JOptionPane.showMessageDialog(null, "Saved..!!");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 387, 110, 44);
		frmProjectDetails.getContentPane().add(btnNewButton);
		
	}
}
