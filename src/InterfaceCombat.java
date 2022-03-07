import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCombat extends JFrame implements ActionListener{
	
	public int width = 800;
	public int height = 400;
	public JButton attaque1;
	public JButton attaque2;
	public JButton attaque3;
	public JButton attaque4;
	public JLabel PV;
	public JLabel ptSort;
	public JLabel fond;
	public JLabel descrMons;
	public Personnage hero;
	public Monstre m;
	public JPanel controle;
	public JPanel salle;
	public JPanel desAM;
	public JPanel cM;

	public InterfaceCombat(Personnage hero, Monstre m){
		super();
		this.m = m;
		this.hero = hero;
		setSize(800,400);
		setLocation(0,0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		descrMons = new JLabel("Le monstre attaque ..."); // on peut imaginer changer le label selon l'attaque




		salle = new JPanel();
		salle.setLayout(null);
		salle.setSize(width,(3*height)/4);
        salle.setLocation(getWidth()/2,(int)(1.5*getHeight())/4);
		salle.setBackground(Color.white);
		
		controle = new JPanel(new GridLayout(2,2,10,10));

		controle.setSize(width,(height)/4);
        controle.setLocation(getWidth()/2,(int)(3.5*getHeight())/4);
		controle.setBackground(Color.red);

		attaque1 = new JButton("Attaque 1");
		attaque2 = new JButton("Attaque 2");
		attaque3 = new JButton("Attaque 3");
		attaque4 = new JButton("Attaque 4");

		attaque1.addActionListener(this);
		attaque2.addActionListener(this);
		attaque3.addActionListener(this);
		attaque4.addActionListener(this);

		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(attaque3);
		controle.add(attaque4);



		desAM = new JPanel();
		desAM.setLayout(null);
		desAM.setSize(width,(height)/4);
        desAM.setLocation(getWidth()/2,(int)((3.5*getHeight())/4));
		desAM.setBackground(Color.blue);
		
		cM = new JPanel(new GridLayout(2,1,0,2));
		cM.add(salle);
		cM.add(controle);
		cM.setSize(width,height);
        cM.setLocation(0,0);
		cM.setBackground(Color.black);
		add(cM);
		
		setVisible(true);
		
	}

	public void actionPerformed (ActionEvent e) {
		/*
		if (e.getSource() == attaque1){
			hero.a1(m);
			controle.setVisible(false);
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

*/
	}

}

