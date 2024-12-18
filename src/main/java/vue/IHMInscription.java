package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;

import controleur.controleurInscription;

public class IHMInscription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMail;
	private JTextField textFieldMotdepasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMInscription frame = new IHMInscription();
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
	public IHMInscription() {
		controleurInscription controleur = new controleurInscription(this);
		setTitle("Inscription");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				IHMConnexion vueConnexion = new IHMConnexion();
				vueConnexion.setVisible(true);
	
				dispose();
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelInscription = new JLabel("Inscription");
		LabelInscription.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelInscription.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelInscription);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain);
		panelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelEmail = new JPanel();
		panelMain.add(panelEmail);
		panelEmail.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelMail = new JLabel("Adresse Mail :");
		LabelMail.setHorizontalAlignment(SwingConstants.CENTER);
		panelEmail.add(LabelMail);
		
		JPanel paneltextFieldMail = new JPanel();
		panelEmail.add(paneltextFieldMail);
		
		textFieldMail = new JTextField();
		paneltextFieldMail.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JPanel panelMotdepasse = new JPanel();
		panelMain.add(panelMotdepasse);
		panelMotdepasse.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelMotdepasse = new JLabel("Mot de Passe :");
		LabelMotdepasse.setHorizontalAlignment(SwingConstants.CENTER);
		panelMotdepasse.add(LabelMotdepasse);
		
		JPanel paneltextFieldMotdepasse = new JPanel();
		panelMotdepasse.add(paneltextFieldMotdepasse);
		
		textFieldMotdepasse = new JTextField();
		paneltextFieldMotdepasse.add(textFieldMotdepasse);
		textFieldMotdepasse.setColumns(10);
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton);
		panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
		JButton BoutonAnnuler = new JButton("Annuler");
		panelBouton.add(BoutonAnnuler);
		BoutonAnnuler.setActionCommand("Annuler");
		BoutonAnnuler.addActionListener(controleur);
		
		JButton BoutonValider = new JButton("Valider");
		panelBouton.add(BoutonValider);
		BoutonValider.setActionCommand("Valider");
		BoutonValider.addActionListener(controleur);
	}

	public String getIdentifiant() {
		return textFieldMail.getText();
	}
	
	public String getMotDePasse() {
		return textFieldMotdepasse.getText();
	}

	public void afficherMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
	}

	public void afficherMessageErreur(String message) {
		JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
}