import javax.swing.*;
import java.awt.*;

public class Dragon extends Monstre{

    public Dragon (){

        super();
        this.nom = "Dragon Squelette";
        this.HPmax= (int)(40 + Math.random()*5);
        this.HP = this.HPmax;
        this.icon = new ImageIcon("dragon.gif");
        this.aIcon = new ImageIcon("dragonA.gif");
        this.dIcon = new ImageIcon("dragonD.gif");
        this.imageM = new ImageIcon("dragonM.png");
        couleurMonstre= Color.white;

    }

    public void dessineMonstre(Graphics g){
        g.setColor(couleurMonstre);
        g.fillOval(posMonX,posMonY,rayonMon,rayonMon);
    }

    public void texteRandom(int dmg){
        double n = Math.random();
        if(n>0.75) {
            texteAM = "Le Dragon utilise son souffle gelé et vous prenez : " + dmg + " dégats !";
        }else if((0.75>n)||(n>0.5)){
                texteAM = "La créature dégage une aura de peur magique : "+dmg+" dégats !";
        } else if((0.5>n)||(n>0.25)){
            texteAM = "La créature vous fait subir un déluge de coup de griffes : "+dmg+" dégats !";
        } else if(n<=0.25) {
            texteAM = "Le Dragon utilise sa morsure d'ombre pour vous inflige : "+dmg+" dégats !";
        }
    }


    public void atk(Personnage p){
        int j = getRandomInt(10) + 3;
        p.HP -=j;
        texteRandom(j);
    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }
}
