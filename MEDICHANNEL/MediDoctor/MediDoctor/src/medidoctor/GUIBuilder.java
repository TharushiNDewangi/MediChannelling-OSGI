package medidoctor;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import medipharmacyservice.PharmacyService;

public class GUIBuilder {
	
	public static void ReseveDriver(ArrayList<String> MedicineList, PharmacyService pharmacySrevice) {
		JFrame frame = new JFrame("Reserved Driver");
		frame.getContentPane().setLayout(new GridLayout(1, 0,50,50));
		JPanel  mainPanel = new JPanel(new GridLayout(1, 0,0,0));
		final JButton btnAdd = new JButton("new reservation");
		mainPanel.setSize(400, 400);
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "pharmacy service ", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman" ,Font.PLAIN,24), Color.BLACK ));
		
		JPanel detailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		detailPanel.setSize(390, 390);
		detailPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
	} 

}
