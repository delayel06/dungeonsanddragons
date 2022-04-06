public class Squelette extends Monstre {
    public Squelette (){

        super();
        this.nom = "Squelette";


    }

    public void atk(Personnage p){
        int j = getRandomInt(4);
        p.HP -=j;

    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

}

