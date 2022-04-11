import javax.swing.*;

public class Guerrier extends Personnage {
    public Guerrier(){
        super();
        this.classe = "guerrier";
        this.icon = new ImageIcon("Warrior.gif");
        this.aIcon = new ImageIcon("WarriorA.gif");
        this.dIcon = new ImageIcon("WarriorD1.gif");

    }

    public void setStats(){
        this.Str = 14 + this.stats[0];
        this.Dex = 11 + this.stats[1];
        this.Con = 13 + this.stats[2];
        this.Int = 8 + this.stats[3];
        this.Wis = 10 + this.stats[4];
        this.Cha = 8 + this.stats[5];

    }

    public void a1(Monstre m){
        int n = (2+this.Mod_Str);
        texteA="Coup d'estoc : Vous infligez "+n+" dégats";
        m.HP-=n;
    }
    public void a2(Monstre m){
        int n = (4+this.Mod_Str);
        texteA="Feinte imparable : Vous trompez le monstre à monter sa garde et en profitez pour lui asséner un coup direct, lui faisant subir "+n+" points de vie";
        m.HP-=n;
    }
    public void a3(Monstre m){
        int n = (6+this.Mod_Str);
        texteA="Attaques multiples : la créature se retrouve prise dans un deluge de coups et prend "+n+" dégats";
        m.HP-=n;
    }
    public void a4(Monstre m){
        int n = (8+this.Mod_Str);
        texteA="Frappe surpuissante : Vous mobilisez votre force et mettez toute votre puissante dans ce coup qui fait "+n+" points de vie au monstre";
        m.HP-=n;
    }
    public void aB(Monstre m){
        texteA="Votre attaque ne touche pas !";

    }




}
