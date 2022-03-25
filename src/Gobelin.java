import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

 class Gobelin extends Monstre {

    public Gobelin (){

        super();
        this.nom = "Gobelin";
        this.HP = 20;
        this.CA = 2;
        this.icon = new ImageIcon("goblin.gif");


    }

     public void atk(Personnage p){
         int j = 2;
         p.HP -=j;

     }

     public int getRandomInt(int n) {
         return (int)(Math.random() * n);
     }

 }