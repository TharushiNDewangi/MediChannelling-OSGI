package mediadmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import medichanneling.ChannelingService;
import medipharmacyservice.PharmacyService;

public class Getpatientdetails {
	public static void select(ChannelingService cs,PharmacyService ps)
	{
		int opcion = JOptionPane.showConfirmDialog(null, "If you want to add channel click 'yes' and if you want to add new medisine click 'no' "
				,"SUWASETHA CHANNEL", JOptionPane.YES_NO_OPTION);
		if(opcion == 0) {
			JFrame jframe = new JFrame("Add Patient");
			jframe.getContentPane().setBackground(Color.GRAY);
			JPanel jpanl = new JPanel(new GridLayout(0,1,10,10));
			JPanel mainPanel = new JPanel( new FlowLayout(250, 230, FlowLayout.CENTER));
			jpanl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Patient Chaneel", TitledBorder.CENTER, TitledBorder.TOP,
					new Font("times new roman",Font.BOLD,34), Color.BLACK));
			
			JTextPane txtpnWer = new JTextPane();
			txtpnWer.setEditable(false);
			txtpnWer.setBackground(Color.LIGHT_GRAY);
			txtpnWer.setForeground(Color.BLACK);
			txtpnWer.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtpnWer.setText("Channel ID");
			JTextField num = new JTextField("");
			
			JTextPane txtpn1 = new JTextPane();
			txtpn1.setEditable(false);
			txtpn1.setBackground(Color.LIGHT_GRAY);
			txtpn1.setForeground(Color.BLACK);
			txtpn1.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtpn1.setText("First Name");
			JTextField firname = new JTextField("");
			
			JTextPane txtp2 = new JTextPane();
			txtp2.setEditable(false);
			txtp2.setBackground(Color.LIGHT_GRAY);
			txtp2.setForeground(Color.BLACK);
			txtp2.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtp2.setText("Last Name");
			JTextField lastname = new JTextField("");
			
			JTextPane txtp3 = new JTextPane();
			txtp3.setEditable(false);
			txtp3.setBackground(Color.LIGHT_GRAY);
			txtp3.setForeground(Color.BLACK);
			txtp3.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtp3.setText("Age");
			JTextField age1 = new JTextField("");
			
			
			num.setPreferredSize( new Dimension( 300,24 ));
			firname.setPreferredSize( new Dimension( 300,24 ));
			lastname.setPreferredSize( new Dimension( 300,24 ));
			age1.setPreferredSize( new Dimension( 300,24 ));
			
			
			JButton btnAdd = new JButton("ADD");
			
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						String no = num.getText();
						String fname = firname.getText();
						String lname = lastname.getText();
						int age=Integer.parseInt(age1.getText());
						cs.addnewchannel(no, fname, lname, age);
						
				
				}
			});
			
			
			
			
			jpanl.add(txtpnWer);
			jpanl.add(num);
			
			jpanl.add(txtpn1);
			jpanl.add(firname);
			
			jpanl.add(txtp2);
			jpanl.add(lastname);
			
			jpanl.add(txtp3);
			jpanl.add(age1);
			
			jpanl.add(btnAdd);
			jpanl.add(mainPanel);
			
			jframe.add(jpanl);
			jframe.setSize(500,500);
			
			jframe.setVisible(true);
			jframe.setBackground(Color.GRAY);
		
			
			
		}else {
			JFrame jframe = new JFrame("Add Medicine");
			jframe.getContentPane().setLayout(new GridLayout(1,0,100,100));
			JPanel jpanl = new JPanel(new GridLayout(0,1,10,10));
			JPanel mainPanel = new JPanel( new FlowLayout(50, 30, FlowLayout.CENTER));
			jpanl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Medicine", TitledBorder.CENTER, TitledBorder.TOP,
					new Font("times new roman",Font.BOLD,34), Color.BLACK));
			
			JTextPane txtpnWer = new JTextPane();
			txtpnWer.setEditable(false);
			txtpnWer.setBackground(Color.LIGHT_GRAY);
			txtpnWer.setForeground(Color.BLACK);
			txtpnWer.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtpnWer.setText("Medicine Name");
			JTextField name = new JTextField("");
			
			JTextPane txtpn1 = new JTextPane();
			txtpn1.setEditable(false);
			txtpn1.setBackground(Color.LIGHT_GRAY);
			txtpn1.setForeground(Color.BLACK);
			txtpn1.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtpn1.setText("Expair Date");
			JTextField exdate = new JTextField("");
			
			JTextPane txtp2 = new JTextPane();
			txtp2.setEditable(false);
			txtp2.setBackground(Color.LIGHT_GRAY);
			txtp2.setForeground(Color.BLACK);
			txtp2.setFont(new Font("Arial Black", Font.BOLD, 17));
			txtp2.setText("Price");
			JTextField price = new JTextField("");
			
			
			
			
			name.setPreferredSize( new Dimension( 300,24 ));
			exdate.setPreferredSize( new Dimension( 300,24 ));
			price.setPreferredSize( new Dimension( 300,24 ));
			
			
			
			JButton btnAdd = new JButton("ADD");
			
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						String mname = name.getText();
						String expairdate = exdate.getText();
						double mprice = Double.parseDouble( price.getText());
						
						ps.addNewMedicines(mname, expairdate, mprice);
						
					
				}
			});
			
			
			jpanl.add(txtpnWer);
			jpanl.add(name);
			
			jpanl.add(txtpn1);
			jpanl.add(exdate);
			
			jpanl.add(txtp2);
			jpanl.add(price);
			
			
			jpanl.add(btnAdd);
			jpanl.add(mainPanel);
			
			jframe.add(jpanl);
			jframe.setSize(500,500);
			
			jframe.setVisible(true);
		
			
			
			
		}
		
	}

}
