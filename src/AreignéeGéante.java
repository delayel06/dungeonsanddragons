public class AreignéeGéante extends Monstre{
    public AreignéeGéante (){

        super(26,12,"AreignéeGéante");



    }

    public void atk(Personnage p){
        int j = getRandomInt(8)+4;
        p.HP -=j;

    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

}

