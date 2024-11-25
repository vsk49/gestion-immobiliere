package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class IHMGestionBaux extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMGestionBaux frame = new IHMGestionBaux();
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
	public IHMGestionBaux() {
		setTitle("Page de gestion des baux");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imageLocataire = new JLabel("image Locataire");
		panel.add(imageLocataire);
		
		JLabel imageBien = new JLabel("Image Bien");
		panel.add(imageBien);
		
		JLabel ImageBaux = new JLabel("Image Baux");
		panel.add(ImageBaux);
		
		JLabel ImageDéclarationFiscale = new JLabel("Image Déclaration Fiscale");
		panel.add(ImageDéclarationFiscale);
		
		JLabel ImageFinance = new JLabel("Image Finance");
		panel.add(ImageFinance);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		getContentPane().add(table);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel labelGestionBaux_1 = new JLabel("Gestion des baux");
		panel_1.add(labelGestionBaux_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		panel_1.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Image filtre");
		panel_1.add(lblNewLabel);
	}

}
