import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

class StatDefine extends JFrame implements ActionListener {

    public Personnage personnage;
    public int width = 800;
    public int height = 400;


    public StatsDice dice = new StatsDice();
    public JButton rollerstr = new JButton("Rouler STR !");
    public JButton rollerdex = new JButton("Rouler DEX !");
    public JButton rollercons = new JButton("Rouler CONS !");
    public JButton rollerintel = new JButton("Rouler INT !");
    public JButton rollerwis = new JButton("Rouler WIS !");
    public JButton rollerchar = new JButton("Rouler CHAR !");








    public JPanel mainpanel ;
    public JButton start ;
    public JLabel label1;


    public StatDefine(Personnage perso){

        this.personnage = perso;
        setSize(width,height);
        setTitle("Création de Personnage");
        setLocation(getWidth()/2,getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mainpanel = new JPanel(new BorderLayout());


        label1 = new JLabel("Vous allez maintenant déterminer vos stats avec un lancé de dés !", SwingConstants.CENTER);

        start = new JButton("Commencer le tirage!");
        start.setBackground(new Color( 35, 133, 141 ));
        start.setPreferredSize( new Dimension(200,100) );
        start.addActionListener(this);


        rollerstr.addActionListener(this);
        rollerdex.addActionListener(this);
        rollerintel.addActionListener(this);
        rollercons.addActionListener(this);
        rollerwis.addActionListener(this);
        rollerchar.addActionListener(this);


        mainpanel.add(start, BorderLayout.PAGE_END);
        mainpanel.add(label1, BorderLayout.CENTER);

        this.add(mainpanel, BorderLayout.CENTER);
        setResizable( false );

    }
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == start){

        mainpanel.remove(label1);
        mainpanel.remove(start);
        mainpanel.revalidate();

        mainpanel.add(dice, BorderLayout.CENTER);
        mainpanel.add(rollerstr, BorderLayout.SOUTH);

    } else if(e.getSource() == rollerstr){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollerstr);
        mainpanel.add(rollerdex, BorderLayout.SOUTH);
        mainpanel.revalidate();

    }else if(e.getSource() == rollerdex){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollerdex);
        mainpanel.add(rollercons, BorderLayout.SOUTH);
        mainpanel.revalidate();

    }else if(e.getSource() == rollercons){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollercons);
        mainpanel.add(rollerintel, BorderLayout.SOUTH);
        mainpanel.revalidate();

    }else if(e.getSource() == rollerintel){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollerintel);
        mainpanel.add(rollerwis, BorderLayout.SOUTH);
        mainpanel.revalidate();

    }else if(e.getSource() == rollerwis){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollerwis);
        mainpanel.add(rollerchar, BorderLayout.SOUTH);
        mainpanel.revalidate();

    }else if(e.getSource() == rollerchar){
        dice.manyroll();
        mainpanel.revalidate();
        mainpanel.remove(rollerchar);
        mainpanel.revalidate();

        // IL FAUT CE SLEEP SINON LE ROLL EST TROP LENT POUR LA BOUCLE EN DESSOUS ! DU COUP YA RIEN DEDANS
        //augmenter le time si on veut plus de roulage de dé
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        setStats();
        personnage.raceAdd();

    }



    }


    public void setStats() {

        for(int i = 0 ; i < 6 ; i++){

            personnage.stats[i] = dice.valeurs[i];
            System.out.println(" ");
            System.out.println(personnage.stats[i]);
        }



    }


/*

    public int rollDie(JLabel a){
        String s = "";
        for(int i = 0 ; i < 22; i++){
            int j = (int)(Math.random()*6);
            a.setIcon( dicearray[j] );
            dicepainted = dicearray[j];
            

        }

        return   convertNumber(  a.getIcon().toString());

    }


    public int convertNumber(String s){


        int a = switch (s) {
            case "6.png" -> 6;
            case "5.png" -> 5;
            case "4.png" -> 4;
            case "3.png" -> 3;
            case "2.png" -> 2;
            case "1.png" -> 1;
            default -> 0;
        };
        return a;
    }
*/
}

