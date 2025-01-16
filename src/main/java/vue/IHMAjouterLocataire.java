package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import controleur.controleurAjoutLocataire;

public class IHMAjouterLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldNom;
	private final JTextField textFieldPrenom;
	private final DatePicker datePicker;
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

		JLabel labelAjouterBien = new JLabel("Ajouter un locataire");
		labelAjouterBien.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelAjouterBien.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
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
		panelBody.add(labelAjouterBien, BorderLayout.NORTH);

		JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBorder(new EmptyBorder(15, 0, 0, 0));
		panelBody.add(panelFormulaire);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		Panel panelPremierePartieFormulaire = new Panel();
		panelFormulaire.add(panelPremierePartieFormulaire);
		panelPremierePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelLabelsPartie1 = new JPanel();
		panelPremierePartieFormulaire.add(panelLabelsPartie1);
		panelLabelsPartie1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_7 = new JPanel();
		panelLabelsPartie1.add(panel_7);

		JLabel labelNom_1 = new JLabel("Nom :");
		panel_7.add(labelNom_1);

		JPanel panel_8 = new JPanel();
		panelLabelsPartie1.add(panel_8);

		JLabel labelPrenom_1 = new JLabel("Prenom :");
		panel_8.add(labelPrenom_1);

		JPanel panel_9 = new JPanel();
		panelLabelsPartie1.add(panel_9);

		JLabel labelCodePostal_1 = new JLabel("Date de naissance :");
		panel_9.add(labelCodePostal_1);

		JPanel panelTextfieldPartie1 = new JPanel();
		panelPremierePartieFormulaire.add(panelTextfieldPartie1);
		panelTextfieldPartie1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_10 = new JPanel();
		panelTextfieldPartie1.add(panel_10);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		panel_10.add(textFieldNom);

		JPanel panel_11 = new JPanel();
		panelTextfieldPartie1.add(panel_11);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		panel_11.add(textFieldPrenom);

		JPanel panel_12 = new JPanel();
		panelTextfieldPartie1.add(panel_12);

		// Configuration des paramètres du DatePicker
        DatePickerSettings settings = new DatePickerSettings();
        settings.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date

        // Création et configuration du DatePicker
        datePicker = new DatePicker(settings);
        datePicker.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePicker.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte
		panel_12.add(datePicker);

		Panel panelDeuxièmePartieFormulaire = new Panel();
		panelFormulaire.add(panelDeuxièmePartieFormulaire);
		panelDeuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelLabelsPartie2 = new JPanel();
		panelDeuxièmePartieFormulaire.add(panelLabelsPartie2);
		panelLabelsPartie2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelTelephone = new JPanel();
		panelLabelsPartie2.add(panelTelephone);

		JLabel labelTelephone = new JLabel("Téléphone :");
		panelTelephone.add(labelTelephone);

		JPanel panelEmail = new JPanel();
		panelLabelsPartie2.add(panelEmail);

		JLabel labelEmail = new JLabel("Email :");
		panelEmail.add(labelEmail);

		JPanel panelDateEntree = new JPanel();
		panelLabelsPartie2.add(panelDateEntree);
		
		JLabel labelDateEntree = new JLabel("Date d'entrée :");
		panelDateEntree.add(labelDateEntree);

		JPanel panelTextfieldPartie2 = new JPanel();
		panelDeuxièmePartieFormulaire.add(panelTextfieldPartie2);
		panelTextfieldPartie2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelTextfieldTelephone = new JPanel();
		panelTextfieldPartie2.add(panelTextfieldTelephone);

		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		panelTextfieldTelephone.add(textFieldTelephone);

		JPanel panelTextfieldEmail = new JPanel();
		panelTextfieldPartie2.add(panelTextfieldEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		panelTextfieldEmail.add(textFieldEmail); 

		
		// Configuration des paramètres du DatePicker
        DatePickerSettings settings2 = new DatePickerSettings();
        settings2.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings2.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date
        // Création et configuration du DatePicker
        datePickerEntree = new DatePicker(settings2);
        datePickerEntree.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePickerEntree.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte
		panelDateEntree.add(datePickerEntree);
	}

	public Object[] getInformations() {
		return new Object[] {
				this.textFieldNom.getText(),
				this.textFieldPrenom.getText(),
				this.datePicker.getDate(),
				this.textFieldTelephone.getText(),
				this.textFieldEmail.getText(),
				this.datePickerEntree.getDate()
		};
	}

}