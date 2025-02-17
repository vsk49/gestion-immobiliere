package vue;

import controleur.ControleurInscription;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;

public class IHMInscription extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField textFieldIdentifiant;
    private final JPasswordField textFieldMotDePasse;

    public IHMInscription() {
        ControleurInscription controleur = new ControleurInscription(this);
        setTitle("Inscription");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelInscription = new JLabel("Inscription");
        labelInscription.setFont(new Font("Arial", Font.BOLD, 30));
        labelInscription.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        contentPane.add(labelInscription, gbc);

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
    }

    public String getIdentifiant() {
        return textFieldIdentifiant.getText();
    }

    public String getMotDePasse() {
        return new String(textFieldMotDePasse.getPassword());
    }

    public void afficherMessageSucces(String message) {
        JOptionPane.showMessageDialog(this, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
    }

    public void afficherMessageErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}