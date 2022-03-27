import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class DessinPerso extends Component {
	int posX =250;
	int posY =350;

	ImageIcon icon = new ImageIcon("knightidle.png");

	public DessinPerso(){
	}
	public void dessine(Graphics g){


		icon.paintIcon( this, g , posX,posY );
	}
	public void deplaceGauche(){
		posX = posX - 5;
		icon = new ImageIcon("knightrun2.png");
	}
	public void deplaceDroite(){
		posX = posX + 5;
		icon = new ImageIcon("knightrun.png");

	}
	public void deplaceHaut(){
		posY = posY - 5;
		icon = new ImageIcon("knightup.png");

	}
	public void deplaceBas(){
		posY = posY + 5;
		icon = new ImageIcon("knightdown.png");

	}


	
}
