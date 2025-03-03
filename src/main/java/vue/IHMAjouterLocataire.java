package vue;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import controleur.ControleurAjoutLocataire;

public class IHMAjouterLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldNom;
	private final JTextField textFieldPrenom;
	private final DatePicker datePickerNaissance;
	private final JTextField textFieldTelephone;
	private final JTextField textFieldEmail;

	public IHMAjouterLocataire() {
		ControleurAjoutLocataire controleur = new ControleurAjoutLocataire(this);
		setTitle("Ajout de locataire");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10));
		this.setBackground(Color.WHITE);

		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(1, 2, 10, 10));
		panelBasDePage.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton boutonAnnuler = new JButton("Annuler");
		JButton boutonValider = new JButton("Valider");
		panelBasDePage.add(boutonAnnuler);
		panelBasDePage.add(boutonValider);

		JPanel panelBody = new JPanel();
		panelBody.setLayout(new BorderLayout(10, 10));
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);

		JLabel labelAjouterLocataire = new JLabel("Ajouter un locataire");
		labelAjouterLocataire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelAjouterLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		panelBody.add(labelAjouterLocataire, BorderLayout.NORTH);

		JPanel panelFormulaire = new JPanel();
		TitledBorder border = new TitledBorder(new EmptyBorder(25, 15, 15, 15),
				"Informations du Locataire", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Calibri", Font.BOLD, 16), Color.BLUE);
		panelFormulaire.setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(10, 10, 10, 10)));
		panelFormulaire.setLayout(new GridBagLayout());
		panelFormulaire.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Nom
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Nom :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		textFieldNom = new JTextField(20);
		panelFormulaire.add(textFieldNom, gbc);

		// Prenom
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Prenom :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		textFieldPrenom = new JTextField(20);
		panelFormulaire.add(textFieldPrenom, gbc);

		// Date de naissance
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Date de naissance :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		DatePickerSettings settings = new DatePickerSettings();
		settings.setAllowKeyboardEditing(false);
		settings.setFormatForDatesCommonEra("dd.MM.yyyy");
		datePickerNaissance = new DatePicker(settings);
		panelFormulaire.add(datePickerNaissance, gbc);

		// Telephone
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Téléphone :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		textFieldTelephone = new JTextField(20);
		panelFormulaire.add(textFieldTelephone, gbc);

		// Email
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.EAST;
		panelFormulaire.add(new JLabel("Email :"), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		textFieldEmail = new JTextField(20);
		panelFormulaire.add(textFieldEmail, gbc);

		panelBody.add(panelFormulaire, BorderLayout.CENTER);
		this.add(panelBody, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	public JTextField getTextFieldTelephone() {
		return textFieldTelephone;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public DatePicker getDatePickerNaissance() {
		return datePickerNaissance;
	}

}