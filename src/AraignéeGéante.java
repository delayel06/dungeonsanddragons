public class AraignéeGéante extends Monstre{
    public AraignéeGéante(){

        super(26,12,"AraignéeGéante");



    }

    public void atk(Personnage p){
        int j = getRandomInt(8)+4;
        p.HP -=j;

    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

}

