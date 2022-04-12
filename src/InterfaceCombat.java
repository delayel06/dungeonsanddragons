import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class InterfaceCombat extends JFrame implements ActionListener {

	private JPanel BVpanel;
	public int width = 1200;
	public int height = 800;


	public JButton attaque1;
	public JButton attaque2;
	public JButton attaque3;
	public JButton attaque4;

	public JLabel PV;
	public JLabel ptSort;
	public JLabel fond;
	public JLabel descrMons;
	public Personnage personnage;
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

	//description de l'attaque du monstre
	public JPanel desAM;
	public JLabel tourM;
	public JButton attaqueM;

	public JPanel controle;
	public JPanel cM;

	public JLabel chatC;

	public Font font;
	public Font fontNOM;


	//compteur+boutton de fin
	public int compte = 1;
	public JButton bVic;
	public JButton bDef;
	public JLabel PERSO_ICON;


	Clip clip;

	public InterfaceCombat(Personnage personnage, Monstre m) {
		super();
		// FAIRE UNE INITIALISATION DU MONSTRE EN FONCTION DE LA SALLE
		this.m=m;
		this.personnage = personnage;
		setSize(width, height);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocation(0, 0);
		setIconImage( new ImageIcon("logo.png").getImage() );
		music("battletheme.wav");




		try {
			// on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
			font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(60f);//taille ici
			fontNOM = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
		} catch (IOException | FontFormatException e) {
			// ca devrait pas arriver ici
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		descrMons = new JLabel("Le monstre attaque ...");


		// Interface de combat:----------------------------------------

		//NOUS : -------------------------------------------


		PERSO_ICON = new JLabel(personnage.icon);
		Perso1 = new JPanel();
		Perso1.setBackground(null);
		Perso1.add(PERSO_ICON);



		Nom = new JLabel("Kevin ", SwingConstants.CENTER); //A VOIR JE PENSE QUE CA VA DEPENDRE DE LA SALLE
		Nom.setSize(400, 100);

		Nom.setFont(fontNOM);

		BV = new JLabel(new ImageIcon("bv1.png"));


		NomPerso = new JPanel();
		NomPerso.setLayout(null);
		NomPerso.add(Nom);
		NomPerso.setBackground(null);

		BVpanel = new JPanel();
		BVpanel.add(BV);


		BVpanel.setBackground(null);

		Perso2 = new JPanel(new GridLayout(2, 1, 0, 0));
		Perso2.add(BVpanel);
		Perso2.add(NomPerso);
		Perso2.setBackground(null);

		Perso3 = new JPanel();

		Perso3.setBackground(null);

		Perso = new JPanel(new GridLayout(1, 3, 0, 0));
		Perso.add(Perso1);
		Perso.add(Perso2);
		Perso.add(Perso3);
		Perso.setBackground(null);


		//MONSTRE : ---------------------------------------------
		//fenetre monstre numéroté de 1 à 3 de gauche ) droite
		//-----
		Monstre1 = new JPanel();
		Monstre1.setLayout(null);
		Monstre1.setBackground(null);
		//-----
		NomM = new JLabel(m.nom);
		NomM.setFont(fontNOM);
		NomM.setBackground(null);
		NM = new JPanel();
		NM.add(NomM);
		NM.setBackground(null);

		BVM = new JLabel((new ImageIcon("bv1.png")));
		BVmonstre = new JPanel();
		BVmonstre.add(BVM);
		BVmonstre.setBackground(null);

		Monstre2 = new JPanel(new GridLayout(2, 1, 0, 0));
		Monstre2.add(NM);
		Monstre2.add(BVmonstre);
		Monstre2.setBackground(null);
		//-----

		//j'ai ajouté le gif pour le personnage en haut a droit  -- lilian

		Icon icon = m.icon;
		ImMonstre = new JLabel(icon);


		Monstre3 = new JPanel(new BorderLayout());
		Monstre3.add(ImMonstre);
		Monstre3.setBackground(null);

		Monstre = new JPanel(new GridLayout(1, 3, 0, 0));
		Monstre.add(Monstre1);
		Monstre.add(Monstre2);
		Monstre.add(Monstre3);
		Monstre.setBackground(null);


		//CONTROL : ------------------------------------------------------------------------------------------------
		controle = new JPanel(new GridLayout(2, 2, 2, 2));
		controle.setBackground(null);
		choixImage();

		//CHOIX IMAGE AVANT SETBUTTON

		setButton(attaque1);
		setButton(attaque2);
		setButton(attaque3);
		setButton(attaque4);


		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(attaque3);
		controle.add(attaque4);


		//TOUR DU MONSTRE -------------------------------------------------------------------------------------------------------



		attaqueM = new JButton("Suite");
		attaqueM.setBackground(Color.gray);
		attaqueM.setFont(font);
		attaqueM.addActionListener(this);


		tourM = new JLabel(" Le monstre attaque !!! ", SwingConstants.CENTER);
		tourM.setFont(font);



		// Panel Principal : -------------------------------------------------------------------
		cM = new JPanel(new GridLayout(3, 1, 0, 0)){
			@Override
			public void paintComponent(Graphics g){
				ImageIcon image = new ImageIcon("grotte.png");
				g.drawImage(image.getImage(),0, 0,null);
			}
		};
		paintComponents(cM.getGraphics());
		cM.add(Monstre);
		cM.add(Perso);
		cM.add(controle);
		cM.setSize(width, height);
		cM.setLocation(0, 0);

		add(cM);
		//-----------------------------------------------------------------------------------
		chatC = new JLabel();
		Perso3.add(chatC);



		setVisible(true);

	}



	public void BarreVieM(Monstre m){
		if((m.HP >= (int)(m.HPmax*0.8))) {
			BVM.setIcon(new ImageIcon("bv1.png"));
		} else if ((m.HP >= (int)(m.HPmax*0.8))&&(m.HP >= (int)(m.HPmax*0.6))){
			BVM.setIcon(new ImageIcon("bv2.png"));
		}
		else if ((m.HP > (int)(m.HPmax*0.6))&&(m.HP >= (int)(m.HPmax*0.4))){
			BVM.setIcon(new ImageIcon("bv3.png"));
		}
		else if ((m.HP > (int)(m.HPmax*0.4))&&(m.HP >= (int)(m.HPmax*0.20))){
			BVM.setIcon(new ImageIcon("bv4.png"));
		}
		else if ((m.HP >= (int)(m.HPmax*0.2))&&(m.HP > 0)){
			BVM.setIcon(new ImageIcon("bv5.png"));
		}
		else if (m.HP <= 0){
			BVM.setIcon(new ImageIcon("bv6.png"));
		}
		Monstre.revalidate();
		Monstre.repaint();
	}

	public void BarreVieP(Personnage p) {
		if((p.HP >= (int)(p.HP_max*0.8))) {
			BV.setIcon(new ImageIcon("bv1.png"));
		}else if ((p.HP <= (int)(p.HP_max*0.8))&&(p.HP >= (int)(p.HP_max*0.6))){
			BV.setIcon(new ImageIcon("bv2.png"));
		}
		else if ((p.HP < (int)(p.HP_max*0.6))&&(p.HP >= (int)(p.HP_max*0.4))){
			BV.setIcon(new ImageIcon("bv3.png"));
		}
		else if ((p.HP < (int)(p.HP_max*0.4))&&(p.HP >= (int)(p.HP_max*0.2))){
			BV.setIcon(new ImageIcon("bv4.png"));
		}
		else if ((p.HP <= (int)(p.HP_max*0.2))&&(p.HP > 0)){
			BV.setIcon(new ImageIcon("bv5.png"));
		}
		else if (p.HP <= 0){
			BV.setIcon(new ImageIcon("bv6.png"));
		}
		Perso.revalidate();
		Perso.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == attaque1) {
			personnage.a1(m);
			chatC.setText(personnage.texteA);
		}else if (e.getSource() == attaque2){

			if (testReussite(0.2)==true){
				personnage.a2(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}

		} else if (e.getSource() == attaque3){

			if (testReussite(0.4)==true){
				personnage.a3(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}
		} else if (e.getSource() == attaque4){

			if (testReussite(0.6)==true){
				personnage.a4(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}
		}
		else if(e.getSource() == attaqueM){
			m.atk(personnage);
			chatC.setText(m.texteAM);
		}

		compte+=1;
		compteur();
		BarreVieM(m);
		BarreVieP(personnage);
		combatTermine();
	}

	private void removeAttackButtons() {
		PERSO_ICON.setIcon(personnage.aIcon);
		controle.remove(attaque1);
		controle.remove(attaque2);
		controle.remove(attaque3);
		controle.remove(attaque4);
		controle.add(tourM);
		controle.add(attaqueM);
	}

	private void addAttackButtons(){
		PERSO_ICON.setIcon(personnage.icon);
		controle.remove(tourM);
		controle.remove(attaqueM);
		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(attaque3);
		controle.add(attaque4);

	}


	private void compteur(){
		if(compte%2==0){
			removeAttackButtons();
			controle.revalidate();
			controle.repaint();
		}
		else if (compte%2==1){
			addAttackButtons();
			controle.revalidate();
			controle.repaint();
		}
	}

	public void setButton(JButton a){
		a.setOpaque(false);
		a.setContentAreaFilled(false);
		a.setBorderPainted(false);
		a.addActionListener(this);
	}


	public void choixImage(){
		if(personnage.classe=="mage"){
			attaque1 = new JButton(new ImageIcon("m1.png"));
			attaque2 = new JButton(new ImageIcon("m2.png"));
			attaque3 = new JButton(new ImageIcon("m3.png"));
			attaque4 = new JButton(new ImageIcon("m4.png"));
			controle.setBackground(new Color(82, 14, 213));
		}
		else if(personnage.classe=="guerrier"){
			attaque1 = new JButton(new ImageIcon("g1.png"));
			attaque2 = new JButton(new ImageIcon("g2.png"));
			attaque3 = new JButton(new ImageIcon("g3.png"));
			attaque4 = new JButton(new ImageIcon("g4.png"));
			controle.setBackground(new Color(211, 27, 51));
		}
		else if(personnage.classe=="archer"){
			attaque1 = new JButton(new ImageIcon("a1.png"));
			attaque2 = new JButton(new ImageIcon("a2.png"));
			attaque3 = new JButton(new ImageIcon("a3.png"));
			attaque4 = new JButton(new ImageIcon("a4.png"));
			controle.setBackground(new Color(51, 211, 51));
		}
		else if(personnage.classe=="paladin"){
			attaque1 = new JButton(new ImageIcon("p1.png"));
			attaque2 = new JButton(new ImageIcon("p2.png"));
			attaque3 = new JButton(new ImageIcon("p3.png"));
			attaque4 = new JButton(new ImageIcon("p4.png"));
			controle.setBackground(new Color(220, 161, 4));
		}
	}

	public void combatTermine(){
		if (m.HP<=0){
			controle.removeAll();
			controle.revalidate();
			controle.repaint();
			JButton bVic = new JButton("Vous avez vaincu le monstre ! Cliquez ici pour revenir sur la salle");
			bVic.addActionListener(e -> {
				this.dispose();
				//relance sa salle
			});
			controle.add(bVic);
			music("victory.wav");

		}
		else if (personnage.HP<=0){
			PERSO_ICON.setIcon(personnage.dIcon);
			controle.removeAll();
			controle.revalidate();
			controle.repaint();
			JButton bDef = new JButton("La partie s'arrête ici pour vous,... Ce monstre a eu raison du puissant guerrier que vous étiez ! ");
			bDef.addActionListener(e -> {this.dispose();});
			controle.add(bDef);

		}

	}

	public boolean testReussite( double x){
		double y = Math.random();
		return (y>x);
	}


	public void music(String path){
		if(clip != null){
			clip.stop();
		}
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