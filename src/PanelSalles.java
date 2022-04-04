import javax.swing.*;
import java.awt.*;

public class PanelSalles extends JPanel {
    int[][]laSalle;
    int longueur;

    int posX;
    int posY;

    public PanelSalles(int [][]s, int l){
        laSalle=s;
        longueur= l;
    }

    public  void paintComponent(Graphics g) {
        int evolutionX =0;
        int evolutionY =0;
        // explication evoX
        for (int i = 0; i<laSalle.length;i++){
            for (int j=0;j<laSalle.length; j++){
                if(laSalle[i][j]==1){
                    g.setColor(Color.black);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==2){
                    g.setColor(Color.blue);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==9){
                    g.setColor(Color.red);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    System.out.println("eazeadz");
                }
                evolutionX=evolutionX+(longueur/20);
            }
            evolutionX=0;
            evolutionY=evolutionY+(longueur/20);
        }

    }

    public void right(){

        repaint();
    }
    public void left(){

        repaint();
    }
    public void up(){

        repaint();
    }
    public void down(){

        repaint();
    }
}
