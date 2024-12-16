package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

import controleur.controleurModificationBien;

public class IHMModificationBien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldAdresse;
	private JTextField textFieldVille;
	private JTextField textFieldCodepostal;
	private JTextField textFieldEtage;
	private JTextField textFieldTypedebien;
	private JTextField textFieldSurface;
	private JTextField textFieldNbPieces;
	private JTextField textFieldStatut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMModificationBien frame = new IHMModificationBien();
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
	public IHMModificationBien() {
		controleurModificationBien controleur = new controleurModificationBien(this);
		setTitle("Modification du bien");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 10));
		getContentPane().add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		BoutonGLocataires.setActionCommand("locataires");
		BoutonGLocataires.addActionListener(controleur);
		
		
		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panelGauche.add(BoutonGBaux);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);
		BoutonGDeclFisc.setActionCommand("DeclarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);
		
		JPanel panelBody = new JPanel();
		getContentPane().add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JLabel labelModifierBien = new JLabel("Modification du bien");
		labelModifierBien.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelModifierBien.setHorizontalAlignment(SwingConstants.CENTER);
		panelBody.add(labelModifierBien, BorderLayout.NORTH);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBody.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelFormulaire = new JPanel();
		panelCentre.add(panelFormulaire);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel premierePartieFormulaire = new Panel();
		panelFormulaire.add(premierePartieFormulaire);
		premierePartieFormulaire.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelLabelsPartie1 = new JPanel();
		premierePartieFormulaire.add(panelLabelsPartie1);
		panelLabelsPartie1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelAdresse = new JPanel();
		panelLabelsPartie1.add(panelLabelAdresse);
		
		JLabel LabelAdresse_1_2 = new JLabel("Adresse :");
		panelLabelAdresse.add(LabelAdresse_1_2);
		
		JPanel panelLabelVille = new JPanel();
		panelLabelsPartie1.add(panelLabelVille);
		
		JLabel labelVille_1_2 = new JLabel("Ville :");
		panelLabelVille.add(labelVille_1_2);
		
		JPanel panelLabelCodepostal = new JPanel();
		panelLabelsPartie1.add(panelLabelCodepostal);
		
		JLabel labelCodepostal_1_2 = new JLabel("Code postale :");
		panelLabelCodepostal.add(labelCodepostal_1_2);
		
		JPanel panelLabelEtage = new JPanel();
		panelLabelsPartie1.add(panelLabelEtage);
		
		JLabel labelEtage_1_2 = new JLabel("Etage :");
		panelLabelEtage.add(labelEtage_1_2);
		
		JPanel panelTextfieldsPartie1 = new JPanel();
		premierePartieFormulaire.add(panelTextfieldsPartie1);
		panelTextfieldsPartie1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTextfieldAdress = new JPanel();
		panelTextfieldsPartie1.add(panelTextfieldAdress);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAdresse.setColumns(10);
		panelTextfieldAdress.add(textFieldAdresse);
		
		JPanel panelTextfieldVille = new JPanel();
		panelTextfieldsPartie1.add(panelTextfieldVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		panelTextfieldVille.add(textFieldVille);
		
		JPanel panelTextfieldCodepostal = new JPanel();
		panelTextfieldsPartie1.add(panelTextfieldCodepostal);
		
		textFieldCodepostal = new JTextField();
		textFieldCodepostal.setColumns(10);
		panelTextfieldCodepostal.add(textFieldCodepostal);
		
		JPanel panelTextfieldEtage = new JPanel();
		panelTextfieldsPartie1.add(panelTextfieldEtage);
		
		textFieldEtage = new JTextField();
		textFieldEtage.setColumns(10);
		panelTextfieldEtage.add(textFieldEtage);
		
		Panel deuxiemePartieFormulaire = new Panel();
		panelFormulaire.add(deuxiemePartieFormulaire);
		deuxiemePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelLabelsPartie2 = new JPanel();
		deuxiemePartieFormulaire.add(panelLabelsPartie2);
		panelLabelsPartie2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelTypedebien = new JPanel();
		panelLabelsPartie2.add(panelLabelTypedebien);
		
		JLabel LabelTypedebien = new JLabel("Type de bien :");
		panelLabelTypedebien.add(LabelTypedebien);
		
		JPanel panelLabelSurface = new JPanel();
		panelLabelsPartie2.add(panelLabelSurface);
		
		JLabel labelSurface = new JLabel("Surface :");
		panelLabelSurface.add(labelSurface);
		
		JPanel panelLabelNbPieces = new JPanel();
		panelLabelsPartie2.add(panelLabelNbPieces);
		
		JLabel labelNbPieces = new JLabel("Nombre de pièces :");
		panelLabelNbPieces.add(labelNbPieces);
		
		JPanel panelLabelStatut = new JPanel();
		panelLabelsPartie2.add(panelLabelStatut);
		
		JLabel labelStatut = new JLabel("Statut :");
		panelLabelStatut.add(labelStatut);
		
		JPanel panelTextfieldsPartie2 = new JPanel();
		deuxiemePartieFormulaire.add(panelTextfieldsPartie2);
		panelTextfieldsPartie2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTextfieldAdresse = new JPanel();
		panelTextfieldsPartie2.add(panelTextfieldAdresse);
		
		textFieldTypedebien = new JTextField();
		textFieldTypedebien.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTypedebien.setColumns(10);
		panelTextfieldAdresse.add(textFieldTypedebien);
		
		JPanel panelTextfieldSurface = new JPanel();
		panelTextfieldsPartie2.add(panelTextfieldSurface);
		
		textFieldSurface = new JTextField();
		textFieldSurface.setColumns(10);
		panelTextfieldSurface.add(textFieldSurface);
		
		JPanel panelTextfieldNbPieces = new JPanel();
		panelTextfieldsPartie2.add(panelTextfieldNbPieces);
		
		textFieldNbPieces = new JTextField();
		textFieldNbPieces.setColumns(10);
		panelTextfieldNbPieces.add(textFieldNbPieces);
		
		JPanel panelTextFieldStatut = new JPanel();
		panelTextfieldsPartie2.add(panelTextFieldStatut);
		
		textFieldStatut = new JTextField();
		textFieldStatut.setColumns(10);
		panelTextFieldStatut.add(textFieldStatut);
		
		JPanel panelBasDePage = new JPanel();
		panelCentre.add(panelBasDePage);
		panelBasDePage.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelChoixLocataire = new JPanel();
		panelChoixLocataire.setBorder(new EmptyBorder(0, 5, 0, 0));
		panelBasDePage.add(panelChoixLocataire);
		panelChoixLocataire.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel labelChoixLocataire = new JLabel("Ajouter un locataire (facultatif) :");
		panelChoixLocataire.add(labelChoixLocataire);
		
		JPanel panelComboboxLocataire = new JPanel();
		FlowLayout fl_panelComboboxLocataire = (FlowLayout) panelComboboxLocataire.getLayout();
		fl_panelComboboxLocataire.setHgap(0);
		fl_panelComboboxLocataire.setAlignment(FlowLayout.LEFT);
		panelChoixLocataire.add(panelComboboxLocataire);
		
		JComboBox ComboboxLocataire = new JComboBox();
		ComboboxLocataire.setEditable(true);
		panelComboboxLocataire.add(ComboboxLocataire);
		
		JPanel panelDocuments = new JPanel();
		panelDocuments.setBorder(new EmptyBorder(0, 5, 0, 0));
		panelBasDePage.add(panelDocuments);
		panelDocuments.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDocsLieAuBien = new JLabel("Liste des documents liés aux biens :");
		panelDocuments.add(labelDocsLieAuBien);
		
		JPanel panelFichiers = new JPanel();
		panelDocuments.add(panelFichiers);
		panelFichiers.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton BoutonDocExemple1 = new JButton("Exemple.pdf");
		panelFichiers.add(BoutonDocExemple1);
		
		JPanel panelBoutons = new JPanel();
		panelBoutons.setBorder(new EmptyBorder(10, 0, 0, 0));
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		panelBody.add(panelBoutons, BorderLayout.SOUTH);
		
		JButton boutonAnnuler = new JButton("Annuler");
		panelBoutons.add(boutonAnnuler);
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panelBoutons.add(BoutonRéinitialiser);
		
		JButton boutonValider = new JButton("Valider");
		panelBoutons.add(boutonValider);
		boutonAnnuler.setActionCommand("Valider");
		boutonAnnuler.addActionListener(controleur);
	}

}