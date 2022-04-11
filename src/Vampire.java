import javax.swing.*;
import java.awt.*;

public class Vampire extends Monstre{
    public Vampire (){

        super();
        this.nom = "Vampire";
        this.HPmax= (int)(10 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("vampire.gif");
        this.aIcon = new ImageIcon("vampireA.gif");
        this.dIcon = new ImageIcon("vampireD.gif");
        couleurMonstre= Color.white;

    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.5){
            texteAM = "Le vampire plante ses crocs et aspire :" +dmg+" de vie !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature dégage une aura de peur : "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un coup de griffe : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(6) + 1;
        p.HP -=j;
        this.HP +=(j-3);
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }
}
