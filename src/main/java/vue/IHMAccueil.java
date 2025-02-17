package vue;

import java.awt.*;
import java.io.Serial;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controleur.ControleurAccueil;

public class IHMAccueil extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;
	private final transient ControleurAccueil controller = new ControleurAccueil(this);

	public IHMAccueil() {
		setTitle("Accueil");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(902, 500);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout(10, 10));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		// Title Panel
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Bienvenue. Que voulez-vous faire aujourd'hui ?");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		titlePanel.add(titleLabel);
		contentPane.add(titlePanel, BorderLayout.NORTH);

		// Main Panel with GridBagLayout
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 20, 15, 20);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// First row (3 sections)
		gbc.gridy = 0;
		addSection(mainPanel, gbc, "locataires.png", "Consulter les locataires", "Ajouter un locataire", 0, 1);
		addSection(mainPanel, gbc, "biens50.png", "Consulter les biens", "Ajouter un bien", 1, 1);
		addSection(mainPanel, gbc, "baux.png", "Consulter les baux", "Ajouter un bail", 2, 1);

		// Second row (Déclaration fiscale)
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;  // Span across two columns to align properly
		addSection(mainPanel, gbc, "declarationFiscale.png", "Déclaration fiscale", null,0, 2);

		// Second row (Finances)
		gbc.gridx = 1; // Move to the correct column
		gbc.gridwidth = 2; // Span two columns to be centered
		addSection(mainPanel, gbc, "finance.png", "Finances", null, 1, 2);

		contentPane.add(mainPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	private void addSection(JPanel panel, GridBagConstraints gbc, String iconPath, String btn1Text,
							String btn2Text, int gridX, int gridWidth) {
		JPanel sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		sectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(iconPath)));
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton button1 = createButton(btn1Text, controller);
		sectionPanel.add(iconLabel);
		sectionPanel.add(Box.createVerticalStrut(5));
		sectionPanel.add(button1);

		if (btn2Text != null) {
			JButton button2 = createButton(btn2Text, controller);
			sectionPanel.add(Box.createVerticalStrut(5));
			sectionPanel.add(button2);
		}

		gbc.gridx = gridX;
		gbc.gridwidth = gridWidth;
		panel.add(sectionPanel, gbc);
	}

	private JButton createButton(String text, ControleurAccueil controller) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(180, 35)); // Uniform button size
		button.setMaximumSize(new Dimension(180, 35));
		button.addActionListener(controller);
		return button;
	}

}
