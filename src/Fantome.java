import javax.swing.*;
import java.awt.*;

public class Fantome extends Monstre{


    public Fantome (){

        super();
        this.nom = "Fantôme";
        this.HPmax= (int)(15 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("ghost.gif");
        this.aIcon = new ImageIcon("ghostA.gif");
        this.dIcon = new ImageIcon("ghostD.gif");
        this.imageM = new ImageIcon("ghostM.png");
        couleurMonstre= Color.white;

    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.5){
            texteAM = "Le fantome passe sa main spéctrale à travers votre ventre : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature pousse un hurlement glaçant : "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un coup de chaine : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(8) + 1;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
            return (int)(Math.random() * n);
        }
}

