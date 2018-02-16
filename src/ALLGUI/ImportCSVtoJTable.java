package ALLGUI;
 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ImportCSVtoJTable {

	 JButton button;
    public ImportCSVtoJTable(String path) {
        try {
        	
        	

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            List<String[]> elements = new ArrayList<String[]>();
            String line = null;
            while((line = br.readLine())!=null) {
                String[] splitted = line.split(",");
                elements.add(splitted);
            }
            br.close();

            JTable table = new JTable();
            String[] columNames = new String[] {
                    "ID", "StudentID", "Date", "Marks","Status"
                };

            Object[][] content = new Object[elements.size()][5];

            for(int i=0; i<elements.size(); i++) {
                content[i][0] = elements.get(i)[0];
                content[i][1] = elements.get(i)[1];
                content[i][2] = elements.get(i)[2];
                content[i][3] = elements.get(i)[3];
                content[i][4] = elements.get(i)[4];
            }

            table.setModel(new DefaultTableModel(content,columNames));
            JFrame frame = new JFrame( "Demo" );
            frame.getContentPane().add(new JScrollPane( table ) );
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.pack();
            frame.setVisible( true );

            System.out.println(table.getModel().getValueAt(1, 1));
            for (String[] strings : elements) {
                System.out.println(Arrays.toString(strings));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

   /*public static void main(String[] args) {
        new ImportCSVtoJTable();
    }*/
}
