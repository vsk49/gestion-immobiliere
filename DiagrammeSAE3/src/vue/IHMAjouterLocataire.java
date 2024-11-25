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
import javax.swing.border.EmptyBorder;

public class IHMAjouterLocataire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField saisieNom;
	private JTextField saisiePrenom;
	private JTextField saisieDateDeNaissance;
	private JTextField saisieTelephone;
	private JTextField saisieEmail;
	private JTextField saisieAncienneAdresse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMAjouterLocataire frame = new IHMAjouterLocataire();
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
	public IHMAjouterLocataire() {
		setTitle("Page d'ajout de locataire");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
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
		
		JLabel labelAjouterBien = new JLabel("Ajouter un locataire");
		getContentPane().add(labelAjouterBien, BorderLayout.NORTH);
		
		JPanel panelFormulaire = new JPanel();
		getContentPane().add(panelFormulaire, BorderLayout.CENTER);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panelPremièrePartieFormulaire = new Panel();
		panelFormulaire.add(panelPremièrePartieFormulaire);
		panelPremièrePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelNom = new JLabel("Nom :");
		panelPremièrePartieFormulaire.add(labelNom);
		
		saisieNom = new JTextField();
		saisieNom.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieNom);
		
		JLabel labelPrenom = new JLabel("Prenom :");
		panelPremièrePartieFormulaire.add(labelPrenom);
		
		saisiePrenom = new JTextField();
		saisiePrenom.setColumns(10);
		panelPremièrePartieFormulaire.add(saisiePrenom);
		
		JLabel labelCodePostal = new JLabel("Date de naissance :");
		panelPremièrePartieFormulaire.add(labelCodePostal);
		
		saisieDateDeNaissance = new JTextField();
		saisieDateDeNaissance.setColumns(10);
		panelPremièrePartieFormulaire.add(saisieDateDeNaissance);
		
		Panel panelDeuxièmePartieFormulaire = new Panel();
		panelFormulaire.add(panelDeuxièmePartieFormulaire);
		panelDeuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelTelephone = new JLabel("Téléphone :");
		panelDeuxièmePartieFormulaire.add(labelTelephone);
		
		saisieTelephone = new JTextField();
		saisieTelephone.setColumns(10);
		panelDeuxièmePartieFormulaire.add(saisieTelephone);
		
		JLabel labelEmail = new JLabel("Email :");
		panelDeuxièmePartieFormulaire.add(labelEmail);
		
		saisieEmail = new JTextField();
		saisieEmail.setColumns(10);
		panelDeuxièmePartieFormulaire.add(saisieEmail);
		
		JLabel labelAncienneAdresse = new JLabel("Ancienne adresse :");
		panelDeuxièmePartieFormulaire.add(labelAncienneAdresse);
		
		saisieAncienneAdresse = new JTextField();
		saisieAncienneAdresse.setColumns(10);
		panelDeuxièmePartieFormulaire.add(saisieAncienneAdresse);
		
		JPanel panelSelectionBien = new JPanel();
		getContentPane().add(panelSelectionBien, BorderLayout.EAST);
		panelSelectionBien.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelChoixBien = new JLabel("Selectionner un bien :");
		panelSelectionBien.add(labelChoixBien);
		
		JComboBox listeDeroulanteBien = new JComboBox();
		panelSelectionBien.add(listeDeroulanteBien);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelSelectionBien.add(lblNewLabel_1);
		
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
		
		JLabel labelFeuillePaie = new JLabel("Feuille de paie ");
		panelFichiers.add(labelFeuillePaie);
		
		JPanel panelbouton = new JPanel();
		panelBasDePage.add(panelbouton);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelbouton.add(boutonAnnuler);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panelbouton.add(BoutonRéinitialiser);
		
		JButton boutonValider = new JButton("Valider");
		panelbouton.add(boutonValider);
	}

}
