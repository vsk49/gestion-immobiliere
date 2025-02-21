package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.controleurGestionBiens;

public class IHMGestionBiens extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTable tableBiens;
	private final JTextField champRecherche;

	/**
	 * Create the frame.
	 */
	public IHMGestionBiens() {
		controleurGestionBiens controleur = new controleurGestionBiens(this);
		setTitle("Gestion des Biens");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		BoutonGLocataires.setActionCommand("locataires");
		BoutonGLocataires.addActionListener(controleur);
		
		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panelGauche.add(BoutonGBaux);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);
		BoutonGDeclFisc.setActionCommand("DeclarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelParamRecherche = new JPanel();
		panelCentre.add(panelParamRecherche, BorderLayout.NORTH);
		panelParamRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.champRecherche = new JTextField();
		this.champRecherche.setColumns(10);
		panelParamRecherche.add(this.champRecherche);
		
		JButton BoutonRecherche = new JButton("Chercher");
		panelParamRecherche.add(BoutonRecherche);
		BoutonRecherche.setActionCommand("Chercher");
		BoutonRecherche.addActionListener(controleur);

		JComboBox<String> comboBoxFiltre = new JComboBox<>(new String[] {"Tous", "Batiment", "Logement", "Garage"});
		panelParamRecherche.add(comboBoxFiltre);
		comboBoxFiltre.addActionListener(controleur);

		ImageIcon iconeGestionAjout = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("plus.png")));
		JButton BoutonGestionAjout = new JButton();
		BoutonGestionAjout.setIcon(iconeGestionAjout);
		panelParamRecherche.add(BoutonGestionAjout);
		BoutonGestionAjout.setActionCommand("Ajout");
		BoutonGestionAjout.addActionListener(controleur);

		this.tableBiens = new JTable(new DefaultTableModel(new Object[] {"ID", "Numero Fiscal", "Adresse",
				"Code Postal", "Ville"}, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		JScrollPane scrollPane = new JScrollPane(this.tableBiens);
		panelCentre.add(scrollPane, BorderLayout.CENTER);
		this.tableBiens.addMouseListener(controleur);
		
		JLabel LabelTitre = new JLabel("Gestion des biens");
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelTitre, BorderLayout.NORTH);

		controleur.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
	}

	public JTable getTableBiens() {
		return this.tableBiens;
	}

	public JTextField getChampRecherche() {
		return this.champRecherche;
	}

}