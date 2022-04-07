import javax.swing.*;
import java.awt.*;

public class Panelinventaire extends JPanel {
    public int [][] objects ;
    public int longueur;
    public int hauteur;
    public Panelinventaire (int [][]o, int l, int h){
        objects= o;
        longueur= l;
        hauteur=h;
        setBounds(0,hauteur/2,longueur,hauteur/2 );
    }
    public  void paintComponent(Graphics g) {
        int evolutionXinventaire = 0;
        int evolutionYinventaire = 0;
        for (int i = 0; i<objects.length;i++) {
            for (int j = 0; j < objects[i].length; j++) {
                if (objects[i][j] == 1) {
                    g.setColor(Color.blue);
                    g.fillRect(evolutionXinventaire, evolutionYinventaire, longueur / 5, hauteur/ 2);
                }
                if (objects[i][j] == 1) {
                    g.setColor(Color.white);
                    g.fillRect(evolutionXinventaire, evolutionYinventaire, longueur / 5, hauteur/ 2);
                }
                if (objects[i][j] == 3) {
                    g.setColor(Color.red);
                    g.fillRect(evolutionXinventaire, evolutionYinventaire, longueur / 5, hauteur/ 2);
                }
                evolutionXinventaire += longueur/5;
            }
            evolutionYinventaire+=hauteur/2;
        }
    }
}
