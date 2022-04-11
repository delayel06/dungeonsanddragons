import javax.swing.*;
import java.awt.*;

public class Mommy extends Monstre{
    public Mommy (){

        super();
        this.nom = "Momie";
        this.HPmax= (int)(15 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("goblin.gif"); //CHANGER
        couleurMonstre= Color.white;

    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.5){
            texteAM = "La momie vous fait un calin un peut trop fort... : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature vous donne un coup de point : "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous tombez à terre : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(2) + 1;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }
}
