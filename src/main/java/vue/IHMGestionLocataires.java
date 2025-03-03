package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controleur.ControleurGestionLocataires;
import modele.Locataire;

public class IHMGestionLocataires extends JFrame {

	private final JTextField champRecherche;
	private final JPanel panelLocataires;
	private final ControleurGestionLocataires controleur;

	public IHMGestionLocataires() {
		setTitle("Gestion des Locataires");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 600);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout());

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel panelGauche = new JPanel();
		panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
		panelGauche.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panelGauche, BorderLayout.WEST);

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

		ImageIcon iconeGestionAjout = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("plus.png")));
		JButton boutonGestionAjout = new JButton(iconeGestionAjout);
		boutonGestionAjout.setActionCommand("Ajout");
		panelParamRecherche.add(boutonGestionAjout);

		panelLocataires = new JPanel();
		panelLocataires.setLayout(new BoxLayout(panelLocataires, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(panelLocataires);
		panelCentre.add(scrollPane, BorderLayout.CENTER);

		JLabel libelleTitrePage = new JLabel("Gestion des locataires");
		libelleTitrePage.setFont(new Font("Tahoma", Font.PLAIN, 24));
		libelleTitrePage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(libelleTitrePage, BorderLayout.NORTH);

		controleur = new ControleurGestionLocataires(this);
		boutonRecherche.addActionListener(controleur);
		boutonGestionAjout.addActionListener(controleur);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);

		JMenu menu = new JMenu("Menu");
		menu.setOpaque(true);
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setForeground(Color.BLACK);

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

		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	// mettre à jour la liste des locataires
	public void updateLocataires(List<Locataire> locataires) {
		panelLocataires.removeAll();
		for (Locataire locataire : locataires) {
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

			panelLocataires.add(panel);
		}
		panelLocataires.revalidate();
		panelLocataires.repaint();
	}

	public JTextField getChampRecherche() {
		return champRecherche;
	}

	public ControleurGestionLocataires getControleur() {
		return controleur;
	}

	public JPanel getPanelLocataires() {
		return panelLocataires;
	}

}