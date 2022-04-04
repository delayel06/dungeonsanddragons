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
                    posX = i;
                    posY = j;
                }
                evolutionX=evolutionX+(longueur/20);
            }
            evolutionX=0;
            evolutionY=evolutionY+(longueur/20);
        }

    }

    public void right(){
        if(laSalle[posX][posY+1] != 2){

            laSalle[posX][posY+1] = 9;
            laSalle[posX][posY] = 1;
            posX += 1;


        }
        repaint();
    }
    public void left(){
        if(laSalle[posX][posY-1] != 2){

            laSalle[posX][posY-1] = 9;
            laSalle[posX][posY] = 1;
            posY -= 1;


        }
        repaint();
    }
    public void up(){
        if(laSalle[posX-1][posY] != 2){

            laSalle[posX-1][posY] = 9;
            laSalle[posX][posY] = 1;
            posX -= 1;


        }
        repaint();
    }
    public void down(){
        if(laSalle[posX+1][posY] != 2){

            laSalle[posX+1][posY] = 9;
            laSalle[posX][posY] = 1;
            posX += 1;


        }
        repaint();
    }
}
