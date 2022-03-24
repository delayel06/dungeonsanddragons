import java.util.LinkedList;
import java.util.TreeSet;

public class Main{

    public static void main(String[] args){

        Personnage p = new Personnage();
        Monstre m = new Monstre(30,3);
        new InterfaceCombat(p, m);
        //new MenuIntroBis();

    }

}
