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

    public unPanel(int l, int h,int n,Color c, int pX, int pY, int lX, int lY, Monstre m){
        longueur=l;
        hauteur= h;
        numSalle=n;
        couleurSalle= c;
        porte1posX=pX;
        porte1posY=pY;
        porte1longX=lX;
        porte1longY=lY;
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
        p.dessine(g);
        monstre1.dessineMonstre(g);
    }
}
