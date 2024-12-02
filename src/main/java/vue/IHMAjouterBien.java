package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class IHMAjouterBien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMAjouterBien frame = new IHMAjouterBien();
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
	public IHMAjouterBien() {
		setTitle("Ajout de bien");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataire = new JButton();
		BoutonGLocataire.setIcon(iconeLocataires);
		panel.add(BoutonGLocataire);
		
		
		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panel.add(BoutonGBaux);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panel.add(BoutonGDeclFisc);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panel.add(BoutonGFinances);
		
		JPanel panelBasDePage = new JPanel();
		
		
		JPanel panelDocuments = new JPanel();
		panelBasDePage.add(panelDocuments);
		panelDocuments.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDocsLiéAuBien = new JLabel("Liste des documents liés aux biens :");
		panelDocuments.add(labelDocsLiéAuBien);
		
		JPanel panelFichiers = new JPanel();
		panelDocuments.add(panelFichiers);
		panelFichiers.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Fichier Bail");
		panelFichiers.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fichier Diagnostics");
		panelFichiers.add(lblNewLabel_3);
		
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
		
		JPanel panelBody = new JPanel();
		getContentPane().add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAjouterBien = new JLabel("Ajouter un bien");
		labelAjouterBien.setHorizontalAlignment(SwingConstants.CENTER);
		panelBody.add(labelAjouterBien, BorderLayout.NORTH);
		
		panelBody.add(panelBasDePage, BorderLayout.SOUTH);
		panelBasDePage.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelFormulaire = new JPanel();
		panelBody.add(panelFormulaire);
		panelFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel premièrePartieFormulaire = new Panel();
		panelFormulaire.add(premièrePartieFormulaire);
		premièrePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Adresse :");
		premièrePartieFormulaire.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		premièrePartieFormulaire.add(textField);
		
		JLabel labelVille = new JLabel("Ville :");
		premièrePartieFormulaire.add(labelVille);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		premièrePartieFormulaire.add(textField_1);
		
		JLabel labelCodePostal = new JLabel("Code postale :");
		premièrePartieFormulaire.add(labelCodePostal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		premièrePartieFormulaire.add(textField_2);
		
		JLabel labelEtage = new JLabel("Etage :");
		premièrePartieFormulaire.add(labelEtage);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		premièrePartieFormulaire.add(textField_7);
		
		Panel deuxièmePartieFormulaire = new Panel();
		panelFormulaire.add(deuxièmePartieFormulaire);
		deuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelType = new JLabel("Type de bien :");
		deuxièmePartieFormulaire.add(labelType);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		deuxièmePartieFormulaire.add(textField_3);
		
		JLabel labelSurface = new JLabel("Surface :");
		deuxièmePartieFormulaire.add(labelSurface);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		deuxièmePartieFormulaire.add(textField_4);
		
		JLabel labelMail_1 = new JLabel("Nombre de pièces :");
		deuxièmePartieFormulaire.add(labelMail_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		deuxièmePartieFormulaire.add(textField_5);
		
		JLabel labelStatut = new JLabel("Statut :");
		deuxièmePartieFormulaire.add(labelStatut);
		
		textField_2 = new JTextField();
		deuxièmePartieFormulaire.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panelChoixLocataire = new JPanel();
		panelBody.add(panelChoixLocataire, BorderLayout.EAST);
		panelChoixLocataire.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelChoixLocataire = new JLabel("Ajouter un locataire (facultatif) :");
		panelChoixLocataire.add(labelChoixLocataire);
		
		JComboBox comboBox = new JComboBox();
		panelChoixLocataire.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelChoixLocataire.add(lblNewLabel_1);
	}

}
