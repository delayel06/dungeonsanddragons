import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class InterfaceCombat extends JFrame implements ActionListener{
	
	public int width = getWidth();
	public int height = getHeight();


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


	public JLabel ImMonstre;
	public JPanel Monstre;
	//CASES DE MONSTRE
	public JPanel Monstre1;
	public JPanel Monstre2;
	public JPanel Monstre3;

	//CASE MONSTRE 2
	public JPanel NM;
	public JLabel NomM;
	public JPanel BVmonstre;
	public JLabel BVM;

	public JPanel Perso;
	//CASES DE Perso
	public JPanel Perso1;
	public JPanel Perso2;
	public JPanel Perso3;
	//CASE PERSO 2
	public JPanel BarreV;
	public JLabel BV;
	public JPanel NomPerso;
	public JLabel Nom;

	public JPanel desAM;
	public JPanel controle;
	public JPanel cM;

	public Font font;
	public Font fontNOM;



	public InterfaceCombat(Personnage hero, Monstre m){
		super();
		// this.m= m;    en pause pour l'instant (le monstre est choisi par la salle)
		//this.m = Gobelin (20, 3);
		this.hero = hero;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocation(0,0);

		// on change pour un beau texte

		try{
			// on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
			font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(60f);//taille ici
			fontNOM = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
		}
		catch(IOException | FontFormatException e){
			// ca devrait pas arriver ici
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		descrMons = new JLabel("Le monstre attaque ..."); // on peut imaginer changer le label selon l'attaque


		// Interface de combat:----------------------------------------

		//NOUS : -------------------------------------------

		Perso1 = new JPanel();
		Perso1.setLayout(null);
		Perso1.setSize(width,height);
		Perso1.setLocation(getWidth()/2,getHeight()/2);
		Perso1.setBackground(Color.blue);

		Nom = new JLabel("Kevin "); //A VOIR JE PENSE QUE CA VA DEPENDRE DE LA SALLE
		Nom.setSize(width,height);
		Nom.setLocation(getWidth()/2,getHeight()/2);

		BV = new JLabel((new ImageIcon("bv1.png")));
		BV.setSize(width,height);
		BV.setLocation(getWidth()/2,getHeight()/2);

		NomPerso = new JPanel();
		NomPerso.setLayout(null);
		NomPerso.add(Nom);
		NomPerso.setSize(width,height);
		NomPerso.setLocation(getWidth()/2,getHeight()/2);
		NomPerso.setBackground(Color.white);

		BarreV = new JPanel();
		BarreV.setLayout(null);
		BarreV.add(BV);
		BarreV.setSize(width,height);
		BarreV.setLocation(getWidth()/2,getHeight()/2);
		BarreV.setBackground(Color.white);

		Perso2 = new JPanel(new GridLayout(2,1,0,0));
		Perso2.add(NomPerso);
		Perso2.add(BarreV);
		Perso2.setSize(width,height);
		Perso2.setLocation(getWidth()/2,getHeight()/2);
		Perso2.setBackground(Color.white);

		Perso3 = new JPanel();
		Perso3.setLayout(null);
		Perso3.setSize(width,height);
		Perso3.setLocation(getWidth()/2,getHeight()/2);
		Perso3.setBackground(Color.red);

		Perso = new JPanel(new GridLayout(1,3,1,0));
		Perso.add(Perso1);
		Perso.add(Perso2);
		Perso.add(Perso3);
		Perso.setSize(width,height);
		Perso.setLocation(getWidth()/2,getHeight()/2);
		Perso.setBackground(Color.black);


		//MONSTRE : ---------------------------------------------
			//fenetre monstre numéroté de 1 à 3 en
		Monstre1 = new JPanel();
		Monstre1.setLayout(null);
		Monstre1.setSize(width,height);
		Monstre1.setLocation(getWidth()/2,getHeight()/2);
		Monstre1.setBackground(Color.yellow);

		NomM = new JLabel("Gobelin "); //A VOIR JE PENSE QUE CA VA DEPENDRE DE LA SALLE
		NomM.setSize(width,height);
		NomM.setLocation(getWidth()/2,getHeight()/2);
		NomM.setFont(fontNOM);


		BVM = new JLabel((new ImageIcon("bv5.png")));
		BVM.setSize(width,height);
		BVM.setLocation(getWidth()/2,getHeight()/2);

		NM = new JPanel();
		NM.add(NomM);
		NM.setSize(width,height);
		NM.setLocation(getWidth()/2,getHeight()/2);
		NM.setBackground(Color.white);

		BVmonstre = new JPanel();
		BVmonstre.add(BVM);
		BVmonstre.setSize(width,height);
		BVmonstre.setLocation(getWidth()/2,getHeight()/2);
		BVmonstre.setBackground(Color.white);

		Monstre2 = new JPanel(new GridLayout(2,1,0,0));
		Monstre2.add(NM);
		Monstre2.add(BVmonstre);
		Monstre2.setSize(width,height);
		Monstre2.setLocation(getWidth()/2,getHeight()/2);
		Monstre2.setBackground(Color.white);

		ImMonstre = new JLabel((new ImageIcon("orc.png")));
		ImMonstre.setSize(width,height);
		ImMonstre.setLocation(getWidth()/2,getHeight()/2);

		Monstre3 = new JPanel(new BorderLayout());
		Monstre3.add(ImMonstre);
		Monstre3.setSize(width,height);
		Monstre3.setLocation(getWidth()/2,getHeight()/2);
		Monstre3.setBackground(Color.white);

		Monstre = new JPanel(new GridLayout(1,3,1,0));
		Monstre.add(Monstre1);
		Monstre.add(Monstre2);
		Monstre.add(Monstre3);
		Monstre.setSize(width,height);
		Monstre.setLocation(getWidth()/2,getHeight()/2);
		Monstre.setBackground(Color.black);




        //CONTROL : ------------------------------------------------------------------------------------------------
		controle = new JPanel(new GridLayout(2,2,2,2));
		controle.setSize(width,(height)/4);
        controle.setLocation(getWidth()/2,getHeight()/2);
		controle.setBackground(Color.black);


		attaque1 = new JButton("Attaque 1");
		attaque2 = new JButton("Attaque 2");
		attaque3 = new JButton("Attaque 3");
		attaque4 = new JButton("Attaque 4");
		attaque1.setFont(font);
		attaque2.setFont(font);
		attaque3.setFont(font);
		attaque4.setFont(font);



		attaque1.addActionListener(this);
		attaque2.addActionListener(this);
		attaque3.addActionListener(this);
		attaque4.addActionListener(this);

		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(attaque3);
		controle.add(attaque4);
		//-------------------------------------------------------------------------------------------------------

		/*
		desAM = new JPanel();
		desAM.setLayout(null);
		desAM.setSize(width,(height));
        desAM.setLocation(getWidth()/2,getHeight()/2);
		desAM.setBackground(Color.blue);
		*/


		// Panel Principal : -------------------------------------------------------------------
		cM = new JPanel(new GridLayout(3,1,2,2));
		cM.add(Monstre);
		cM.add(Perso);
		cM.add(controle);
		cM.setSize(width,height);
        cM.setLocation(0,0);
		cM.setBackground(Color.black);
		add(cM);
		//-----------------------------------------------------------------------------------

		setVisible(true);

	}

/*
	public void BarreVie(Personnage p){
		if (p.HP >= (int)(p.HP_max*0.8)){

		}
	}
*/
	public void actionPerformed (ActionEvent e) {
/*
		if (e.getSource() == attaque1) {
			//hero.a1(m);
			controle.setVisible(false);
		}

			//desAM.setVisible(true);
			//m.jouer(hero);


			}

		}
			//desAM.setVisible(null);
/*
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

