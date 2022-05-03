import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Monstre {

    public int HP;
    public int HPmax;
    public Icon icon;
    public Icon aIcon;
    public Icon dIcon;
    public ImageIcon imageM;
    public String nom;
    Color couleurMonstre;
    int rayonMon = 20;
    int posMonX =400;
    int posMonY =100;
    String texteAM; //description attaque + dégats
    public Icon mapIcon;

    // création de différents monstre dont cette classe est mère : chaque monstre possède une barre de vie, des dégats variables, une image sur la carte et différentes animations de combat
    public Monstre(){
        this.imageM = new ImageIcon("ombre.png");

    }
    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }



    public void atk(Personnage p){}


}
