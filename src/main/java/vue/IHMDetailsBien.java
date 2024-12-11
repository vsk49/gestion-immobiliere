package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class IHMDetailsBien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable tableLocataires;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMDetailsBien frame = new IHMDetailsBien();
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
	public IHMDetailsBien() {
		setTitle("Détail du bien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		
		
		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panelGauche.add(BoutonGBaux);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFormulaire = new JPanel();
		panelMain.add(panelFormulaire, BorderLayout.NORTH);
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
		
		JPanel panelLabelValeurPartie1 = new JPanel();
		premierePartieFormulaire.add(panelLabelValeurPartie1);
		panelLabelValeurPartie1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelValeurAdresse = new JPanel();
		panelLabelValeurPartie1.add(panelLabelValeurAdresse);
		
		JLabel LabelValeurAdresse = new JLabel("");
		panelLabelValeurAdresse.add(LabelValeurAdresse);
		
		JPanel panelLabelValeurVille = new JPanel();
		panelLabelValeurPartie1.add(panelLabelValeurVille);
		
		JLabel LabelValeurVille = new JLabel("");
		panelLabelValeurVille.add(LabelValeurVille);
		
		JPanel panelLabelValeurCodepostal = new JPanel();
		panelLabelValeurPartie1.add(panelLabelValeurCodepostal);
		
		JLabel LabelValeurCodepostal = new JLabel("");
		panelLabelValeurCodepostal.add(LabelValeurCodepostal);
		
		JPanel panelLabelValeurEtage = new JPanel();
		panelLabelValeurPartie1.add(panelLabelValeurEtage);
		
		JLabel LabelValeurEtage = new JLabel("");
		panelLabelValeurEtage.add(LabelValeurEtage);
		
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
		
		JPanel panelLabelValeurPartie2 = new JPanel();
		deuxiemePartieFormulaire.add(panelLabelValeurPartie2);
		panelLabelValeurPartie2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelLabelValeurTypedebien = new JPanel();
		panelLabelValeurPartie2.add(panelLabelValeurTypedebien);
		
		JLabel LabelValeurTypedebien = new JLabel("");
		panelLabelValeurTypedebien.add(LabelValeurTypedebien);
		
		JPanel panelLabelValeurSurface = new JPanel();
		panelLabelValeurPartie2.add(panelLabelValeurSurface);
		
		JLabel LabelValeurSurface = new JLabel("");
		panelLabelValeurSurface.add(LabelValeurSurface);
		
		JPanel panelLabelValeurNbPieces = new JPanel();
		panelLabelValeurPartie2.add(panelLabelValeurNbPieces);
		
		JLabel LabelValeurNbPieces = new JLabel("");
		panelLabelValeurNbPieces.add(LabelValeurNbPieces);
		
		JPanel panelLabelValeurStatut = new JPanel();
		panelLabelValeurPartie2.add(panelLabelValeurStatut);
		
		JLabel LabelValeurStatut = new JLabel("");
		panelLabelValeurStatut.add(LabelValeurStatut);
		
		JPanel panelDocsEtLocataires = new JPanel();
		panelDocsEtLocataires.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelMain.add(panelDocsEtLocataires, BorderLayout.CENTER);
		panelDocsEtLocataires.setLayout(new BorderLayout(0, 0));
		
		JPanel panelListeLocataire = new JPanel();
		panelListeLocataire.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelDocsEtLocataires.add(panelListeLocataire, BorderLayout.WEST);
		panelListeLocataire.setLayout(new BorderLayout(0, 0));
		
		JLabel LabelLocataire = new JLabel("Liste des locataires :");
		LabelLocataire.setVerticalAlignment(SwingConstants.BOTTOM);
		panelListeLocataire.add(LabelLocataire, BorderLayout.NORTH);
		
		tableLocataires = new JTable();
		tableLocataires.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		panelListeLocataire.add(tableLocataires);
		
		JPanel panelDocuments_1 = new JPanel();
		panelDocuments_1.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelDocsEtLocataires.add(panelDocuments_1, BorderLayout.EAST);
		panelDocuments_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDocsLieAuBien_1 = new JLabel("Liste des documents liés aux biens :");
		labelDocsLieAuBien_1.setVerticalAlignment(SwingConstants.BOTTOM);
		labelDocsLieAuBien_1.setHorizontalAlignment(SwingConstants.LEFT);
		panelDocuments_1.add(labelDocsLieAuBien_1);
		
		JPanel panelListeDocuments_1 = new JPanel();
		panelDocuments_1.add(panelListeDocuments_1);
		panelListeDocuments_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNewButton_2 = new JButton("Exemple1.pdf");
		panelListeDocuments_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Exemple2.pdf");
		panelListeDocuments_1.add(btnNewButton_1_1);
		
		JPanel panelBouton = new JPanel();
		panelMain.add(panelBouton, BorderLayout.SOUTH);
		
		JButton boutonRetour = new JButton("Retour");
		panelBouton.add(boutonRetour);
		
		JButton boutonModifier = new JButton("Modifier");
		panelBouton.add(boutonModifier);
	}

}