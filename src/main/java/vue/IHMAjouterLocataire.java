package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.Serial;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controleur.controleurAjoutLocataire;

public class IHMAjouterLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldNom;
	private final JTextField textFieldPrenom;
	private final JRadioButton radioButtonHomme;
    private final DatePicker datePickerNaissance;
	private final JTextField textFieldLieuNaissance;
	private final JTextField textFieldNationalite;
	private final JTextField textProfession;
	private final JTextField textFieldTelephone;
	private final DatePicker datePickerEntree;
	private final JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				IHMAjouterLocataire frame = new IHMAjouterLocataire();
				frame.setVisible(true);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IHMAjouterLocataire() {
		controleurAjoutLocataire controleur = new controleurAjoutLocataire(this);
		setTitle("Ajout de locataire");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel menu = new JPanel();
		getContentPane().add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(0, 1, 0, 0));

		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		menu.add(BoutonGBiens);
		BoutonGBiens.setActionCommand("biens");
		BoutonGBiens.addActionListener(controleur);


		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		menu.add(BoutonGBaux);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);


		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		menu.add(BoutonGDeclFisc);
		BoutonGDeclFisc.setActionCommand("DeclarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		menu.add(BoutonGFinances);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);

		JLabel labelAjouterLocataire = new JLabel("Ajouter un locataire");
		labelAjouterLocataire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelAjouterLocataire.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);

		JButton boutonAnnuler = new JButton("Annuler");
		panelbouton.add(boutonAnnuler);
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);

		JButton boutonValider = new JButton("Valider");
		panelbouton.add(boutonValider);
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);

		JPanel panelBody = new JPanel();
		getContentPane().add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));

		panelBody.add(panelBasDePage, BorderLayout.SOUTH);
		panelBody.add(labelAjouterLocataire, BorderLayout.NORTH);

		JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBorder(new EmptyBorder(15, 0, 0, 0));
		panelBody.add(panelFormulaire);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		Panel panelGauchePartieFormulaire = new Panel();
		panelFormulaire.add(panelGauchePartieFormulaire);
		panelGauchePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelLabelsGauche = new JPanel();
		panelGauchePartieFormulaire.add(panelLabelsGauche);
		panelLabelsGauche.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelLabelNom = new JPanel();
		FlowLayout flowLayoutLabelNom = (FlowLayout) panelLabelNom.getLayout();
		flowLayoutLabelNom.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLabelNom);

		JLabel labelNom = new JLabel("Nom :");
		panelLabelNom.add(labelNom);

		JPanel panelLabelPrenom = new JPanel();
		FlowLayout flowLayoutLabelPrenom = (FlowLayout) panelLabelPrenom.getLayout();
		flowLayoutLabelPrenom.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLabelPrenom);

		JLabel labelPrenom = new JLabel("Prenom :");
		panelLabelPrenom.add(labelPrenom);

		JPanel panelLabelDateDeNaissance = new JPanel();
		FlowLayout flowLayoutLabelDateDeNaissance = (FlowLayout) panelLabelDateDeNaissance.getLayout();
		flowLayoutLabelDateDeNaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLabelDateDeNaissance);

		JLabel labelDateDeNaissance = new JLabel("Date de naissance :");
		panelLabelDateDeNaissance.add(labelDateDeNaissance);

		JPanel panelTextfieldGauche = new JPanel();
		panelGauchePartieFormulaire.add(panelTextfieldGauche);
		panelTextfieldGauche.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelTextfieldNom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTextfieldNom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelTextfieldNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		panelTextfieldNom.add(textFieldNom);

		JPanel panelTextfieldPrenom = new JPanel();
		FlowLayout flowLayoutTextfieldPrenom = (FlowLayout) panelTextfieldPrenom.getLayout();
		flowLayoutTextfieldPrenom.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelTextfieldPrenom);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		panelTextfieldPrenom.add(textFieldPrenom);

		JPanel panelDatepickerDateDeNaissance = new JPanel();
		FlowLayout flowLayoutDatepickerDateDeNaissance = (FlowLayout) panelDatepickerDateDeNaissance.getLayout();
		flowLayoutDatepickerDateDeNaissance.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelDatepickerDateDeNaissance);

		// Configuration des paramètres du DatePicker
        DatePickerSettings settings = new DatePickerSettings();
        settings.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date

        // Création et configuration du DatePicker
        datePickerNaissance = new DatePicker(settings);
        datePickerNaissance.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePickerNaissance.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte
		panelDatepickerDateDeNaissance.add(datePickerNaissance);

		Panel panelDroitePartieFormulaire = new Panel();
		panelFormulaire.add(panelDroitePartieFormulaire);
		panelDroitePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelLabelsDroite = new JPanel();
		panelDroitePartieFormulaire.add(panelLabelsDroite);
		panelLabelsDroite.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelLabelTelephone = new JPanel();
		FlowLayout flowLayoutLabelTelephone = (FlowLayout) panelLabelTelephone.getLayout();
		flowLayoutLabelTelephone.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelLabelTelephone);

		JLabel labelTelephone = new JLabel("Téléphone :");
		panelLabelTelephone.add(labelTelephone);

		JPanel panelLabelEmail = new JPanel();
		FlowLayout flowLayoutLabelEmail = (FlowLayout) panelLabelEmail.getLayout();
		flowLayoutLabelEmail.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelLabelEmail);

		JLabel labelEmail = new JLabel("Email :");
		panelLabelEmail.add(labelEmail);

		JPanel panelDateEntree = new JPanel();
		FlowLayout flowLayoutDateEntree = (FlowLayout) panelDateEntree.getLayout();
		flowLayoutDateEntree.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelDateEntree);
		
		JLabel labelDateEntree = new JLabel("Date d'entrée :");
		panelDateEntree.add(labelDateEntree);

		JPanel panelTextfieldDroite = new JPanel();
		panelDroitePartieFormulaire.add(panelTextfieldDroite);
		panelTextfieldDroite.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelTextfieldTelephone = new JPanel();
		FlowLayout flowLayoutTextfieldTelephone = (FlowLayout) panelTextfieldTelephone.getLayout();
		flowLayoutTextfieldTelephone.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldTelephone);

		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		panelTextfieldTelephone.add(textFieldTelephone);

		JPanel panelTextfieldEmail = new JPanel();
		FlowLayout flowLayoutTextfieldEmail = (FlowLayout) panelTextfieldEmail.getLayout();
		flowLayoutTextfieldEmail.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		panelTextfieldEmail.add(textFieldEmail); 
		
		JPanel panelDatepickerDateEntree = new JPanel();
		FlowLayout flowLayoutDatepickerDateEntree = (FlowLayout) panelDatepickerDateEntree.getLayout();
		flowLayoutDatepickerDateEntree.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelDatepickerDateEntree);

		
		// Configuration des paramètres du DatePicker
        DatePickerSettings settings2 = new DatePickerSettings();
        settings2.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings2.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date
        // Création et configuration du DatePicker
        datePickerEntree = new DatePicker(settings2);
        datePickerEntree.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePickerEntree.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte
		panelDatepickerDateEntree.add(datePickerEntree);

		// Panel pour le genre
		JPanel panelGenre = new JPanel();
		FlowLayout fl_panelGenre = (FlowLayout) panelGenre.getLayout();
		fl_panelGenre.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelGenre);

		JLabel labelGenre = new JLabel("Genre :");
		panelGenre.add(labelGenre);

		JPanel panelRadioButtonsGenre = new JPanel();
		FlowLayout fl_panelRadioButtonsGenre = (FlowLayout) panelRadioButtonsGenre.getLayout();
		fl_panelRadioButtonsGenre.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelRadioButtonsGenre);

		radioButtonHomme = new JRadioButton("Homme");
		panelRadioButtonsGenre.add(radioButtonHomme);

        JRadioButton radioButtonFemme = new JRadioButton("Femme");
		panelRadioButtonsGenre.add(radioButtonFemme);

		ButtonGroup groupGenre = new ButtonGroup();
		groupGenre.add(radioButtonHomme);
		groupGenre.add(radioButtonFemme);

		// Panel pour le lieu de naissance
		JPanel panelLieuNaissance = new JPanel();
		FlowLayout fl_panelLieuNaissance = (FlowLayout) panelLieuNaissance.getLayout();
		fl_panelLieuNaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLieuNaissance);

		JLabel labelLieuNaissance = new JLabel("Lieu de naissance :");
		panelLieuNaissance.add(labelLieuNaissance);

		JPanel panelTextfieldLieuNaissance = new JPanel();
		FlowLayout fl_panelTextfieldLieuNaissance = (FlowLayout) panelTextfieldLieuNaissance.getLayout();
		fl_panelTextfieldLieuNaissance.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelTextfieldLieuNaissance);

		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setColumns(10);
		panelTextfieldLieuNaissance.add(textFieldLieuNaissance);

		// Panel pour la nationalité
		JPanel panelNationalite = new JPanel();
		FlowLayout fl_panelNationalite = (FlowLayout) panelNationalite.getLayout();
		fl_panelNationalite.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelNationalite);

		JLabel labelNationalite = new JLabel("Nationalité :");
		panelNationalite.add(labelNationalite);

		JPanel panelTextfieldNationalite = new JPanel();
		FlowLayout fl_panelTextfieldNationalite = (FlowLayout) panelTextfieldNationalite.getLayout();
		fl_panelTextfieldNationalite.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldNationalite);

		textFieldNationalite = new JTextField();
		textFieldNationalite.setColumns(10);
		panelTextfieldNationalite.add(textFieldNationalite);

		// Panel pour la profession
		JPanel panelProfession = new JPanel();
		FlowLayout fl_panelProfession = (FlowLayout) panelProfession.getLayout();
		fl_panelProfession.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelProfession);

		JLabel labelProfession = new JLabel("Profession :");
		panelProfession.add(labelProfession);

		JPanel panelTextfieldProfession = new JPanel();
		FlowLayout fl_panelTextfieldProfession = (FlowLayout) panelTextfieldProfession.getLayout();
		fl_panelTextfieldProfession.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldProfession);

		textProfession = new JTextField();
		textProfession.setColumns(10);
		panelTextfieldProfession.add(textProfession);
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	public JRadioButton getRadioButtonHomme() {
		return radioButtonHomme;
	}

	public JTextField getTextFieldLieuNaissance() {
		return textFieldLieuNaissance;
	}

	public JTextField getTextFieldNationalite() {
		return textFieldNationalite;
	}

	public JTextField getTextProfession() {
		return textProfession;
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

	public DatePicker getDatePickerEntree() {
		return datePickerEntree;
	}

}