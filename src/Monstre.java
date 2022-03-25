import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Monstre {

    public int HP;
    public int CA;
    public int HPmax;
    public Icon icon;
    public String nom;




    public Monstre(){


    }




    public void atk(Personnage p){
        p.HP -= 2;
    }


}
