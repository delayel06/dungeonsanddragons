import java.util.LinkedList; 
import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Graphics;
import java.io.*

public class InterfaceCombat extends JFrame implements ActionListener{
	
	int width = 800;
    int height = 400;
	JButton attaque1;
	JButton attaque2;
	JButton attaque3;
	JButton attaque4;
	JLabel PV;
	JLabel ptSort;
	JLabel fond;
	JLabel descrMons;
	Personnage hero;
	Monstre m;
	

	public InterfaceCombat(Personnage hero, Monstre m){
		super();
		this.m = m;
		this.hero = hero;
		setSize(400,500);
		setLocation(300,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		descrMons = new JLabel("Le monstre attaque ..."); // on peut imaginer changer le label selon l'attaque




		JPanel salle = new JPanel();
		salle.setLayout(null);
		salle.setSize(width,(3*height)/4);
        salle.setTitle("Salle");
        salle.setLocation(getWidth()/2,(1.5*getHeight())/4);
		salle.setBackground(Color.white);
		
		JPanel controle = new JPanel(new GridLayout(2,2)());
		controle.setLayout(null);
		controle.setSize(width,(height)/4);
        controle.setTitle("Commandes");
        controle.setLocation(getWidth()/2,(3.5*getHeight())/4);
		controle.setBackground(Color.blue);
		
		JPanel desAM = new JPanel();
		desAM.setLayout(null);
		desAM.setSize(width,(height)/4);
        desAM.setTitle("Description attaque");
        desAM.setLocation(getWidth()/2,(3.5*getHeight())/4);
		desAM.setBackground(Color.blue);
		
		JPanel cM = new JPanel();
		cM.setLayout(null);
		cM.add(salle);
		cM.add(controle);
		cM.setSize(width,height);
        cM.setTitle("Combat");
        cM.setLocation(0,0);
		cM.setBackground(Color.yellow);
		add(cM);
		
		setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == attaque1){
			hero.a1(m);
			controle.setVisible(null);
			desAM.setVisible(true);
			m.jouer(hero);
			thread.sleep(5000);
			controle.setVisible(true);
			desAM.setVisible(null);
			
		} else if (e.getSource() == attaque2){
			hero.a2(m);
		} else if (e.getSource() == attaque3){
			hero.a3(m);
		} else if (e.getSource() == attaque4){
			hero.a4(m);
		} 

	}
}
