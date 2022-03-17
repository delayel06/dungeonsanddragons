import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import java.awt.Color;


public class RaceSelect  extends JFrame implements ActionListener {


        public Icon iconhuman,iconorc,iconelf,icondwarf;

        public JButton human,orc,elf,dwarf;

        public int width = 800;
        public int height = 400;

        public JPanel mainpanel;

        public JButton confirm;
        public JButton back;

        public JLabel labelhuman = new JLabel("explication humain");
        public JLabel labelorc = new JLabel("explication orc");
        public JLabel labelelf = new JLabel("Créature sans égale, vous ne supportez être en compagnie des races inférieurs (en particulier les nains). Etre immortel, vos connaissance sur le monde et sur ses peuples sont immenses. A cause de votre grand-âge vous n'aimez pas vous coucher trop tard.\n" +
                "\n" +
                "Bonus : \n" +
                "\tconstitution -1\n" +
                "\tintelligence +2\n" +
                "\tdextérité +1");
        public JLabel labeldwarf = new JLabel("Téméraires et robustes, les nains sont d'habiles guerriers. Aussi agile avec une hache en main qu'une peinte, ils ne ratent jamais une occasion de festoyer.Ce sont des être très rancuniers qui n'aiment pas qu'on se moque de leur ta...\n" +
                "\n" +
                "Bonus : \n" +
                "\tconstitution +1\n" +
                "\tintelligence +2\n" +
                "\tdextérité -1");

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


            iconhuman = new ImageIcon("human.jpg");
            iconorc = new ImageIcon( "orc.jpg");
            iconelf = new ImageIcon("elf.jpg");
            icondwarf = new ImageIcon("dwarf.jpg");

            human = new JButton("Humain", iconhuman );
            orc = new JButton("Orc",iconorc);
            elf = new JButton("Haut Elf",iconelf);
            dwarf = new JButton("Nain",icondwarf);
            back = new JButton("Revenir !");
            confirm = new JButton("Confirmer!");
/*
            mage.setBackground(Color.WHITE);
            guerrier.setBackground(Color.WHITE);
            paladin.setBackground(Color.WHITE);
            archer.setBackground(Color.WHITE);

 */
            back.setBackground(Color.RED);
            confirm.setBackground(Color.GREEN);

            human.addActionListener(this);
            orc.addActionListener(this);
            elf.addActionListener(this);
            dwarf.addActionListener(this);
            back.addActionListener(this);
            confirm.addActionListener(this);






            mainpanel.add(human);
            mainpanel.add(orc);
            mainpanel.add(elf);
            mainpanel.add(dwarf);





            this.add(mainpanel);

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


