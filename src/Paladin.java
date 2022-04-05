import javax.swing.*;

public class Paladin extends Personnage {
    public Paladin() {
        super();
        this.classe = "paladin";
        this.icon = new ImageIcon("paladin.gif");
    }

    public void setStats(){
        this.Str = 11 + this.stats[0];
        this.Dex = 8 + this.stats[1];
        this.Con = 14 + this.stats[2];
        this.Int = 8 + this.stats[3];
        this.Wis = 13 + this.stats[4];
        this.Cha = 10 + this.stats[5];

    }


    public void a1(Monstre m){
        int n = (2+this.Mod_Str);
        texteA="Point de justice : Vous prenez votre élan et infligez un coup de point destructeur et faites "+n+" dégats";
        m.HP-=n;
    }
    public void a2(Monstre m){
        int n = (4+this.Mod_Str);
        texteA="Coup de justice : Vous assénez un coup de votre arme bénite et faites "+n+" points de vie";
        m.HP-=n;
    }
    public void a3(Monstre m){
        int n = (6+this.Mod_Str);
        texteA="Feu sacré : Vous projetez une colone de flammes, les créatures prissent dedans subissent "+n+" dégats";
        m.HP-=n;
    }
    public void a4(Monstre m){
        int n = (8+this.Mod_Str);
        texteA="Restauration supérieure : Votre dieu vous accorde sa bénédiction: récuperez "+n+" points de vie";
        this.HP+=n;
    }
}