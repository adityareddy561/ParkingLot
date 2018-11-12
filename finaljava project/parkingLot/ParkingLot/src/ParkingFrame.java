import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ParkingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ParkingFrame frame = new ParkingFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});+
//	}

	/**
	 * Create the frame.
	 */
	public ParkingFrame() {
		this.setResizable(false);
		this.setTitle("Parking Lot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ParkingLot p=new ParkingLot("src//Data.txt");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Lot Status", null, panel, null);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Locate Vehicle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String k =p.Locate(textField.getText());
					if(k.equals("-1")) {
						JOptionPane.showMessageDialog(null,"Vehicle not found ???");
					}
					else {
						JOptionPane.showMessageDialog(null,"Parking lot number "+k);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCheckLotCapacity = new JButton("Check lot Capacity");
		btnCheckLotCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cap =p.Capacity();
				JOptionPane.showMessageDialog(null, "free lots "+cap);
			}
		});
		
		JButton btnSaveLotState = new JButton("Report");
		btnSaveLotState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report re =new Report();
				re.setVisible(true);
			}
		});
		
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EmployLogin e =new EmployLogin();
				JOptionPane.showMessageDialog(null,"Logout sucessfull ");
				e.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVehicleNumber)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSaveLotState)
								.addComponent(btnCheckLotCapacity))))
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblVehicleNumber))
					.addGap(17)
					.addComponent(btnCheckLotCapacity)
					.addGap(18)
					.addComponent(btnSaveLotState)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout)
						.addComponent(btnNewButton_1)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add or Remove Vehicles", null, panel_1, null);
		
		JLabel lblVehicleNumber_1 = new JLabel("Vehicle Number :");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnAddVehicleFrom = new JButton("Add Vehicle to Lot");
		btnAddVehicleFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(textField_1.getText())!=null)
				{   try {
					if(p.isfull()==false) {
						p.Store(textField_1.getText());
						JOptionPane.showMessageDialog(null,"Vehicle added sucessfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "parking lot is full ");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
		});
		
		
		JButton btnRemoveVehicleFrom = new JButton("Remove Vehicle from Lot");
		btnRemoveVehicleFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new String(textField_1.getText())!=null)
				{
					try {
						String a=textField_1.getText();
						if( p.Locate(textField_1.getText())!="-1" ) {
						p.remove(textField_1.getText());
						JOptionPane.showMessageDialog(null,"removed sucessfully");
						}
						else {
							JOptionPane.showMessageDialog(null,"Not found ");
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton btnLogout_1 = new JButton("logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EmployLogin e =new EmployLogin();
				JOptionPane.showMessageDialog(null,"Logout sucessfull ");
				e.setVisible(true);
			}
		});
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAddVehicleFrom)
							.addGap(18)
							.addComponent(btnRemoveVehicleFrom))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblVehicleNumber_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(230, Short.MAX_VALUE)
					.addComponent(btnLogout_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVehicleNumber_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddVehicleFrom)
						.addComponent(btnRemoveVehicleFrom))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout_1)
						.addComponent(btnQuit)))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
