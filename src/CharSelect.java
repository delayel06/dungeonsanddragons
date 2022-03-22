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

    public JLabel labelmage = new JLabel("Vêtue d'une robe d'argent qui dénote son rang, un grand chapeau sur la tête, un grimoire dans une main\n" +
            "et un bâton dans l'autre, les magiciens sont très puissants. S'appuyant sur la vague de magie qui se répand\n" +
            "dans le cosmos ils sont capable de contrôler le feu, la foudre, et même la nature. \n" +
            "Il est déconseillé de les sousestimer, ceux qui s'y aventure ont connu une fin atroce.");
    public JLabel labelguerrier = new JLabel("Chevaliers menant une quête, seigneurs conquérants, champions royaux, fantassins d'élite,\n" +
            "mercenaires endurcis et rois-bandits, tous partagent une maîtrise inégalée des armes et des \n" +
            "armures ainsi qu'une connaissance approfondie des compétences de combat. Leur point commun ?\n" +
            "Ce sont tous des guerriers et tous connaissent bien la mort, l'infligeant autant qu'ils lui font face.");
    public JLabel labelpaladin = new JLabel("Quelles que soient leurs origines et leurs missions, les paladins sont unis par leur serment\n" +
            "de s'opposer aux forces du mal. Le serment d'un paladin est un lien très puissant. \n" +
            "Il est la source d'un pouvoir qui transforme un guerrier dévoué en un champion béni. Vêtue d'une\n" +
            "armure étincelante sous le soleil, malgré la poussière et la crasse accumulées durant leurs voyages les\n" +
            "Paladins sont de fier guerriers de la lumière.\n");
    public JLabel labelarcher = new JLabel("Fier guerrier des bois et habile traqueur \n" +
            ", vous êtes un maitre chasseur." +
            " L'archer est la personnification \n" +
            "même du talent pour le tir à l'arc. Il peut réussir tous les tirs réputés difficiles.\n" +
            "Que sa cible soit exposée à de forts vents contraires, ou complètement dissimulée par des buissons,\n" +
            "l'archer est certain de réussir son coup.");

    public String classchosen;

    public Font font;

    public Personnage perso;



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


        ImageIcon backicon = new ImageIcon("exit.png");
        back = new JButton(backicon);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);


        ImageIcon starticon = new ImageIcon("play.png");
        confirm = new JButton(starticon);
        confirm.setOpaque(false);
        confirm.setContentAreaFilled(false);
        confirm.setBorderPainted(false);


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
            if(classchosen == "paladin"){
                perso = new Paladin();
            }else if(classchosen == "mage"){
                perso = new Mage();
            }else if (classchosen == "archer"){
                perso = new Archer();
            }else{
                perso = new Guerrier();
            }

            new RaceSelect(perso);
            this.dispose();
        }


    }
}
