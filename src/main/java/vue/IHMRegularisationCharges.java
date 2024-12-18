package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.controleurRegularisationCharges;

public class IHMRegularisationCharges extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TabDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					IHMRegularisationCharges frame = new IHMRegularisationCharges();
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
	public IHMRegularisationCharges() {
		controleurRegularisationCharges controleur = new controleurRegularisationCharges(this);
		setTitle("Régularisation des charges");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataire = new JButton();
		BoutonGLocataire.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataire);
		BoutonGLocataire.setActionCommand("locataires");
		BoutonGLocataire.addActionListener(controleur);

		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		panelGauche.add(BoutonGBiens);
		BoutonGBiens.setActionCommand("biens");
		BoutonGBiens.addActionListener(controleur);

		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panelGauche.add(BoutonGBaux);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);

		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);
		BoutonGDeclFisc.setActionCommand("declarations fiscales");
		BoutonGDeclFisc.addActionListener(controleur);

		JPanel panelBody = new JPanel();
		panelBody.setBorder(new EmptyBorder(0, 5, 0, 0));
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		panelBody.add(panelTitre, BorderLayout.NORTH);
		
		JLabel LabelTitre = new JLabel("Régularisation des charges");
		panelTitre.add(LabelTitre);
		
		JPanel panelBoutons = new JPanel();
		panelBody.add(panelBoutons, BorderLayout.SOUTH);
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton ButtonAnnuler = new JButton("Annuler");
		panelBoutons.add(ButtonAnnuler);
		ButtonAnnuler.setActionCommand("Annuler");
		ButtonAnnuler.addActionListener(controleur);
		
		JButton ButtonValider = new JButton("Valider");
		panelBoutons.add(ButtonValider);
		ButtonValider.setActionCommand("Valider");
		ButtonValider.addActionListener(controleur);
		
		JPanel PanelMain = new JPanel();
		panelBody.add(PanelMain, BorderLayout.CENTER);
		PanelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel PanelTabDetails = new JPanel();
		PanelMain.add(PanelTabDetails);
		PanelTabDetails.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelTabDetails = new JLabel("Détails des charges");
		PanelTabDetails.add(LabelTabDetails);
		
		TabDetails = new JTable();
		TabDetails.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		PanelTabDetails.add(TabDetails);
		
		JPanel panelCentre = new JPanel();
		PanelMain.add(panelCentre);
		panelCentre.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelTotalCharges = new JPanel();
		panelCentre.add(panelTotalCharges);
		panelTotalCharges.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelTotalCharges = new JLabel("Total charges :");
		panelTotalCharges.add(LabelTotalCharges);
		
		JLabel TotalCharges = new JLabel("");
		panelTotalCharges.add(TotalCharges);
		
		JPanel panelMontProvisions = new JPanel();
		panelCentre.add(panelMontProvisions);
		panelMontProvisions.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelMontProvisions = new JLabel("Montant actuel des provisions :");
		panelMontProvisions.add(LabelMontProvisions);
		
		JLabel MontProvisions = new JLabel("");
		panelMontProvisions.add(MontProvisions);
		
		JPanel panelAjusterProvisions = new JPanel();
		panelCentre.add(panelAjusterProvisions);
		panelAjusterProvisions.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelAjusterProvisions = new JLabel("Modifier montant des provisions :");
		panelAjusterProvisions.add(LabelAjusterProvisions);
		
		JButton AjusterProvision = new JButton("Ajuster les provisions");
		panelAjusterProvisions.add(AjusterProvision);
		AjusterProvision.setActionCommand("provisions");
		AjusterProvision.addActionListener(controleur);
		
		JPanel panelResultat = new JPanel();
		PanelMain.add(panelResultat);
		panelResultat.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelRssultatsCharges = new JLabel("Résultats :");
		panelResultat.add(LabelRssultatsCharges);
		
		JLabel ResultatsCharges = new JLabel("");
		panelResultat.add(ResultatsCharges);
	}

}