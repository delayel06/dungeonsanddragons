import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

 class Gobelin extends Monstre {

    public Gobelin (){

        super(7,15,"gobelin");



    }

     public void atk(Personnage p){
         int j = getRandomInt(6)+3;
         p.HP -=j;

     }

     public int getRandomInt(int n) {
         return (int)(Math.random() * n);
     }

 }