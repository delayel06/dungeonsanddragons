import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList; 	

public class DeplacementSalle  extends JFrame implements KeyListener{
	int width = 500;
	int height= 500;
	DessinPerso p = new DessinPerso();
	public DeplacementSalle(){
		setTitle( " La carte du jeu ");
        setSize(width,height);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unPanel pan= new unPanel();//La on va creer toutes les salles et les mettre and la Jframe tour a tour
		addKeyListener(this);
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) {

		//	System.out.print("Code clavier "+code+" appuye. ");
		if(e.getKeyCode() == 37){
			p.deplaceGauche();

		}
		if(e.getKeyCode() == 38){
			p.deplaceHaut();

		}
		if(e.getKeyCode() == 39){
			p.deplaceDroite();

		}
		if(e.getKeyCode() == 40){
			p.deplaceBas();


		}
		repaint();

	}
	public void keyReleased(KeyEvent e) {

			p.icon = new ImageIcon("knightidle.png");
			repaint();


	}
	public void keyTyped(KeyEvent e) {  }
	
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0,0,getWidth(),getHeight());
		p.dessine(g);
	}
	
	public static void main (String[] args) {
    DeplacementSalle c = new DeplacementSalle();}
    
}
