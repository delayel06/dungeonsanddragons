import java.util.LinkedList; 

public class TestSalles {

    public static void main (String[] args) {
        LinkedList <Salle> carte = new LinkedList<Salle>();
        carte.add(new Salle(1,0,5,0,2));
        carte.add(new Salle(2,3,1,0,0));
        carte.add(new Salle(3,0,0,2,4));
        System.out.println(carte.get(0).toString());
        ControlSalle test = new ControlSalle(carte);
    }

}
