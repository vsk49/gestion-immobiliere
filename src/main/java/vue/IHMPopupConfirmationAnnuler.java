package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JSpinner;
import java.awt.Font;

public class IHMPopupConfirmationAnnuler extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMPopupConfirmationAnnuler frame = new IHMPopupConfirmationAnnuler();
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
	public IHMPopupConfirmationAnnuler() {
		setTitle("Popup confirmation d'annulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel LabelTitrePage = new JLabel("Voulez vous confirmer l'annulation ?");
		LabelTitrePage.setFont(new Font("Tahoma", Font.BOLD, 18));
		LabelTitrePage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LabelTitrePage, BorderLayout.NORTH);
		
		JPanel panelBouton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBouton.getLayout();
		flowLayout.setVgap(25);
		contentPane.add(panelBouton, BorderLayout.CENTER);
		
		JButton BoutonConfirmationOui = new JButton("Oui");
		panelBouton.add(BoutonConfirmationOui);
		
		JButton BoutonConfirmationNon = new JButton("Non");
		panelBouton.add(BoutonConfirmationNon);
		
		
	}

}