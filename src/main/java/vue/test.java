package vue;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

public class test extends JPanel {

    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("LGoodDatePicker Example");
        JPanel panel = new JPanel(new FlowLayout());

        // Configuration de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Configuration des paramètres du DatePicker
        DatePickerSettings settings = new DatePickerSettings();
        settings.setAllowKeyboardEditing(false); // Désactiver la saisie manuelle
        settings.setFormatForDatesCommonEra("dd.MM.yyyy"); // Format clair pour la date

        // Création et configuration du DatePicker
        DatePicker datePicker = new DatePicker(settings);
        datePicker.setText(""); // Initialisation avec un texte vide pour éviter les erreurs
        datePicker.getComponentDateTextField().setEditable(false); // Verrouiller le champ texte

        // Ajout du DatePicker au panneau
        panel.add(datePicker);

        // Ajout du panneau dans la fenêtre
        frame.add(panel);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }
}
