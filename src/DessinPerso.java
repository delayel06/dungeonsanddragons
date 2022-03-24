import javax.swing.*;
import java.awt.*;

public class DessinPerso extends Component {
	int rayon = 20;
	int posX =250;
	int posY =350;
	public ImageIcon icon = new ImageIcon("knightidle.gif");
	public DessinPerso(){
	}
	public void dessine(Graphics g){
		icon.paintIcon( this, g , posX,posY );
	}
	public void deplaceGauche(){
		icon = new ImageIcon("knightrun2.gif");
		posX = posX - 50;
	}
	public void deplaceDroite(){
		icon = new ImageIcon("knightrun.gif");
		posX = posX + 50;
	}
	public void deplaceHaut(){
		posY = posY - 50;
	}
	public void deplaceBas(){
		posY = posY + 50;
	}
	
}
