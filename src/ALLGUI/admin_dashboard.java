package ALLGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void Adminmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_dashboard frame = new admin_dashboard();
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
	public admin_dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnManage = new JMenu("Manage");
		menuBar.add(mnManage);
		
		JMenu mnPersonalInformation = new JMenu("Personal Information");
		mnManage.add(mnPersonalInformation);
		
		JMenuItem mntmEnrollUser = new JMenuItem("Enroll User");
		mnPersonalInformation.add(mntmEnrollUser);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnPersonalInformation.add(mntmChangePassword);
		
		JMenu mnStudent = new JMenu("Student");
		mnManage.add(mnStudent);
		
		JMenuItem mntmEnrollUser_1 = new JMenuItem("Enroll User");
		mnStudent.add(mntmEnrollUser_1);
		
		JMenuItem mntmAddeditdeleteSubject = new JMenuItem("Add/Edit/Delete Subject");
		mnStudent.add(mntmAddeditdeleteSubject);
		
		JMenuItem mntmUploadMarks = new JMenuItem("Upload Marks");
		mntmUploadMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFile uf  =new UploadFile();
				uf.main();
			}
		});
		mnStudent.add(mntmUploadMarks);
		
		JMenuItem mntmViewResumeIn = new JMenuItem("view Resume in PDF format");
		mnStudent.add(mntmViewResumeIn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
