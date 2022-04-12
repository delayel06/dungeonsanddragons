import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Litch extends Monstre {

    public Litch (){

        super();
        this.nom = "Lich";
        this.HPmax= (int)(10 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("Litch.gif");
        this.aIcon = new ImageIcon("LitchA.gif");
        this.dIcon = new ImageIcon("LitchD.gif");
        this.imageM = new ImageIcon("LitchM.gif");
        couleurMonstre=Color.white;

    }

    public void atk(Personnage p){
        int j = getRandomInt(6) + 2;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }


    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.5){
            texteAM = "Le mage squelette envoie une boule de feu : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature puise dans sa réserve d'énergie nécrotique et inflige "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un jet de glace : "+dmg+" dégats !";
        }
    }


}