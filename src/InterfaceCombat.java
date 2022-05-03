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

	//Contient l'ensemble des éléments de la fenetre
	public JPanel cM; //divisé en 3 lignes (Monstre, Perso et Controle)

	//définition en attribut du monstre et du personnage qui participent au combat
	public Personnage personnage;
	public Monstre m;

	PanelSalles salle;

	//Contient les informations dédiées au monstre (divisé en trois colonnes)
	public JPanel Monstre;
	//CASES DE MONSTRE (numéroté de gauche à droite)
	public JPanel Monstre1; //ne contient rien
	public JPanel Monstre2; //contient nom+barre de vie du monstre
	public JPanel Monstre3; // contient l'image du monstre
	//CASE MONSTRE 2
	public JPanel NM;//contient le nom du monstre
	public JLabel NomM;//nom du monstre
	public JPanel BVmonstre;//contient barre vie du monstre
	public JLabel BVM;//barre de vie du monstre
	//CASE MONSTRE 3
	public JLabel ImMonstre;//gif du monstre

	//Contient les informations dédiées au personnage (divisée en 3 colonnes)
	public JPanel Perso;
	//CASES DE Perso (numéroté de gauche à droite)
	public JPanel Perso1; //contient l'image du joueur
	public JPanel Perso2; //contient barre de vie + nom du joueur
	public JPanel Perso3; //contient descriptions des attaques
	//CASE PERSO 1
	public JLabel PERSO_ICON; //gif perso
	//CASE PERSO 2
	private JPanel BVpanel; //contient barre de vie perso
	public JLabel BV; //barre de vie de perso
	public JPanel NomPerso; //contient le nom du perso
	public JLabel Nom; //nom du perso
	//CASE PERSO 3
	public JLabel chatC; //description attaque (avec dégats)

	//POLICE
	public Font font;
	public Font fontNOM;

	//Contient les actions possibles par le joueurs (attaque ou bouton suite)
	public JPanel controle;
	//définition des boutons d'attaque lors du tour du joueur (tableau 2x2)
	public JButton attaque1;
	public JButton attaque2;
	public JButton attaque3;
	public JButton attaque4;
	//défition du contenu de CM lors du tour du monstre (tableau 2x1)
	public JLabel tourM;
	public JButton attaqueM;

	public int coordx;
	public int coordy;

	//compteur de tour
	public int compte = 1;
	Clip clip;

	public InterfaceCombat(Personnage personnage, Monstre m, PanelSalles salle, int coordx, int coordy) {
		super();
		this.salle = salle;
		this.coordy = coordy;
		this.coordx = coordx;
		this.m = m; //attribut à monstre le monstre avec lequel le jouer lance le combat
		this.personnage = personnage; //définit comme personnage celui que le joueur a choisi
		salle.combat = this;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //la taille de l'interface de combat est celle de la fenêtre
		music("battletheme.wav"); //musique de combat

		try {
			// on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
			font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(60f); //taille ici
			fontNOM = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
		} catch (IOException | FontFormatException e) {
			// ca devrait pas arriver ici
		}

		// Interface de combat:----------------------------------------

		//LIGNE DU PERSONNAGE -------------------------------------------
		//CASE PERSO 1 (contient l'image du personnage)
		PERSO_ICON = new JLabel(personnage.icon);
		Perso1 = new JPanel();
		Perso1.setBackground(null);
		Perso1.add(PERSO_ICON);
		//CASE PERSO 2(contient la barre de vie du personnage et son nom)
		Nom = new JLabel("Vous", SwingConstants.CENTER); // On crée un JLabel pour le nom du personnage
		Nom.setSize(400, 100);
		Nom.setFont(fontNOM);
		NomPerso = new JPanel(); //On crée un Jpanel qui contient le JLabel nom
		NomPerso.setLayout(null);
		NomPerso.add(Nom);
		NomPerso.setBackground(null);
		BV = new JLabel(new ImageIcon("bv1.png")); // On crée un JLabel image pour la barre de vie
		BVpanel = new JPanel(); // On crée un Jpanel qui contient le JLabel barre de vie
		BVpanel.add(BV);
		BVpanel.setBackground(null);
		Perso2 = new JPanel(new GridLayout(2, 1, 0, 0)); // Perso2 contient les deux JPanel crée précédemment (le gridLayout leur permet d'être de la même taille)
		Perso2.add(BVpanel);
		Perso2.add(NomPerso);
		Perso2.setBackground(null);
		//CASE PERSO 3 (contient la destricption des attaques)
		chatC = new JLabel(); //servira à écrire les dégâts et la description des attaques
		Perso3 = new JPanel();
		Perso3.add(chatC);
		Perso3.setBackground(null);
		//LIGNE DU PERSO
		Perso = new JPanel(new GridLayout(1, 3, 0, 0)); //le grid layout sert à le diviser en 3 cases égales
		Perso.add(Perso1);
		Perso.add(Perso2);
		Perso.add(Perso3);
		Perso.setBackground(null);

		//MONSTRE : ---------------------------------------------
		//CASE MONSTRE 1 (elle est vide)
		Monstre1 = new JPanel();
		Monstre1.setLayout(null);
		Monstre1.setBackground(null);
		//CASE MONSTRE 2 (contient la barre de vie et le nom du monstre)
		NomM = new JLabel(m.nom); //attribue comme texte le nom du monstre
		NomM.setFont(fontNOM); //définit la police utilisée
		NomM.setBackground(null);
		NM = new JPanel(); //contient le Jlabel du nom
		NM.add(NomM);
		NM.setBackground(null);
		BVM = new JLabel((new ImageIcon("bv1.png"))); //crée un JLabel image pour la barre de vie
		BVmonstre = new JPanel(); //sert à contenir le Jlabel barre de vie
		BVmonstre.add(BVM);
		BVmonstre.setBackground(null);
		Monstre2 = new JPanel(new GridLayout(2, 1, 0, 0)); //gridlayout pour partager en 2 cases égales
		Monstre2.add(NM);
		Monstre2.add(BVmonstre);
		Monstre2.setBackground(null);
		//CASE MONSTRE 3 (contient l'image du monstre)
		Icon icon = m.icon; //crée un variable qui a pour valeur l'image du monstre
		ImMonstre = new JLabel(icon); //crée un Jlabel image
		Monstre3 = new JPanel(new BorderLayout());
		Monstre3.add(ImMonstre);
		Monstre3.setBackground(null);
		//LIGNE MONSTRE
		Monstre = new JPanel(new GridLayout(1, 3, 0, 0)); //divise en 3 cases égales
		Monstre.add(Monstre1);
		Monstre.add(Monstre2);
		Monstre.add(Monstre3);
		Monstre.setBackground(null);

		//CONTROL : ------------------------------------------------------------------------------------------------
		controle = new JPanel(new GridLayout(2, 2, 2, 2)); // divise en un tableau 2x2
		controle.setBackground(null);
		//QUAN ON DOIT ATTAQUER
		choixImage(); //sert à choisir les bonnes images d'attaques pour chaque classe
		setButton(attaque1); //la méthode sert à créer les boutons
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
		cM = new JPanel(new GridLayout(3, 1, 0, 0)) {
			@Override
			public void paintComponent(Graphics g) {
				ImageIcon image = new ImageIcon("grotte.png");
				g.drawImage(image.getImage(), 0, 0, null);
			}
		};
		paintComponents(cM.getGraphics());
		cM.add(Monstre);
		cM.add(Perso);
		cM.add(controle);
		add(cM);
		//-----------------------------------------------------------------------------------
		this.setVisible(true);

	}

	public void BarreVieM(Monstre m) { //change la barre de vie du monstre en fonction de son nombre d'HP par rapport au max qu'il peut avoir
		if ((m.HP >= (int)(m.HPmax * 0.8))) {
			BVM.setIcon(new ImageIcon("bv1.png"));
		} else if ((m.HP >= (int)(m.HPmax * 0.8)) && (m.HP >= (int)(m.HPmax * 0.6))) {
			BVM.setIcon(new ImageIcon("bv2.png"));
		} else if ((m.HP > (int)(m.HPmax * 0.6)) && (m.HP >= (int)(m.HPmax * 0.4))) {
			BVM.setIcon(new ImageIcon("bv3.png"));
		} else if ((m.HP > (int)(m.HPmax * 0.4)) && (m.HP >= (int)(m.HPmax * 0.20))) {
			BVM.setIcon(new ImageIcon("bv4.png"));
		} else if ((m.HP >= (int)(m.HPmax * 0.2)) && (m.HP > 0)) {
			BVM.setIcon(new ImageIcon("bv5.png"));
		} else if (m.HP <= 0) {
			BVM.setIcon(new ImageIcon("bv6.png"));
		}
		Monstre.revalidate();
		Monstre.repaint();
	}

	public void BarreVieP(Personnage p) { //change la barre de vie du personnage en fonction de son nombre d'HP par rapport au max qu'il peut avoir
		if ((p.HP >= (int)(p.HP_max * 0.8))) {
			BV.setIcon(new ImageIcon("bv1.png"));
		} else if ((p.HP <= (int)(p.HP_max * 0.8)) && (p.HP >= (int)(p.HP_max * 0.6))) {
			BV.setIcon(new ImageIcon("bv2.png"));
		} else if ((p.HP < (int)(p.HP_max * 0.6)) && (p.HP >= (int)(p.HP_max * 0.4))) {
			BV.setIcon(new ImageIcon("bv3.png"));
		} else if ((p.HP < (int)(p.HP_max * 0.4)) && (p.HP >= (int)(p.HP_max * 0.2))) {
			BV.setIcon(new ImageIcon("bv4.png"));
		} else if ((p.HP <= (int)(p.HP_max * 0.2)) && (p.HP > 0)) {
			BV.setIcon(new ImageIcon("bv5.png"));
		} else if (p.HP <= 0) {
			BV.setIcon(new ImageIcon("bv6.png"));
		}
		Perso.revalidate();
		Perso.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == attaque1) { //lance l'attaque 1 (réussi chaque fois)
			personnage.a1(m);
			chatC.setText(personnage.texteA); //décrit l'attaque 1
		} else if (e.getSource() == attaque2) { //lance l'attaque 2 qui a des chances d'échouer
			if (testReussite(0.2) == true) { // 0,2 sont les chances de rater (20%)
				personnage.a2(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}

		} else if (e.getSource() == attaque3) { //lance l'attaque 3 qui a des chances d'échouer
			if (testReussite(0.4) == true) {
				personnage.a3(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}
		} else if (e.getSource() == attaque4) { //lance l'attaque 4 qui a des chances d'échouer

			if (testReussite(0.6) == true) {
				personnage.a4(m);
				chatC.setText(personnage.texteA);
			} else {
				personnage.aB(m);
				chatC.setText(personnage.texteA);
			}
		} else if (e.getSource() == attaqueM) { //lance l'attaque du monstre
			m.atk(personnage);
			chatC.setText(m.texteAM);
		}

		compte += 1; //permet de déctecter le changement de tour
		compteur(); //fait changer de tour
		BarreVieM(m); //test si il faut changer la barre de vie du monstre
		BarreVieP(personnage); //test si il faut changer la barre de vie du personnage
		combatTermine(); //test si le combat est finis
	}

	private void removeAttackButtons() { //adapte l'interface pendant le tour du monstre (image de combat + remplace bouttons d'attaque)
		PERSO_ICON.setIcon(personnage.aIcon); //met l'icon d'attaque pour le personnage
		ImMonstre.setIcon(m.icon); // met l'icon normale pour le monstre
		//on retire ce que contient controle
		controle.remove(attaque1);
		controle.remove(attaque2);
		controle.remove(attaque3);
		controle.remove(attaque4);
		//on met l'interface pour le tour du monstre
		controle.add(tourM);
		controle.add(attaqueM);
	}

	private void addAttackButtons() { //adapte l'interface pendant le tour du joueur (image de combat + remet bouttons d'attaque)
		PERSO_ICON.setIcon(personnage.icon); // met l'icon normale pour le personnage
		ImMonstre.setIcon(m.aIcon); //met l'icon d'attaque pour le monstre
		//on retire ce que contient controle
		controle.remove(tourM);
		controle.remove(attaqueM);
		//on met les boutons d'attaque (dans l'ordre)
		controle.add(attaque1);
		controle.add(attaque2);
		controle.add(attaque3);
		controle.add(attaque4);

	}

	private void compteur() { //sert à identifier le tour de jeu
		if (compte % 2 == 0) { //tour du joueur
			removeAttackButtons();
			controle.revalidate();
			controle.repaint();
		} else if (compte % 2 == 1) { //tour du monstre
			addAttackButtons();
			controle.revalidate();
			controle.repaint();
		}
	}

	public void setButton(JButton a) { //intialise les boutons
		a.setOpaque(false);
		a.setContentAreaFilled(false);
		a.setBorderPainted(false);
		a.addActionListener(this);
	}

	public void choixImage() { //attribut aux boutons une image différents en fonction de l'attribut classe du personnage et met en fond de controle une couleur différente
		if (personnage.classe == "mage") {
			attaque1 = new JButton(new ImageIcon("m1.png"));
			attaque2 = new JButton(new ImageIcon("m2.png"));
			attaque3 = new JButton(new ImageIcon("m3.png"));
			attaque4 = new JButton(new ImageIcon("m4.png"));
			controle.setBackground(new Color(82, 14, 213));
		} else if (personnage.classe == "guerrier") {
			attaque1 = new JButton(new ImageIcon("g1.png"));
			attaque2 = new JButton(new ImageIcon("g2.png"));
			attaque3 = new JButton(new ImageIcon("g3.png"));
			attaque4 = new JButton(new ImageIcon("g4.png"));
			controle.setBackground(new Color(211, 27, 51));
		} else if (personnage.classe == "archer") {
			attaque1 = new JButton(new ImageIcon("a1.png"));
			attaque2 = new JButton(new ImageIcon("a2.png"));
			attaque3 = new JButton(new ImageIcon("a3.png"));
			attaque4 = new JButton(new ImageIcon("a4.png"));
			controle.setBackground(new Color(51, 211, 51));
		} else if (personnage.classe == "paladin") {
			attaque1 = new JButton(new ImageIcon("p1.png"));
			attaque2 = new JButton(new ImageIcon("p2.png"));
			attaque3 = new JButton(new ImageIcon("p3.png"));
			attaque4 = new JButton(new ImageIcon("p4.png"));
			controle.setBackground(new Color(220, 161, 4));
		}
	}

	public void combatTermine() { //détecte la fin du combat
		if (m.HP <= 0) { //si victoire du joueur
			ImMonstre.setIcon(m.dIcon); //image de mort du monstre
			controle.removeAll(); //vide le panel controle
			controle.revalidate();
			controle.repaint();
			JButton bVic = new JButton("Vous avez vaincu le monstre ! Cliquez ici pour revenir sur la salle");
			bVic.addActionListener(e -> {
				salle.combat = this;
				this.dispose(); //ferme l'interface de combat
			});
			controle.add(bVic);
			music("victory.wav");
			salle.battlewin(coordx, coordy);

		} else if (personnage.HP <= 0) { //si défaite du joueur
			PERSO_ICON.setIcon(personnage.dIcon); //met le gif de mort du personnage
			controle.removeAll();
			controle.revalidate();
			controle.repaint();
			JButton bDef = new JButton("La partie s'arrête ici pour vous,... Ce monstre a eu raison du puissant guerrier que vous étiez ! ");
			bDef.addActionListener(e -> {
				this.dispose(); //ferme l'interface de combat
				//ajouter une ligne qui relance le jeu et ferme la feêntre de la salle
			});
			controle.add(bDef);
			salle.battlelose();

		}

	}

	public boolean testReussite(double x) { //permet de créer une part d'aléatoire et de voir si une attaque touche ou non
		double y = Math.random();
		return (y > x);
	}

	public void music(String path) { //sert à jouer de la musique
		if (clip != null) {
			clip.stop();
		}
		File music = new File(path);
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(music));
			clip.start();
		} catch (Exception e) {
			// :(((
		}
	}

}