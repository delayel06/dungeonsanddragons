import java.util.LinkedList;
import java.util.TreeSet;

public class Main{

    public static void main(String[] args){

        Mage p = new Mage();
        p.HP=20;
        p.HP_max=20;
        p.classe="mage";
        Gobelin m = new Gobelin();
        new InterfaceCombat(p, m);
        new MenuIntroBis();

    }

}
