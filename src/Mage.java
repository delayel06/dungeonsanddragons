import java.awt.*;
import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Mage extends Personnage{



    public Mage(){
        super();
        this.classe = "mage";
        this.icon = new ImageIcon("wizard.gif");

    }

    public void setStats(){
        this.Str = 8 + this.stats[0];
        this.Dex = 11 + this.stats[1];
        this.Con = 10 + this.stats[2];
        this.Int = 14 + this.stats[3];
        this.Wis = 13 + this.stats[4];
        this.Cha = 8 + this.stats[5];



    }
    public void a1(Monstre m){
        int n = 2;
        texteA="Lance un crâne enflamé. Inflige "+n+" dégats";
        m.HP-=n;
    }
    public void a2(Monstre m){
        int n = 3;
        texteA="Lance une pluie de météores. Inflige "+n+" dégats";
        m.HP-=n;
    }
    public void a3(Monstre m){
        int n = 3;
        texteA="Lance une pluie des flammes. Inflige "+n+" dégats";
        m.HP-=n;
    }
    public void a4(Monstre m){
        int n = 10;
        texteA="Vous vous enflammez. Inflige "+n+" dégats";
        m.HP-=n;
    }


}
