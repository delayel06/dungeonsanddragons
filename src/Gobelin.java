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
        this.HPmax=20;
        this.CA = 2;
        this.icon = new ImageIcon("goblin.gif");
        couleurMonstre=Color.green;

    }

    public void atk(Personnage p){
        texteRandom();
        p.HP -=2;
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(){
        double n = Math.random();
        if(n>0.5){
            texteAM = "Il vous donne un coup de couteau";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "Il vous donne un coup de pied";
        } else if(n<=0.25) {
            texteAM = "Il vous mord";
        }
    }
}
