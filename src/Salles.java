import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salles extends JFrame implements KeyListener {
    int width;
    int heigth;
    PanelSalles salle0, salle11, salle12, salle13, salle21, salle22, salle23, salle31, salle32, salle33, salle41, salle42, salle43, sallef;

    Monstre[] tabmonstre = {
            new Dragon(),
            new Litch(),
            new Vampire(),
            new Demon(),
            new DarkKnight(),
            new DarkKnight(),
            new Mommy(),
            new Mommy(),
            new Mommy(),
            new Mommy(),
            new Mommy(),
            new Zombie(),
            new Zombie(),
            new Zombie(),
            new Zombie(),
            new Zombie(),
            new Squelette(),
            new Squelette(),
            new Squelette(),
            new Squelette(),
            new Fantome(),
            new Fantome(),
            new Demon()
    };
    PanelSalles[] tabsalles;
    Inventaire notreInventaire;
    carte notreCarte;
    public int i;
    Personnage perso;
    boolean mvmt = true;

    public Salles(Personnage perso) {
        this.perso = perso;
        setTitle(" La carte du jeu ");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        width = tailleMoniteur.width * 1 / 2;
        heigth = tailleMoniteur.height * 1 / 2;
        setSize(width + 12, width + 30);
        setResizable(false);
        setIconImage((new ImageIcon("logo.png")).getImage());
        setLocation((tailleMoniteur.width - getSize().width) / 2, ((tailleMoniteur.height - getSize().height) / 2) - 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 0=neant , 1 = MUR , 2 = sol, >100= porte, 4= monstre
        // TOUT CE QUI EST SUPERIEUR A 100 C'EST DES PORTES ON VA SUREMENT FAIRE LA MEME POUR LES MONSTRES ET >200
        int [][] caseSalle0={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 1, 1, 2, 2, 2, 101, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0},
                                { 0, 1, 1, 2, 2, 301, 302, 303, 304, 305, 306, 307, 308, 309, 2, 2, 2, 1, 1, 0},
                                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                                { 0, 1, 110, 2, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 2, 2, 2, 104, 1, 0},
                                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0},
                                { 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0},
                                { 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 107, 2, 2, 2, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int [][] caseSalle11={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 214, 2, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 212, 1, 1, 1, 1, 1, 2, 2, 1, 0},
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 1, 0, 0, 0, 1, 1, 2, 1, 0},
                { 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0, 1, 215, 1, 0},
                { 0, 0, 0, 0, 0, 1, 1, 213, 1, 1, 1, 1, 0, 0, 0, 0, 1, 102, 1, 0},
                { 0, 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                { 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 211, 2, 9, 100, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle12={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 103, 1, 0},
                { 0, 1, 206, 1, 2, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 0},
                { 0, 1, 2, 1, 2, 5, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 0},
                { 0, 1, 2, 1, 2, 2, 1, 2, 2, 1, 207, 1, 2, 2, 1, 2, 1, 209, 1, 0},
                { 0, 1, 2, 1, 2, 5, 1, 5, 2, 1, 2, 1, 5, 2, 1, 208, 1, 2, 1, 0},
                { 0, 1, 2, 1, 2, 2, 1, 5, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 0},
                { 0, 1, 9, 1, 2, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 0},
                { 0, 1, 101, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle13={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 3, 2, 2, 2, 1, 1, 1, 102, 9, 2, 2, 2, 1, 1, 1, 0},
                { 0, 0, 1, 3, 2, 5, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 5, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
                { 0, 1, 3, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 1, 0},
                { 0, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 0},
                { 0, 1, 2, 5, 2, 1, 7, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 7, 2, 2, 1, 2, 2, 5, 2, 2, 1, 1, 1, 1, 0},
                { 0, 1, 1, 1, 2, 1, 1, 5, 1, 1, 1, 1, 2, 2, 5, 1, 0, 0, 0, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 70, 68, 1, 2, 5, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 63, 61, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 70, 68, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 63, 61, 64, 1, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 3, 3, 1, 62, 62, 62, 62, 1, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 5, 5, 1, 1, 1, 1, 1, 1, 1, 5, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 202, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 1, 2, 2, 7, 7, 7, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int [][] caseSalle21={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 9, 100, 1, 1, 2, 80, 80,80, 80, 2, 1, 2, 80, 80, 80, 2, 1, 0},
                { 0, 1, 80, 1, 1, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 2, 80, 2, 1, 1, 1, 1, 80, 80, 80, 80, 80, 1, 80, 1, 0},
                { 0, 1, 80, 1, 80, 80, 80, 1, 2, 80, 80, 80, 2, 80, 80, 80, 1, 80, 1, 0},
                { 0, 1, 80, 1, 80, 80, 80, 80, 80, 1, 1, 80, 1, 80, 1, 1, 1, 80, 1, 0},
                { 0, 1, 80, 1, 2, 80, 2, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 2, 1, 0},
                { 0, 1, 80, 1, 1, 1, 1, 1, 80, 80, 80, 80, 1, 80, 80, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 2, 80, 2, 1, 80, 105, 2, 2, 1, 80, 80, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 80, 1, 80, 1, 80, 80, 80, 1, 1, 80, 80, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 80, 1, 80, 1, 2, 80, 80, 2, 1, 80, 1, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 80, 1, 80, 1, 80, 80, 80, 80, 1, 80, 1, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 80, 1, 80, 1, 80, 80, 1, 80, 1, 80, 1, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 80, 1, 80, 1, 2, 80, 2, 2, 1, 80, 1, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 2, 80, 80, 80, 80, 80, 80, 80, 80, 2, 1, 80, 80, 80, 1, 0},
                { 0, 1, 80, 1, 1, 1, 80, 1, 80, 80, 80, 80, 1, 80, 80, 80, 80, 80, 1, 0},
                { 0, 1, 2, 80, 80, 80, 2, 1, 2, 80, 2, 1, 1, 2, 80, 80, 80, 2, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle22={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 2, 104, 9, 2, 2, 2, 5, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0},
                { 0, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 5, 1, 5, 1, 0, 0, 0, 0},
                { 0, 1, 5, 2, 2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 0, 0, 0, 0},
                { 0, 1, 5, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 1, 2, 72, 69, 1, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 73, 1, 1, 1, 0, 0},
                { 0, 0, 1, 5, 2, 2, 2, 2, 6, 61, 2, 2, 1, 2, 70, 6, 68, 1, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 221, 1, 61, 6, 2, 2, 2, 2, 65, 2, 1, 0, 0},
                { 0, 0, 1, 5, 2, 2, 2, 2, 1, 61, 6, 6, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 1, 2, 1, 72, 62, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 220, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 106, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        int [][] caseSalle23={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 105, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 5, 5, 5, 5, 2, 9, 2, 2, 5, 5, 5, 5, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 64, 69, 71, 1, 1, 64, 69, 71, 1, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 66, 10, 65, 1, 1, 66, 10, 65, 1, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 67, 62, 74, 1, 1, 67, 62, 74, 1, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 3, 69, 69, 69, 69, 69, 69, 3, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 3, 62, 62, 62, 62, 3, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 3, 1, 1, 1, 1, 3, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle31={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 100, 9, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 2, 2, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 2, 2, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 2, 2, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 216, 217, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 219, 218, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 7, 2, 2, 7, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 1, 1, 1, 1, 1, 7, 2, 2, 7, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 0, 1, 7, 7, 7, 1, 7, 2, 2, 2, 7, 7, 7, 7, 7, 1, 0, 0},
                { 0, 0, 0, 1, 7, 5, 5, 7, 7, 2, 2, 2, 2, 2, 2, 2, 108, 1, 0, 0},
                { 0, 0, 0, 1, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2, 2, 1, 0, 0},
                { 0, 0, 0, 1, 7, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1, 0, 0},
                { 0, 0, 0, 1, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] caseSalle32={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 7, 7, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 7, 7, 7, 1, 0},
                { 0, 1, 7, 7, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 7, 7, 1, 0},
                { 0, 1, 7, 2, 1, 1, 7, 7, 7, 1, 1, 7, 7, 7, 1, 1, 2, 7, 1, 0},
                { 0, 1, 2, 2, 1, 1, 1, 1, 1, 2, 109, 1, 1, 1, 1, 1, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 61, 63, 1, 2, 7, 1, 61, 63, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 65, 66, 1, 2, 2, 1, 65, 66, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 68, 70, 1, 7, 2, 1, 68, 70, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 2, 2, 2, 1, 2, 201, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 107, 9, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 5, 2, 2, 2, 2, 2, 2, 5, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 7, 5, 2, 2, 2, 2, 5, 7, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 7, 1, 7, 7, 5, 2, 2, 5, 7, 7, 1, 7, 2, 2, 1, 0},
                { 0, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 0},
                { 0, 1, 7, 2, 1, 1, 7, 7, 7, 2, 2, 7, 7, 7, 1, 1, 2, 7, 1, 0},
                { 0, 1, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7, 7, 1, 0},
                { 0, 1, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7, 7, 7, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle33={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 5, 1, 108, 6, 6, 1, 0},
                { 0, 1, 7, 7, 2, 5, 5, 5, 5, 5, 5, 2, 2, 5, 1, 9, 2, 302, 1, 0},
                { 0, 1, 7, 2, 5, 2, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 6, 5, 5, 2, 5, 2, 5, 5, 2, 2, 2, 5, 5, 3, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 2, 2, 2, 2, 5, 5, 5, 2, 5, 5, 2, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 2, 2, 5, 5, 5, 2, 2, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 7, 5, 5, 5, 5, 2, 5, 5, 3, 2, 5, 2, 2, 2, 2, 5, 1, 0},
                { 0, 1, 7, 5, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 5, 5, 2, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 6, 2, 2, 2, 5, 2, 2, 2, 2, 3, 5, 2, 2, 5, 5, 5, 1, 0},
                { 0, 1, 6, 6, 5, 2, 5, 5, 5, 5, 5, 2, 5, 3, 5, 2, 5, 5, 1, 0},
                { 0, 1, 67, 7, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 1, 0},
                { 0, 1, 66, 6, 5, 5, 5, 5, 5, 5, 5, 5, 2, 2, 5, 6, 7, 6, 1, 0},
                { 0, 1, 69, 7, 6, 5, 5, 2, 330, 5, 5, 5, 2, 2, 6, 73, 64, 65, 1, 0},
                { 0, 1, 63, 65, 6, 5, 5, 2, 5, 5, 5, 5, 6, 6, 7, 7, 7, 69, 1, 0},
                { 0, 1, 64, 65, 6, 6, 7, 7, 7, 6, 6, 6, 7, 7, 7, 64, 65, 60, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };




        int[][] caseSalle41={    { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 2, 2, 2, 100, 9, 2, 2, 2, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 1, 1, 2, 73, 73, 73, 73, 73, 73, 2, 73, 2, 1, 1, 0, 0, 0},
                { 0, 0, 1, 1, 2, 73, 2, 2, 2, 2, 2, 2, 2, 2, 73, 2, 1, 1, 0, 0},
                { 0, 1, 1, 2, 73, 2, 2, 2, 60, 60, 60, 60, 2, 2, 2, 73, 2, 1, 1, 0},
                { 0, 1, 2, 73, 2, 2, 2, 60, 2, 2, 2, 2, 60, 2, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 60, 2, 2, 73, 73, 2, 2, 60, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 2, 2, 73, 222, 2, 2, 2, 60, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 2, 2, 73, 111, 203, 2, 2, 60, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 60, 2, 2, 73,73, 2, 2, 60, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 2, 60, 2, 2, 2, 2, 60, 2, 2, 2, 73, 2, 1, 0},
                { 0, 1, 2, 73, 2, 2, 2, 2, 60, 60, 60, 60, 2, 2, 2, 2, 73, 2, 1, 0},
                { 0, 1, 1, 2, 73, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 73, 2, 1, 1, 0},
                { 0, 0, 1, 1, 2, 73, 2, 2, 2, 2, 2, 2, 2, 2, 73, 2, 1, 1, 0, 0},
                { 0, 0, 0, 1, 1, 2, 73, 73, 73, 73, 73, 73, 73, 73, 2, 1, 1, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };




        int [][] caseSalle42={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 60, 60, 60, 60, 60, 60, 60, 60, 60, 110, 9, 2, 1, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 64, 69, 69, 69, 71, 2, 60, 1, 0, 0},
                { 0, 0, 1, 2, 60, 60, 60, 60, 60, 2, 66, 73, 73, 73, 65, 2, 60, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 60, 2, 66, 73, 72, 73, 65, 2, 60, 1, 0, 0},
                { 0, 0, 1, 60, 60, 60, 60, 2, 60, 2, 66, 73, 73, 73, 65, 2, 60, 1, 0, 0},
                { 0, 0, 1, 69, 69, 69, 71, 2, 60, 2, 67, 62, 62, 62, 74, 2, 60, 1, 0, 0},
                { 0, 0, 1, 73, 73, 73, 65, 2, 60, 2, 2, 2, 2, 2, 2, 2, 60, 1, 0, 0},
                { 0, 0, 1, 66, 66, 73, 65, 2, 61, 62, 62, 62, 62, 62, 62, 62, 63, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 2, 68, 69, 69, 69, 69, 69, 69, 69, 70, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 2, 2, 2, 2, 2, 2, 2, 2, 2, 60, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 61, 62, 62, 62, 62, 62, 62, 63, 2, 60, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 68, 69, 69, 69, 69, 69, 69, 70, 2, 60, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 60, 60, 2, 2, 2, 2, 2, 2, 2, 60, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 60, 60, 2, 60, 60, 60, 60, 60, 60, 60, 1, 0, 0},
                { 0, 0, 1, 60, 66, 73, 65, 60, 60, 2, 60, 60, 60, 60, 60, 60, 60, 1, 0, 0},
                { 0, 0, 0, 1, 66, 73, 65, 60, 60, 112, 60, 60, 60, 60, 60, 60, 1, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle43={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 7, 7, 2, 2, 2, 2, 2, 7, 7, 7, 2, 2, 2, 2, 2, 1, 0},
                { 0, 111, 9, 2, 2, 2, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
                { 0, 1, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 7, 7, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 5, 5, 5, 2, 2, 2, 2, 2, 2, 1, 73, 73, 73, 73, 2, 2, 1, 0},
                { 0, 1, 5, 2, 204, 2, 2, 2, 2, 2, 7, 1, 73, 7, 73, 7, 2, 2, 1, 0},
                { 0, 1, 5, 5, 5, 2, 2, 2, 2, 7, 7, 1, 73, 73, 73, 73, 2, 2, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 73, 2, 2, 5, 5, 5, 1, 0},
                { 0, 1, 5, 3, 5, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 1, 0},
                { 0, 1, 5, 3, 5, 2, 2, 205, 2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 1, 0},
                { 0, 1, 5, 3, 5, 2, 2, 1, 2, 2, 2, 2, 7, 7, 7, 5, 2, 7, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSallef={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 73, 73, 80, 80, 73, 73, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 2, 2, 2, 2, 2, 2, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 2, 2, 2, 2, 2, 2, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 2, 2, 2, 2, 2, 2, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 2, 2, 80, 2, 2, 2, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 73, 2, 2, 2, 2, 2, 2, 73, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 2, 80, 80, 2, 2, 80, 80, 2, 1, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 2, 73, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 1, 73, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        salle0 = new PanelSalles(caseSalle0, width, this);
        salle11 = new PanelSalles(caseSalle11, width, this);
        salle12 = new PanelSalles(caseSalle12, width, this);
        salle13 = new PanelSalles(caseSalle13, width, this);
        salle21 = new PanelSalles(caseSalle21, width, this);
        salle22 = new PanelSalles(caseSalle22, width, this);
        salle23 = new PanelSalles(caseSalle23, width, this);
        salle31 = new PanelSalles(caseSalle31, width, this);
        salle32 = new PanelSalles(caseSalle32, width, this);
        salle33 = new PanelSalles(caseSalle33, width, this);
        salle41 = new PanelSalles(caseSalle41, width, this);
        salle42 = new PanelSalles(caseSalle42, width, this);
        salle43 = new PanelSalles(caseSalle43, width, this);
        sallef = new PanelSalles(caseSallef, width, this);

        notreCarte = new carte();

        notreInventaire = new Inventaire(perso);
        tabsalles = new PanelSalles[] {
                salle0,
                salle11,
                salle12,
                salle13,
                salle21,
                salle22,
                salle23,
                salle31,
                salle32,
                salle33,
                salle41,
                salle42,
                salle43,
                sallef
        };
        this.setContentPane(this.salle0);
        i = 0;
        addKeyListener(this);
        setVisible(true);

    }

    public void keyPressed(KeyEvent e) {
        if (mvmt) {
            if (e.getKeyCode() == 32) {
                //tabsalles[i].space();
                System.out.println(perso.HP_max);
                System.out.println(perso.HP);
            }
            if (e.getKeyCode() == 39) {
                tabsalles[i].right();
            }
            if (e.getKeyCode() == 38) {
                tabsalles[i].up();
            }
            if (e.getKeyCode() == 37) {
                tabsalles[i].left();
            }
            if (e.getKeyCode() == 40) {
                tabsalles[i].down();
            }

        }

    }

    public void keyReleased(KeyEvent e) {
        tabsalles[i].idle();
    }

    public void keyTyped(KeyEvent e) {}

    public void changeSalle(int i) {

        this.setContentPane(tabsalles[i]);
        this.pack();
        this.i = i;
        setSize(width + 12, width + 30);
        setResizable(false);
        this.revalidate();

    }

    public static void main(String[] args) {
        Mage a = new Mage();
        Salles s = new Salles(a);
    }

}