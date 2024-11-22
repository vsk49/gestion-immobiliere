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
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_1.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Déclaration fiscale");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Régime microfoncier");
		panel_5.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Oui");
		rdbtnNewRadioButton.setSelected(true);
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Non");
		panel_5.add(rdbtnNewRadioButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_8.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_7);
		
		textField = new JTextField();
		panel_7.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6_1 = new JPanel();
		panel_4.add(panel_6_1);
		panel_6_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_8_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_6_1.add(panel_8_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		panel_8_1.add(lblNewLabel_2_1);
		
		JPanel panel_7_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_7_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_6_1.add(panel_7_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_7_1.add(textField_1);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_4.add(panel_6_1_1);
		panel_6_1_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8_1_1 = new JPanel();
		panel_6_1_1.add(panel_8_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		panel_8_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_7_1_1 = new JPanel();
		panel_6_1_1.add(panel_7_1_1);
		
		table = new JTable();
		panel_7_1_1.add(table);
	}

}
