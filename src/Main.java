import java.util.LinkedList;
import java.util.TreeSet;

public class Main{

    public static void main(String[] args){

        Personnage p = new Personnage();
        p.HP=20;
        p.HP_max=20;
        p.classe="guerrier";
        Monstre m = new Monstre(30,3,"gobelin");
        new InterfaceCombat(p, m);
        //new MenuIntroBis();

    }

}
