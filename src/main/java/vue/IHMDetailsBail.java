package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IHMDetailsBail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMDetailsBail frame = new IHMDetailsBail();
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
	public IHMDetailsBail() {
		setTitle("Détail du bail");
setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imageLocataire = new JLabel("image Locataire");
		panel.add(imageLocataire);
		
		JLabel imageBien = new JLabel("Image Bien");
		panel.add(imageBien);
		
		JLabel ImageBaux = new JLabel("Image Baux");
		panel.add(ImageBaux);
		
		JLabel ImageDéclarationFiscale = new JLabel("Image Déclaration Fiscale");
		panel.add(ImageDéclarationFiscale);
		
		JLabel ImageFinance = new JLabel("Image Finance");
		panel.add(ImageFinance);
		
		JLabel labelDetailBail = new JLabel("Détails du bail ");
		add(labelDetailBail, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lienBien = new JLabel("Bien lié au bail");
		panel_2.add(lienBien);
		
		JLabel lienLocataire = new JLabel("Locataire lié au bail ");
		panel_2.add(lienLocataire);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDocsLiéAuBien = new JLabel("Liste des documents liés aux biens :");
		panel_5.add(labelDocsLiéAuBien);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Fichier du bail");
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fiche de paie");
		panel_6.add(lblNewLabel_3);
	}

}
