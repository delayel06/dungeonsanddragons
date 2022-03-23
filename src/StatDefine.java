import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

class StatDefine extends JFrame implements ActionListener {

    public Personnage personnage;
    public int width = 800;
    public int height = 400;

    ImageIcon rollbutton = new ImageIcon("button_rouler.png");

    public StatsDice dice = new StatsDice();
    public JButton rollerstr = new JButton(rollbutton);
    public JButton rollerdex = new JButton(rollbutton);
    public JButton rollercons = new JButton(rollbutton);
    public JButton rollerintel = new JButton(rollbutton);
    public JButton rollerwis = new JButton(rollbutton);
    public JButton rollerchar = new JButton(rollbutton);


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

        setButton(rollerstr);
        setButton(rollerchar);
        setButton(rollerdex);
        setButton(rollerintel);
        setButton(rollerwis);
        setButton(rollercons);


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
        dice.lastroll(this);
        mainpanel.revalidate();
        mainpanel.remove(rollerchar);
        mainpanel.revalidate();

        setStats();



    }


    }
    public void setStats() {

        for(int i = 0 ; i < 6 ; i++){

            personnage.stats[i] = dice.valeurs[i];
            System.out.println(" ");
            System.out.println(personnage.stats[i]);
        }



    }
    public void setButton(JButton a){
        a.setOpaque(false);
        a.setContentAreaFilled(false);
        a.setBorderPainted(false);
        a.addActionListener(this);
    }

}

