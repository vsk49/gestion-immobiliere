package vue;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import controleur.ControleurModificationBien;
import modele.BienImmobilier;

public class IHMModificationBien extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldAdresse;
	private final JTextField textFieldVille;
	private final JTextField textFieldCodePostal;
	private final JTextField textFieldEtage;
	private final JTextField textFieldTypeBien;
	private final JTextField textFieldSurface;
	private final JTextField textFieldNbPieces;
	private final JTextField textFieldStatut;

	public IHMModificationBien(BienImmobilier bien) {
		setTitle("Modification du Bien");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10));
		this.setBackground(Color.WHITE);

		// Header
		JLabel labelHeader = new JLabel("Modification du Bien");
		labelHeader.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(labelHeader, BorderLayout.NORTH);

		// Form Panel
		JPanel panelFormulaire = new JPanel();
		TitledBorder border = new TitledBorder(new EmptyBorder(25, 15, 15, 15),
				"Informations du Bien", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Calibri", Font.BOLD, 16), Color.BLUE);
		panelFormulaire.setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(10, 10, 10, 10)));
		panelFormulaire.setLayout(new GridBagLayout());
		panelFormulaire.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Address
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Adresse :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldAdresse = new JTextField(20);
		panelFormulaire.add(textFieldAdresse, gbc);

		// City
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Ville :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldVille = new JTextField(20);
		panelFormulaire.add(textFieldVille, gbc);

		// Postal Code
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Code Postal :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldCodePostal = new JTextField(20);
		panelFormulaire.add(textFieldCodePostal, gbc);

		// Floor
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Étage :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldEtage = new JTextField(20);
		panelFormulaire.add(textFieldEtage, gbc);

		// Type of Property
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Type de Bien :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldTypeBien = new JTextField(20);
		panelFormulaire.add(textFieldTypeBien, gbc);

		// Surface
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Surface :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldSurface = new JTextField(20);
		panelFormulaire.add(textFieldSurface, gbc);

		// Number of Rooms
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Nombre de Pièces :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldNbPieces = new JTextField(20);
		panelFormulaire.add(textFieldNbPieces, gbc);

		// Status
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Statut :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.textFieldStatut = new JTextField(20);
		panelFormulaire.add(textFieldStatut, gbc);

		this.add(panelFormulaire, BorderLayout.CENTER);

		// Bottom Panel with Buttons
		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(1, 3, 10, 10));
		panelBasDePage.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton boutonAnnuler = new JButton("Annuler");
		JButton boutonReinitialiser = new JButton("Réinitialiser");
		JButton boutonValider = new JButton("Valider");
		panelBasDePage.add(boutonAnnuler);
		panelBasDePage.add(boutonReinitialiser);
		panelBasDePage.add(boutonValider);

		this.add(panelBasDePage, BorderLayout.SOUTH);

		// Controller
		ControleurModificationBien controleur = new ControleurModificationBien(this, bien);
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		boutonReinitialiser.setActionCommand("Réinitialiser");
		boutonReinitialiser.addActionListener(controleur);
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JTextField getTextFieldAdresse() {
		return textFieldAdresse;
	}

	public JTextField getTextFieldVille() {
		return textFieldVille;
	}

	public JTextField getTextFieldCodePostal() {
		return textFieldCodePostal;
	}

	public JTextField getTextFieldEtage() {
		return textFieldEtage;
	}

	public JTextField getTextFieldTypeBien() {
		return textFieldTypeBien;
	}

	public JTextField getTextFieldSurface() {
		return textFieldSurface;
	}

	public JTextField getTextFieldNbPieces() {
		return textFieldNbPieces;
	}

	public JTextField getTextFieldStatut() {
		return textFieldStatut;
	}

}