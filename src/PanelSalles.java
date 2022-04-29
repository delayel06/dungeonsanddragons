import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class PanelSalles extends JPanel implements MouseListener {
    int[][] laSalle;
    int longueur;
    int posX;
    int posY;
    int i;
    Salles main;
    ImageIcon icon = new ImageIcon("knightidle.png");
    JLabel labelI;
    JLabel labelC;
    //variables pour le déplacement de l'animation de lancement de combat
    int vsX = -1000;
    int vsY = 0;
    ImageIcon image = new ImageIcon("vsscreen.png");
    boolean bossawakened = false;
    Clip clip;
    InterfaceCombat combat;

    public PanelSalles(int[][] s, int l, Salles salle) {
        laSalle = s;
        longueur = l;
        main = salle;
        i = main.i;
        setLayout(null);

        // Bouton Inventaire
        labelI = new JLabel();
        labelI.setBounds(0, 0, longueur / 20, longueur / 20);
        labelI.addMouseListener(this);
        add(labelI);

        //Bouton Carte
        labelC = new JLabel();
        labelC.setBounds(longueur * 19 / 20, 0, longueur / 20, longueur / 20);
        labelC.addMouseListener(this);
        add(labelC);

    /*if(main.tabsalles[i] == main.sallef){
        finalboss();
    }*/
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == labelI) {
            main.notreInventaire.setVisible(true);
        }
        if (e.getSource() == labelC) {
            main.notreCarte.setVisible(true);

        }
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    //Dans la méthode paintComponent, on va parcourir le tableau laSalle et testant chaque case du tableau
    //pour associer chaque chiffre à un type de case : par exemple, 1 est un mur, 2 un plancher
    // Les monstres sont entre 100 et 200, en enlevant 100, on trouve l'identité du monstre correspondant dans le tableau de monstre de la
    //classe Salle
    public void paintComponent(Graphics g) {

        // 9 EST RESERVE POUR LE JOUEUR !!!
        // 1 mur, 0 néant , 2 plancher (pour marcher) , 3 case rouge pour baril , 4 case verte avec baril, 5 baril
        //6 rocher , 7 crystal , 8 sac a dos, 9 JOUEUR , 10 ombre
        //60 - 74 : laves
        //80 - 84  : glaces
        //+100 : salles
        //+200 : monstres
        //+300 : objets
        int evolutionX = 0;
        int evolutionY = 0;
        // explication evoX
        for (int i = 0; i < laSalle.length; i++) {
            for (int j = 0; j < laSalle.length; j++) {
                //Elements basiques du terrain
                if (laSalle[i][j] == 0) {
                    g.setColor(Color.black);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                }
                if (laSalle[i][j] == 1) {
                    (new ImageIcon("stone.jpg")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 2) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                }
                if (laSalle[i][j] == 3) {
                    g.setColor(Color.red);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                }
                if (laSalle[i][j] == 4) {
                    g.setColor(Color.green);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("barrel.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 5) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("barrel.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 6) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("rock.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 8) {
                    g.setColor(Color.black);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("backpack.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 11) {
                    g.setColor(Color.black);
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("carte.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] >= 100 && laSalle[i][j] < 200) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("door.png")).paintIcon(this, g, evolutionX - 30, evolutionY - 30);

                }
                if (laSalle[i][j] >= 200 && laSalle[i][j] <= 300) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (main.tabmonstre[laSalle[i][j] - 200].imageM).paintIcon(this, g, evolutionX - 10, evolutionY - 10);

                }

                //CRISTALS
                if (laSalle[i][j] == 7) { //crystal
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("crystal.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 10) { //OMBRE
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("ombre.png")).paintIcon(this, g, evolutionX, evolutionY);

                }

                //LAVES DIFFERENTES
                if (laSalle[i][j] == 60) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava1.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 61) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava2.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 62) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava3.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 63) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava4.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 64) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava5.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 65) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava6.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 66) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava7.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 67) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava8.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 68) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava9.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 69) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava10.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 70) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava11.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 71) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava12.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 72) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava13.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 73) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava14.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 74) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("lava15.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                //GLACES
                if (laSalle[i][j] == 80) {
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("ice.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 81) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("iceright.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 82) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("iceleft.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 83) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("icebottom.png")).paintIcon(this, g, evolutionX, evolutionY);
                }
                if (laSalle[i][j] == 84) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);

                    (new ImageIcon("icetop.png")).paintIcon(this, g, evolutionX, evolutionY);
                }

                //PONDS
                if (laSalle[i][j] == 90) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond1.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 91) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond2.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 92) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond3.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 93) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond4.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 94) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond5.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 95) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond6.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 96) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond7.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 97) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("pond8.png")).paintIcon(this, g, evolutionX, evolutionY);

                }

                // OBJETS
                if (laSalle[i][j] >= 300) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("chest.png")).paintIcon(this, g, evolutionX - 10, evolutionY - 10);
                }
                if (laSalle[i][j] == 321) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("epee.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 322) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("casque.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 323) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("hache.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 324) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("armure.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 325) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("collierMagique.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 326) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("petiteDague.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 327) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("doubleSabre.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 328) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("bouclier.png")).paintIcon(this, g, evolutionX, evolutionY);

                }
                if (laSalle[i][j] == 329) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    (new ImageIcon("bottesMagiques.png")).paintIcon(this, g, evolutionX, evolutionY);

                }

                if (laSalle[i][j] == 9 || laSalle[i][j] == 85) {
                    g.setColor(new Color(145, 107, 100));
                    g.fillRect(evolutionX, evolutionY, longueur / 20, longueur / 20);
                    icon.paintIcon(this, g, evolutionX - 20, evolutionY - 10);
                    posX = i;
                    posY = j;

                }
                evolutionX = evolutionX + (longueur / 20);
            }
            evolutionX = 0;
            evolutionY = evolutionY + (longueur / 20);
        }

        g.drawImage(image.getImage(), vsX, vsY, null);

    }

    //startfight est une méthode qui lance un combat après une courte animation de lancement de combat
    //cette animation se déplace de la gauche à la droite et assombri l'écran, puis lance l'interface de combat ,pour un effet inutile mais agréable visuellement
    public void startfight(Personnage perso, Monstre monstre, PanelSalles salle, int x, int y) {
        java.util.Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int i = 0;

            public void run() {
                vsX += 5;
                repaint();

                i++;
                if (i == 190) {

                    new InterfaceCombat(perso, monstre, salle, x, y);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        //t'inquiete
                    }
                    vsX = -1000;
                    repaint();
                    t.cancel();

                }
            }

        };

        t.schedule(task, 0, 10);

    }

    // MOVEMENT

    //Les 4 méthodes de mouvement sont appelées dans Salles, elle vérifie les cases de déplacement par rapprot au tableau et ce qu'il y a dedans
    //Si c'est un plancher, on peut avancer, et la case du joueur (représenté par 9 ) est remplacé par un plancher
    //Ces codes testent aussi pour tout type d'interaction : objet, monstre, baril qui est déplacable, etc..
    //si l'attribut mvmt dans Salles n'est pas true, alors on ne peut pas accéder à ces méthodes ( permet de bloquer le joueur )
    //on test également l'intéraction des cases rouges avec des barils, qui deviendront des cases vertes avec des barils dedans
    //(on test a x+2 si à x+1 il y a un baril)
    //Cette manipulation de tableau nous permet un déplacement facile, avec des intéractions rapides à coder sans problèmes. Le code est adapté
    //avec un tableau de salles et un indice de salles pour que lorsqu'on change de salles, le même code est utilisé pour accéder aux méthodes de
    //déplacement. Aussi, chaque déplacement correspond à un changement d'image pour que le personnage regarde dans des directions différentes
    //selon la ou il se déplace
    public void right() {
        icon = new ImageIcon("knightrun.png");
        if (laSalle[posX][posY + 1] == 2) {

            laSalle[posX][posY + 1] = 9;
            laSalle[posX][posY] = 2;
            posY += 1;

        } else if (laSalle[posX][posY + 1] == 80) {

            ice(1);

        } else if (laSalle[posX][posY + 1] >= 100 && laSalle[posX][posY + 1] < 200) {
            main.changeSalle(laSalle[posX][posY + 1] - 100);

        } else if (laSalle[posX][posY + 1] == 5) { // Barils bouger
            if (laSalle[posX][posY + 2] == 2) {
                laSalle[posX][posY + 2] = 5;
                laSalle[posX][posY + 1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
            } else if (laSalle[posX][posY + 2] == 3) { // Puzzle 1
                laSalle[posX][posY + 2] = 4;
                laSalle[posX][posY + 1] = 9;
                laSalle[posX][posY] = 2;
                posY += 1;
                checkPuzzle1();
            }

        } else if (laSalle[posX][posY + 1] >= 200 && laSalle[posX][posY + 1] < 300) {
            startfight(main.perso, main.tabmonstre[laSalle[posX][posY + 1] - 200], this, posX, posY + 1);
            blockPerso();
        } else if (laSalle[posX][posY + 1] >= 300 && laSalle[posX][posY + 1] <= 320) {

            laSalle[posX][posY + 1] = laSalle[posX][posY + 1] + 20;

        } else if (laSalle[posX][posY + 1] == 321) {
            main.notreInventaire.ajouterObjet(1);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 322) {
            main.notreInventaire.ajouterObjet(2);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 323) {
            main.notreInventaire.ajouterObjet(3);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 324) {
            main.notreInventaire.ajouterObjet(4);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 325) {
            main.notreInventaire.ajouterObjet(5);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 326) {
            main.notreInventaire.ajouterObjet(6);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 327) {
            main.notreInventaire.ajouterObjet(7);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 328) {
            main.notreInventaire.ajouterObjet(8);
            laSalle[posX][posY + 1] = 2;
        } else if (laSalle[posX][posY + 1] == 329) {
            main.notreInventaire.ajouterObjet(9);
            laSalle[posX][posY + 1] = 2;
        }

        repaint();
    }

    public void left() {
        if (main.tabsalles[main.i] == main.sallef) {
            if (!bossawakened) {
                finalboss();
                bossawakened = true;
            }
        }

        icon = new ImageIcon("knightrun2.png");

        if (laSalle[posX][posY - 1] == 2) {

            laSalle[posX][posY - 1] = 9;
            laSalle[posX][posY] = 2;
            posY -= 1;
        } else if (laSalle[posX][posY - 1] >= 100 && laSalle[posX][posY - 1] < 200) {
            main.changeSalle(laSalle[posX][posY - 1] - 100);

        } else if (laSalle[posX][posY - 1] >= 200 && laSalle[posX][posY - 1] < 300) {
            startfight(main.perso, main.tabmonstre[laSalle[posX][posY - 1] - 200], this, posX, posY - 1);
            blockPerso();
        } else if (laSalle[posX][posY - 1] == 5) {
            if (laSalle[posX][posY - 2] == 2) {
                laSalle[posX][posY - 2] = 5;
                laSalle[posX][posY - 1] = 9;
                laSalle[posX][posY] = 2;
                posY -= 1;
            } else if (laSalle[posX][posY - 2] == 3) {
                laSalle[posX][posY - 2] = 4;
                laSalle[posX][posY - 1] = 9;
                laSalle[posX][posY] = 2;
                posY -= 1;
                checkPuzzle1();

            }
        } else if (laSalle[posX][posY - 1] >= 300 && laSalle[posX][posY - 1] <= 320) {

            laSalle[posX][posY - 1] = laSalle[posX][posY - 1] + 20;

        } else if (laSalle[posX][posY - 1] == 321) {
            main.notreInventaire.ajouterObjet(1);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 322) {
            main.notreInventaire.ajouterObjet(2);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 323) {
            main.notreInventaire.ajouterObjet(3);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 324) {
            main.notreInventaire.ajouterObjet(4);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 325) {
            main.notreInventaire.ajouterObjet(5);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 326) {
            main.notreInventaire.ajouterObjet(6);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 327) {
            main.notreInventaire.ajouterObjet(7);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 328) {
            main.notreInventaire.ajouterObjet(8);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 329) {
            main.notreInventaire.ajouterObjet(9);
            laSalle[posX][posY - 1] = 2;
        } else if (laSalle[posX][posY - 1] == 80) {

            ice(2);

        }

        repaint();
    }

    public void up() {
        icon = new ImageIcon("knightup.png");
        System.out.println(posX);
        if (laSalle[posX - 1][posY] == 2) {

            laSalle[posX - 1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX -= 1;
            System.out.println("apres: " + posX);
        } else if (laSalle[posX - 1][posY] >= 100 && laSalle[posX - 1][posY] < 200) {
            main.changeSalle(laSalle[posX - 1][posY] - 100);

        } else if (laSalle[posX - 1][posY] >= 200 && laSalle[posX - 1][posY] < 300) {
            startfight(main.perso, main.tabmonstre[laSalle[posX - 1][posY] - 200], this, posX - 1, posY);
            blockPerso();
        } else if (laSalle[posX - 1][posY] == 5) {
            if (laSalle[posX - 2][posY] == 2) {
                laSalle[posX - 2][posY] = 5;
                laSalle[posX - 1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX -= 1;
            } else if (laSalle[posX - 2][posY] == 3) {
                laSalle[posX - 2][posY] = 4;
                laSalle[posX - 1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX -= 1;
                checkPuzzle1();

            }
        } else if (laSalle[posX - 1][posY] == 80) {

            ice(4);

        } else if (laSalle[posX - 1][posY] >= 300 && laSalle[posX - 1][posY] <= 320) {

            laSalle[posX - 1][posY] = laSalle[posX - 1][posY] + 20;

        } else if (laSalle[posX - 1][posY] == 321) {
            main.notreInventaire.ajouterObjet(1);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 322) {
            main.notreInventaire.ajouterObjet(2);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 323) {
            main.notreInventaire.ajouterObjet(3);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 324) {
            main.notreInventaire.ajouterObjet(4);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 325) {
            main.notreInventaire.ajouterObjet(5);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 326) {
            main.notreInventaire.ajouterObjet(6);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 327) {
            main.notreInventaire.ajouterObjet(7);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 328) {
            main.notreInventaire.ajouterObjet(8);
            laSalle[posX - 1][posY] = 2;
        } else if (laSalle[posX - 1][posY] == 329) {
            main.notreInventaire.ajouterObjet(9);
            laSalle[posX - 1][posY] = 2;
        }
        repaint();
    }

    public void down() {
        icon = new ImageIcon("knightdown.png");

        if (laSalle[posX + 1][posY] == 2) {

            laSalle[posX + 1][posY] = 9;
            laSalle[posX][posY] = 2;
            posX += 1;
        } else if (laSalle[posX + 1][posY] >= 100 && laSalle[posX + 1][posY] < 200) {
            main.changeSalle(laSalle[posX + 1][posY] - 100);

        } else if (laSalle[posX + 1][posY] >= 200 && laSalle[posX + 1][posY] < 300) {
            startfight(main.perso, main.tabmonstre[laSalle[posX + 1][posY] - 200], this, posX + 1, posY);
            blockPerso();
        } else if (laSalle[posX + 1][posY] == 5) {
            if (laSalle[posX + 2][posY] == 2) {
                laSalle[posX + 2][posY] = 5;
                laSalle[posX + 1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX += 1;
            } else if (laSalle[posX + 2][posY] == 3) {
                laSalle[posX + 2][posY] = 4;
                laSalle[posX + 1][posY] = 9;
                laSalle[posX][posY] = 2;
                posX += 1;
                checkPuzzle1();

            }
        } else if (laSalle[posX + 1][posY] >= 300 && laSalle[posX + 1][posY] <= 320) {

            laSalle[posX + 1][posY] = laSalle[posX + 1][posY] + 20;

        } else if (laSalle[posX + 1][posY] == 321) {
            main.notreInventaire.ajouterObjet(1);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 322) {
            main.notreInventaire.ajouterObjet(2);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 323) {
            main.notreInventaire.ajouterObjet(3);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 324) {
            main.notreInventaire.ajouterObjet(4);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 325) {
            main.notreInventaire.ajouterObjet(5);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 326) {
            main.notreInventaire.ajouterObjet(6);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 327) {
            main.notreInventaire.ajouterObjet(7);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 328) {
            main.notreInventaire.ajouterObjet(8);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 329) {
            main.notreInventaire.ajouterObjet(9);
            laSalle[posX + 1][posY] = 2;
        } else if (laSalle[posX + 1][posY] == 80) {

            ice(3);

        }
        repaint();
    }

    //idle sert au niveau de l'animation du déplacement, lorsque aucune touche est appuyé le personnage revient à son état initial,
    //il ne regarde pas de direction.
    public void idle() {
        icon = new ImageIcon("knightidle.png");
        repaint();
    }

    //Cette méthode va vérifier après chaque baril placé dans un cadre rouge s'il reste des cases rouges. Si non, une porte secrète va s'ouvrir
    public void checkPuzzle1() {
        boolean b = true;

        for (int i = 0; i < laSalle.length; i++) {
            for (int j = 0; j < 20; j++) {
                if (laSalle[i][j] == 3) {
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            laSalle[18][3] = 106;
        }

    }

    //Ces méthodes simples changent la variable mvmt pour permettre l'accès a right(), left(), etc. On a donc un moyen très simple, lors d'animations
    // de bloquer le personnage.
    public void blockPerso() {
        main.mvmt = false;
    }

    public void deblockPerso() {
        main.mvmt = true;
    }

    //Une méthode qui permet de "glisser" sur des blocs de glace, de n'importe quelle direction,
    //peu importe le nombre de blocs de glace, en utilisant un timer et en bloquant le personnage afin d'avoir une pseudo animation
    //de glissement. il a fallu faire des cas spécifiques pour chaque direction ainsi que pour les nombres différents de blocs de glace,
    //sinon cela ne marchait pas. Nous pourrons donc ajouter ceci au moteur du jeu afin de créer des salles avec des puzzles de glace
    // ou il faut prendre les bons chemins pour arriver à l'endroit voulu.
    //Inspiration : https://gamerpillar.com/wp-content/uploads/2021/11/2-1024x576.jpeg
    public void ice(int direction) {
        //1 right, 2 left, 3 down, 4 up
        if (direction == 1) {

            blockPerso();

            if (laSalle[posX][posY + 2] == 2) {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {
                    int i = 0;

                    public void run() {

                        if (i == 1) {
                            t.cancel();
                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY + 1] = 9;
                            posY += 1;
                            repaint();
                            deblockPerso();

                        } else {

                            laSalle[posX][posY] = 2;
                            laSalle[posX][posY + 1] = 9;
                            posY += 1;
                            i++;
                        }
                        repaint();
                    }
                };
                t.schedule(task, 0, 250);
            } else {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {

                    boolean a = true;
                    boolean b = true;

                    public void run() {
                        if (b) {
                            System.out.println(" premier deplacement");

                            laSalle[posX][posY] = 2;
                            laSalle[posX][posY + 1] = 9;

                            posY += 1;
                            b = false;
                        } else if (!a) {
                            System.out.println(" dernier deplacement !a");

                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY + 1] = 9;
                            posY++;

                            t.cancel();
                            deblockPerso();
                        } else if (a) {
                            System.out.println(" else if normal : a");
                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY + 1] = 9;
                            posY++;

                            if (laSalle[posX][posY + 1] != 80) {
                                a = false;

                            }
                        }

                        repaint();

                    }
                };
                t.schedule(task, 0, 250);

            }
        }

        if (direction == 2) {

            blockPerso();

            if (laSalle[posX][posY - 2] == 2) {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {
                    int i = 0;

                    public void run() {

                        if (i == 1) {
                            t.cancel();
                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY - 1] = 9;
                            posY -= 1;
                            repaint();
                            deblockPerso();

                        } else {

                            laSalle[posX][posY] = 2;
                            laSalle[posX][posY - 1] = 9;
                            posY -= 1;
                            i++;
                        }
                        repaint();
                    }
                };
                t.schedule(task, 0, 250);
            } else {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {

                    boolean a = true;
                    boolean b = true;

                    public void run() {
                        if (b) {
                            System.out.println(" premier deplacement");

                            laSalle[posX][posY] = 2;
                            laSalle[posX][posY - 1] = 9;

                            posY -= 1;
                            b = false;
                        } else if (!a) {
                            System.out.println(" dernier deplacement !a");

                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY - 1] = 9;
                            posY--;

                            t.cancel();
                            deblockPerso();
                        } else if (a) {
                            System.out.println(" else if normal : a");
                            laSalle[posX][posY] = 80;
                            laSalle[posX][posY - 1] = 9;
                            posY--;

                            if (laSalle[posX][posY - 1] != 80) {
                                a = false;

                            }
                        }

                        repaint();

                    }
                };
                t.schedule(task, 0, 250);

            }
        }

        if (direction == 3) {

            blockPerso();

            if (laSalle[posX + 2][posY] == 2) {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {
                    int i = 0;

                    public void run() {

                        if (i == 1) {
                            t.cancel();
                            laSalle[posX][posY] = 80;
                            laSalle[posX + 1][posY] = 9;
                            posX += 1;
                            repaint();
                            deblockPerso();

                        } else {

                            laSalle[posX][posY] = 2;
                            laSalle[posX + 1][posY] = 9;
                            posX += 1;
                            i++;
                        }
                        repaint();
                    }
                };
                t.schedule(task, 0, 250);
            } else {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {

                    boolean a = true;
                    boolean b = true;

                    public void run() {
                        if (b) {
                            System.out.println(" premier deplacement");

                            laSalle[posX][posY] = 2;
                            laSalle[posX + 1][posY] = 9;

                            posX += 1;
                            b = false;
                        } else if (!a) {
                            System.out.println(" dernier deplacement !a");

                            laSalle[posX][posY] = 80;
                            laSalle[posX + 1][posY] = 9;
                            posX++;

                            t.cancel();
                            deblockPerso();
                        } else if (a) {
                            System.out.println(" else if normal : a");
                            laSalle[posX][posY] = 80;
                            laSalle[posX + 1][posY] = 9;
                            posX++;

                            if (laSalle[posX + 1][posY] != 80) {
                                a = false;

                            }
                        }

                        repaint();

                    }
                };
                t.schedule(task, 0, 250);

            }
        }

        if (direction == 4) {

            blockPerso();

            if (laSalle[posX - 2][posY] == 2) {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {
                    int i = 0;

                    public void run() {

                        if (i == 1) {
                            t.cancel();
                            laSalle[posX][posY] = 80;
                            laSalle[posX - 1][posY] = 9;
                            posX -= 1;
                            repaint();
                            deblockPerso();

                        } else {

                            laSalle[posX][posY] = 2;
                            laSalle[posX - 1][posY] = 9;
                            posX--;
                            i++;
                        }
                        repaint();
                    }
                };
                t.schedule(task, 0, 250);
            } else {
                java.util.Timer t = new Timer();
                TimerTask task = new TimerTask() {

                    boolean a = true;
                    boolean b = true;

                    public void run() {
                        if (b) {
                            System.out.println(" premier deplacement");

                            laSalle[posX][posY] = 2;
                            laSalle[posX - 1][posY] = 9;
                            posX--;

                            b = false;
                        } else if (!a) {
                            System.out.println(" dernier deplacement !a");

                            laSalle[posX][posY] = 80;
                            laSalle[posX - 1][posY] = 9;
                            posX--;

                            t.cancel();
                            deblockPerso();
                        } else if (a) {
                            System.out.println(" else if normal : a");
                            laSalle[posX][posY] = 80;
                            laSalle[posX - 1][posY] = 9;
                            posX--;

                            if (laSalle[posX - 1][posY] != 80) {
                                a = false;

                            }
                        }

                        repaint();

                    }
                };
                t.schedule(task, 0, 250);

            }
        }

    }

    //méthode d'animation qui fait apparaitre une a une les pierres autour du dragon squelettique, puis le dragon squelettique au milieu
    // c'est le grand boss!
    public void finalboss() {
        blockPerso();
        java.util.Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int a = 0;
            int b = 0;

            public void run() {
                if (a <= 4) {
                    laSalle[8 - b][6] = 6;
                    a++;
                    b++;
                    repaint();
                } else if (a <= 9) {
                    laSalle[4][7 + (b - 5)] = 6;
                    a++;
                    b++;
                    repaint();
                } else if (a < 14) {
                    laSalle[4 + (b - 9)][11] = 6;
                    a++;
                    b++;
                    repaint();
                } else if (a == 14) {
                    laSalle[7][8] = 200;
                    repaint();
                    a++;
                } else if (a == 15) {
                    vibratemonstre();
                    deblockPerso();
                    t.cancel();
                }

            }

        };
        t.schedule(task, 0, 300);

    }

    //fait vibrer l'écran et rugir le dragon une fois qu'il a été apparu
    public void vibratemonstre() {
        int locX = 0;
        int locY = 0;
        blockPerso();
        music("dragonson.wav");
        //un try car on utilise thread.sleep
        try {

            for (int i = 0; i < 15; i++) {
                Thread.sleep(30);
                setLocation(locX, locY + 15);
                Thread.sleep(30);
                setLocation(locX, locY - 15);
                Thread.sleep(30);
                setLocation(locX + 15, locY);
                Thread.sleep(30);
                setLocation(locX, locY);
            }
        } catch (InterruptedException e) {
            //aille.
        }

    }

    //méthode qui joue du son au format wav
    public void music(String path) {

        File music = new File(path);
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.start();
        } catch (Exception e) {
            // :(((
        }
    }

    //Les methodes ci dessous sont le trigger de la victoire et de la défaite dans InterfaceCombat. La méthode
    //win enleve le monstre ( spécial si c'est le boss ) et lose relance la salle
    public void battlewin(int coordx, int coordy) {
        laSalle[coordx][coordy] = 2;
        deblockPerso();
        repaint();
        combat.clip.stop();
        if (main.i == 13) {
            winwholegame();
        }

    }

    public void battlelose() {
        main.changeSalle(main.i);
        main.perso.HP = main.perso.HP_max;
        combat.clip.stop();

        deblockPerso();

    }
    public void winwholegame() {

    }

}