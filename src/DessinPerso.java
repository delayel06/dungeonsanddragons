import java.awt.Color;
import java.awt.Graphics;

public class DessinPerso{
	int rayon = 20;
	int posX =250;
	int posY =350;
	public DessinPerso(){
	}
	public void dessine(Graphics g){
		g.setColor(Color.red) ;
		g.fillOval(posX,posY,rayon,rayon) ;
	}
	public void deplaceGauche(){
		posX = posX - 50;
	}
	public void deplaceDroite(){
		posX = posX + 50;
	}
	public void deplaceHaut(){
		posY = posY - 50;
	}
	public void deplaceBas(){
		posY = posY + 50;
	}
	
}
