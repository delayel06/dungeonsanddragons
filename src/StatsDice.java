import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;



public class StatsDice extends JPanel {


    public int val;
    public int j = 0;

    public ImageIcon zero = new ImageIcon("0.png");
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

        if(val == 1) {

            holder = one;

        }else if( val == 2) {
            holder = two;
        }else if (val == 3) {
            holder = three;
        }else if(val == 4) {

            holder = four;
        }else if ( val == 5) {
            holder = five;
        }else if(val == 6) {
            holder = six;
        }
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




}




