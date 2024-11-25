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

public class IHMConnexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setTitle("Page de connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblConnexion);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain);
		panelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelMail = new JPanel();
		panelMain.add(panelMail);
		panelMail.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelEmail = new JLabel("Adresse Mail :");
		panelMail.add(LabelEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		panelMail.add(textField);
		
		JPanel panelMotdepasse = new JPanel();
		panelMain.add(panelMotdepasse);
		panelMotdepasse.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelMotdepasse = new JLabel("Mot de Passe :");
		panelMotdepasse.add(LabelMotdepasse);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panelMotdepasse.add(textField_1);
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton);
		panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
		JButton BoutonAnnuler = new JButton("Annuler");
		panelBouton.add(BoutonAnnuler);
		
		JButton BoutonValider = new JButton("Valider");
		panelBouton.add(BoutonValider);
	}

}
