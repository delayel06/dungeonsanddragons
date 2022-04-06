import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Salles extends JFrame implements KeyListener {
    int width ;
    int heigth;
    PanelSalles salle0, salle1, salle2, salle3, salle4, salle5, salle6;

    Monstre[] tabmonstre = {new Gobelin(), new Gobelin(), new Squelette()};
    PanelSalles[] tabsalles;
    Inventaire notreInventaire;
    int i = 0;
    Personnage perso;

    public Salles(Personnage perso){
        this.perso = perso;
        setTitle( " La carte du jeu ");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        width = tailleMoniteur.width * 1/2;
        heigth = tailleMoniteur.height * 1/2;
        setSize(width,width+30);
        setResizable( false );
        setIconImage( (new ImageIcon("logo.png" )).getImage());
        setLocation((tailleMoniteur.width - getSize().width)/2,((tailleMoniteur.height - getSize().height)/2)-20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 0=neant , 1 = MUR , 2 = sol, >100= porte, 4= monstre
        // TOUT CE QUI EST SUPERIEUR A 100 C'EST DES PORTES ON VA SUREMENT FAIRE LA MEME POUR LES MONSTRES ET >200
        int [][] caseSalle0={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 6, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 6, 6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 200, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 1, 1, 1, 1, 101, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 106, 1, 1, 1, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 1, 105, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 6, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        };

        int [][] caseSalle1={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 6, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 6, 6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 6, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 200, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 5, 2, 1, 1, 2, 5, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 102, 1, 0, 0},
                { 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 1, 9, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 6, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle2={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 9, 103, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 2, 2, 1, 0, 0, 0, 0},
                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 1, 0, 0, 0, 0},
                { 0, 1, 5, 2, 2, 2, 2, 2, 2, 2, 6, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 1, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 1, 1, 2, 2, 2, 2, 6, 6, 2, 2, 2, 2, 2, 13, 13, 1, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 6, 6, 2, 2, 2, 2, 2, 13, 1, 1, 1, 0, 0},
                { 0, 0, 1, 5, 2, 2, 2, 2, 6, 13, 2, 2, 2, 2, 13, 6, 13, 1, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 2, 1, 13, 6, 2, 2, 2, 2, 13, 2, 1, 0, 0},
                { 0, 0, 1, 5, 2, 2, 2, 2, 1, 13, 6, 6, 2, 2, 2, 2, 2, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 1, 2, 1, 13, 13, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 101, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] caseSalle3={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 9, 102, 1, 0},
                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 0},
                { 0, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 5, 2, 2, 1, 13, 13, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 5, 2, 2, 1, 13, 13, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 0},
                { 0, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 104, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] caseSalle4={    { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
                { 0, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 1, 0},
                { 0, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 5, 2, 2, 2, 2, 2, 1, 0},
                { 0, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 5, 2, 2, 2, 1, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 13, 13, 1, 2, 5, 5, 2, 9, 103, 1, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 13, 13, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 0, 0, 1, 2, 2, 2, 2, 1, 13, 13, 1, 2, 2, 2, 2, 2, 2, 1, 0},
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 13, 13, 13, 1, 2, 2, 2, 2, 2, 1, 0},
                { 0, 0, 0, 0, 1, 2, 105, 1, 13, 13, 13, 13, 1, 2, 2, 2, 2, 1, 1, 0},
                { 0, 0, 0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 0},
                { 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int [][] caseSalle5={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 104, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
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
                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2, 106, 1, 0, 0},
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle6={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 7, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 5, 1, 105, 6, 6, 1, 0},
                { 0, 1, 7, 7, 2, 5, 5, 5, 5, 5, 5, 2, 2, 5, 1, 9, 2, 2, 1, 0},
                { 0, 1, 7, 2, 5, 2, 5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 6, 5, 5, 2, 5, 2, 5, 5, 2, 2, 2, 5, 5, 2, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 2, 2, 2, 2, 5, 5, 5, 2, 5, 5, 2, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 2, 5, 5, 5, 5, 2, 2, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 7, 5, 5, 5, 5, 2, 5, 5, 2, 2, 5, 2, 2, 2, 2, 5, 1, 0},
                { 0, 1, 7, 5, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 1, 0},
                { 0, 1, 6, 2, 5, 5, 5, 2, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 1, 6, 2, 2, 2, 5, 2, 2, 2, 2, 2, 5, 2, 2, 5, 5, 5, 1, 0},
                { 0, 1, 6, 6, 5, 2, 5, 5, 5, 5, 5, 2, 5, 2, 5, 2, 5, 5, 1, 0},
                { 0, 1, 67, 7, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 1, 0},
                { 0, 1, 66, 6, 5, 5, 5, 5, 5, 5, 5, 5, 2, 2, 5, 6, 7, 6, 1, 0},
                { 0, 1, 69, 7, 6, 5, 5, 2, 102, 5, 5, 5, 2, 2, 6, 73, 64, 65, 1, 0},
                { 0, 1, 63, 65, 6, 5, 5, 2, 5, 5, 5, 5, 6, 6, 7, 7, 7, 69, 1, 0},
                { 0, 1, 64, 65, 6, 6, 7, 7, 7, 6, 6, 6, 7, 7, 7, 64, 65, 60, 1, 0},
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int [][] caseSalle7={   { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 9, 1, 1, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 0, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 5, 2, 2, 2, 0, 1, 1, 0},
                                { 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 1, 0},
                                { 0, 0, 0, 3, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 1, 0},
                                { 0, 0, 0, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 1, 0},
                                { 0, 0, 0, 3, 1, 2, 2, 68, 69, 70, 71, 73, 73, 5, 1, 2, 0, 1, 1, 0},
                                { 0, 0, 0, 3, 1, 2, 2, 67, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0},
                                { 0, 0, 0, 1, 1, 2, 2, 67, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 64, 3, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 63, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 0, 0},
                                { 0, 0, 1, 1, 2, 2, 2, 62, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 0, 0},
                                { 0, 0, 0, 1, 1, 2, 2, 61, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0},
                                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        salle0 = new PanelSalles(caseSalle0, width, this);
        salle1 =new PanelSalles(caseSalle1,width, this) ;
        salle2 =new PanelSalles(caseSalle2,width, this) ;
        salle3 = new PanelSalles(caseSalle3, width, this);
        salle4 = new PanelSalles(caseSalle4, width, this);
        salle5 = new PanelSalles(caseSalle5, width, this);
        salle6 = new PanelSalles(caseSalle6, width, this);

        notreInventaire = new Inventaire();
        tabsalles = new PanelSalles[]{salle0, salle1, salle2,salle3, salle4, salle5, salle6};
        this.setContentPane(this.salle0);
        addKeyListener(this);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {

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

    public void keyReleased(KeyEvent e) {
        tabsalles[i].idle();
	}

	public void keyTyped(KeyEvent e) {  }

    public void changeSalle(int i){

        this.setContentPane( tabsalles[i] );
        this.pack();
        this.i = i;
        setSize(width,width+30);
        setResizable( false );
        this.revalidate();



    }
 
    public static void main (String[] args) {
        Mage a = new Mage();
        Salles s = new Salles(a);}

}