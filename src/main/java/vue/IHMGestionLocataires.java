
package vue;

import controleur.ControleurGestionLocataires;
import dao.JDBCLocataire;
import modele.Locataire;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class IHMGestionLocataires extends JFrame {

	private final JTextField champRecherche;
	private final JPanel panelLocataires;
	private final ControleurGestionLocataires controleur;

	public IHMGestionLocataires() {
		setTitle("Gestion des Locataires");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelGauche = new JPanel();
		panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
		panelGauche.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelGauche, BorderLayout.WEST);

		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));

		JPanel panelParamRecherche = new JPanel();
		panelCentre.add(panelParamRecherche, BorderLayout.NORTH);
		panelParamRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.champRecherche = new JTextField();
		this.champRecherche.setColumns(10);
		panelParamRecherche.add(this.champRecherche);

		JButton boutonRecherche = new JButton("Chercher");
		panelParamRecherche.add(boutonRecherche);
		boutonRecherche.setActionCommand("Chercher");

		ImageIcon iconeGestionAjout = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("plus.png")));
		JButton boutonGestionAjout = new JButton();
		boutonGestionAjout.setIcon(iconeGestionAjout);
		panelParamRecherche.add(boutonGestionAjout);
		boutonGestionAjout.setActionCommand("Ajout");

		this.panelLocataires = new JPanel();
		this.panelLocataires.setLayout(new BoxLayout(this.panelLocataires, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(this.panelLocataires);
		panelCentre.add(scrollPane, BorderLayout.CENTER);

		JLabel libelleTitrePage = new JLabel("Gestion des locataires");
		libelleTitrePage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		libelleTitrePage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(libelleTitrePage, BorderLayout.NORTH);

		this.controleur = new ControleurGestionLocataires(this, new JDBCLocataire());
		setJMenuBar(createMenuBar(controleur));
		boutonRecherche.addActionListener(controleur);
		boutonGestionAjout.addActionListener(controleur);

		this.setVisible(true);
	}

	private JMenuBar createMenuBar(ControleurGestionLocataires controleur) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);

		JMenu menu = new JMenu("Menu");
		menu.setOpaque(true);
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setForeground(Color.BLACK);

		JMenuItem menuItemAccueil = createMenuItem("Accueil", controleur);
		JMenuItem menuItemLocataires = createMenuItem("Mes Locataires", controleur);
		JMenuItem menuItemBiens = createMenuItem("Mes Biens", controleur);
		JMenuItem menuItemBaux = createMenuItem("Mes Baux", controleur);
		JMenuItem menuItemDeclarationFiscale = createMenuItem("Déclaration Fiscale", controleur);
		JMenuItem menuItemFinances = createMenuItem("Régularisation de Charges", controleur);

		menu.add(menuItemAccueil);
		menu.add(menuItemLocataires);
		menu.add(menuItemBiens);
		menu.add(menuItemBaux);
		menu.add(menuItemDeclarationFiscale);
		menu.add(menuItemFinances);

		menuBar.add(menu);
		return menuBar;
	}

	private JMenuItem createMenuItem(String text, ControleurGestionLocataires controleur) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setOpaque(true);
		menuItem.setBackground(Color.LIGHT_GRAY);
		menuItem.setForeground(Color.BLACK);
		menuItem.addActionListener(controleur);
		return menuItem;
	}

	public void updateLocataires(List<Locataire> locataires) {
		this.panelLocataires.removeAll();
		for (Locataire locataire : locataires) {
			JPanel locatairePanel = createLocatairePanel(locataire);
			locatairePanel.addMouseListener(this.controleur);
			this.panelLocataires.add(locatairePanel);
		}
		this.panelLocataires.revalidate();
		this.panelLocataires.repaint();
	}

	private JPanel createLocatairePanel(Locataire locataire) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Locataire ID: " + locataire.getIdLocataire()));
		panel.putClientProperty("locataire", locataire);

		JLabel nameLabel = new JLabel("Nom: " + locataire.getNom() + " " + locataire.getPrenom());
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(nameLabel);

		JLabel emailLabel = new JLabel("Email: " + locataire.getEmail());
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(emailLabel);

		panel.addMouseListener(this.controleur);

		return panel;
	}

	public JTextField getChampRecherche() {
		return this.champRecherche;
	}

	public ControleurGestionLocataires getControleur() {
		return this.controleur;
	}

}