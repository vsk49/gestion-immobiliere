package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IHMDetailsLocataire extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public IHMDetailsLocataire() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel imageLocataire = new JLabel("image Locataire");
		panel.add(imageLocataire);

		JLabel imageBien = new JLabel("Image Bien");
		panel.add(imageBien);

		JLabel ImageBaux = new JLabel("Image Baux");
		panel.add(ImageBaux);

		JLabel ImageDéclarationFiscale = new JLabel("Image Déclaration Fiscale");
		panel.add(ImageDéclarationFiscale);

		JLabel ImageFinance = new JLabel("Image Finance");
		panel.add(ImageFinance);

		JLabel labelAjouterBien = new JLabel("New label");
		add(labelAjouterBien, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		Panel premièrePartieFormulaire = new Panel();
		panel_1.add(premièrePartieFormulaire);
		premièrePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel labelNom = new JLabel("Nom :");
		premièrePartieFormulaire.add(labelNom);

		JLabel nomLocataire = new JLabel("Nom du locataire");
		premièrePartieFormulaire.add(nomLocataire);

		JLabel labelPrenom = new JLabel("Prenom :");
		premièrePartieFormulaire.add(labelPrenom);

		JLabel prnomLocataire = new JLabel("Prenom du locataire");
		premièrePartieFormulaire.add(prnomLocataire);

		JLabel labelDateNaissance = new JLabel("Date de naissance :");
		premièrePartieFormulaire.add(labelDateNaissance);

		JLabel dateNaissanceLocataire = new JLabel("Date de Naissance");
		premièrePartieFormulaire.add(dateNaissanceLocataire);

		Panel deuxièmePartieFormulaire = new Panel();
		panel_1.add(deuxièmePartieFormulaire);
		deuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel labelTéléphone = new JLabel("Téléphone :");
		deuxièmePartieFormulaire.add(labelTéléphone);

		JLabel lblNewLabel = new JLabel("New label");
		deuxièmePartieFormulaire.add(lblNewLabel);

		JLabel labelEmail = new JLabel("Email :");
		deuxièmePartieFormulaire.add(labelEmail);

		JLabel lblNewLabel_4 = new JLabel("New label");
		deuxièmePartieFormulaire.add(lblNewLabel_4);

		JLabel labelAncienneAdresse = new JLabel("Ancienne adresse :");
		deuxièmePartieFormulaire.add(labelAncienneAdresse);

		JLabel lblNewLabel_5 = new JLabel("New label");
		deuxièmePartieFormulaire.add(lblNewLabel_5);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel labelChoixBien = new JLabel("Selectionner un bien :");
		panel_2.add(labelChoixBien);

		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel labelDocsLiéAuLocataire = new JLabel("Liste des documents liés au locataire :");
		panel_5.add(labelDocsLiéAuLocataire);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Fichier Bail");
		panel_6.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Feuille de paie ");
		panel_6.add(lblNewLabel_3);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(boutonAnnuler);

		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panel_4.add(BoutonRéinitialiser);

		JButton boutonValider = new JButton("Valider");
		panel_4.add(boutonValider);
	}

}
