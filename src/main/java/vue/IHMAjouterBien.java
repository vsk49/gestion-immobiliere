package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.controleurAjoutBien;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class IHMAjouterBien extends JFrame {

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
	 * Create the frame.
	 */
	public IHMAjouterBien() {
		controleurAjoutBien controleur = new controleurAjoutBien();
		setTitle("Ajout de bien");
		this.setSize(600, 400);
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
		
		JLabel labelAjouterBien = new JLabel("Ajouter un bien");
		labelAjouterBien.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelAjouterBien.setHorizontalAlignment(SwingConstants.CENTER);
		panelBody.add(labelAjouterBien, BorderLayout.NORTH);
		
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
		FlowLayout flowLayout = (FlowLayout) panelLabelAdresse.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie1.add(panelLabelAdresse);
		
		JLabel LabelAdresse_1_2 = new JLabel("Adresse :");
		panelLabelAdresse.add(LabelAdresse_1_2);
		
		JPanel panelLabelVille = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelLabelVille.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie1.add(panelLabelVille);
		
		JLabel labelVille_1_2 = new JLabel("Ville :");
		panelLabelVille.add(labelVille_1_2);
		
		JPanel panelLabelCodepostal = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panelLabelCodepostal.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie1.add(panelLabelCodepostal);
		
		JLabel labelCodepostal_1_2 = new JLabel("Code postale :");
		panelLabelCodepostal.add(labelCodepostal_1_2);
		
		JPanel panelLabelEtage = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panelLabelEtage.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie1.add(panelLabelEtage);
		
		JLabel labelEtage_1_2 = new JLabel("Etage :");
		panelLabelEtage.add(labelEtage_1_2);
		
		JPanel panelTextfieldsPartie1 = new JPanel();
		premierePartieFormulaire.add(panelTextfieldsPartie1);
		panelTextfieldsPartie1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTextfieldAdress = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTextfieldAdress.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie1.add(panelTextfieldAdress);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAdresse.setColumns(10);
		panelTextfieldAdress.add(textFieldAdresse);
		
		JPanel panelTextfieldVille = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelTextfieldVille.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie1.add(panelTextfieldVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		panelTextfieldVille.add(textFieldVille);
		
		JPanel panelTextfieldCodepostal = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panelTextfieldCodepostal.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie1.add(panelTextfieldCodepostal);
		
		textFieldCodepostal = new JTextField();
		textFieldCodepostal.setColumns(10);
		panelTextfieldCodepostal.add(textFieldCodepostal);
		
		JPanel panelTextfieldEtage = new JPanel();
		FlowLayout flowLayout_15 = (FlowLayout) panelTextfieldEtage.getLayout();
		flowLayout_15.setAlignment(FlowLayout.LEFT);
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
		FlowLayout flowLayout_7 = (FlowLayout) panelLabelTypedebien.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie2.add(panelLabelTypedebien);
		
		JLabel LabelTypedebien = new JLabel("Type de bien :");
		panelLabelTypedebien.add(LabelTypedebien);
		
		JPanel panelLabelSurface = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panelLabelSurface.getLayout();
		flowLayout_9.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie2.add(panelLabelSurface);
		
		JLabel labelSurface = new JLabel("Surface :");
		panelLabelSurface.add(labelSurface);
		
		JPanel panelLabelNbPieces = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panelLabelNbPieces.getLayout();
		flowLayout_11.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie2.add(panelLabelNbPieces);
		
		JLabel labelNbPieces = new JLabel("Nombre de pièces :");
		panelLabelNbPieces.add(labelNbPieces);
		
		JPanel panelLabelStatut = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panelLabelStatut.getLayout();
		flowLayout_13.setAlignment(FlowLayout.RIGHT);
		panelLabelsPartie2.add(panelLabelStatut);
		
		JLabel labelStatut = new JLabel("Statut :");
		panelLabelStatut.add(labelStatut);
		
		JPanel panelTextfieldsPartie2 = new JPanel();
		deuxiemePartieFormulaire.add(panelTextfieldsPartie2);
		panelTextfieldsPartie2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTextfieldAdresse = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panelTextfieldAdresse.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie2.add(panelTextfieldAdresse);
		
		textFieldTypedebien = new JTextField();
		textFieldTypedebien.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTypedebien.setColumns(10);
		panelTextfieldAdresse.add(textFieldTypedebien);
		
		JPanel panelTextfieldSurface = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panelTextfieldSurface.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie2.add(panelTextfieldSurface);
		
		textFieldSurface = new JTextField();
		textFieldSurface.setColumns(10);
		panelTextfieldSurface.add(textFieldSurface);
		
		JPanel panelTextfieldNbPieces = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panelTextfieldNbPieces.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		panelTextfieldsPartie2.add(panelTextfieldNbPieces);
		
		textFieldNbPieces = new JTextField();
		textFieldNbPieces.setColumns(10);
		panelTextfieldNbPieces.add(textFieldNbPieces);
		
		JPanel panelTextFieldStatut = new JPanel();
		FlowLayout flowLayout_14 = (FlowLayout) panelTextFieldStatut.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
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
		panelChoixLocataire.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel labelChoixLocataire = new JLabel("Ajouter un locataire (facultatif) :");
		labelChoixLocataire.setVerticalAlignment(SwingConstants.BOTTOM);
		panelChoixLocataire.add(labelChoixLocataire);
		labelChoixLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelComboboxLocataire = new JPanel();
		panelChoixLocataire.add(panelComboboxLocataire);
		panelComboboxLocataire.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox ComboboxLocataire = new JComboBox();
		panelComboboxLocataire.add(ComboboxLocataire);
		ComboboxLocataire.setEditable(true);
		
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
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);
	}

}