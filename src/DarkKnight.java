import javax.swing.*;
import java.awt.*;

public class DarkKnight extends Monstre{

    public DarkKnight (){

        super();
        this.nom = "Dark Knight";
        this.HPmax= (int)(15 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("darkNight.gif");
        this.aIcon = new ImageIcon("darkNightA.gif");
        this.dIcon = new ImageIcon("darkNightD.gif");
        this.mapIcon = new ImageIcon("darkNightM.gif");
        couleurMonstre= Color.white;

    }

    public void atk(Personnage p){
        int j = getRandomInt(10);
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
            texteAM = "Le chevalier maléfique charge et vous touche avec sa lance : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La cavalier assène un coup d'épée : "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous vous faites piétiner : "+dmg+" dégats !";
        }
    }
}
