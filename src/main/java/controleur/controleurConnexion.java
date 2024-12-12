package controleur;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    import javax.swing.JButton;
    
    import vue.IHMAccueil;
    import vue.IHMConnexion;
    import vue.IHMInscription;

public class controleurConnexion implements ActionListener{

    private IHMConnexion vue;
    
    public controleurConnexion (IHMConnexion vue) {
        this.vue = vue;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Inscription" :
            IHMInscription vueInscription = new IHMInscription();
            vueInscription.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Valider" :
            IHMAccueil vueAccueil = new IHMAccueil();
            vueAccueil.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Annuler" :
        this.vue.dispose();
        break;
        }
    }
}  
