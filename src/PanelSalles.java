import javax.swing.*;
import java.awt.*;

public class PanelSalles extends JPanel {
    int[][]laSalle;
    int longueur;
    int posX;
    int posY;
    ImageIcon icon = new ImageIcon("knightidle.png");
    ImageIcon stone = new ImageIcon("stone.jpg");
    ImageIcon stonefloor = new ImageIcon("stonefloor.jpg");


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
                if(laSalle[i][j]==0){
                    g.setColor(Color.black);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==1){
                    stone.paintIcon( this, g, evolutionX, evolutionY );
                }
                if(laSalle[i][j]==2){
                    stonefloor.paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]>100){
                    g.setColor(Color.yellow);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==4){
                    g.setColor(Color.green);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==9){
                    icon.paintIcon( this, g, evolutionX, evolutionY );
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
        icon = new ImageIcon("knightrun.png");
        if(laSalle[posX][posY+1] != 1 && laSalle[posX][posY+1] < 100 && laSalle[posX][posY+1] != 4){

            laSalle[posX][posY+1] = 9;
            laSalle[posX][posY] = 2;
            posX += 1;


        }

        if(laSalle[posX][posY+1] == 4){

        }
        repaint();
    }
    public void left(){
        icon = new ImageIcon("knightrun2.png");

        if(laSalle[posX][posY-1] != 1 && laSalle[posX][posY-1] != 3 && laSalle[posX][posY-1] != 4){

            laSalle[posX][posY-1] = 9;
            laSalle[posX][posY] = 2;
            posY -= 1;
        }
        if(laSalle[posX][posY-1] == 3){

        }
        if(laSalle[posX][posY-1] == 4){

        }
        repaint();
    }
    public void up(){
        icon = new ImageIcon("knightup.png");

        if(laSalle[posX-1][posY] != 1 && laSalle[posX-1][posY] != 3 && laSalle[posX-1][posY] != 4){

            laSalle[posX-1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX -= 1;
        }
        if(laSalle[posX-1][posY] == 3){

        }
        if(laSalle[posX-1][posY] == 4){

        }
        repaint();
    }
    public void down(){
        icon = new ImageIcon("knightdown.png");

        if(laSalle[posX+1][posY] != 1 && laSalle[posX+1][posY] != 3 && laSalle[posX+1][posY] != 4){

            laSalle[posX+1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX += 1;
        }
        if(laSalle[posX+1][posY] == 3){

        }
        if(laSalle[posX+1][posY] == 4){

        }
        repaint();
    }
    public void idle(){
        icon = new ImageIcon("knightidle.png");
        repaint();
    }
}
