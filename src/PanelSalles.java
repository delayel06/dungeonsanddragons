import javax.swing.*;
import java.awt.*;

public class PanelSalles extends JPanel {
    int[][]laSalle;
    int longueur;
    int posX=4;
    int posY=4;

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
                    g.fillRect(evolutionX,evolutionY,longueur/10,longueur/10);
                }
                if(laSalle[i][j]==2){
                    g.setColor(Color.blue);
                    g.fillRect(evolutionX,evolutionY,longueur/10,longueur/10);
                }
                if(laSalle[i][j]==9){
                    g.setColor(Color.red);
                    g.fillRect(evolutionX,evolutionY,longueur/10,longueur/10);
                    System.out.println("eazeadz");
                }
                evolutionX=evolutionX+(longueur/10);
            }
            evolutionX=0;
            evolutionY=evolutionY+(longueur/10);
        }

    }

    public void right(){

        laSalle[4][4] = 9;
        repaint();
    }
}
