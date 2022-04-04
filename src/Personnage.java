import javax.swing.*;

public class Personnage{
    public String classe;
    public String race;
    public int[] stats = new int[6];
    // 1 str 2 dex 3 int 4 cons 5 wis 6 char
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


    public Personnage(){
        this.Str =1;
        this.Dex =1;
        this.Con =1;
        this.Int =1;
        this.Wis =1;
        this.Cha =1;


    }



    public void setRace(String race){
        this.race = race;
    }

    //re défintion des attaques dans chaque classe
    public void a1(Monstre m){}
    public void a2(Monstre m){}
    public void a3(Monstre m){}
    public void a4(Monstre m){}

    public int Mod(int Stat){
        int Mod =0;
        if (Stat == 21 || Stat ==22){
            Mod = 6;
        } else if (Stat == 19 || Stat == 20){
            Mod = 5;
        } else if (Stat == 17 || Stat == 18){
            Mod = 4;
        } else if (Stat == 15 || Stat == 16){
            Mod = 3;
        } else if (Stat == 13 || Stat == 14){
            Mod = 2;
        } else if (Stat == 11 || Stat == 12){
            Mod= 1;
        } else if (Stat == 9 || Stat == 10){
            Mod = 0;
        } else if (Stat == 7 || Stat == 8){
            Mod = -1;
        } else {
            Mod = -2;
        }
        return Mod;
    }

    public void setPerso(){
        this.Mod_Str = Mod(this.Str);
        this.Mod_Dex = Mod(this.Dex);
        this.Mod_Con = Mod(this.Con);
        this.Mod_Int = Mod(this.Int);
        this.Mod_Wis = Mod(this.Wis);
        this.Mod_Cha = Mod(this.Cha);
        this.HP_max = (10+Mod_Con)*3;
        this.HP = this.HP_max;
    }

    //permet de change la description de l'attaque

    public void changeTexte(String t){
        texteA=t;
    }
}
