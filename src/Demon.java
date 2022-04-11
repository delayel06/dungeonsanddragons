import javax.swing.*;
import java.awt.*;

public class Demon extends Monstre {

    public Demon (){

        super();
        this.nom = "Démon Mineur";
        this.HPmax= (int)(20 + Math.random()*5);
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
            texteAM = "Le démon assène un coup de griffe magique: "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature lance un jet de magie démonique :"+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Vous recevez une boule de feu : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(8) + 3;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }
}
