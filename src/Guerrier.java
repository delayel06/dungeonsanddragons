public class Guerrier extends Personnage {
    public Guerrier(){
        super();
        String texteA[]= {"Lance sort 1","lance sort 2", "lance sort 3", "lance sort4"};
        this.classe = "guerrier";

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
        m.HP += (2+this.Mod_Str);
    }

    public void a2(Monstre m){
        m.HP += (4+this.Mod_Str);
    }
    public void a3(Monstre m){
        m.HP += (6+this.Mod_Str);
    }
    public void a4(Monstre m){
        m.HP += (8+this.Mod_Str);
    }




}
