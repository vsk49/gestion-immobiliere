package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class IHMInscription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ChampEmail;
	private JTextField ChampMotdepasse;

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
		setTitle("Page d'inscription");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelTitre = new JLabel("Inscription");
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelTitre);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain);
		panelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelMail = new JPanel();
		panelMain.add(panelMail);
		panelMail.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelEmail = new JLabel("Adresse Mail :");
		panelMail.add(LabelEmail);
		
		ChampEmail = new JTextField();
		panelMail.add(ChampEmail);
		ChampEmail.setColumns(10);
		
		JPanel panelMotdepasse = new JPanel();
		panelMain.add(panelMotdepasse);
		panelMotdepasse.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel LabelMotdepasse = new JLabel("Mot de Passe :");
		panelMotdepasse.add(LabelMotdepasse);
		
		ChampMotdepasse = new JTextField();
		panelMotdepasse.add(ChampMotdepasse);
		ChampMotdepasse.setColumns(10);
		
		JPanel panelBouton = new JPanel();
		contentPane.add(panelBouton);
		
		JButton BoutonAnnuler = new JButton("Annuler");
		
		JButton BoutonValider = new JButton("Valider");
		panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		panelBouton.add(BoutonAnnuler);
		panelBouton.add(BoutonValider);
	}

}
