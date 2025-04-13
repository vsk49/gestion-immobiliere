package vue;

import java.awt.*;
import java.io.Serial;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controleur.ControleurGestionBiens;

public class IHMGestionBiens extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTable tableBiens;
	private final JTextField champRecherche;

	public IHMGestionBiens() {
		setTitle("Gestion des Biens");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 600);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout());

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel panelCentre = new JPanel();
		panelCentre.setLayout(new BorderLayout());
		contentPane.add(panelCentre, BorderLayout.CENTER);

		JPanel panelParamRecherche = new JPanel();
		panelParamRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelCentre.add(panelParamRecherche, BorderLayout.NORTH);

		champRecherche = new JTextField(20);
		panelParamRecherche.add(champRecherche);

		JButton boutonRecherche = new JButton("Chercher");
		boutonRecherche.setActionCommand("Chercher");
		panelParamRecherche.add(boutonRecherche);

		JComboBox<String> comboBoxFiltre = new JComboBox<>(new String[]{"Tous", "Batiment", "Logement", "Garage"});
		panelParamRecherche.add(comboBoxFiltre);

		ImageIcon iconeGestionAjout = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("plus.png")));
		JButton boutonGestionAjout = new JButton(iconeGestionAjout);
		boutonGestionAjout.setActionCommand("Ajout");
		panelParamRecherche.add(boutonGestionAjout);

		tableBiens = new JTable(new DefaultTableModel(new Object[]{"Numero Fiscal", "Adresse", "Code Postal", "Ville", "Date d'Acquisition"}, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		JScrollPane scrollPane = new JScrollPane(tableBiens);
		panelCentre.add(scrollPane, BorderLayout.CENTER);

		JLabel labelTitre = new JLabel("Gestion des biens");
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitre, BorderLayout.NORTH);

		ControleurGestionBiens controleur = new ControleurGestionBiens(this);
		boutonRecherche.addActionListener(controleur);
		boutonGestionAjout.addActionListener(controleur);
		comboBoxFiltre.addActionListener(controleur);
		tableBiens.addMouseListener(controleur);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);

		JMenu menu = new JMenu("Menu");
		menu.setOpaque(true);
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setForeground(Color.BLACK);

		addMenuItems(menu, controleur);

		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	private void addMenuItems(JMenu menu, ControleurGestionBiens controleur) {
		JMenuItem menuItemAccueil = new JMenuItem("Accueil");
		menuItemAccueil.setOpaque(true);
		menuItemAccueil.setBackground(Color.LIGHT_GRAY);
		menuItemAccueil.setForeground(Color.BLACK);
		menuItemAccueil.addActionListener(controleur);
		menu.add(menuItemAccueil);

		JMenuItem menuItemLocataires = new JMenuItem("Mes Locataires");
		menuItemLocataires.setOpaque(true);
		menuItemLocataires.setBackground(Color.LIGHT_GRAY);
		menuItemLocataires.setForeground(Color.BLACK);
		menuItemLocataires.addActionListener(controleur);
		menu.add(menuItemLocataires);

		JMenuItem menuItemBiens = new JMenuItem("Mes Biens");
		menuItemBiens.setOpaque(true);
		menuItemBiens.setBackground(Color.LIGHT_GRAY);
		menuItemBiens.setForeground(Color.BLACK);
		menuItemBiens.addActionListener(controleur);
		menu.add(menuItemBiens);

		JMenuItem menuItemBaux = new JMenuItem("Mes Baux");
		menuItemBaux.setOpaque(true);
		menuItemBaux.setBackground(Color.LIGHT_GRAY);
		menuItemBaux.setForeground(Color.BLACK);
		menuItemBaux.addActionListener(controleur);
		menu.add(menuItemBaux);

		JMenuItem menuItemDeclaration = new JMenuItem("Déclaration Fiscale");
		menuItemDeclaration.setOpaque(true);
		menuItemDeclaration.setBackground(Color.LIGHT_GRAY);
		menuItemDeclaration.setForeground(Color.BLACK);
		menuItemDeclaration.addActionListener(controleur);
		menu.add(menuItemDeclaration);

		JMenuItem menuItemRegularisation = new JMenuItem("Régularisation de Charges");
		menuItemRegularisation.setOpaque(true);
		menuItemRegularisation.setBackground(Color.LIGHT_GRAY);
		menuItemRegularisation.setForeground(Color.BLACK);
		menuItemRegularisation.addActionListener(controleur);
		menu.add(menuItemRegularisation);
	}

	public JTable getTableBiens() {
		return tableBiens;
	}

	public JTextField getChampRecherche() {
		return champRecherche;
	}

}