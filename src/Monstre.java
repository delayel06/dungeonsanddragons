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
    public String nom;
    public int DMG;
    Color couleurMonstre;
    int rayonMon = 20;
    int posMonX =400;
    int posMonY =100;
    String texteAM; //description attaque + dégats


    public Monstre(){


    }
    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }



    public void atk(Personnage p){}


}
