package vue;

import controleur.ControleurConnexion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;
import java.util.logging.Logger;

public class IHMConnexion extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTextField textFieldIdentifiant;
	private final JPasswordField textFieldMotDePasse;
	private static final Logger logger = Logger.getLogger(IHMConnexion.class.getName());

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				IHMConnexion frame = new IHMConnexion();
				frame.setVisible(true);
			} catch (Exception e) {
				logger.severe("Erreur lors de l'affichage de la fenêtre de connexion : " + e.getMessage());
			}
		});
	}

	public IHMConnexion() {
		ControleurConnexion controleur = new ControleurConnexion(this);
		setTitle("Connexion");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null); // Center the frame
		setResizable(false);

		// Set modern look and feel
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			logger.warning("Unable to set the look and feel to Nimbus");
		}

		JPanel contentPane = new JPanel(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel labelConnexion = new JLabel("Connexion");
		labelConnexion.setFont(new Font("Arial", Font.BOLD, 30));
		labelConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		contentPane.add(labelConnexion, gbc);

		JLabel labelIdentifiant = new JLabel("Identifiant :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5;
		contentPane.add(labelIdentifiant, gbc);

		textFieldIdentifiant = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		contentPane.add(textFieldIdentifiant, gbc);

		JLabel labelMotDePasse = new JLabel("Mot de Passe :");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.5;
		contentPane.add(labelMotDePasse, gbc);

		textFieldMotDePasse = new JPasswordField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		contentPane.add(textFieldMotDePasse, gbc);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setActionCommand("Annuler");
		boutonAnnuler.addActionListener(controleur);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5;
		contentPane.add(boutonAnnuler, gbc);

		JButton boutonValider = new JButton("Valider");
		boutonValider.setActionCommand("Valider");
		boutonValider.addActionListener(controleur);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.5;
		contentPane.add(boutonValider, gbc);

		JLabel labelInscription = new JLabel("<html><a href=''>Pas de compte ?</a></html>");
		labelInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelInscription.addMouseListener(controleur);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		contentPane.add(labelInscription, gbc);
	}

	public String getIdentifiant() {
		return textFieldIdentifiant.getText();
	}

	public String getMotDePasse() {
		return new String(textFieldMotDePasse.getPassword());
	}

	public void afficherMessageErreur(String message) {
		JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

}