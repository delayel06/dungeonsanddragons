import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Salles extends JFrame implements KeyListener {
    int width ;
    int heigth;
    PanelSalles salle1;
    PanelSalles salle2;
    Personnage perso;

    public Salles(Personnage perso){
        this.perso = perso;
        setTitle( " La carte du jeu ");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        width = tailleMoniteur.width * 1/2;
        heigth = tailleMoniteur.height * 1/2;
        setSize(width,width+30);
        setLocation((tailleMoniteur.width - getSize().width)/2,((tailleMoniteur.height - getSize().height)/2)-20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Monsieur les csv ne veulent pas de nous comme les meufs
        // 0=neant , 1 = MUR , 2 = sol, >100= porte, 4= monstre
        // TOUT CE QUI EST SUPERIEUR A 100 C'EST DES PORTES ON VA SUREMENT FAIRE LA MEME POUR LES MONSTRES ET >200
        int [][] caseSalle1={   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 102, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int [][] caseSalle2={   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 103, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 103, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        salle1 =new PanelSalles(caseSalle1,width) ;
        salle2 =new PanelSalles(caseSalle2,width) ;
        this.setContentPane(this.salle1);
        addKeyListener(this);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

        if(getContentPane()==salle1) {
            if (e.getKeyCode() == 39) {
                salle1.right();
                if(salle1.laSalle[salle1.posX][salle1.posY+1] >= 100){
                    this.setContentPane(salle2);
                }
            }
            if (e.getKeyCode() == 38) {
                salle1.up();
            }
            if (e.getKeyCode() == 37) {
                salle1.left();
            }
            if (e.getKeyCode() == 40) {
                salle1.down();
            }
        }
        if(getContentPane()==salle2) {
            if (e.getKeyCode() == 39) {
                salle2.right();
            }
            if (e.getKeyCode() == 38) {
                salle2.up();
            }
            if (e.getKeyCode() == 37) {
                salle2.left();
            }
            if (e.getKeyCode() == 40) {
                salle2.down();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {  }
 
    public static void main (String[] args) {
        Mage a = new Mage();
        Salles s = new Salles(a);}

}