import javax.swing.*;
import java.awt.*;

public class Inventaire extends JFrame {
    int [][] lesObjets = new int[2][5];
    JPanel panelObjets;
    JButton btn1;
    public Inventaire (){
        setTitle( " INVENTAIRE");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurInventaire = tailleMoniteur.width * 1/2;
        int largeurInventaire  = tailleMoniteur.height * 1/2;
        setSize(longueurInventaire,largeurInventaire);
        //setResizable( false );
        setLocation((tailleMoniteur.width - getSize().width)/2,((tailleMoniteur.height - getSize().height)/2)-20);

        JPanel conteneurDescription = new JPanel();
        conteneurDescription.setLayout(null);
        conteneurDescription.setBounds(0,0 , longueurInventaire,largeurInventaire/2);
        conteneurDescription.setBackground(Color.red);

        lesObjets[1][1]=0;
        lesObjets[1][2]=0;
        lesObjets[1][3]=0;
        lesObjets[1][4]=0;
        lesObjets[1][0]=0;
        lesObjets[0][1]=0;
        lesObjets[0][2]=0;
        lesObjets[0][3]=0;
        lesObjets[0][4]=0;
        lesObjets[0][0]=0;

        JPanel conteneurObject = new Panelinventaire(lesObjets,longueurInventaire,largeurInventaire);

        btn1 = new JButton(new ImageIcon("bone.png"));

        panelObjets = new JPanel();
        panelObjets.setLayout(new GridLayout(3,2));
        panelObjets.setBounds(0,largeurInventaire/2,longueurInventaire,largeurInventaire/2 );

        // ON PEUT CLIQUER SUR LES BOUTONS POUR VOIR LEURS STATS
        panelObjets.add(btn1);
        btn1.setVisible(false);

        JPanel inventaireTotal = new JPanel();
        inventaireTotal.setLayout(null);

        inventaireTotal.add(conteneurDescription);
        inventaireTotal.add(panelObjets);
        //inventaireTotal.add(conteneurObject);
        this.add(inventaireTotal);

        setVisible(false);
    }
    public void ajouterObjet(int a){
        btn1.setVisible(true);
        // boost de stats et autre
        // on aurait pu ajouter les boutons au panal ici mais c'est moche a cause des dimension
    }
}
