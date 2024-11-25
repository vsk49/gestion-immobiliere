package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IHMAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMAccueil frame = new IHMAccueil();
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
	public IHMAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Bienvenue. Que voulez-vous faire aujourd'hui ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon("ressources/locataires.png");
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(iconeLocataires);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Locataires");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ajouter un locataire");
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBiens = new ImageIcon("ressources/biens50.png");
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(iconeBiens);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Biens");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Ajouter un bien");
		panel_5.add(btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBaux = new ImageIcon("ressources/baux.png");
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(iconeBaux);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Baux");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Ajouter un bail");
		panel_8.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeDeclarationFisc = new ImageIcon("ressources/declarationFiscale.png");
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(iconeDeclarationFisc);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Déclaration fiscale");
		panel_6.add(btnNewButton_3);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeFinances = new ImageIcon("ressources/finance.png");
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(iconeFinances);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_9);
		
		JButton btnNewButton_4 = new JButton("Finances");
		panel_7.add(btnNewButton_4);
	}

}
