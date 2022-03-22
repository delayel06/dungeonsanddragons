import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
 
public class unPanel extends JPanel{
 
 
    public unPanel(){
		this.setBounds(0,0,500,500);
        //this.setBackground(Color.yellow);
        // faire plusier panele et switch de panel 
    }
 
    public  void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(10,10,200,200);
 
    }
 }
