package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.controleurAccueil;
import modele.Locataire;

public class IHMAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                IHMAccueil frame = new IHMAccueil();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public IHMAccueil() {
		controleurAccueil controleur = new controleurAccueil(this);
		setTitle("Accueil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		contentPane.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel LabelTitre = new JLabel("Bienvenue. Que voulez-vous faire aujourd'hui ?");
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelTitre.add(LabelTitre);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		panelMain.add(panelTop, BorderLayout.NORTH);
		
		JPanel panelLocataire = new JPanel();
		panelTop.add(panelLocataire);
		panelLocataire.setLayout(new GridLayout(0, 1, 0, 0));

		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(iconeLocataires);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelLocataire.add(lblNewLabel_1);
		
		JButton BoutonConsultLoc = new JButton("Consulter les locataires");
		panelLocataire.add(BoutonConsultLoc);
		BoutonConsultLoc.addActionListener(controleur);
		
		JButton btnAjoutLoc = new JButton("Ajouter un locataire");
		panelLocataire.add(btnAjoutLoc);
		btnAjoutLoc.addActionListener(controleur);
		
		JPanel panelBiens = new JPanel();
		panelTop.add(panelBiens);
		panelBiens.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(iconeBiens);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBiens.add(lblNewLabel_3);
		
		JButton BoutonConsultBiens = new JButton("Consulter les biens");
		panelBiens.add(BoutonConsultBiens);
		BoutonConsultBiens.addActionListener(controleur);
		
		JButton btnAjoutBien = new JButton("Ajouter un bien");
		panelBiens.add(btnAjoutBien);
		btnAjoutBien.addActionListener(controleur);
		
		JPanel panelBaux = new JPanel();
		panelTop.add(panelBaux);
		panelBaux.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(iconeBaux);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelBaux.add(lblNewLabel_5);
		
		JButton BoutonConsultBaux = new JButton("Consulter les baux");
		panelBaux.add(BoutonConsultBaux);
		BoutonConsultBaux.addActionListener(controleur);
		
		JButton btnAjoutBail = new JButton("Ajouter un bail");
		panelBaux.add(btnAjoutBail);
		btnAjoutBail.addActionListener(controleur);
		
		JPanel panelBottom = new JPanel();
		panelMain.add(panelBottom, BorderLayout.CENTER);
		
		JPanel panelFiscale = new JPanel();
		panelBottom.add(panelFiscale);
		panelFiscale.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeDeclarationFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(iconeDeclarationFisc);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelFiscale.add(lblNewLabel_7);
		
		JButton btnDeclarationFiscale = new JButton("Déclaration fiscale");
		panelFiscale.add(btnDeclarationFiscale);
		btnDeclarationFiscale.addActionListener(controleur);
		
		JPanel panelFinance = new JPanel();
		panelBottom.add(panelFinance);
		panelFinance.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(iconeFinances);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panelFinance.add(lblNewLabel_9);
		
		JButton btnVoirFinances = new JButton("Finances");
		panelFinance.add(btnVoirFinances);
		btnVoirFinances.addActionListener(controleur);
	}

}
