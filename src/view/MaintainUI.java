package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class MaintainUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MaintainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 String[] columns = new String[] {
		            "Id", "Name", "Hourly Rate", "Part Time"
		        };
		        
		        //actual data for the table in a 2d array
		        Object[][] data = new Object[][] {
		            {1, "John", 40.0, false },
		            {2, "Rambo", 70.0, false },
		            {3, "Zorro", 60.0, true },
		        };
		        
		        final Class[] columnClass = new Class[] {
		            Integer.class, String.class, Double.class, Boolean.class
		        };

		        //create table model with data
		        DefaultTableModel model = new DefaultTableModel(data, columns) {

		            @Override
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }

		            @Override
		            public Class<?> getColumnClass(int columnIndex)
		            {
		                return columnClass[columnIndex];
		            }
		        };
		        
		        JTable table = new JTable(model);
		        
		        //add the table to the frame
		        contentPane.add(new JScrollPane(table));
		            
		        
		        setVisible(true);
	}
	public static void main(String[] args) {
		new MaintainUI();
				
	}
}
