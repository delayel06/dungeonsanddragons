import javax.swing.*;
import java.awt.*;

public class Zombie extends Monstre{

    public Zombie (){

        super();
        this.nom = "Zombie";
        this.HPmax= (int)(10 + Math.random()*5);
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
            texteAM = "Le zombie vous griffe le visage : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature vous mords "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez un coup de point : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(3) + 1;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }
}
