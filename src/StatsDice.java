import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;



public class StatsDice extends JPanel {


    public int val;
    public int j = 0;

    public ImageIcon zero = new ImageIcon("1.png");
    public ImageIcon one = new ImageIcon("1.png");
    public ImageIcon two = new ImageIcon("2.png");
    public ImageIcon three = new ImageIcon("3.png");
    public ImageIcon four = new ImageIcon("4.png");
    public ImageIcon five = new ImageIcon("5.png");
    public ImageIcon six = new ImageIcon("6.png");

    int[] valeurs = new int[8];

    public ImageIcon holder;



public StatsDice(){
        setPreferredSize(new Dimension(100,100));
        setBackground(new Color( 120, 104, 161 ));
        holder = zero;
        setLayout(null);
    }

public void paintComponent(Graphics g) {
        super.paintComponent(g);
        holder.paintIcon(this, g, 330,100 );
        g.drawString("Vous avez roulé un "+ String.valueOf( val ), 335, 80);


            }

public void roll(){
    val = (int)((Math.random()*6)+1);
    setDice();

    }

public void setDice(){

        holder = switch(val) {

            case 1 -> one;
            case 2 -> two;
            case 3 -> three;
            case 4 -> four;
            case 5 -> five;
            case 6 -> six;


            default -> throw new IllegalStateException( "Unexpected value: " + val );
        };
        repaint();


        }

public void manyroll(){

    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        int i = 0;
        public void run()
        {
           roll();

            System.out.print(""+j);
           i++;
           if (i == 10){
               valeurs[j] = val;
               t.cancel();

               j++;

           }
        }


    };

        t.schedule( task,0, 125 );
}

public void lastroll(JFrame a){


    int vallastroll = (int)((Math.random()*6) + 1);
    valeurs[5] = vallastroll;
    System.out.println(vallastroll);



    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        int i = 0;
        public void run() {

            if (i == 9) {

                val = vallastroll;
                setDice();
                i++;

            } else if (i == 10) {

                t.cancel();

                new DeplacementSalle();

                a.dispose();

            }else{
                roll();

                i++;
            }
        }


    };

    t.schedule( task,0, 125 );
}




}








