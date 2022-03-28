import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class unPanel extends JPanel{

    DessinPerso p = new DessinPerso();
    int longueur;
    int hauteur;
    int numSalle;
    Color couleurSalle;
    Monstre monstre1;
    //La on a les coordonnées des portes dans les salles
    int porte1posX;
    int porte1posY;
    int porte1longX;
    int porte1longY;
    int porte2posX;
    int porte2posY;
    int porte2longX;
    int porte2longY;

    public unPanel(int l, int h,int n,Color c, int p1X, int p1Y, int p1lX, int p1lY,int p2X, int p2Y, int p2lX, int p2lY, Monstre m){
        longueur=l;
        hauteur= h;
        numSalle=n;
        couleurSalle= c;
        porte1posX=p1X;
        porte1posY=p1Y;
        porte1longX=p1lX;
        porte1longY=p1lY;
        porte2posX=p2X;
        porte2posY=p2Y;
        porte2longX=p2lX;
        porte2longY=p2lY;
		/*On peut faire un tableau contenant tous ls monstres et le parcours pour à,chaque deplacement du jour mais c'est
		inutile vu le nombre de monstre par salle*/
        monstre1=m;
        this.setBounds(0,0,500,500);
    }

    public  void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(couleurSalle);
        g.fillRect(0,0,longueur,hauteur);
        g.setColor(Color.black);
        g.fillRect(porte1posX,porte1posY,porte1longX,porte1longY);
        g.fillRect(porte2posX,porte2posY,porte2longX,porte2longY);
        p.dessine(g);
        monstre1.dessineMonstre(g);
    }
}
