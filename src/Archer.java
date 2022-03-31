public class Archer extends Personnage {
    public Archer(){
        super();
        String texteA[]= {"Lance sort 1","lance sort 2", "lance sort 3", "lance sort4"};
    }
    public void setStats(){
        this.Str = 10 + this.stats[0];
        this.Dex = 14 + this.stats[1];
        this.Con = 13 + this.stats[2];
        this.Int = 8 + this.stats[3];
        this.Wis = 11 + this.stats[4];
        this.Cha = 8 + this.stats[5];

    }
    public void a1(Monstre m){
        int n = (2+this.Mod_Dex);
        texteA="Vous etes en symbiose avec la nature, récuperez "+n+" de vie";
        this.HP+=n;
    }
    public void a2(Monstre m){
        int n = (4+this.Mod_Dex);
        texteA="Vous lancez un couteau dans le flan de la créature qui subit "+n+" points de vie";
        m.HP-=n;
    }
    public void a3(Monstre m){
        int n = (6+this.Mod_Dex));
        texteA="Vous effectuez une faite feinte et attaquez à la dague et infligez "+n+" dégats";
        m.HP-=n;
    }
    public void a4(Monstre m){
        int n = (8+this.Mod_Dex);
        texteA="Vous décochez une flèche qui touche et inflige "+n+" dégats";
        m.HP-=n;
    }
}
