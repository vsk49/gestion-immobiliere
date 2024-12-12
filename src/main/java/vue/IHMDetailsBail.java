package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.controleurDetailsBail;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import vue.IHMGestionBaux;

public class IHMDetailsBail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableLocataires;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMDetailsBail frame = new IHMDetailsBail();
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
	public IHMDetailsBail() {
		controleurDetailsBail controleur = new controleurDetailsBail();
		setTitle("Détail du bail");
		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 450, 300);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
                vueGestionBaux.setVisible(true);

                dispose();
            }
        });
		
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
		BoutonGLocataires.setActionCommand("locataires");
		BoutonGLocataires.addActionListener(controleur);
		
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		panelGauche.add(BoutonGBiens);
		BoutonGBiens.setActionCommand("biens");
		BoutonGBiens.addActionListener(controleur);
		
		
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
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBouton = new JPanel();
		panelMain.add(panelBouton, BorderLayout.SOUTH);
		
		JButton boutonRetour = new JButton("Retour");
		panelBouton.add(boutonRetour);
		boutonRetour.setActionCommand("Retour");
		boutonRetour.addActionListener(controleur);

		JButton boutonModifier = new JButton("Modifier");
		panelBouton.add(boutonModifier);
		boutonModifier.setActionCommand("Modifier");
		boutonModifier.addActionListener(controleur);
		
		JLabel LabelTitre = new JLabel("Détail du bail");
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelMain.add(LabelTitre, BorderLayout.NORTH);
		
		JPanel panelCenter = new JPanel();
		panelMain.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelBienEtDocuments = new JPanel();
		panelCenter.add(panelBienEtDocuments);
		panelBienEtDocuments.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelBien = new JPanel();
		panelBienEtDocuments.add(panelBien);
		panelBien.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelBien = new JLabel("Le bien");
		LabelBien.setHorizontalAlignment(SwingConstants.CENTER);
		panelBien.add(LabelBien);
		
		JPanel panelBoutonBien = new JPanel();
		panelBien.add(panelBoutonBien);
		
		JButton BoutonBien = new JButton("");
		panelBoutonBien.add(BoutonBien);
		
		JPanel panelDocuments = new JPanel();
		panelBienEtDocuments.add(panelDocuments);
		panelDocuments.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDocuments = new JLabel("Les documents associés à ce bail");
		labelDocuments.setHorizontalAlignment(SwingConstants.CENTER);
		panelDocuments.add(labelDocuments);
		
		JPanel panelBoutonDocuments = new JPanel();
		panelDocuments.add(panelBoutonDocuments);
		
		JButton BoutonDocumentBail = new JButton("Bail.pdf");
		panelBoutonDocuments.add(BoutonDocumentBail);
		
		JButton BoutonDocumentFeuillepaie = new JButton("Feuille de paie.pdf");
		panelBoutonDocuments.add(BoutonDocumentFeuillepaie);
		
		JPanel panelLocataires = new JPanel();
		panelCenter.add(panelLocataires);
		panelLocataires.setLayout(new BorderLayout(0, 0));
		
		JLabel LabelLocataires = new JLabel("Liste des locataires");
		LabelLocataires.setHorizontalAlignment(SwingConstants.CENTER);
		panelLocataires.add(LabelLocataires, BorderLayout.NORTH);
		
		JPanel panelTableLocataires = new JPanel();
		panelLocataires.add(panelTableLocataires, BorderLayout.CENTER);
		
		tableLocataires = new JTable();
		tableLocataires.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nom", "Prenom", "Sexe", "\u00C2ge"},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		panelTableLocataires.add(tableLocataires);
	}
}