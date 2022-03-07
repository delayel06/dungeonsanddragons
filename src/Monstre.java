public class Monstre extends Figurine {

    public Monstre(){
        super();
    }

    public void a1 (personnage p){
        if((getRandomInt(20)+1)>p.CA){
            p.PV=p.PV-((getRandomInt(4)+1)+this.modifDext);
        }
    }

    public void a2 (){
        if((getRandomInt(20)+1)>p.CA){
            p.PV=p.PV-(2*(getRandomInt(6)+1)+this.modifForce);
        }
    }

    public void a3 (){
        if((getRandomInt(20)+1)>p.CA){
            p.PV=p.PV-(2*(getRandomInt(4)+1)+this.modifDext);
        }
    }

    public void jouer(personnage p){
        int n = getRandomInt(100);
        if(n <5){
            this.pv -= 2;
        }
        else if(5<=n<=55){
            this.a1(p);
        }
        else if(56<=n<=85){
            this.a1(p);
        }
        else if(85<=n<=99){
            this.a1(p);
        }
    }

    public int getRandomInt(int n){
        int x = (int)(n*math.random);
        return x;
    }
