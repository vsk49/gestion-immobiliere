package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import java.awt.FlowLayout;
import javax.swing.JSpinner;

import controleur.controleurPopupAjusterProvisions;
import controleur.controleurRegularisationCharges;

public class IHMPopupAjusterProvisions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMPopupAjusterProvisions frame = new IHMPopupAjusterProvisions();
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
	public IHMPopupAjusterProvisions() {
		controleurPopupAjusterProvisions controleur = new controleurPopupAjusterProvisions(this);
		setTitle("Ajuster montant provisions");
		setBounds(100, 100, 450, 300);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
                vueRegularisationCharges.setVisible(true);

                dispose();
            }
        });

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBody = new JPanel();
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		panelBody.add(panelTitre, BorderLayout.NORTH);
		
		JLabel LabelTitre = new JLabel("Ajuster le montant des provisions");
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
		
		JPanel PanelMontantProvisions = new JPanel();
		PanelMain.add(PanelMontantProvisions);
		PanelMontantProvisions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
		
		JLabel LabelTitreMontantProvisions = new JLabel("Montant actuel des provisions :");
		PanelMontantProvisions.add(LabelTitreMontantProvisions);
		
		JLabel LabelMontantProvisions = new JLabel("");
		PanelMontantProvisions.add(LabelMontantProvisions);
		
		JPanel panelAjusterProvisions = new JPanel();
		PanelMain.add(panelAjusterProvisions);
		panelAjusterProvisions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel LabelTitreAjustementProvisions = new JLabel("Ajuster le montant des provisions :");
		panelAjusterProvisions.add(LabelTitreAjustementProvisions);
		
		JSpinner spinnerAjustementProvisions = new JSpinner();
		panelAjusterProvisions.add(spinnerAjustementProvisions);
	}

}
