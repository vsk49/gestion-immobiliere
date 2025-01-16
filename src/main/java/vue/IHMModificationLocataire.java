package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.Serial;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controleur.controleurModificationLocataire;
import modele.Locataire;

public class IHMModificationLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldNom;
	private final JTextField textFieldPrenom;
	private final DatePicker datePickerNaissance;
	private final JTextField textFieldTelephone;
	private final DatePicker datePickerEntree;
	private final JTextField textFieldEmail;

	//public static void main(String[] args) {
	//	EventQueue.invokeLater(() -> {
    //        try {
	//	 			Locataire l = new Locataire("DUDU", "Dupont", "Francois", Genre.MASCULIN,
	//				LocalDate.of(1990, 5, 13), "Toulouse", "Francais",
	//				"Enseignant", "0123456789", "francois.dupont@gmail.com",
 	//				null, null, 1.0);
    //            IHMModificationLocataire frame = new IHMModificationLocataire(l);
    //            frame.setVisible(true);
    //        } catch (Exception e) {
    //            System.out.println("Erreur lors de l'ouverture de la fenêtre de modification d'un locataire");
    //        }
    //    });
	//}

    /**
	 * Create the frame.
	 */
	public IHMModificationLocataire(Locataire locataire) {
        setTitle("Modification du locataire");
		this.setSize(600, 400);
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

		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		menu.add(BoutonGBaux);

		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		menu.add(BoutonGDeclFisc);
		
		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		menu.add(BoutonGFinances);
		
		JLabel labelModifierLocataire = new JLabel("Modification du locataire");
		labelModifierLocataire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelModifierLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);
		
		JButton boutonAnnuler = new JButton("Annuler");
		panelbouton.add(boutonAnnuler);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panelbouton.add(BoutonRéinitialiser);
		
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
		
		controleurModificationLocataire controleur = new controleurModificationLocataire(this, locataire);
		BoutonGBiens.setActionCommand("biens");
		BoutonGBiens.addActionListener(controleur);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);
		BoutonGDeclFisc.setActionCommand("DeclarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		BoutonRéinitialiser.setActionCommand("Reinitialiser");
		BoutonRéinitialiser.addActionListener(controleur);
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);
	}

	public JTextField getModifPrenom() {
		return this.textFieldPrenom;
	}
	public JTextField getModifNom(){
		return this.textFieldNom;
	}
	public DatePicker getModifDateNaissance(){
		return this.datePickerNaissance;
	}
	public JTextField getModifTelephone(){
		return this.textFieldTelephone;
	}
	public JTextField getModifEmail(){
		return this.textFieldEmail;
	}

	public DatePicker getModifDateEntree() {
		return this.datePickerEntree;
	}
}