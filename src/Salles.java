import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.event.KeyEvent.VK_RIGHT;

public class Salles extends JFrame implements KeyListener {
    int width ;
    int heigth;
    PanelSalles salle1;
    public Salles(){
        setTitle( " La carte du jeu ");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        width = tailleMoniteur.width * 1/2;
        heigth = tailleMoniteur.height * 1/2;
        setSize(width,width);
        setLocation((tailleMoniteur.width - getSize().width)/2,(tailleMoniteur.height - getSize().height)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int [][] caseSalle1={   { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 9, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                                { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2}
        };

        salle1 =new PanelSalles(caseSalle1,width) ;
        this.setContentPane(this.salle1);
        addKeyListener(this);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(getContentPane()==salle1) {
            if (e.getKeyCode() == 39) {
                salle1.right();
            }
            if (e.getKeyCode() == 38) {

                repaint();
            }
            if (e.getKeyCode() == 37) {

                repaint();
            }
            if (e.getKeyCode() == 40) {

                repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {  }
 
    public static void main (String[] args) {
        Salles s = new Salles();}

}