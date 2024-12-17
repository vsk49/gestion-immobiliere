package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controleur.controleurModificationLocataire;
import modele.Genre;
import modele.Locataire;
import vue.IHMDetailsLocataire;

public class IHMModificationLocataire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldTelephone;
	private JTextField textFieldEmail;
	private Locataire locataire;
	private controleurModificationLocataire controleur;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locataire loc = new Locataire("DUDU", "Dupont", "Francois", Genre.MASCULIN, LocalDate.of(1990, 10, 07), "Tls", "Fr", "Professeur", "06 06 06 06 06", "fr.dupont@gmail.com", LocalDate.now(), null, 1);
					IHMModificationLocataire frame = new IHMModificationLocataire(loc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IHMModificationLocataire(Locataire locataire) {
		this.locataire = locataire;
		setTitle("Modification du locataire");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IHMDetailsLocataire vueDetailLocataire = new IHMDetailsLocataire(this.locataire);
                vueDetailLocataire.setVisible(true);

                dispose();
            }
        });
		
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
		
		JPanel panelBienEtDocuments = new JPanel();
		panelBienEtDocuments.setBorder(new EmptyBorder(5, 0, 0, 0));
		panelBasDePage.add(panelBienEtDocuments);
		panelBienEtDocuments.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelChoixBien = new JPanel();
		panelChoixBien.setBorder(new EmptyBorder(0, 5, 0, 0));
		panelBienEtDocuments.add(panelChoixBien);
		panelChoixBien.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelLabelBien = new JPanel();
		FlowLayout fl_panelLabelBien = (FlowLayout) panelLabelBien.getLayout();
		panelChoixBien.add(panelLabelBien);
		
		JLabel labelChoixBien = new JLabel("Selectionner un bien :");
		panelLabelBien.add(labelChoixBien);
		
		JPanel panelComboboxBien = new JPanel();
		FlowLayout fl_panelComboboxBien = (FlowLayout) panelComboboxBien.getLayout();
		panelChoixBien.add(panelComboboxBien);
		
		JComboBox comboBoxBien = new JComboBox();
		panelComboboxBien.add(comboBoxBien);
		
		JPanel panelFichierDocuments = new JPanel();
		panelBienEtDocuments.add(panelFichierDocuments);
		panelFichierDocuments.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelEtAjoutDocuments = new JPanel();
		panelFichierDocuments.add(panelLabelEtAjoutDocuments);
		
		JLabel LabelAjoutDocument = new JLabel("Documents location");
		panelLabelEtAjoutDocuments.add(LabelAjoutDocument);
		
		JButton BoutonAjouterDocuments = new JButton("Ajouter un document");
		panelLabelEtAjoutDocuments.add(BoutonAjouterDocuments);
		
		JPanel panelListeDocuments = new JPanel();
		panelFichierDocuments.add(panelListeDocuments);
		
		JButton BoutonDocumentExemple = new JButton("Exemple.pdf");
		panelListeDocuments.add(BoutonDocumentExemple);
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);
		
		JButton boutonAnnuler = new JButton("Annuler");
		panelbouton.add(boutonAnnuler);
		
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
		
		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setColumns(10);
		panel_12.add(textFieldDateNaissance);
		
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
		
		this.controleur = new controleurModificationLocataire(this, this.locataire);
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
		boutonAnnuler.setActionCommand("Valider");
		boutonAnnuler.addActionListener(controleur);
	}

	public JTextField getModifPrenom() {
		return this.textFieldPrenom;
	}
	public JTextField getModifNom(){
		return this.textFieldNom;
	}
	public JTextField getModifDateNaissance(){
		return this.textFieldDateNaissance;
	}
	public JTextField getModifTelephone(){
		return this.textFieldTelephone;
	}
	public JTextField getModifEmail(){
		return this.textFieldEmail;
	}

}