import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

public class DeplacementSalle  extends JFrame implements KeyListener{
	int width ;
	int heigth;
	unPanel salle1;
	unPanel salle2;
	Gobelin leMonstre;
	//DessinPerso p = new DessinPerso();
	public DeplacementSalle(){
		setTitle( " La carte du jeu ");
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		width = tailleMoniteur.width * 2/3;
		heigth = tailleMoniteur.height * 2/3;
		setSize(width,heigth);
		setLocation((tailleMoniteur.width - getSize().width)/2,(tailleMoniteur.height - getSize().height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leMonstre = new Gobelin();
		salle1= new unPanel(width, heigth,1,Color.blue,width-50,50,50,100,leMonstre);//La on va creer toutes les salles et les mettre and la Jframe tour a tour
		salle2= new unPanel(width, heigth,2,Color.green,450,50,50,100,leMonstre);

		this.setContentPane(this.salle1);
		addKeyListener(this);
		setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		//int code = e.getKeyCode();
		//	System.out.print("Code clavier "+code+" appuye. ");
		if(getContentPane()==salle1){
			if(e.getKeyCode() == 37){
				salle1.p.deplaceGauche();
				repaint();
			}
			if(e.getKeyCode() == 38){
				salle1.p.deplaceHaut();
				repaint();
			}
			if(e.getKeyCode() == 39){
				salle1.p.deplaceDroite();
				repaint();
			}
			if(e.getKeyCode() == 40){
				salle1.p.deplaceBas();
				repaint();
			}
			if(salle1.p.posX >=(salle1.monstre1.posMonX-3)&& salle1.p.posX <=(salle1.monstre1.posMonX+3 /*salle1.monstre1.rayonMon*/)
					&&salle1.p.posY >=(salle1.monstre1.posMonY-3)&& salle1.p.posY <=(salle1.monstre1.posMonY +3/*salle1.monstre1.rayonMon*/)){
				System.out.print("CA MARCHE");
			}
			if(salle1.p.posX >=salle1.porte1posX && (salle1.p.posY>salle1.porte1posY && salle1.p.posY<(salle1.porte1posY+100))){
				this.setContentPane(this.salle2);
				this.revalidate();
			}
		}
		if(getContentPane()==salle2){
			if(e.getKeyCode() == 37){
				salle2.p.deplaceGauche();
				repaint();
			}
			if(e.getKeyCode() == 38){
				salle2.p.deplaceHaut();
				repaint();
			}
			if(e.getKeyCode() == 39){
				salle2.p.deplaceDroite();
				repaint();
			}
			if(e.getKeyCode() == 40){
				salle2.p.deplaceBas();
				repaint();
			}
			if(salle2.p.posX >450){
				this.setContentPane(this.salle1);
				this.revalidate();
			}
		}

	}
	public void keyReleased(KeyEvent e) { salle1.p.icon = new ImageIcon("knightidle.png");
		repaint();
	}
	public void keyTyped(KeyEvent e) {  }

	/*public void paint(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0,0,width,heigth);
		p.dessine(g);
	}*/

	public static void main (String[] args) {
		DeplacementSalle c = new DeplacementSalle();}

}
