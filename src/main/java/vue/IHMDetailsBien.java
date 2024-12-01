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
import javax.swing.JButton;
import javax.swing.JComboBox;

public class IHMDetailsBien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		setTitle("Détail de bail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel premièrePartieFormulaire = new Panel();
		panel_1.add(premièrePartieFormulaire);
		premièrePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Adresse :");
		premièrePartieFormulaire.add(lblNewLabel_5);
		
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		premièrePartieFormulaire.add(textField_3);
		
		Panel deuxièmePartieFormulaire = new Panel();
		panel_1.add(deuxièmePartieFormulaire);
		deuxièmePartieFormulaire.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelType = new JLabel("Type de bien :");
		deuxièmePartieFormulaire.add(labelType);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		deuxièmePartieFormulaire.add(textField_4);
		
		JLabel labelSurface = new JLabel("Surface :");
		deuxièmePartieFormulaire.add(labelSurface);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		deuxièmePartieFormulaire.add(textField_5);
		
		JLabel labelMail_1 = new JLabel("Nombre de pièces :");
		deuxièmePartieFormulaire.add(labelMail_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		deuxièmePartieFormulaire.add(textField_6);
		
		JLabel labelStatut = new JLabel("Statut :");
		deuxièmePartieFormulaire.add(labelStatut);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		deuxièmePartieFormulaire.add(textField_7);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDocsLiéAuBien = new JLabel("Liste des documents liés aux biens :");
		panel_5.add(labelDocsLiéAuBien);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("Fichier Bail");
		panel_6.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Fichier Diagnostics");
		panel_6.add(lblNewLabel_3_1);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JButton boutonAnnuler = new JButton("Annuler");
		panel_4.add(boutonAnnuler);
		
		JButton BoutonRéinitialiser = new JButton("Réinitialiser");
		panel_4.add(BoutonRéinitialiser);
		
		JButton boutonValider = new JButton("Valider");
		panel_4.add(boutonValider);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelChoixLocataire = new JLabel("Ajouter un locataire (facultatif) :");
		panel_2.add(labelChoixLocataire);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		panel_2.add(lblNewLabel_1_1);
	}

}
