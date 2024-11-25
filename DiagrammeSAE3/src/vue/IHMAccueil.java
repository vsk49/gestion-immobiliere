package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.controleurAccueil;

public class IHMAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		controleurAccueil controleur = new controleurAccueil(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 448);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		FlowLayout fl_panelTitre = (FlowLayout) panelTitre.getLayout();
		fl_panelTitre.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelTitre, BorderLayout.NORTH);
		
		JLabel LabelTitre = new JLabel("Bienvenue. Que voulez-vous faire aujourd'hui ?");
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
		
		ImageIcon iconeLocataires = new ImageIcon("ressources/locataires.png");
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(iconeLocataires);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelLocataire.add(lblNewLabel_1);
		
		JButton BoutonConsultLoc = new JButton("Consulter les locataires");
		panelLocataire.add(BoutonConsultLoc);
		
		JButton btnAjoutLoc = new JButton("Ajouter un locataire");
		btnAjoutLoc.add(btnAjoutLoc);
		btnAjoutLoc.addActionListener(controleur);
		
		JPanel panelBiens = new JPanel();
		panelTop.add(panelBiens);
		panelBiens.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBiens = new ImageIcon("ressources/biens50.png");
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(iconeBiens);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBiens.add(lblNewLabel_3);
		
		JButton BoutonConsultBiens = new JButton("Consulter les biens");
		panelBiens.add(BoutonConsultBiens);
		
		JButton btnAjoutBien = new JButton("Ajouter un bien");
		btnAjoutBien.add(btnAjoutBien);
		btnAjoutBien.addActionListener(controleur);
		
		JPanel panelBaux = new JPanel();
		panelTop.add(panelBaux);
		panelBaux.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeBaux = new ImageIcon("ressources/baux.png");
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(iconeBaux);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelBaux.add(lblNewLabel_5);
		
		JButton BoutonConsultBaux = new JButton("Consulter les baux");
		panelBaux.add(BoutonConsultBaux);
		
		JButton btnAjoutBail = new JButton("Ajouter un bail");
		btnAjoutBail.add(btnAjoutBail);
		btnAjoutBail.addActionListener(controleur);
		
		JPanel panelBottom = new JPanel();
		panelMain.add(panelBottom, BorderLayout.CENTER);
		
		JPanel panelFiscale = new JPanel();
		panelBottom.add(panelFiscale);
		panelFiscale.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeDeclarationFisc = new ImageIcon("ressources/declarationFiscale.png");
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(iconeDeclarationFisc);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panelFiscale.add(lblNewLabel_7);
		
		JButton btnDeclarationFiscale = new JButton("Déclaration fiscale");
		btnDeclarationFiscale.add(btnDeclarationFiscale);
		btnDeclarationFiscale.addActionListener(controleur);
		
		JPanel panelFinance = new JPanel();
		panelBottom.add(panelFinance);
		panelFinance.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeFinances = new ImageIcon("ressources/finance.png");
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(iconeFinances);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panelFinance.add(lblNewLabel_9);
		
		JButton btnVoirFinances = new JButton("Finances");
		btnVoirFinances.add(btnVoirFinances);
		btnVoirFinances.addActionListener(controleur);
	}

}
