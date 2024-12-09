package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.Component;

public class IHMModificationBail extends JFrame {

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
					IHMModificationBail frame = new IHMModificationBail();
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
	public IHMModificationBail() {
		setTitle("Modification d'un bail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		panelGauche.add(BoutonGBiens);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		
		JPanel panelBody = new JPanel();
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		panelBody.add(panelTitre, BorderLayout.NORTH);
		
		JLabel LabelTitre = new JLabel("Modification d'un bail");
		panelTitre.add(LabelTitre);
		
		JPanel panelBoutons = new JPanel();
		panelBody.add(panelBoutons, BorderLayout.SOUTH);
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton ButtonAnnuler = new JButton("Annuler");
		panelBoutons.add(ButtonAnnuler);
		
		JButton ButtonReinitialiser = new JButton("Reinitialiser");
		panelBoutons.add(ButtonReinitialiser);
		
		JButton ButtonValider = new JButton("Valider");
		panelBoutons.add(ButtonValider);
		
		JPanel PanelMain = new JPanel();
		panelBody.add(PanelMain, BorderLayout.CENTER);
		PanelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelBienEtDocuments = new JPanel();
		PanelMain.add(panelBienEtDocuments);
		panelBienEtDocuments.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel PanelBien = new JPanel();
		panelBienEtDocuments.add(PanelBien);
		PanelBien.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTitreAjoutBien = new JPanel();
		PanelBien.add(panelTitreAjoutBien);
		
		JLabel LabelBien = new JLabel("Bien du bail");
		panelTitreAjoutBien.add(LabelBien);
		
		JButton BoutonAjoutNvBien = new JButton("Ajout nouveau bien");
		panelTitreAjoutBien.add(BoutonAjoutNvBien);
		
		JLabel CarteBien = new JLabel("InsertCarteBien");
        CarteBien.setHorizontalAlignment(SwingConstants.CENTER);
		PanelBien.add(CarteBien);
		
		JPanel panelDocuments = new JPanel();
		panelBienEtDocuments.add(panelDocuments);
		panelDocuments.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTitreEtAjoutDocs = new JPanel();
		panelDocuments.add(panelTitreEtAjoutDocs);
		panelTitreEtAjoutDocs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel LabelDocuments = new JLabel("Documents du bail");
		panelTitreEtAjoutDocs.add(LabelDocuments);
		
		JButton btnNewButton = new JButton("Ajout nouveau bail");
		panelTitreEtAjoutDocs.add(btnNewButton);
		
		JPanel panelListeDocuments = new JPanel();
		panelDocuments.add(panelListeDocuments);
		
		JButton ButtonDocumentBail1 = new JButton("Exemple.pdf");
		panelListeDocuments.add(ButtonDocumentBail1);
		
		JPanel panelLocataires = new JPanel();
		PanelMain.add(panelLocataires);
		panelLocataires.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTitreEtAjoutLocataire = new JPanel();
		panelLocataires.add(panelTitreEtAjoutLocataire);
		
		JLabel LabelListeLocataires = new JLabel("Liste des locataires");
		panelTitreEtAjoutLocataire.add(LabelListeLocataires);
		
		JButton BoutonAjoutLocataire = new JButton("Ajouter un locataire");
		panelTitreEtAjoutLocataire.add(BoutonAjoutLocataire);
		
		JPanel panelListeLocataire = new JPanel();
		panelLocataires.add(panelListeLocataire);
		
		tableLocataires = new JTable();
		tableLocataires.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		panelListeLocataire.add(tableLocataires);
	}

}