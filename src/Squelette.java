public class Squelette extends Monstre {
    public Squelette (){

        super(13,13,"squelette");



    }

    public void atk(Personnage p){
        int j = getRandomInt(8);
        p.HP -=j;

    }

    public int getRandomInt(int n) {
        return (int)(Math.random() * n);
    }

}

