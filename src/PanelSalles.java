import javax.swing.*;
import java.awt.*;

public class PanelSalles extends JPanel {
    int[][]laSalle;
    int longueur;
    int posX;
    int posY;
    Salles main;
    ImageIcon icon = new ImageIcon("knightidle.png");



    public PanelSalles(int [][]s, int l, Salles salle){
        laSalle=s;
        longueur= l;
        main = salle;





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
                    (new ImageIcon("stone.jpg")).paintIcon( this, g, evolutionX, evolutionY );
                }
                if(laSalle[i][j]==2){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);

                }
                if(laSalle[i][j]>=100){
                    g.setColor(Color.yellow);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }
                if(laSalle[i][j]==4){
                    g.setColor(Color.green);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("barrel.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if(laSalle[i][j]==3){
                    g.setColor(Color.red);
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                }if(laSalle[i][j] == 6){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("rock.png")).paintIcon(this, g, evolutionX, evolutionY);

                }if(laSalle[i][j] == 5){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("barrel.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if(laSalle[i][j]==9){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    icon.paintIcon( this, g, evolutionX-20, evolutionY-10 );
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
        if(laSalle[posX][posY+1] == 2 ){

            laSalle[posX][posY+1] = 9;
            laSalle[posX][posY] = 2;
            posY += 1;


            }
        else if(laSalle[posX][posY+1] >= 100){
            main.changeSalle( laSalle[posX][posY+1] -100  );

        }else if (laSalle[posX][posY+1] == 5){
            if(laSalle[posX][posY+2] == 2){
                laSalle[posX][posY+2] = 5;
                laSalle[posX][posY+1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
            }else if(laSalle[posX][posY+2] == 3){
                laSalle[posX][posY+2] = 4;
                laSalle[posX][posY+1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
                checkPuzzle1();
            }
        }
        repaint();
    }
    public void left(){
        icon = new ImageIcon("knightrun2.png");

        if(laSalle[posX][posY-1] == 2){

            laSalle[posX][posY-1] = 9;
            laSalle[posX][posY] = 2;
            posY -= 1;
        }
        else if(laSalle[posX][posY-1] >= 100){
            main.changeSalle( laSalle[posX][posY-1] -100  );

        }else if (laSalle[posX][posY-1] == 5){
            if(laSalle[posX][posY-2] == 2){
                laSalle[posX][posY-2] = 5;
                laSalle[posX][posY-1] = 9;
                laSalle[posX][posY] = 2;
                posY -= 1;
            }else if(laSalle[posX][posY-2] == 3){
                laSalle[posX][posY-2] = 4;
                laSalle[posX][posY-1] = 9;
                laSalle[posX][posY] = 2;
                posY -= 1;
                checkPuzzle1();

            }
        }


        repaint();
    }
    public void up(){
        icon = new ImageIcon("knightup.png");
        System.out.println(posX);
        if(laSalle[posX-1][posY] == 2){

            laSalle[posX-1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX -= 1;
            System.out.println("apres: "+posX);
        }
             else if(laSalle[posX-1][posY] >= 100){
                main.changeSalle( laSalle[posX-1][posY] -100  );

        }else if (laSalle[posX-1][posY] == 5){
            if(laSalle[posX-2][posY] == 2){
                laSalle[posX-2][posY] = 5;
                laSalle[posX-1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX -= 1;
            }else if(laSalle[posX-2][posY] == 3){
                laSalle[posX-2][posY] = 4;
                laSalle[posX-1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX -= 1;
                checkPuzzle1();

            }
        }
        repaint();
    }
    public void down(){
        icon = new ImageIcon("knightdown.png");

        if(laSalle[posX+1][posY] == 2){

            laSalle[posX+1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX += 1;
        }
        else if(laSalle[posX+1][posY] >= 100){
            main.changeSalle( laSalle[posX+1][posY] -100  );

        }else if (laSalle[posX+1][posY] == 5){
            if(laSalle[posX+2][posY] == 2){
                laSalle[posX+2][posY] = 5;
                laSalle[posX+1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX += 1;
            }else if(laSalle[posX+2][posY] == 3){
                laSalle[posX+2][posY] = 4;
                laSalle[posX+1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX += 1;
                checkPuzzle1();

            }
        }
        repaint();
    }
    public void idle(){
        icon = new ImageIcon("knightidle.png");
        repaint();
    }

    public void checkPuzzle1() {
        boolean b = true;

            for (int i = 0; i < laSalle.length; i++) {
                for (int j = 0; j < 20; j++) {
                    if(laSalle[i][j] == 3){
                        b = false;
                        break;
                    }
                }
            }
            if(b){
                laSalle[18][3] = 102;
            }

    }
}
