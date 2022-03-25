import java.awt.*;
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
        String texteA[]= {"Lance sort 1","lance sort 2", "lance sort 3", "lance sort4"};

    }

    public void setStats(){
        this.Str = 8 + this.stats[0];
        this.Dex = 11 + this.stats[1];
        this.Con = 10 + this.stats[2];
        this.Int = 14 + this.stats[3];
        this.Wis = 13 + this.stats[4];
        this.Cha = 8 + this.stats[5];



    }


}
