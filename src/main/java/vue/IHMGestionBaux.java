package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IHMGestionBaux extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable tableBaux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMGestionBaux frame = new IHMGestionBaux();
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
	public IHMGestionBaux() {
		setTitle("Gestion des baux");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon iconeLocataires = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("locataires.png")));
		JButton BoutonGLocataires = new JButton();
		BoutonGLocataires.setIcon(iconeLocataires);
		panelGauche.add(BoutonGLocataires);
		
		
		ImageIcon iconeBiens = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("biens50.png")));
		JButton BoutonGBiens = new JButton();
		BoutonGBiens.setIcon(iconeBiens);
		panelGauche.add(BoutonGBiens);
		
		
		ImageIcon iconeDeclFisc = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("declarationFiscale.png")));
		JButton BoutonGDeclFisc = new JButton();
		BoutonGDeclFisc.setIcon(iconeDeclFisc);
		panelGauche.add(BoutonGDeclFisc);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelParamRecherche = new JPanel();
		panelCentre.add(panelParamRecherche, BorderLayout.NORTH);
		panelParamRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		textField.setColumns(10);
		panelParamRecherche.add(textField);
		
		JButton BoutonRecherche = new JButton("Chercher");
		panelParamRecherche.add(BoutonRecherche);
		
		JComboBox comboBoxFiltre = new JComboBox();
		panelParamRecherche.add(comboBoxFiltre);
		
		ImageIcon iconeFiltre = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("IconeLoupe.png")));
		JLabel LabelimageFiltre = new JLabel();
		LabelimageFiltre.setIcon(iconeFiltre);
		panelParamRecherche.add(LabelimageFiltre);
		
		tableBaux = new JTable();
		tableBaux.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}));
		panelCentre.add(tableBaux, BorderLayout.CENTER);
		
		JLabel LabelTitre = new JLabel("Gestion des baux");
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelTitre, BorderLayout.NORTH);
	}

}
