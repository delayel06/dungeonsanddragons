import javax.swing.*;
import java.awt.*;

public class Inventaire extends JFrame {
    int [][] lesObjets = new int[2][5];
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

        /*for (int i = 0; i<2;i++) {
            for (int j = 0; j < 5; j++) {
                lesObjets[i][j]=1;
            }
        }*/
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


        JPanel inventaireTotal = new JPanel();
        inventaireTotal.setLayout(null);

        inventaireTotal.add(conteneurDescription);
        inventaireTotal.add(conteneurObject);
        this.add(inventaireTotal);

        setVisible(false);
    }
}
