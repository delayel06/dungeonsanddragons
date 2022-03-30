import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.beans.JavaBean;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

	public JTextField chatC;

	public Font font;
	public Font fontNOM;
	//Utilitaires
	public JButton potionVie;
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


		// on change pour un beau texte

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

		descrMons = new JLabel("Le monstre attaque ..."); // on peut imaginer changer le label selon l'attaque


		// Interface de combat:----------------------------------------

		//NOUS : -------------------------------------------

		Icon iconperso = personnage.icon;
		PERSO_ICON = new JLabel(iconperso);
		Perso1 = new JPanel();
		Perso1.setLayout(null);
		Perso1.setBackground(Color.white);
		Perso1.add(PERSO_ICON, SwingConstants.CENTER);
		Nom = new JLabel("Kevin ", SwingConstants.CENTER); //A VOIR JE PENSE QUE CA VA DEPENDRE DE LA SALLE
		Nom.setSize(400, 100);

		Nom.setFont(fontNOM);

		BV = new JLabel(new ImageIcon("bv1.png"));


		NomPerso = new JPanel();
		NomPerso.setLayout(null);
		NomPerso.add(Nom);
		NomPerso.setBackground(Color.white);

		BVpanel = new JPanel();
		BVpanel.add(BV);


		BVpanel.setBackground(Color.white);

		Perso2 = new JPanel(new GridLayout(2, 1, 0, 0));
		Perso2.add(BVpanel);
		Perso2.add(NomPerso);
		Perso2.setBackground(Color.white);

		Perso3 = new JPanel();

		Perso3.setBackground(Color.white);

		Perso = new JPanel(new GridLayout(1, 3, 1, 0));
		Perso.add(Perso1);
		Perso.add(Perso2);
		Perso.add(Perso3);
		Perso.setBackground(Color.black);


		//MONSTRE : ---------------------------------------------
		//fenetre monstre numéroté de 1 à 3 en
		Monstre1 = new JPanel();
		Monstre1.setLayout(null);
		Monstre1.setBackground(Color.yellow);

		NomM = new JLabel(m.nom); //A VOIR JE PENSE QUE CA VA DEPENDRE DE LA SALLE
		NomM.setFont(fontNOM);


		BVM = new JLabel((new ImageIcon("bv1.png")));

		NM = new JPanel();
		NM.add(NomM);
		NM.setBackground(Color.white);

		BVmonstre = new JPanel();
		BVmonstre.add(BVM);
		BVmonstre.setBackground(Color.white);

		Monstre2 = new JPanel(new GridLayout(2, 1, 0, 0));
		Monstre2.add(NM);
		Monstre2.add(BVmonstre);
		Monstre2.setBackground(Color.white);


		//j'ai ajouté le gif pour le personnage en haut a droit  -- lilian

		Icon icon = m.icon;
		ImMonstre = new JLabel(icon);


		Monstre3 = new JPanel(new BorderLayout());
		Monstre3.add(ImMonstre);
		Monstre3.setBackground(Color.white);

		Monstre = new JPanel(new GridLayout(1, 3, 1, 0));
		Monstre.add(Monstre1);
		Monstre.add(Monstre2);
		Monstre.add(Monstre3);
		Monstre.setBackground(Color.black);


		//CONTROL : ------------------------------------------------------------------------------------------------
		controle = new JPanel(new GridLayout(2, 2, 2, 2));
		controle.setBackground(Color.white);


		choixImage();
//CHOIX IMAGE AVANT SETBUTTON

		setButton(attaque1);
		setButton(attaque2);
		setButton(attaque3);
		setButton(attaque4);


		controle.add(attaque1);
		controle.add(attaque2);


		//UTILITAIRE --------------------------------------------------------------------
		potionVie = new JButton(new ImageIcon("potionVie.png"));
		setButton(potionVie);
		controle.add(potionVie);
		controle.add(attaque3);
		controle.add(attaque4);

		//TOUR DU MONSTRE -------------------------------------------------------------------------------------------------------



		attaqueM = new JButton("Suite");
		attaqueM.setBackground(Color.gray);
		attaqueM.setFont(font);
		attaqueM.addActionListener(this);


		tourM = new JLabel(" Le monstre attaque !!! ", SwingConstants.CENTER); //A remplir avec des descriptions predéterminées pour chaque attaque
		tourM.setFont(font);



		// Panel Principal : -------------------------------------------------------------------
		cM = new JPanel(new GridLayout(3, 1, 2, 2));
		cM.add(Monstre);
		cM.add(Perso);
		cM.add(controle);
		cM.setSize(width, height);
		cM.setLocation(0, 0);
		cM.setBackground(Color.black);
		add(cM);
		//-----------------------------------------------------------------------------------
		chatC = new JTextField();
		Perso3.add(chatC);

		setVisible(true);

	}


	public void BarreVieM(Monstre m){
		if ((m.HP >= (int)(m.HPmax*0.9))&&(m.HP >= (int)(m.HPmax*0.65))){
			BVM.setIcon(new ImageIcon("bv2.png"));
		}
		else if ((m.HP > (int)(m.HPmax*0.65))&&(m.HP >= (int)(m.HPmax*0.4))){
			BVM.setIcon(new ImageIcon("bv3.png"));
		}
		else if ((m.HP > (int)(m.HPmax*0.4))&&(m.HP >= (int)(m.HPmax*0.15))){
			BVM.setIcon(new ImageIcon("bv4.png"));
		}
		else if ((m.HP >= (int)(m.HPmax*0.15))&&(m.HP > 0)){
			BVM.setIcon(new ImageIcon("bv5.png"));
		}
		else if (m.HP <= 0){
			BVM.setIcon(new ImageIcon("bv6.png"));
		}
		Monstre.revalidate();
		Monstre.repaint();
	}

	public void BarreVieP(Personnage p) {
		if((p.HP >= (int)(p.HP_max*0.9))) {
			BV.setIcon(new ImageIcon("bv1.png"));
		}else if ((p.HP <= (int)(p.HP_max*0.9))&&(p.HP >= (int)(p.HP_max*0.65))){
			BV.setIcon(new ImageIcon("bv2.png"));
		}
		else if ((p.HP < (int)(p.HP_max*0.65))&&(p.HP >= (int)(p.HP_max*0.4))){
			BV.setIcon(new ImageIcon("bv3.png"));
		}
		else if ((p.HP < (int)(p.HP_max*0.4))&&(p.HP >= (int)(p.HP_max*0.15))){
			BV.setIcon(new ImageIcon("bv4.png"));
		}
		else if ((p.HP <= (int)(p.HP_max*0.15))&&(p.HP > 0)){
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
			personnage.a2(m);
			chatC.setText(personnage.texteA);
		} else if (e.getSource() == attaque3){
			personnage.a3(m);
			chatC.setText(personnage.texteA);
		} else if (e.getSource() == attaque4){
			personnage.a4(m);
			chatC.setText(personnage.texteA);
		}
		else if(e.getSource() == attaqueM){
			m.atk(personnage);
			chatC.setText(m.texteAM);
		}
		else if(e.getSource() == potionVie){
			personnage.HP+=4; //à voir en fonction
			if(personnage.HP> personnage.HP_max){
				personnage.HP=personnage.HP_max;
			}
			chatC.setText("Cette potion vous soigne de 4 point  de vie");
		}
		compte+=1;
		compteur();
		BarreVieM(m);
		BarreVieP(personnage);
		combatTerminé();
	}

	private void removeAttackButtons() {
		controle.remove(attaque1);
		controle.remove(attaque2);
		controle.remove(attaque3);
		controle.remove(attaque4);
		controle.remove(potionVie);
		controle.add(tourM);
		controle.add(attaqueM);
	}

	private void addAttackButtons(){
		controle.remove(tourM);
		controle.remove(attaqueM);
		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(potionVie);
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
			attaque1.setForeground(new Color(92, 36, 218, 255));
		}
		else if(personnage.classe=="guerrier"){
			attaque1 = new JButton(new ImageIcon("g1.png"));
			attaque2 = new JButton(new ImageIcon("g2.png"));
			attaque3 = new JButton(new ImageIcon("g3.png"));
			attaque4 = new JButton(new ImageIcon("g4.png"));
		}
		else if(personnage.classe=="archer"){
			//à remplir
		}
		else if(personnage.classe=="paladin"){
			attaque1 = new JButton(new ImageIcon("p1.png"));
			attaque2 = new JButton(new ImageIcon("p2.png"));
			attaque3 = new JButton(new ImageIcon("p3.png"));
			attaque4 = new JButton(new ImageIcon("p4.png"));
		}
	}

	public void combatTerminé(){
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
			controle.removeAll();
			controle.revalidate();
			controle.repaint();
			JButton bDef = new JButton("La partie s'arrête ici pour vous,... Ce monstre a eu raison du puissant guerrier que vous étiez ! ");
			bDef.addActionListener(e -> {this.dispose();});
			controle.add(bDef);
		}

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