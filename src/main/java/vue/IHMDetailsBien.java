package vue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serial;
import controleur.ControleurDetailsBiens;
import modele.BienImmobilier;

public class IHMDetailsBien extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JLabel labelAdresse;
	private final JLabel labelCodePostal;
	private final JLabel labelVille;
	private final JLabel labelEtage;
	private final JLabel labelTypeBien;
	private final JLabel labelSurface;
	private final JLabel labelNbPieces;
	private final JLabel labelStatut;
	private final JTable tableLocataires;

	public IHMDetailsBien(BienImmobilier bien) {
		setTitle("Détail du Bien " + bien.getIdBienImmobilier());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10));
		this.setBackground(Color.WHITE);

		// Bottom panel with buttons
		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(1, 2, 10, 10));
		panelBasDePage.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton boutonRetour = new JButton("Retour");
		JButton boutonModifier = new JButton("Modifier");
		panelBasDePage.add(boutonRetour);
		panelBasDePage.add(boutonModifier);

		// Main body panel
		JPanel panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout(10, 10));
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);

		// Form panel with TitledBorder
		JPanel panelFormulaire = new JPanel();
		TitledBorder border = new TitledBorder(new EmptyBorder(25, 15, 15, 15),
				"Informations du Bien " + bien.getIdBienImmobilier(),
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Calibri", Font.BOLD, 16), Color.BLUE);
		panelFormulaire.setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(10, 10, 10, 10)));
		panelFormulaire.setLayout(new GridBagLayout());
		panelFormulaire.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Adding fields
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Adresse :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelAdresse = new JLabel(bien.getAdresse());
		panelFormulaire.add(labelAdresse, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Code Postal :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelCodePostal = new JLabel(String.valueOf(bien.getCodePostal()));
		panelFormulaire.add(labelCodePostal, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Ville :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelVille = new JLabel(bien.getVille());
		panelFormulaire.add(labelVille, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Etage :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelEtage = new JLabel("N/A"); // Example value
		panelFormulaire.add(labelEtage, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Type de Bien :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelTypeBien = new JLabel(bien.getClass().getSimpleName());
		panelFormulaire.add(labelTypeBien, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Surface :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelSurface = new JLabel("N/A"); // Example value
		panelFormulaire.add(labelSurface, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Nombre de Pièces :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelNbPieces = new JLabel("N/A"); // Example value
		panelFormulaire.add(labelNbPieces, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Statut :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelStatut = new JLabel("N/A"); // Example value
		panelFormulaire.add(labelStatut, gbc);

		// Locataires section
		JPanel panelLocataires = new JPanel();
		TitledBorder locatairesBorder = new TitledBorder("Liste des Locataires");
		panelLocataires.setBorder(locatairesBorder);
		panelLocataires.setLayout(new BorderLayout());

		// Initialize JTable with no data
		tableLocataires = new JTable(new Object[][]{}, new String[]{"Nom", "Date d'entrée", "Email"});
		JScrollPane scrollPane = new JScrollPane(tableLocataires);
		panelLocataires.add(scrollPane, BorderLayout.CENTER);

		panelBody.add(panelFormulaire, BorderLayout.CENTER); // Details in the center
		panelBody.add(panelLocataires, BorderLayout.EAST);   // Locataires on the right
		this.add(panelBody, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Controller
		ControleurDetailsBiens controleur = new ControleurDetailsBiens(this, bien);
		boutonModifier.addActionListener(controleur);
		boutonRetour.addActionListener(controleur);
	}

	// Getters for labels
	public JLabel getLabelAdresse() {
		return this.labelAdresse;
	}

	public JLabel getLabelCodePostal() {
		return this.labelCodePostal;
	}

	public JLabel getLabelVille() {
		return this.labelVille;
	}

	public JLabel getLabelEtage() {
		return this.labelEtage;
	}

	public JLabel getLabelTypeBien() {
		return this.labelTypeBien;
	}

	public JLabel getLabelSurface() {
		return this.labelSurface;
	}

	public JLabel getLabelNbPieces() {
		return this.labelNbPieces;
	}

	public JLabel getLabelStatut() {
		return this.labelStatut;
	}

	public JTable getTableLocataires() {
		return this.tableLocataires;
	}

}