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
    String texteA[]= {"Lance sort 1","lance sort 2", "lance sort 3", "lance sort4"};
}
