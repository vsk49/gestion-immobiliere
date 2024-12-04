package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.JDBCLocataire;

import controleur.controleurDetailsLocataire;
import modele.Locataire;
import vue.IHMGestionLocataires;

public class IHMDetailsLocataire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField saisieModificationNom;
	private JTextField saisieModificationPrenom;
	private JTextField saisieModificationDateNaissance;
	private JTextField saisieModificationTelephone;
	private JTextField saisieModificationEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locataire l1 = new Locataire("DUDU", "Dupont", "Dudule", null,
							LocalDate.of(2004, 4, 9), null, null, null,
							null, null, null, null, 0);
					IHMDetailsLocataire frame = new IHMDetailsLocataire(l1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Locataire locataire;
	private JDBCLocataire daoLoc = new JDBCLocataire();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public IHMDetailsLocataire(Locataire locataire) {
		this.locataire = locataire;
		// this.locataire = daoLoc.getById("DUDU").get();
		setTitle("Détail du locataire");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

		JLabel labelAGEstionLocataire = new JLabel("Gestion du locataire");
		getContentPane().add(labelAGEstionLocataire, BorderLayout.NORTH);
		
		JPanel panelFormulaire = new JPanel();
		getContentPane().add(panelFormulaire, BorderLayout.CENTER);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panelPremièrePartieFormulaire = new Panel();
		panelFormulaire.add(panelPremièrePartieFormulaire);
		panelPremièrePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelNom = new JLabel("Nom :");
		panelPremièrePartieFormulaire.add(labelNom);
		
		saisieModificationNom = new JTextField();
		saisieModificationNom.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieModificationNom);
		
		JLabel labelPrenom = new JLabel("Prenom :");
		panelPremièrePartieFormulaire.add(labelPrenom);
		
		saisieModificationPrenom = new JTextField();
		saisieModificationPrenom.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieModificationPrenom);
		
		JLabel labelDateNaissance = new JLabel("Date de naissance :");
		panelPremièrePartieFormulaire.add(labelDateNaissance);
		
		saisieModificationDateNaissance = new JTextField();
		saisieModificationDateNaissance.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieModificationDateNaissance);
		
		Panel PaneldeuxièmePartieFormulaire = new Panel();
		panelFormulaire.add(PaneldeuxièmePartieFormulaire);
		PaneldeuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelTéléphone = new JLabel("Téléphone :");
		PaneldeuxièmePartieFormulaire.add(labelTéléphone);
		
		saisieModificationTelephone = new JTextField();
		saisieModificationTelephone.setColumns(10);
		PaneldeuxièmePartieFormulaire.add(saisieModificationTelephone);
		
		JLabel labelEmail = new JLabel("Email :");
		PaneldeuxièmePartieFormulaire.add(labelEmail);
		
		saisieModificationEmail = new JTextField();
		saisieModificationEmail.setColumns(10);
		PaneldeuxièmePartieFormulaire.add(saisieModificationEmail);
		
		JPanel panelSelectionBien = new JPanel();
		getContentPane().add(panelSelectionBien, BorderLayout.EAST);
		panelSelectionBien.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelChoixBien = new JLabel("Selectionner un bien :");
		panelSelectionBien.add(labelChoixBien);
		
		JComboBox listeDeroulanteBiens = new JComboBox();
		panelSelectionBien.add(listeDeroulanteBiens);
		
		JLabel labelVide = new JLabel("");
		panelSelectionBien.add(labelVide);
		
		JPanel panelBasDePage = new JPanel();
		getContentPane().add(panelBasDePage, BorderLayout.SOUTH);
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelDocuments = new JPanel();
		panelBasDePage.add(panelDocuments);
		panelDocuments.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDocsLiéAuLocataire = new JLabel("Liste des documents liés au locataire :");
		panelDocuments.add(labelDocsLiéAuLocataire);
		
		JPanel panelFichiers = new JPanel();
		panelDocuments.add(panelFichiers);
		panelFichiers.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelFichierBail = new JLabel("Fichier Bail");
		panelFichiers.add(labelFichierBail);
		
		JLabel labelFeuilleDePaie = new JLabel("Feuille de paie ");
		panelFichiers.add(labelFeuilleDePaie);
		
		JPanel panel_4 = new JPanel();
		panelBasDePage.add(panel_4);

		controleurDetailsLocataire controleur = new controleurDetailsLocataire(this, this.locataire);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(boutonAnnuler);
		boutonAnnuler.addActionListener(controleur);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panel_4.add(BoutonRéinitialiser);
		BoutonRéinitialiser.addActionListener(controleur);
		
		JButton boutonValider = new JButton("Valider");
		panel_4.add(boutonValider);
		boutonValider.addActionListener(controleur);
		
		JPanel menu = new JPanel();
		getContentPane().add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton boutonLocataire = new JButton();
		ImageIcon IconeBoutonLocataire = new ImageIcon("ressources/locataires.png");
		boutonLocataire.setIcon(IconeBoutonLocataire);
		menu.add(boutonLocataire);
		
		JButton boutonBiens = new JButton();
		ImageIcon IconeBoutonBien = new ImageIcon("ressources/biens50.png");
		boutonBiens.setIcon(IconeBoutonBien);
		menu.add(boutonBiens);
		
		JButton boutonBail = new JButton();
		ImageIcon IconeBoutonBail = new ImageIcon("ressources/baux.png");
		boutonBail.setIcon(IconeBoutonBail);
		menu.add(boutonBail);
		
		JButton boutonDéclarationFiscale = new JButton();
		ImageIcon IconeBoutonDéclarationFiscale = new ImageIcon("ressources/declarationFiscale.png");
		boutonDéclarationFiscale.setIcon(IconeBoutonDéclarationFiscale);
		menu.add(boutonDéclarationFiscale);
		
		JButton boutonFinance = new JButton();
		ImageIcon IconeBoutonFinance = new ImageIcon("ressources/finance.png");
		boutonFinance.setIcon(IconeBoutonFinance);
		menu.add(boutonFinance);
	}

	public JTextField getModifPrenom(){
		return this.saisieModificationPrenom;
	}
	public JTextField getModifNom(){
		return this.saisieModificationNom;
	}
	public JTextField getModifDateNaissance(){
		return this.saisieModificationDateNaissance;
	}
	public JTextField getModifTelephone(){
		return this.saisieModificationTelephone;
	}
	public JTextField getModifEmail(){
		return this.saisieModificationEmail;
	}
}
