package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.Serial;
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
import javax.swing.JScrollPane;

import controleur.controleurGestionLocataires;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IHMGestionLocataires extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final JTable tableLocataires;
	private final JTextField champRecherche;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                IHMGestionLocataires frame = new IHMGestionLocataires();
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
	}

	public IHMGestionLocataires() {
		controleurGestionLocataires controleur = new controleurGestionLocataires(this);
		setTitle("Gestion des Locataires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 1, 0, 0));
		
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
		BoutonGDeclFisc.setActionCommand("DeclarationFiscale");
		BoutonGDeclFisc.addActionListener(controleur);

		ImageIcon iconeFinances = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("finance.png")));
		JButton BoutonGFinances = new JButton();
		BoutonGFinances.setIcon(iconeFinances);
		panelGauche.add(BoutonGFinances);
		BoutonGFinances.setActionCommand("RegularisationCharges");
		BoutonGFinances.addActionListener(controleur);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelParamRecherche = new JPanel();
		panelCentre.add(panelParamRecherche, BorderLayout.NORTH);
		panelParamRecherche.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        this.champRecherche = new JTextField();
		this.champRecherche.setColumns(10);
		panelParamRecherche.add(this.champRecherche);
		
		JButton BoutonRecherche = new JButton("Chercher");
		panelParamRecherche.add(BoutonRecherche);
		BoutonRecherche.addActionListener(controleur);

		JComboBox<String> comboBoxFiltre = new JComboBox<>(new String[] {
				"Tous",
				"Nationalite: Francaise",
				"Nationalite: Etrangere",
		});
		panelParamRecherche.add(comboBoxFiltre);
		comboBoxFiltre.addActionListener(controleur);
		
		ImageIcon iconeFiltre = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("IconeLoupe.png")));
		JLabel LabelimageFiltre = new JLabel();
		LabelimageFiltre.setIcon(iconeFiltre);
		panelParamRecherche.add(LabelimageFiltre);

		ImageIcon iconeGestionAjout = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("plus.png")));
		JButton BoutonGestionAjout = new JButton();
		BoutonGestionAjout.setIcon(iconeGestionAjout);
		panelParamRecherche.add(BoutonGestionAjout);
		BoutonGestionAjout.setActionCommand("Ajout");
		BoutonGestionAjout.addActionListener(controleur);

		this.tableLocataires = new JTable(new DefaultTableModel(new Object[]{"ID", "Nom", "Prenom", "Email"}, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		JScrollPane scrollPane = new JScrollPane(this.tableLocataires);
		panelCentre.add(scrollPane, BorderLayout.CENTER);
		
		JLabel LabelTitre = new JLabel("Gestion des locataires");
		LabelTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelTitre, BorderLayout.NORTH);

		controleur.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
	}

	public JTable getTableLocataires() {
		return this.tableLocataires;
	}

	public JTextField getChampRecherche() {
		return this.champRecherche;
	}

}