package vue;

import controleur.ControleurDetailsLocataire;
import modele.Locataire;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class IHMDetailsLocataire extends JFrame {

	private final JLabel labelContenuNom;
	private final JLabel labelContenuPrenom;
	private final JLabel labelContenuDateDeNaissance;
	private final JLabel labelContenuTelephone;
	private final JLabel labelContenuEmail;

	public IHMDetailsLocataire(Locataire locataire) {
		setTitle("Details du Locataire " + locataire.getIdLocataire());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10));
		this.setBackground(Color.WHITE);

		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(1, 2, 10, 10));
		panelBasDePage.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton boutonRetour = new JButton("Retour");
		JButton boutonModifier = new JButton("Modifier");
		panelBasDePage.add(boutonRetour);
		panelBasDePage.add(boutonModifier);

		JPanel panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout(10, 10));
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);

		JPanel panelFormulaire = new JPanel();
		TitledBorder border = new TitledBorder(new EmptyBorder(25, 15, 15, 15), // Increased top padding
				"Informations du Locataire " + locataire.getIdLocataire(),
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Calibri", Font.BOLD, 16), Color.BLUE);
		panelFormulaire.setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(10, 10, 10, 10)));
		panelFormulaire.setLayout(new GridBagLayout());
		panelFormulaire.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 10, 15); // Increased top and right insets
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Nom
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Nom :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelContenuNom = new JLabel(locataire.getNom());
		panelFormulaire.add(labelContenuNom, gbc);

		// Prenom
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Prenom :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelContenuPrenom = new JLabel(locataire.getPrenom());
		panelFormulaire.add(labelContenuPrenom, gbc);

		// Date de naissance
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Date de naissance :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelContenuDateDeNaissance = new JLabel(locataire.getDateNaissance().toString());
		panelFormulaire.add(labelContenuDateDeNaissance, gbc);

		// Telephone
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Téléphone :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelContenuTelephone = new JLabel(locataire.getTelephone());
		panelFormulaire.add(labelContenuTelephone, gbc);

		// Email
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Email :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		labelContenuEmail = new JLabel(locataire.getEmail());
		panelFormulaire.add(labelContenuEmail, gbc);

		panelBody.add(panelFormulaire, BorderLayout.CENTER);
		this.add(panelBody, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		ControleurDetailsLocataire controleur = new ControleurDetailsLocataire(this, locataire);
		boutonModifier.addActionListener(controleur);
		boutonRetour.addActionListener(controleur);
	}

	// getters pour les JLabels
	public JLabel getModifPrenom() {
		return this.labelContenuPrenom;
	}

	public JLabel getModifNom() {
		return this.labelContenuNom;
	}

	public JLabel getModifDateNaissance() {
		return this.labelContenuDateDeNaissance;
	}

	public JLabel getModifTelephone() {
		return this.labelContenuTelephone;
	}

	public JLabel getModifEmail() {
		return this.labelContenuEmail;
	}

}