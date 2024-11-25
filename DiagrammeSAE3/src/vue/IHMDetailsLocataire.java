package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IHMDetailsLocataire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField saisieModificationNom;
	private JTextField saisieModificationPrenom;
	private JTextField saisieModificationCodePostal;
	private JTextField saisieModificationTelephone;
	private JTextField saisieModificationEmail;
	private JTextField saisieModificationAncienneAdresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMDetailsLocataire frame = new IHMDetailsLocataire();
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
	public IHMDetailsLocataire() {
		setTitle("Page de détail du locataire");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
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
		
		JLabel labelCodePostal = new JLabel("Date de naissance :");
		panelPremièrePartieFormulaire.add(labelCodePostal);
		
		saisieModificationCodePostal = new JTextField();
		saisieModificationCodePostal.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieModificationCodePostal);
		
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
		
		JLabel labelAncienneAdresse = new JLabel("Ancienne adresse :");
		PaneldeuxièmePartieFormulaire.add(labelAncienneAdresse);
		
		saisieModificationAncienneAdresse = new JTextField();
		saisieModificationAncienneAdresse.setColumns(10);
		PaneldeuxièmePartieFormulaire.add(saisieModificationAncienneAdresse);
		
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
		
		JPanel panelBoutons = new JPanel();
		panelBasDePage.add(panelBoutons);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBoutons.add(boutonAnnuler);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panelBoutons.add(BoutonRéinitialiser);
		
		JButton boutonValider = new JButton("Valider");
		panelBoutons.add(boutonValider);
		
		JPanel menu = new JPanel();
		getContentPane().add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imageLocataire = new JLabel("image Locataire");
		menu.add(imageLocataire);
		
		JLabel imageBien = new JLabel("Image Bien");
		menu.add(imageBien);
		
		JLabel ImageBaux = new JLabel("Image Baux");
		menu.add(ImageBaux);
		
		JLabel ImageDéclarationFiscale = new JLabel("Image Déclaration Fiscale");
		menu.add(ImageDéclarationFiscale);
		
		JLabel ImageFinance = new JLabel("Image Finance");
		menu.add(ImageFinance);
	}

}
