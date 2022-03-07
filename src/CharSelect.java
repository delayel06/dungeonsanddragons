import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.File;
import java.io.IOException;


public class CharSelect extends JFrame implements ActionListener {

    public Icon iconmage,iconguerrier,iconarcher,iconpaladin;

    public JButton mage,guerrier,archer,paladin;

    public int width = 800;
    public int height = 400;

    public JPanel mainpanel;

    public JButton confirm;
    public JButton back;

    public JLabel labelmage = new JLabel("explication mage");
    public JLabel labelguerrier = new JLabel("explication guerrier");
    public JLabel labelpaladin = new JLabel("explication paladin");
    public JLabel labelarcher = new JLabel("explication archer");

    public String classchosen;

    public Font font;





    public CharSelect(){
        setSize(width,height);
        setTitle("Création de Personnage");
        setLocation(getWidth()/2,getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mainpanel = new JPanel(new GridLayout(2,2,20,20));


        iconmage = new ImageIcon("mage.png");
        iconpaladin = new ImageIcon( "paladin.png");
        iconguerrier = new ImageIcon("guerrier.png");
        iconarcher = new ImageIcon("archer.png");

        mage = new JButton("Mage", iconmage );
        guerrier = new JButton("Guerrier",iconguerrier);
        archer = new JButton("Archer",iconarcher);
        paladin = new JButton("Paladin",iconpaladin);
        back = new JButton("Revenir !");
        confirm = new JButton("Confirmer!");

        try{
            // on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
            font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(30f); //taille ici
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
        }
        catch(IOException | FontFormatException e){
            // ca devrait pas arriver ici
        }

        mage.setFont(font);
        paladin.setFont(font);
        guerrier.setFont(font);
        archer.setFont(font);

        mage.setBackground(Color.WHITE);
        guerrier.setBackground(Color.WHITE);
        paladin.setBackground(Color.WHITE);
        archer.setBackground(Color.WHITE);
        back.setBackground(Color.RED);
        confirm.setBackground(Color.GREEN);

        mage.addActionListener(this);
        guerrier.addActionListener(this);
        paladin.addActionListener(this);
        archer.addActionListener(this);
        back.addActionListener(this);
        confirm.addActionListener(this);






        mainpanel.add(mage);
        mainpanel.add(archer);
        mainpanel.add(paladin);
        mainpanel.add(guerrier);





        this.add(mainpanel);

    }



    public void actionPerformed(ActionEvent e) {
        classchoose( e );
    }

    private void classchoose(ActionEvent e) {
        if(e.getSource() == mage){
            classchosen = "mage";

            mainpanel.remove(archer);
            mainpanel.remove(paladin);
            mainpanel.remove(guerrier);
            mainpanel.add(labelmage);
            mainpanel.add(back);
            mainpanel.add(confirm);
            mainpanel.revalidate();

        }else if(e.getSource() == archer){
            classchosen = "archer";

            mainpanel.remove(mage);
            mainpanel.remove(paladin);
            mainpanel.remove(guerrier);
            mainpanel.add(labelarcher);
            mainpanel.add(back);
            mainpanel.add(confirm);
            mainpanel.revalidate();

        }else if(e.getSource() == guerrier){
            classchosen = "guerrier";
            mainpanel.remove(mage);
            mainpanel.remove(paladin);
            mainpanel.remove(archer);
            mainpanel.add(labelguerrier);
            mainpanel.add(back);
            mainpanel.add(confirm);
            mainpanel.revalidate();

        }else if(e.getSource() == paladin){
            classchosen = "paladin";
            mainpanel.remove(mage);
            mainpanel.remove(archer);
            mainpanel.remove(guerrier);

            mainpanel.add(labelpaladin);
            mainpanel.add(back);
            mainpanel.add(confirm);
            mainpanel.revalidate();

        }else if (e.getSource() == back){
            new CharSelect();
            this.dispose();
        }else if(e.getSource() == confirm){
            Personnage perso = new Personnage(classchosen);
            new RaceSelect(perso);
            this.dispose();
        }


    }
}
