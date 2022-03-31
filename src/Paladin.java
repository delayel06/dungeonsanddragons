public class Paladin extends Personnage {
    public Paladin() {
        super();
        String texteA[]= {"Lance sort 1","lance sort 2", "lance sort 3", "lance sort4"};
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
        texteA="Vous lancez un crâne enflamé et infligez "+n+" dégats";
        m.HP-=n;
    }
    public void a2(Monstre m){
        int n = (4+this.Mod_Str);
        texteA="Vous puisez dans vos ressources magiques et vous vous soignez "+n+" points de vie";
        m.HP-=n;
    }
    public void a3(Monstre m){
        int n = (6+this.Mod_Str);
        texteA="Lancez une tempète de flammes, le monstre prend "+n+" dégats";
        m.HP-=n;
    }
    public void a4(Monstre m){
        int n = (8+this.Mod_Str);
        texteA="Votre dieu vous accorde sa bénédiction: récuperez "+n+" points de vie";
        this.HP+=n;
    }
}