package vue;

import java.awt.*;
import java.io.Serial;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controleur.ControleurModificationLocataire;
import modele.Locataire;

public class IHMModificationLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldNom;
	private final JTextField textFieldPrenom;
	private final JRadioButton radioButtonHomme;
	private final JRadioButton radioButtonFemme;
	private final DatePicker datePickerNaissance;
	private final JTextField textFieldLieuNaissance;
	private final JTextField textFieldNationalite;
	private final JTextField textFieldProfession;
	private final JTextField textFieldTelephone;
	private final DatePicker datePickerEntree;
	private final JTextField textFieldEmail;

    /**
	 * Create the frame.
	 */
	public IHMModificationLocataire(Locataire locataire) {
        setTitle("Modification du locataire");
		this.setSize(600, 400);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		getContentPane().add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton boutonGestionBiens = new JButton();
		boutonGestionBiens.setIcon(iconeBiens);
		menu.add(boutonGestionBiens);

		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton boutonGestionBaux = new JButton();
		boutonGestionBaux.setIcon(iconeBaux);
		menu.add(boutonGestionBaux);

		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton boutonDeclaration = new JButton();
		boutonDeclaration.setIcon(iconeDeclFisc);
		menu.add(boutonDeclaration);
		
		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton boutonRegularisation = new JButton();
		boutonRegularisation.setIcon(iconeFinances);
		menu.add(boutonRegularisation);
		
		JLabel labelModifierLocataire = new JLabel("Modification du locataire");
		labelModifierLocataire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelModifierLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);
		
		JButton boutonAnnuler = new JButton("Annuler");
		panelbouton.add(boutonAnnuler);
		
		JButton boutonReinitialiser = new JButton("Réinitialiser");
		panelbouton.add(boutonReinitialiser);
		
		JButton boutonValider = new JButton("Valider");
		panelbouton.add(boutonValider);
		
		JPanel panelBody = new JPanel();
		getContentPane().add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);
		panelBody.add(labelModifierLocataire, BorderLayout.NORTH);
		
		JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBorder(new EmptyBorder(15, 0, 0, 0));
		panelBody.add(panelFormulaire);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panelGaucheFormulaire = new Panel();
		panelFormulaire.add(panelGaucheFormulaire);
		panelGaucheFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelLabelsGauche = new JPanel();
		panelGaucheFormulaire.add(panelLabelsGauche);
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
		
		JPanel panelLabelDatenaissance = new JPanel();
		FlowLayout flowLayoutLabelDatenaissance = (FlowLayout) panelLabelDatenaissance.getLayout();
		flowLayoutLabelDatenaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLabelDatenaissance);
		
		JLabel labelDatenaissance = new JLabel("Date de naissance :");
		panelLabelDatenaissance.add(labelDatenaissance);
		
		JPanel panelTextfieldGauche = new JPanel();
		panelGaucheFormulaire.add(panelTextfieldGauche);
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
		
		JPanel paneldatePickerDatenaissance = new JPanel();
		FlowLayout flowLayoutDatepickerDatenaissance = (FlowLayout) paneldatePickerDatenaissance.getLayout();
		flowLayoutDatepickerDatenaissance.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(paneldatePickerDatenaissance);

		// Configuration des paramètres du DatePicker
        DatePickerSettings settings = new DatePickerSettings();
        settings.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date

        // Création et configuration du DatePicker
        datePickerNaissance = new DatePicker(settings);
        datePickerNaissance.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePickerNaissance.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte
		paneldatePickerDatenaissance.add(datePickerNaissance);
		
		Panel panelDroiteFormulaire = new Panel();
		panelFormulaire.add(panelDroiteFormulaire);
		panelDroiteFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelLabelsDroite = new JPanel();
		panelDroiteFormulaire.add(panelLabelsDroite);
		panelLabelsDroite.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTelephone = new JPanel();
		FlowLayout flowLayoutpanelTelephone = (FlowLayout) panelTelephone.getLayout();
		flowLayoutpanelTelephone.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelTelephone);
		
		JLabel labelTelephone = new JLabel("Téléphone :");
		panelTelephone.add(labelTelephone);
		
		JPanel panelEmail = new JPanel();
		FlowLayout flowLayoutpanelEmail = (FlowLayout) panelEmail.getLayout();
		flowLayoutpanelEmail.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelEmail);
		
		JLabel labelEmail = new JLabel("Email :");
		panelEmail.add(labelEmail);

		JPanel panelDateEntree = new JPanel();
		FlowLayout flowLayoutpanelDateEntree = (FlowLayout) panelDateEntree.getLayout();
		flowLayoutpanelDateEntree.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelDateEntree);
		
		JLabel labelDateEntree = new JLabel("Date d'entrée :");
		panelDateEntree.add(labelDateEntree);
		
		JPanel panelTextfieldDroite = new JPanel();
		panelDroiteFormulaire.add(panelTextfieldDroite);
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
		FlowLayout layoutPanelGenre = (FlowLayout) panelGenre.getLayout();
		layoutPanelGenre.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelGenre);

		JLabel labelGenre = new JLabel("Genre :");
		panelGenre.add(labelGenre);

		JPanel panelRadioButtonsGenre = new JPanel();
		FlowLayout layoutPanelRadioButtonGenre = (FlowLayout) panelRadioButtonsGenre.getLayout();
		layoutPanelRadioButtonGenre.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelRadioButtonsGenre);

		radioButtonHomme = new JRadioButton("Homme");
		panelRadioButtonsGenre.add(radioButtonHomme);

		this.radioButtonFemme = new JRadioButton("Femme");
		panelRadioButtonsGenre.add(this.radioButtonFemme);

		ButtonGroup groupGenre = new ButtonGroup();
		groupGenre.add(radioButtonHomme);
		groupGenre.add(radioButtonFemme);

		// Panel pour le lieu de naissance
		JPanel panelLieuNaissance = new JPanel();
		FlowLayout layoutPanelLieuNaissance = (FlowLayout) panelLieuNaissance.getLayout();
		layoutPanelLieuNaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLieuNaissance);

		JLabel labelLieuNaissance = new JLabel("Lieu de naissance :");
		panelLieuNaissance.add(labelLieuNaissance);

		JPanel panelTextfieldLieuNaissance = new JPanel();
		FlowLayout layoutPanelTextFieldLieuNaissance = (FlowLayout) panelTextfieldLieuNaissance.getLayout();
		layoutPanelTextFieldLieuNaissance.setAlignment(FlowLayout.LEFT);
		panelTextfieldGauche.add(panelTextfieldLieuNaissance);

		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setColumns(10);
		panelTextfieldLieuNaissance.add(textFieldLieuNaissance);

		// Panel pour la nationalité
		JPanel panelNationalite = new JPanel();
		FlowLayout layoutPanelNationalite = (FlowLayout) panelNationalite.getLayout();
		layoutPanelNationalite.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelNationalite);

		JLabel labelNationalite = new JLabel("Nationalité :");
		panelNationalite.add(labelNationalite);

		JPanel panelTextfieldNationalite = new JPanel();
		FlowLayout layoutPanelTextFieldNationalite = (FlowLayout) panelTextfieldNationalite.getLayout();
		layoutPanelTextFieldNationalite.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldNationalite);

		textFieldNationalite = new JTextField();
		textFieldNationalite.setColumns(10);
		panelTextfieldNationalite.add(textFieldNationalite);

		// Panel pour la profession
		JPanel panelProfession = new JPanel();
		FlowLayout layoutPanelProfession = (FlowLayout) panelProfession.getLayout();
		layoutPanelProfession.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelProfession);

		JLabel labelProfession = new JLabel("Profession :");
		panelProfession.add(labelProfession);

		JPanel panelTextfieldProfession = new JPanel();
		FlowLayout layoutPanelTextFieldProfession = (FlowLayout) panelTextfieldProfession.getLayout();
		layoutPanelTextFieldProfession.setAlignment(FlowLayout.LEFT);
		panelTextfieldDroite.add(panelTextfieldProfession);

		textFieldProfession = new JTextField();
		textFieldProfession.setColumns(10);
		panelTextfieldProfession.add(textFieldProfession);
		
		ControleurModificationLocataire controleur = new ControleurModificationLocataire(this, locataire);
		boutonGestionBiens.setActionCommand("biens");
		boutonGestionBiens.addActionListener(controleur);
		boutonGestionBaux.setActionCommand("baux");
		boutonGestionBaux.addActionListener(controleur);
		boutonDeclaration.setActionCommand("DeclarationFiscale");
		boutonDeclaration.addActionListener(controleur);
		boutonRegularisation.setActionCommand("RegularisationCharges");
		boutonRegularisation.addActionListener(controleur);
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		boutonReinitialiser.setActionCommand("Reinitialiser");
		boutonReinitialiser.addActionListener(controleur);
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);
	}

	public JTextField getModifPrenom() {
		return this.textFieldPrenom;
	}

	public JTextField getModifNom() {
		return this.textFieldNom;
	}

	public JRadioButton getModifHomme(){
		return this.radioButtonHomme;
	}

	public DatePicker getModifDateNaissance() {
		return this.datePickerNaissance;
	}

	public JTextField getModifTelephone() {
		return this.textFieldTelephone;
	}

	public JTextField getModifEmail() {
		return this.textFieldEmail;
	}

	public DatePicker getModifDateEntree() {
		return this.datePickerEntree;
	}

	public JTextField getModifLieuNaissance() {
		return this.textFieldLieuNaissance;
	}

	public JTextField getModifNationalite() {
		return this.textFieldNationalite;
	}

	public JTextField getModifProfession() {
		return this.textFieldProfession;
	}

	public JRadioButton getModifFemme() {
		return this.radioButtonFemme;
	}

}