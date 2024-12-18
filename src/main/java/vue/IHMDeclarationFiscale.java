package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;

import controleur.controleurDeclarationFiscale;

public class IHMDeclarationFiscale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMDeclarationFiscale frame = new IHMDeclarationFiscale();
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
	public IHMDeclarationFiscale() {
		controleurDeclarationFiscale controleur = new controleurDeclarationFiscale(this);
		setTitle("Déclaration fiscale");
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
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		BoutonGLocataires.setActionCommand("locataires");
		BoutonGLocataires.addActionListener(controleur);
		
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		panelGauche.add(BoutonGBiens);
		BoutonGBiens.setActionCommand("baux");
		BoutonGBiens.addActionListener(controleur);

		ImageIcon iconeBaux = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("baux.png")));
		JButton BoutonGBaux = new JButton();
		BoutonGBaux.setIcon(iconeBaux);
		panelGauche.add(BoutonGBaux);
		BoutonGBaux.setActionCommand("baux");
		BoutonGBaux.addActionListener(controleur);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);
		
		JPanel panelBody = new JPanel();
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		panelBody.add(panelTitre, BorderLayout.NORTH);
		
		JLabel LabelTitre = new JLabel("Déclaration fiscale");
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
		
		JPanel PanelRegime = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PanelRegime.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		PanelMain.add(PanelRegime);
		
		JLabel LabelRegimeFoncier = new JLabel("Régime microfoncier");
		PanelRegime.add(LabelRegimeFoncier);
		
		JRadioButton BoutonRegimeOui = new JRadioButton("Oui");
		BoutonRegimeOui.setSelected(true);
		PanelRegime.add(BoutonRegimeOui);
		
		JRadioButton BoutonRegimeNon = new JRadioButton("Non");
		PanelRegime.add(BoutonRegimeNon);
		
		JPanel panel_6 = new JPanel();
		PanelMain.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel PanelRevenuGestion = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) PanelRevenuGestion.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_6.add(PanelRevenuGestion);
		
		JLabel LabelRevenus = new JLabel("Revenus immobilier :");
		PanelRevenuGestion.add(LabelRevenus);
		
		JPanel PanelChampRevenus = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) PanelChampRevenus.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_6.add(PanelChampRevenus);
		
		textField = new JTextField();
		PanelChampRevenus.add(textField);
		textField.setColumns(10);
		
		JPanel PanelGestion = new JPanel();
		PanelMain.add(PanelGestion);
		PanelGestion.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel PanelTitreGestion = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) PanelTitreGestion.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		PanelGestion.add(PanelTitreGestion);
		
		JLabel LabelGestion = new JLabel("Frais de gestion :");
		PanelTitreGestion.add(LabelGestion);
		
		JPanel PanelChampGestion = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) PanelChampGestion.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		PanelGestion.add(PanelChampGestion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		PanelChampGestion.add(textField_1);
		
		JPanel PanelBas = new JPanel();
		PanelMain.add(PanelBas);
		PanelBas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTravaux = new JPanel();
		PanelBas.add(panelTravaux);
		
		JLabel LabelTravaux = new JLabel("Informations travaux :");
		panelTravaux.add(LabelTravaux);
		
		JPanel panelTable = new JPanel();
		PanelBas.add(panelTable);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Label travaux", "Co\u00FBt", "Date d\u00E9but", "Dur\u00E9e", "Date de fin"},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		panelTable.add(table);
	}

}
