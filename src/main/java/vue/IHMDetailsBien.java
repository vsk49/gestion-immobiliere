package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.JLabel;
import java.io.Serial;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import controleur.ControleurDetailsBiens;
import modele.BienImmobilier;

public class IHMDetailsBien extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JLabel labelAdresse;
	private final JLabel labelCodePostal;
	private final JLabel labelVille;
	private final JLabel labelEtage;
	private final JLabel labelTypeBien;
	private final JLabel labelSurface;
	private final JLabel labelNbPieces;
	private final JLabel labelStatut;

	public IHMDetailsBien(BienImmobilier bien) {
		setTitle("Détail du bien");
		this.setSize(600, 400);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
				vueGestionBiens.setVisible(true);
				dispose();
			}
		});

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));

		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton boutonLocataires = new JButton();
		boutonLocataires.setIcon(iconeLocataires);
		panelGauche.add(boutonLocataires);

		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton boutonBaux = new JButton();
		boutonBaux.setIcon(iconeBaux);
		panelGauche.add(boutonBaux);

		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton boutonDeclFisc = new JButton();
		boutonDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(boutonDeclFisc);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton boutonFinances = new JButton();
		boutonFinances.setIcon(iconeFinances);
		panelGauche.add(boutonFinances);

		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));

		JPanel panelFormulaire = new JPanel();
		panelMain.add(panelFormulaire, BorderLayout.NORTH);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		this.labelAdresse = new JLabel("Adresse: ");
		panelFormulaire.add(labelAdresse);

		this.labelCodePostal = new JLabel("Code postal: ");
		panelFormulaire.add(labelCodePostal);

		this.labelVille = new JLabel("Ville: ");
		panelFormulaire.add(labelVille);

		this.labelEtage = new JLabel("Etage: ");
		panelFormulaire.add(labelEtage);

		this.labelTypeBien = new JLabel("Type de bien: ");
		panelFormulaire.add(labelTypeBien);

		this.labelSurface = new JLabel("Surface: ");
		panelFormulaire.add(labelSurface);

		this.labelNbPieces = new JLabel("Nombre de pièces: ");
		panelFormulaire.add(labelNbPieces);

		this.labelStatut = new JLabel("Statut: ");
		panelFormulaire.add(labelStatut);

		JPanel panelDocsEtLocataires = new JPanel();
		panelDocsEtLocataires.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelMain.add(panelDocsEtLocataires, BorderLayout.CENTER);
		panelDocsEtLocataires.setLayout(new BorderLayout(0, 0));

		JPanel panelListeLocataire = new JPanel();
		panelListeLocataire.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelDocsEtLocataires.add(panelListeLocataire, BorderLayout.WEST);
		panelListeLocataire.setLayout(new BorderLayout(0, 0));

		JLabel labelLocataire = new JLabel("Liste des locataires :");
		labelLocataire.setVerticalAlignment(SwingConstants.BOTTOM);
		panelListeLocataire.add(labelLocataire, BorderLayout.NORTH);

		JTable tableLocataires = new JTable();
		tableLocataires.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
				},
				new String[] {
						"New column", "New colum", "New colun", "New olumn"
				}
		));
		panelListeLocataire.add(tableLocataires);

		JPanel panelDocuments = new JPanel();
		panelDocuments.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelDocsEtLocataires.add(panelDocuments, BorderLayout.EAST);
		panelDocuments.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel labelDocsLieAuBien = new JLabel("Liste des documents liés aux biens :");
		labelDocsLieAuBien.setVerticalAlignment(SwingConstants.BOTTOM);
		labelDocsLieAuBien.setHorizontalAlignment(SwingConstants.LEFT);
		panelDocuments.add(labelDocsLieAuBien);

		JPanel panelListeDocuments = new JPanel();
		panelDocuments.add(panelListeDocuments);
		panelListeDocuments.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnExemple1 = new JButton("Exemple1.pdf");
		panelListeDocuments.add(btnExemple1);

		JButton btnExemple2 = new JButton("Exemple2.pdf");
		panelListeDocuments.add(btnExemple2);

		JPanel panelBouton = new JPanel();
		panelMain.add(panelBouton, BorderLayout.SOUTH);

		JButton boutonRetour = new JButton("Retour");
		panelBouton.add(boutonRetour);

		JButton boutonModifier = new JButton("Modifier");
		panelBouton.add(boutonModifier);

		ControleurDetailsBiens controleur = new ControleurDetailsBiens(this, bien);

		boutonLocataires.setActionCommand("locataires");
		boutonLocataires.addActionListener(controleur);

		boutonBaux.setActionCommand("baux");
		boutonBaux.addActionListener(controleur);

		boutonDeclFisc.setActionCommand("DeclarationFiscale");
		boutonDeclFisc.addActionListener(controleur);

		boutonFinances.setActionCommand("RegularisationCharges");
		boutonFinances.addActionListener(controleur);

		boutonRetour.setActionCommand("Retour");
		boutonRetour.addActionListener(controleur);

		boutonModifier.setActionCommand("Modifier");
		boutonModifier.addActionListener(controleur);
	}

	public JLabel getLabelAdresse() {
		return this.labelAdresse;
	}

	public JLabel getLabelCodePostal() {
		return this.labelCodePostal;
	}

	public JLabel getLabelVille() {
		return this.labelVille;
	}

	public JLabel getLabelEtage() {
		return this.labelEtage;
	}

	public JLabel getLabelTypeBien() {
		return this.labelTypeBien;
	}

	public JLabel getLabelSurface() {
		return this.labelSurface;
	}

	public JLabel getLabelNbPieces() {
		return this.labelNbPieces;
	}

	public JLabel getLabelStatut() {
		return this.labelStatut;
	}

}