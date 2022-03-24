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
    public Icon monstre;


    public Monstre(int PV, int CA){
        this.HP = PV;
        this.CA = CA;
        this.HPmax=PV;

    }


    public int getRandomInt(int n) {
        return (int) (n * Math.random());
    }

    public void atk(Personnage p){
        p.HP -= getRandomInt(6);
    }


}
