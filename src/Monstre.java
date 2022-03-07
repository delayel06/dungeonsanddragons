public class Monstre {

    public int PV;
    public int CA;

    public Monstre(int PV, int CA){
        this.PV = PV;
        this.CA = CA;
    }


    public int getRandomInt(int n) {
        return (int) (n * Math.random());
    }

    public void a1(){} //re définition dans chaque race de monstre
    public void a2(){}
    public void a3(){}
    public void a4(){}

}
