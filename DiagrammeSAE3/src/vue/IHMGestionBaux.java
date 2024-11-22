package vue;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class IHMGestionBaux extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public IHMGestionBaux() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
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
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		add(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel labelGestionBaux_1 = new JLabel("Gestion des baux");
		panel_1.add(labelGestionBaux_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Chercher");
		panel_1.add(btnNewButton);

	}

}
