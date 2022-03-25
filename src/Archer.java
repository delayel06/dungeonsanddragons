public class Archer extends Personnage {
    public Archer(){

    }
    public void setStats(){
        this.Str = 10 + this.stats[0];
        this.Dex = 14 + this.stats[1];
        this.Con = 13 + this.stats[2];
        this.Int = 8 + this.stats[3];
        this.Wis = 11 + this.stats[4];
        this.Cha = 8 + this.stats[5];

    }
}
