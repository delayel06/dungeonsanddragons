import javax.swing.*;

public abstract class Personnage {
    public String classe;
    public String race;
    public int[] stats = new int[6];
    // 1 str 2 dex 3 cons 4 int 5 wis 6 char
    public int HP;
    public int HP_max;
    public int Str;
    public int Mod_Str;
    public int Dex;
    public int Mod_Dex;
    public int Con;
    public int Mod_Con;
    public int Wis;
    public int Mod_Wis;
    public int Int;
    public int Mod_Int;
    public int Cha;
    public int Mod_Cha;
    public String texteA; //description de l'attaque
    public Icon icon;
    public Icon aIcon;
    public Icon dIcon;

    public Personnage() {
        this.Str = this.stats[0];
        this.Dex = this.stats[1];
        this.Con = this.stats[2];
        this.Int = this.stats[3];
        this.Wis = this.stats[4];
        this.Cha = this.stats[5];
        this.BonusRace();
        this.Mod_Str = Mod(this.Str);
        this.Mod_Dex = Mod(this.Dex);
        this.Mod_Con = Mod(this.Con);
        this.Mod_Int = Mod(this.Int);
        this.Mod_Wis = Mod(this.Wis);
        this.Mod_Cha = Mod(this.Cha);
        this.HP_max = (10 + Mod_Con) * 3;
        this.HP = this.HP_max;

    }

    public void setRace(String race) {
        this.race = race;

    }

    //re défintion des attaques dans chaque classe
    public void a1(Monstre m) {}
    public void a2(Monstre m) {}
    public void a3(Monstre m) {}
    public void a4(Monstre m) {}
    public void aB(Monstre m) {}

    public int Mod(int Stat) {
        int Mod;
        if (Stat >= 29){
            Mod = 10;
        } else if (Stat == 27 || Stat == 28) {
            Mod = 9;
        } else if (Stat == 25 || Stat == 26) {
            Mod = 8;
        } else if (Stat == 23 || Stat == 24) {
            Mod = 7;
        } else if (Stat == 21 || Stat == 22) {
            Mod = 6;
        } else if (Stat == 19 || Stat == 20) {
            Mod = 5;
        } else if (Stat == 17 || Stat == 18) {
            Mod = 4;
        } else if (Stat == 15 || Stat == 16) {
            Mod = 3;
        } else if (Stat == 13 || Stat == 14) {
            Mod = 2;
        } else if (Stat == 11 || Stat == 12) {
            Mod = 1;
        } else if (Stat == 9 || Stat == 10) {
            Mod = 0;
        } else if (Stat == 7 || Stat == 8) {
            Mod = -1;
        } else {
            Mod = -2;
        }
        return Mod;
    }

    public void setPerso() {
        //this.BonusRace();
        this.Mod_Str = Mod(this.Str);
        this.Mod_Dex = Mod(this.Dex);
        this.Mod_Con = Mod(this.Con);
        this.Mod_Int = Mod(this.Int);
        this.Mod_Wis = Mod(this.Wis);
        this.Mod_Cha = Mod(this.Cha);
        this.HP_max = (10 + Mod_Con) * 3;
        this.HP = this.HP_max;
    }

    public void BonusRace() {
        if (this.race.equals("human")) {
            this.Str +=  1;
            this.Dex += 1;
            this.Con += -1;
            this.Int += 1;
            this.Wis += -1;
            this.Cha += 1;

        } else if (this.race.equals("orc")) {
            this.Str += 2;
            this.Con += 1;
            this.Int += -1;

        } else if (this.race.equals("dwarf")) {
            this.Con += 2;
            this.Int += 1;
            this.Cha += -1;
        } else if (this.race.equals("elf")) {
            this.Dex += 2;
            this.Con += -1;
            this.Int += 1;
        }
    }

    //permet de change la description de l'attaque

    public void changeTexte(String t) {
        texteA = t;
    }

    public abstract void setStats();

}