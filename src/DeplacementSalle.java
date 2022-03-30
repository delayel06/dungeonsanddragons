import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;
import java.util.LinkedList;

public class DeplacementSalle  extends JFrame implements KeyListener{
	int width ;
	int heigth;
	unPanel salle1;
	unPanel salle2;
	Gobelin leMonstre;
	Personnage personnage;
	Clip clip;
	//DessinPerso p = new DessinPerso();
	public DeplacementSalle(Personnage perso){
		setTitle( " La carte du jeu ");
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		width = tailleMoniteur.width * 2/3;
		heigth = tailleMoniteur.height * 2/3;
		setSize(width,heigth);
		setLocation((tailleMoniteur.width - getSize().width)/2,(tailleMoniteur.height - getSize().height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leMonstre = new Gobelin();
		salle1= new unPanel(width, heigth,1,Color.blue,width-50,50,50,100,0,50,50,100,leMonstre);//La on va creer toutes les salles et les mettre and la Jframe tour a tour
		salle2= new unPanel(width, heigth,2,Color.green,0,50,50,100,width-50,50,50,100,leMonstre);
		this.personnage = perso;
		this.setContentPane(this.salle1);
		addKeyListener(this);
		setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		//int code = e.getKeyCode();
		//	System.out.print("Code clavier "+code+" appuye. ");
		if(e.getKeyChar() == 'p'){
			System.out.println("X : " + salle1.p.posX +"Y: "+ salle1.p.posY);
		}
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
			if(salle1.p.posX >=(salle1.monstre1.posMonX-40)&& salle1.p.posX <=(salle1.monstre1.posMonX-10 )
					&&salle1.p.posY >=(salle1.monstre1.posMonY-40)&& salle1.p.posY <=(salle1.monstre1.posMonY - 10)){
				System.out.print("CA MARCHE");
				//touche monstre vert
				Gobelin gob = new Gobelin();
				//new InterfaceCombat(personnage, gob);
				LancementCombat a =new LancementCombat(personnage, gob);
				salle1.p.posX += 100;
				salle1.p.posY += 100;

				this.setVisible(false);
			}
			if(salle1.p.posX >=salle1.porte1posX && (salle1.p.posY>salle1.porte1posY-50 && salle1.p.posY<(salle1.porte1posY+100))){
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
			if(salle2.p.posX <=salle2.porte1posX && (salle2.p.posY>salle2.porte1posY-50 && salle2.p.posY<(salle2.porte1posY+100))){
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
		DeplacementSalle c = new DeplacementSalle(new Mage());}


	public void music(String path){

		File music = new File(path);
		try {
			clip = AudioSystem.getClip();
			clip.open( AudioSystem.getAudioInputStream( music ) );
			clip.start();
		}catch(Exception e){
			// :(((
		}
	}
}