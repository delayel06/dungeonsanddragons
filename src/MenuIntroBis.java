import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MenuIntroBis extends JFrame implements ActionListener {
    public JPanel mainPanel;
    public int width = 800;
    public int height = 400;
    public JButton btn1;
    public JButton btnhelp;
    public JPanel helpPanel;
    public JLabel helpLabel;
    public JButton btnback;
    public JPanel bigpanel;
    public Font font;
    public ImageIcon image = new ImageIcon("background.png");
    public ImageIcon titlescreen = new ImageIcon("title.png");
    public int backgroundx;
    public int backgroundy;
    Clip clip;

    public MenuIntroBis() {
        setSize(width, height);
        setTitle("Menu Principal");
        setLocation(getWidth() / 2, getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        music("introtheme.wav"); //joue la musique
        setIconImage(new ImageIcon("logo.png").getImage());

        // on change pour un beau texte
        try {
            // on amene le font qui DOIT ETRE DANS LE FICHIER
            font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(30f); //taille ici
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
        } catch (IOException | FontFormatException e) {
            // ca devrait pas arriver ici
        }
        //Ici, on fais l'image qui bouge en arriere plan, ceci est le paint directement du panel derriere les boutons
        backgroundx = 0;
        backgroundy = -300;
        mainPanel = new JPanel(new GridLayout(1, 2, 10, 10)) {
            @Override
            public void paintComponent(Graphics g) {

                g.drawImage(image.getImage(), backgroundx, backgroundy, null);//ici, l'image d'arriere plan va bouger grace a des variables qui
                //vont etre modifi??s
                g.drawImage(titlescreen.getImage(), 00, -50, null);
                //Ici, on peint par dessus tout le reste l'image du titre qui a ??t?? cr???? sp??cialement pour ??tre au bon endroit
            }
            //Comment mettre l'image en background
            // ici on doit faire ce { } dans la d??finition du panel car paint ne marche que dans un jpanel

        };

        mainPanel.setSize(width, height);
        mainPanel.setLocation(0, 0);
        //Ici, des diff??rentes cr??ations de tous les panels et boutons basique qu'il nous faut.
        helpPanel = new JPanel(new BorderLayout(20, 20));
        helpPanel.setSize(width, height);
        helpPanel.setLocation(0, 0);
        helpPanel.setBackground(Color.WHITE);

        helpLabel = new JLabel( new ImageIcon("helptext.png"));
        helpLabel.setFont(font);

        btnback = new JButton("Retourner au menu principal!");
        btnback.setPreferredSize(new Dimension(200, 100));
        btnback.setBackground(Color.magenta);
        btnback.addActionListener(this);

        ImageIcon starticon = new ImageIcon("start.png");
        btn1 = new JButton(starticon);
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);

        btn1.setPreferredSize(new Dimension(200, 100));

        btn1.addActionListener(this);

        ImageIcon helpicon = new ImageIcon("info.png");
        btnhelp = new JButton(helpicon);
        btnhelp.setPreferredSize(new Dimension(200, 100));
        btnhelp.setOpaque(false);
        btnhelp.setContentAreaFilled(false);
        btnhelp.setBorderPainted(false);
        btnhelp.addActionListener(this);

        mainPanel.add(btn1);
        mainPanel.add(btnhelp);
        //on ajoute ce  qu'on a cr???? au rendu final
        helpPanel.add(helpLabel);
        helpPanel.add(btnback, BorderLayout.AFTER_LAST_LINE);

        bigpanel = new JPanel(new BorderLayout());
        bigpanel.setSize(width, height);
        bigpanel.setLocation(0, 0);
        bigpanel.setBackground(Color.WHITE);

        bigpanel.add(mainPanel);

        this.add(bigpanel, BorderLayout.CENTER);

        setVisible(true);
        panBack(); //la m??thode appel??e pour changer la variable du fond
    }

    private void panBack() {
        //Cette animation utilise un timer + repaint, le fond est boug?? de moins en moins un et change de sens toutes les 400 it??rations
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            int i = 0;
            public void run() {
                if (i < 400) {
                    backgroundx--;
                    repaint();
                    i++;
                } else if (i < 800) {
                    backgroundx++;
                    repaint();
                    i++;
                } else if (i < 1200) {
                    backgroundx--;
                    repaint();
                    i++;
                } else if (i < 1600) {
                    backgroundx++;
                    repaint();
                    i++;
                } else if (i < 2000) {
                    backgroundx--;
                    repaint();
                    i++;
                } else if (i < 2400) {
                    backgroundx++;
                    repaint();
                    i++;
                }
            }

        };

        t.schedule(task, 0, 20);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnhelp) {
            bigpanel.remove(mainPanel);
            bigpanel.add(helpPanel, BorderLayout.CENTER);
            bigpanel.validate();
            /* J'appelle le dim en dessous c'est la taille de l'??cran en gros, dimension c'est une sorte d'objet pour utiliser dans les
             * layouts */
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            setBounds(100, 100, (int) dim.getWidth() - 100, (int) dim.getHeight() - 100);
            setLocationRelativeTo(null);

            /* En gros la le probl??me c'??tait que ca affichait les 2 panels en m??me temps, du coup j'ai oblig?? ?? ce que ca se resize comme ca ca reinitialise*/

        } else if (e.getSource() == btnback) {
            bigpanel.remove(helpPanel);
            bigpanel.add(mainPanel, BorderLayout.CENTER);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            setBounds(100, 100, (int) dim.getWidth() / 2, (int) dim.getHeight() / 2);
            setLocationRelativeTo(null);
            bigpanel.validate();

        } else if (e.getSource() == btn1) {
            new CharSelect();
            clip.stop();

            this.dispose();

        }
    }
    // m??thode simple musique
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

}