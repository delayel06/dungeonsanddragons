import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelSalles extends JPanel implements MouseListener {
    int[][]laSalle;
    int longueur;
    int posX;
    int posY;
    Salles main;
    ImageIcon icon = new ImageIcon("knightidle.png");
    JLabel labelTest ;


    public PanelSalles(int [][]s, int l, Salles salle){
        laSalle=s;
        longueur= l;
        main = salle;
        setLayout(null);
        labelTest = new JLabel();
        labelTest.setBounds(0,0,longueur/20, longueur/20);
        labelTest.addMouseListener(this);
        add(labelTest);



    }
    public void mouseClicked(MouseEvent e) {
        System.out.println("EAZPEAEPOAZDIOAZDAOZIDNAZOI");
        main.notreInventaire.setVisible(true);
        main.notreInventaire.repaint();
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
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
                if(laSalle[i][j]>=100 && laSalle[i][j]<200){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("door.png")).paintIcon(this, g, evolutionX-30, evolutionY-30);

                }if(laSalle[i][j]>=200 && laSalle[i][j]<=300 ){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("ombre.png")).paintIcon(this, g, evolutionX-10, evolutionY-10);

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
                if(laSalle[i][j] == 8){
                    (new ImageIcon("backpack.png")).paintIcon(this, g, evolutionX, evolutionY);
                }

                //CRISTALS
                if(laSalle[i][j] == 7){//crystal
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("crystal.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if(laSalle[i][j] == 10){//OMBRE
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);
                    (new ImageIcon("ombre.png")).paintIcon(this, g, evolutionX, evolutionY);

                }


                //LAVES DIFFERENTES
                if(laSalle[i][j]==60){
                    g.setColor(new Color( 145, 107, 100 ));
                    g.fillRect(evolutionX,evolutionY,longueur/20,longueur/20);

                    (new ImageIcon("lava1.png")).paintIcon(this,g,evolutionX,evolutionY);
                }
                if(laSalle[i][j]==61) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava2.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==62) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava3.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==63) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava4.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==64) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava5.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==65) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava6.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==66) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava7.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==67) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava8.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==68) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava9.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==69) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava10.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==70) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava11.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==71) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava12.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==72) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava13.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==73) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava14.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if(laSalle[i][j]==74) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava15.png")).paintIcon(this, g, evolutionX, evolutionY);
                }

                // OBJETS
                if(laSalle[i][j]>=300) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("rock.png")).paintIcon(this, g, evolutionX-10, evolutionY-10);
                }
                if (laSalle[i][j] ==321) {
                    g.setColor(Color.orange);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur/ 20);
                    (new ImageIcon("bone.png")).paintIcon(this, g, evolutionX, evolutionY);

                }



                if(laSalle[i][j]==14){

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
// MOVEMENT
    public void right(){
        icon = new ImageIcon("knightrun.png");
        if(laSalle[posX][posY+1] == 2 ){

            laSalle[posX][posY+1] = 9;
            laSalle[posX][posY] = 2;
            posY += 1;


            }
        else if(laSalle[posX][posY+1] >= 100 && laSalle[posX][posY+1] < 200){
            main.changeSalle( laSalle[posX][posY+1] -100  );

        }else if (laSalle[posX][posY+1] == 5){ // Barils bouger
            if(laSalle[posX][posY+2] == 2){
                laSalle[posX][posY+2] = 5;
                laSalle[posX][posY+1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
            }else if(laSalle[posX][posY+2] == 3){ // Puzzle 1
                laSalle[posX][posY+2] = 4;
                laSalle[posX][posY+1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
                checkPuzzle1();
            }
        }else if (laSalle[posX][posY+1] >= 200 && laSalle[posX][posY+1] < 300){
            
            new InterfaceCombat(main.perso, main.tabmonstre[laSalle[posX][posY+ 1]- 200]  );
        }
        else if (laSalle[posX][posY+1] >= 300 && laSalle[posX][posY+1] <= 320){

            laSalle[posX][posY+1] =321;
            repaint();
            //System.out.println("ca marche "+ (laSalle[posX][posY+1]-300));
            main.notreInventaire.repaint();
        }else if (laSalle[posX][posY+1] >= 321 && laSalle[posX][posY+1] <= 400){
            main.notreInventaire.lesObjets[1][3]=laSalle[posX][posY+1]-300;
            laSalle[posX][posY+1] =2;
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
        else if(laSalle[posX][posY-1] >= 100 && laSalle[posX][posY-1] < 200){
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
        }else if (laSalle[posX][posY-1] >= 300 && laSalle[posX][posY-1] < 400){
            main.notreInventaire.lesObjets[1][3]=laSalle[posX][posY-1] -300;
            main.notreInventaire.repaint();
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
             else if(laSalle[posX-1][posY] >= 100 && laSalle[posX-1][posY] < 200){
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
        else if (laSalle[posX-2][posY] >= 300 && laSalle[posX-2][posY] < 400){
            main.notreInventaire.lesObjets[1][3]=laSalle[posX-2][posY]-300;
            main.notreInventaire.repaint();
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
        else if(laSalle[posX+1][posY] >= 100  && laSalle[posX+1][posY] < 200){
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
        else if (laSalle[posX+2][posY] >= 300 && laSalle[posX+2][posY] < 400){
            main.notreInventaire.lesObjets[1][3]=laSalle[posX+2][posY] -300;
            main.notreInventaire.repaint();
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
                laSalle[18][3] = 106;
            }

    }
}
