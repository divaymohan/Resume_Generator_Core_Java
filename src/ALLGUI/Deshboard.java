package ALLGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ALLGUI.Student_Dao;
import ALLGUI.StudentInfo;
import ALLGUI.UDao;
public class Deshboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void manu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deshboard frame = new Deshboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deshboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnManage = new JMenu("Manage");
		menuBar.add(mnManage);
		
		JMenu mnNew = new JMenu("New");
		mnManage.add(mnNew);
		
		JMenuItem mntmStudentDetails = new JMenuItem("Student Details");
		mntmStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				STUDENT_INFO si = new STUDENT_INFO();
				si.studentdata();
				
				
			}
		}
				
		
			);
		mnNew.add(mntmStudentDetails);
		
		JMenuItem mntmAddress = new JMenuItem("Address");
		mnNew.add(mntmAddress);
		
		JMenuItem mntmExtraCurricular = new JMenuItem("Extra Curricular");
		mntmExtraCurricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExtraCurricular_Details ecd = new ExtraCurricular_Details();
				ecd.ExtraData();
			}
		});
		mnNew.add(mntmExtraCurricular);
		
		JMenuItem mntmProjects = new JMenuItem("Projects");
		mntmProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project_Details pd = new Project_Details();
				pd.project();
			}
		});
		mnNew.add(mntmProjects);
		
		JMenuItem mntmAcademics = new JMenuItem("Academics");
		mntmAcademics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Academics_Details ac = new Academics_Details();
				ac.Academics();
			}
		});
		mnNew.add(mntmAcademics);
		
		JMenu mnViewReports = new JMenu("View Reports");
		menuBar.add(mnViewReports);
		
		JMenu mnSearchengine = new JMenu("SearchEngine");
		menuBar.add(mnSearchengine);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
