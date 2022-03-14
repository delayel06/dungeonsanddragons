public class Personnage extends Figurine{
    public String classe;
    public String race;
    public int HP;
    public int HP_max;
    public int For;
    public int Mod_For;
    public int Dex;
    public int Mod_Dex;
    public int Con;
    public int Mod_Con;
    public int Sag;
    public int Mod_Sag;
    public int Int;
    public int Mod_Int;
    public int Cha;
    public int Mod_Cha;


    public Personnage(String classchosen){
        this.classe = classchosen;
    }



    public void setRace(String race){
        this.race = race;
    }

    public void a1(){}  //re défintion des attaques dans chaque classe
    public void a2(){}
    public void a3(){}
    public void a4(){}
    public void a5(){}
    public void a6(){}

}
