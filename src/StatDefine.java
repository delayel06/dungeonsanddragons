import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import java.awt.Color;

public class StatDefine extends JFrame implements ActionListener {

    public Personnage personnage;
    public int width = 800;
    public int height = 400;

    public ImageIcon one = new ImageIcon("1.png");
    public ImageIcon two = new ImageIcon("2.png");
    public ImageIcon three = new ImageIcon("3.png");
    public ImageIcon four = new ImageIcon("4.png");
    public ImageIcon five = new ImageIcon("5.png");
    public ImageIcon six = new ImageIcon("6.png");

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



        label1 = new JLabel("Vous allez maintenant déterminer vos stats avec un lancé de dés !");

        start = new JButton("Commencer le tirage!");
        start.setBackground(Color.green);
        start.setPreferredSize( new Dimension(200,100) );
        start.addActionListener(this);

        mainpanel.add(start, BorderLayout.PAGE_END);
        mainpanel.add(label1,BorderLayout.CENTER);


        this.add(mainpanel, BorderLayout.CENTER);


    }
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == start){

        mainpanel.remove(label1);
        mainpanel.remove(start);
        mainpanel.revalidate();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(100, 100, (int) dim.getWidth()/2, (int) dim.getHeight()/2);
        setLocationRelativeTo(null);

    }
    }
}
