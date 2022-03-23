import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.io.File;
import java.io.IOException;


public class RaceSelect  extends JFrame implements ActionListener {


        public Icon iconhuman,iconorc,iconelf,icondwarf;

        public JButton human,orc,elf,dwarf;

        public int width = 800;
        public int height = 400;

        public JPanel mainpanel;

        public JButton confirm;
        public JButton back;
        public Font font;

        public JLabel labelhuman = new JLabel("explication humain");
        public JLabel labelorc = new JLabel("explication orc");
        public JLabel labelelf = new JLabel("explication elf");
        public JLabel labeldwarf = new JLabel("explication nain");

        public String racechoisie;
        public Personnage personnage;

    public RaceSelect(Personnage perso){
            this.personnage = perso;
            setSize(width,height);
            setTitle("Création de Personnage");
            setLocation(getWidth()/2,getHeight()/2);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            mainpanel = new JPanel(new GridLayout(2,2,20,20));
            try{
                // on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
                font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(30f); //taille ici
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
            }
            catch(IOException | FontFormatException e){
                // ca devrait pas arriver ici
            }

            ImageIcon backicon = new ImageIcon("exit.png");


            ImageIcon starticon = new ImageIcon("play.png");

            iconhuman = new ImageIcon("human.jpg");
            iconorc = new ImageIcon( "orc.jpg");
            iconelf = new ImageIcon("elf.jpg");
            icondwarf = new ImageIcon("dwarf.jpg");

            human = new JButton("Humain", iconhuman );
            orc = new JButton("Orc",iconorc);
            elf = new JButton("Haut Elf",iconelf);
            dwarf = new JButton("Nain",icondwarf);
            back = new JButton(backicon);
            confirm = new JButton(starticon);


            setButton( human );
            setButton( orc );
            setButton( elf );
            setButton( dwarf );
            setButton( back );
            setButton( confirm );

            human.setFont( font);
            orc.setFont( font);
            elf.setFont( font);
            dwarf.setFont( font);


            mainpanel.add(human);
            mainpanel.add(orc);
            mainpanel.add(elf);
            mainpanel.add(dwarf);





            this.add(mainpanel);

        }

    public void setButton(JButton a){
        a.setOpaque(false);
        a.setContentAreaFilled(false);
        a.setBorderPainted(false);
        a.addActionListener(this);
    }

        public void actionPerformed(ActionEvent e) {
            classchoose( e );
        }

        private void classchoose(ActionEvent e) {
            if(e.getSource() == human){
                racechoisie = "humain";

                mainpanel.remove(elf);
                mainpanel.remove(orc);
                mainpanel.remove(dwarf);
                mainpanel.add(labelhuman);
                mainpanel.add(back);
                mainpanel.add(confirm);
                mainpanel.revalidate();

            }else if(e.getSource() == orc){
                racechoisie = "orc";

                mainpanel.remove(human);
                mainpanel.remove(elf);
                mainpanel.remove(dwarf);
                mainpanel.add(labelorc);
                mainpanel.add(back);
                mainpanel.add(confirm);
                mainpanel.revalidate();

            }else if(e.getSource() == elf){
                racechoisie = "elf";
                mainpanel.remove(human);
                mainpanel.remove(orc);
                mainpanel.remove(dwarf);
                mainpanel.add(labelelf);
                mainpanel.add(back);
                mainpanel.add(confirm);
                mainpanel.revalidate();

            }else if(e.getSource() == dwarf){
                racechoisie = "nain";
                mainpanel.remove(human);
                mainpanel.remove(orc);
                mainpanel.remove(elf);

                mainpanel.add(labeldwarf);
                mainpanel.add(back);
                mainpanel.add(confirm);
                mainpanel.revalidate();

            }else if (e.getSource() == back){
                new RaceSelect(personnage);
                this.dispose();
            }else if(e.getSource() == confirm){
                personnage.setRace(racechoisie);
                new StatDefine(personnage);
                this.dispose();

            }


        }
    }


