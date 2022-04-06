import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Litch extends Monstre {

    public Litch (){

        super();
        this.nom = "Gobelin";
        this.HPmax= (int)(10 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("Litch.gif");
        this.aIcon = new ImageIcon("LitchA.gif");
        this.dIcon = new ImageIcon("LitchD.gif");
        this.mapIcon = new ImageIcon("Litch.gif");
        this.DMG = (this.HPmax)%4;
        couleurMonstre=Color.green;

    }

    public void atk(Personnage p){
        texteRandom();
        p.HP -= this.DMG;

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
            texteAM = "Le Gobelin prend son élan et vous mord !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature prend sa massue et assène un coup !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un coup de couteau !";
        }
    }
}