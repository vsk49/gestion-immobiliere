package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controleur.controleurConnexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import java.io.Serial;

public class IHMConnexion extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
    private final JTextField textFieldIdentifiant;
	private final JTextField PasswordFieldMotdepasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                IHMConnexion frame = new IHMConnexion();
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println("Erreur lors de l'ouverture de la fenêtre de connexion");
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public IHMConnexion() {
		controleurConnexion controleur = new controleurConnexion(this);
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelConnexion = new JLabel("Connexion");
		LabelConnexion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelConnexion);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain);
		panelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelIdentifiant = new JPanel();
		panelMain.add(panelIdentifiant);
		panelIdentifiant.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelIdentifiant = new JLabel("Identifiant :");
		LabelIdentifiant.setHorizontalAlignment(SwingConstants.CENTER);
		panelIdentifiant.add(LabelIdentifiant);
		
		JPanel paneltextFieldIdentifiant = new JPanel();
		panelIdentifiant.add(paneltextFieldIdentifiant);

		textFieldIdentifiant = new JTextField();
		paneltextFieldIdentifiant.add(textFieldIdentifiant);
		textFieldIdentifiant.setColumns(10);
		
		JPanel panelMotdepasse = new JPanel();
		panelMain.add(panelMotdepasse);
		panelMotdepasse.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelMotdepasse = new JLabel("Mot de Passe :");
		LabelMotdepasse.setHorizontalAlignment(SwingConstants.CENTER);
		panelMotdepasse.add(LabelMotdepasse);
		
		JPanel panelPasswordFieldMotdepasse = new JPanel();
		panelMotdepasse.add(panelPasswordFieldMotdepasse);
		
		PasswordFieldMotdepasse  = new JPasswordField();
		panelPasswordFieldMotdepasse.add(PasswordFieldMotdepasse);
		PasswordFieldMotdepasse.setColumns(10);
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton);
		panelBouton.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAnulerOuValider = new JPanel();
		panelBouton.add(panelAnulerOuValider, BorderLayout.NORTH);
		
		JButton BoutonAnnuler = new JButton("Annuler");
		panelAnulerOuValider.add(BoutonAnnuler);
		BoutonAnnuler.setActionCommand("Annuler");
		BoutonAnnuler.addActionListener(controleur);
		
		JButton BoutonValider = new JButton("Valider");
		panelAnulerOuValider.add(BoutonValider);
		BoutonValider.setActionCommand("Valider");
		BoutonValider.addActionListener(controleur);
		
		JPanel panelInscription = new JPanel();
		panelBouton.add(panelInscription);
		
		JButton BoutonInscription = new JButton("Pas de compte ?");
		panelInscription.add(BoutonInscription);
		BoutonInscription.setActionCommand("Inscription");
		BoutonInscription.addActionListener(controleur);
	}

	public String getIdentifiant() {
        return textFieldIdentifiant.getText();
    }

    public String getMotDePasse() {
        return PasswordFieldMotdepasse.getText();
    }

    // Méthode pour afficher des messages
    public void afficherMessageErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}