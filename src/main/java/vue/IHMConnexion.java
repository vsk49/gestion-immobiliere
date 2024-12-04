package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;

public class IHMConnexion extends JFrame {

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
					IHMConnexion frame = new IHMConnexion();
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
	public IHMConnexion() {
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 340);
		contentPane = new JPanel();
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
		
		JButton BoutonValider = new JButton("Valider");
		panelBouton.add(BoutonValider);
	}

}