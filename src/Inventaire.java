import javax.swing.*;
import java.awt.*;

public class Inventaire extends JFrame {
    public Inventaire (){
        setTitle( " INVENTAIRE");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurInventaire = tailleMoniteur.width * 1/2;
        int largeurInventaire  = tailleMoniteur.height * 1/2;
        setSize(longueurInventaire,largeurInventaire);
        setResizable( false );
        setLocation((tailleMoniteur.width - getSize().width)/2,((tailleMoniteur.height - getSize().height)/2)-20);

        JPanel conteneurDescription = new JPanel();
        conteneurDescription.setLayout(null);
        conteneurDescription.setBounds(0,0 , longueurInventaire/2,largeurInventaire/2);
        conteneurDescription.setBackground(Color.black);
        JPanel conteneurObject = new JPanel();
        conteneurObject.setLayout(null);
        conteneurObject.setBounds(0,largeurInventaire/2,longueurInventaire/2,largeurInventaire/2 );
        conteneurObject.setBackground(Color.blue);
        JPanel inventaireTotal = new JPanel();
        inventaireTotal.setLayout(null);

        inventaireTotal.add(conteneurDescription);
        inventaireTotal.add(conteneurObject);
        this.add(inventaireTotal);

        setVisible(false);
    }
}
