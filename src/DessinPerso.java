import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class DessinPerso extends Component {
	int rayon = 20;
	int posX =250;
	int posY =350;

	ImageIcon icon = new ImageIcon("knightidle.png");

	public DessinPerso(){
	}
	public void dessine(Graphics g){


		icon.paintIcon( this, g , posX,posY );
	}
	public void deplaceGauche(){
		icon = new ImageIcon("knightrun2.png");
		posX = posX - 50;
	}
	public void deplaceDroite(){
		icon = new ImageIcon("knightrun.png");
		posX = posX + 50;
	}
	public void deplaceHaut(){
		posY = posY - 50;
	}
	public void deplaceBas(){
		posY = posY + 50;
	}
	
}
