package controleur;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    import javax.swing.JButton;
    
    import vue.IHMConnexion;
    import vue.IHMInscription;

public class controleurInscription implements ActionListener {

    private IHMInscription vue;
    
    public controleurInscription (IHMInscription vue) {
        this.vue = vue;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Annuler" :
        case "Valider" :
            IHMConnexion vueConnexion = new IHMConnexion();
            vueConnexion.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
} 
