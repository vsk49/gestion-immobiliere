package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.controleurDetailsLocataire;
import modele.Genre;
import modele.Locataire;

public class IHMDetailsLocataire extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JLabel labelContenuNom;
	private final JLabel labelContenuPrenom;
	private final JLabel labelContenuGenre;
	private final JLabel labelContenuDateDeNaissance;
	private final JLabel labelContenuLieuNaissance;
	private final JLabel labelContenuNationalite;
	private final JLabel labelContenuProfession;
	private final JLabel labelContenuTelephone;
	private final JLabel labelContenuEmail;
	private final JLabel labelContenuDateEntree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
				Locataire l = new Locataire("DUDU", "Dupont", "Francois", Genre.MASCULIN,
						LocalDate.of(1990, 5, 13), "Toulouse", "Francais",
						"Enseignant", "0123456789", "francois.dupont@gmail.com",
						null, null, 1.0);
                IHMDetailsLocataire frame = new IHMDetailsLocataire(l);
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println("Erreur lors de l'ouverture de la fenêtre de détails du locataire");
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public IHMDetailsLocataire(Locataire locataire) {
        setTitle("Détails du locataire");
		this.setSize(600, 400);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
                vueGestionLocataires.setVisible(true);

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
		
		JLabel labelDetailsLocataire = new JLabel("Détails du locataire ");
		labelDetailsLocataire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelDetailsLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelBasDePage = new JPanel();
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);
		
		JButton boutonRetour = new JButton("Retour");
		panelbouton.add(boutonRetour);
		
		JButton boutonModifier = new JButton("Modifier");
		panelbouton.add(boutonModifier);
		
		JPanel panelBody = new JPanel();
		getContentPane().add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);
		panelBody.add(labelDetailsLocataire, BorderLayout.NORTH);
		
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
		
		JPanel panelNom = new JPanel();
		FlowLayout fl_panelNom = (FlowLayout) panelNom.getLayout();
		fl_panelNom.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelNom);
		
		JLabel labelNom = new JLabel("Nom :");
		panelNom.add(labelNom);
		
		JPanel panelPrenom = new JPanel();
		FlowLayout fl_panelPrenom = (FlowLayout) panelPrenom.getLayout();
		fl_panelPrenom.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelPrenom);
		
		JLabel labelPrenom = new JLabel("Prenom :");
		panelPrenom.add(labelPrenom);
		
		JPanel panelDateDeNaissance = new JPanel();
		FlowLayout fl_panelDateDeNaissance = (FlowLayout) panelDateDeNaissance.getLayout();
		fl_panelDateDeNaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelDateDeNaissance);
		
		JLabel labelCodePostal = new JLabel("Date de naissance :");
		panelDateDeNaissance.add(labelCodePostal);
		
		JPanel panelContenuLabelsGauche = new JPanel();
		panelGaucheFormulaire.add(panelContenuLabelsGauche);
		panelContenuLabelsGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelNom = new JPanel();
		FlowLayout fl_panelLabelNom = (FlowLayout) panelLabelNom.getLayout();
		fl_panelLabelNom.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsGauche.add(panelLabelNom);
		
		this.labelContenuNom = new JLabel("New label");
		labelContenuNom.setHorizontalAlignment(SwingConstants.CENTER);
		panelLabelNom.add(labelContenuNom);
		
		JPanel panelLabelPrenom = new JPanel();
		FlowLayout fl_panelLabelPrenom = (FlowLayout) panelLabelPrenom.getLayout();
		fl_panelLabelPrenom.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsGauche.add(panelLabelPrenom);
		
		this.labelContenuPrenom = new JLabel("New label");
		panelLabelPrenom.add(labelContenuPrenom);
		
		JPanel panelLabelDateDeNaissance = new JPanel();
		FlowLayout fl_panelLabelDateDeNaissance = (FlowLayout) panelLabelDateDeNaissance.getLayout();
		fl_panelLabelDateDeNaissance.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsGauche.add(panelLabelDateDeNaissance);
		
		this.labelContenuDateDeNaissance = new JLabel("New label");
		panelLabelDateDeNaissance.add(labelContenuDateDeNaissance);
		
		Panel panelDroitePartieFormulaire = new Panel();
		panelFormulaire.add(panelDroitePartieFormulaire);
		panelDroitePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelLabelsDroite = new JPanel();
		panelDroitePartieFormulaire.add(panelLabelsDroite);
		panelLabelsDroite.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTelephone = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panelTelephone.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelTelephone);
		
		JLabel labelTelephone = new JLabel("Téléphone :");
		panelTelephone.add(labelTelephone);
		
		JPanel panelEmail = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panelEmail.getLayout();
		flowLayout_8.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelEmail);
		
		JLabel labelEmail = new JLabel("Email :");
		panelEmail.add(labelEmail);

		JPanel panelDateEntree = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panelDateEntree.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelDateEntree);
		
		JLabel labelDateEntree = new JLabel("Date d'entrée :");
		panelDateEntree.add(labelDateEntree);
		
		JPanel panelContenuLabelsDroite = new JPanel();
		panelDroitePartieFormulaire.add(panelContenuLabelsDroite);
		panelContenuLabelsDroite.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelTelephone = new JPanel();
		FlowLayout fl_panelLabelTelephone = (FlowLayout) panelLabelTelephone.getLayout();
		fl_panelLabelTelephone.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsDroite.add(panelLabelTelephone);
		
		this.labelContenuTelephone = new JLabel("New label");
		panelLabelTelephone.add(labelContenuTelephone);
		
		JPanel panelLabelEmail = new JPanel();
		FlowLayout fl_panelLabelEmail = (FlowLayout) panelLabelEmail.getLayout();
		fl_panelLabelEmail.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsDroite.add(panelLabelEmail);
		
		this.labelContenuEmail = new JLabel("New label");
		panelLabelEmail.add(labelContenuEmail);
		
		JPanel panelLabelDateEntree = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panelLabelDateEntree.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsDroite.add(panelLabelDateEntree);
		
		this.labelContenuDateEntree = new JLabel("New label");
		panelLabelDateEntree.add(labelContenuDateEntree);

		// Panel pour le genre
		JPanel panelGenre = new JPanel();
		FlowLayout fl_panelGenre = (FlowLayout) panelGenre.getLayout();
		fl_panelGenre.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelGenre);

		JLabel labelGenre = new JLabel("Genre :");
		panelGenre.add(labelGenre);

		JPanel panelLabelGenre = new JPanel();
		FlowLayout fl_panelLabelGenre = (FlowLayout) panelLabelGenre.getLayout();
		fl_panelLabelGenre.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsGauche.add(panelLabelGenre);

		this.labelContenuGenre = new JLabel("New label");
		panelLabelGenre.add(labelContenuGenre);

		// Panel pour le lieu de naissance
		JPanel panelLieuNaissance = new JPanel();
		FlowLayout fl_panelLieuNaissance = (FlowLayout) panelLieuNaissance.getLayout();
		fl_panelLieuNaissance.setAlignment(FlowLayout.RIGHT);
		panelLabelsGauche.add(panelLieuNaissance);

		JLabel labelLieuNaissance = new JLabel("Lieu de naissance :");
		panelLieuNaissance.add(labelLieuNaissance);

		JPanel panelLabelLieuNaissance = new JPanel();
		FlowLayout fl_panelLabelLieuNaissance = (FlowLayout) panelLabelLieuNaissance.getLayout();
		fl_panelLabelLieuNaissance.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsGauche.add(panelLabelLieuNaissance);

		this.labelContenuLieuNaissance = new JLabel("New label");
		panelLabelLieuNaissance.add(labelContenuLieuNaissance);

		// Panel pour la nationalité
		JPanel panelNationalite = new JPanel();
		FlowLayout fl_panelNationalite = (FlowLayout) panelNationalite.getLayout();
		fl_panelNationalite.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelNationalite);

		JLabel labelNationalite = new JLabel("Nationalité :");
		panelNationalite.add(labelNationalite);

		JPanel panelLabelNationalite = new JPanel();
		FlowLayout fl_panelLabelNationalite = (FlowLayout) panelLabelNationalite.getLayout();
		fl_panelLabelNationalite.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsDroite.add(panelLabelNationalite);

		this.labelContenuNationalite = new JLabel("New label");
		panelLabelNationalite.add(labelContenuNationalite);

		// Panel pour la profession
		JPanel panelProfession = new JPanel();
		FlowLayout fl_panelProfession = (FlowLayout) panelProfession.getLayout();
		fl_panelProfession.setAlignment(FlowLayout.RIGHT);
		panelLabelsDroite.add(panelProfession);

		JLabel labelProfession = new JLabel("Profession :");
		panelProfession.add(labelProfession);

		JPanel panelLabelProfession = new JPanel();
		FlowLayout fl_panelLabelProfession = (FlowLayout) panelLabelProfession.getLayout();
		fl_panelLabelProfession.setAlignment(FlowLayout.LEFT);
		panelContenuLabelsDroite.add(panelLabelProfession);

		this.labelContenuProfession = new JLabel("New label");
		panelLabelProfession.add(labelContenuProfession);

        controleurDetailsLocataire controleur = new controleurDetailsLocataire(this, locataire);
		boutonModifier.setActionCommand("Modifier");
		boutonModifier.addActionListener(controleur);
		boutonRetour.setActionCommand("Retour");
		boutonRetour.addActionListener(controleur);
		BoutonGBiens.setActionCommand("biens");
		BoutonGBiens.addActionListener(controleur);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);
		BoutonGDeclFisc.setActionCommand("declarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);
		BoutonGFinances.setActionCommand("finances");
		BoutonGFinances.addActionListener(controleur);
	}
	
	public JLabel getModifPrenom() {
		return this.labelContenuPrenom;
	}
	
	public JLabel getModifNom(){
		return this.labelContenuNom;
	}
	
	public JLabel getModifDateNaissance(){
		return this.labelContenuDateDeNaissance;
	}
	
	public JLabel getModifTelephone(){
		return this.labelContenuTelephone;
	}

	public JLabel getModifEmail(){
		return this.labelContenuEmail;
	}

	public JLabel getModifDateEntree(){
		return this.labelContenuDateEntree;
	}

	public JLabel getModifGenre(){
		return this.labelContenuGenre;
	}

	public JLabel getModifLieuNaissance(){
		return this.labelContenuLieuNaissance;
	}

	public JLabel getModifNationalite(){
		return this.labelContenuNationalite;
	}

	public JLabel getModifProfession(){
		return this.labelContenuProfession;
	}
	
}