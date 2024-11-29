package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class IHMGestionLocataires extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableLocataires;
	private JTextField saisieRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMGestionLocataires frame = new IHMGestionLocataires();
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
	public IHMGestionLocataires() {
		setTitle("Gestion des locataires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRechercheEtTableau = new JPanel();
		contentPane.add(panelRechercheEtTableau, BorderLayout.CENTER);
		panelRechercheEtTableau.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRecherche = new JPanel();
		panelRechercheEtTableau.add(panelRecherche, BorderLayout.NORTH);
		panelRecherche.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel labelTitre = new JLabel("Gestion des locataires");
		panelRecherche.add(labelTitre);
		
		saisieRecherche = new JTextField();
		panelRecherche.add(saisieRecherche);
		saisieRecherche.setColumns(10);
		
		JComboBox listeDeroulanteFiltre = new JComboBox();
		panelRecherche.add(listeDeroulanteFiltre);
		
		JLabel imageRecherche = new JLabel("Image Filtre");
		panelRecherche.add(imageRecherche);
		
		tableLocataires = new JTable();
		tableLocataires.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		panelRechercheEtTableau.add(tableLocataires, BorderLayout.CENTER);
		
		JPanel menu = new JPanel();
		contentPane.add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imageLocataire = new JLabel("image Locataire");
		menu.add(imageLocataire);
		
		JLabel imageBien = new JLabel("Image Bien");
		menu.add(imageBien);
		
		JLabel ImageBaux = new JLabel("Image Baux");
		menu.add(ImageBaux);
		
		JLabel ImageDéclarationFiscale = new JLabel("Image Déclaration Fiscale");
		menu.add(ImageDéclarationFiscale);
		
		JLabel ImageFinance = new JLabel("Image Finance");
		menu.add(ImageFinance);
	}

}
