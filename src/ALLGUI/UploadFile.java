package ALLGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import ALLGUI.ImportCSVtoJTable;

public class UploadFile extends JFrame {

	private JPanel contentPane;
	 final JLabel statusbar = 
             new JLabel("Output of your selection will go here");

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadFile frame = new UploadFile();
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
	public UploadFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Upload File");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("select file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
		        chooser.setMultiSelectionEnabled(true);
		        int option = chooser.showOpenDialog(UploadFile.this);
		        if (option == JFileChooser.APPROVE_OPTION) {
		          File[] sf = chooser.getSelectedFiles();
		          String filelist = "nothing";
		          if (sf.length > 0) filelist = sf[0].getPath();
		          for (int i = 1; i < sf.length; i++) {
		            filelist += ", " + sf[i].getPath();
		          }
		          statusbar.setText("You chose " + filelist);
		         ImportCSVtoJTable icj = new ImportCSVtoJTable(filelist);
		          System.out.println("You chose " + filelist);
		        }
		        else {
		          statusbar.setText("You canceled.");
		        }
		        
		        
			}
		});
		btnNewButton.setBounds(25, 34, 111, 31);
		contentPane.add(btnNewButton);
		
		JButton btnUploadFile = new JButton("Upload File");
		btnUploadFile.setBounds(25, 89, 111, 31);
		contentPane.add(btnUploadFile);
		
		JButton btnDownloadFile = new JButton("DownLoad File");
		btnDownloadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDownloadFile.setBounds(25, 144, 111, 31);
		contentPane.add(btnDownloadFile);
	}
}
