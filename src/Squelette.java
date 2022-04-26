import javax.swing.*;
import java.awt.*;

public class Squelette extends Monstre {
    public Squelette (){

        super();
        this.nom = "Squelette";
        this.HPmax= (int)(5 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("Skeleton.gif");
        this.aIcon = new ImageIcon("SkeletonA.gif");
        this.dIcon = new ImageIcon("SkeletonD.gif");
        this.imageM = new ImageIcon("skeletonM.png");
        couleurMonstre= Color.white;

    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.5){
            texteAM = "Le squelette prend son élan et vous assène un coup de dague : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature donne un coup d'épée et vous fait "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un coup de point : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(4) + 1;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

}

