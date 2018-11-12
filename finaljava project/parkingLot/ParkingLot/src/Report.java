import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Report frame = new Report();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Report() {
		this.setTitle("Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
		);
		
		Object[][] vehicle=new Object[35][2];
		contentPane.setLayout(gl_contentPane);
		String file="src//data.txt";
		String line="";
		try {
			BufferedReader br =new BufferedReader(new FileReader(file));
	
			int i=0;
			try {
				while ((line = br.readLine()) != null) {
					
					vehicle[i][0]=line.split(",")[0];
					vehicle[i][1]=line.split(",")[1];
					i++;
				}
		
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null,null,null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				 "Vehicle Number", "Slot number"
//			}
//		));
		String col[]= {"Vehicle Number", "Slot number"};
		table =new JTable(vehicle,col);
		table.setVisible(true);
		scrollPane.setViewportView(table);

	}
}
