
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;


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

    public MenuIntroBis()  {
        setSize(width,height);
        setTitle("Menu Principal");
        setLocation(getWidth()/2,getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // on change pour un beau texte

        try{
            // on amene le font qui DOIT ETRE DANS LE FICHIER LES GARS
            font = Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")).deriveFont(30f); //taille ici
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dungeon.ttf")));
        }
        catch(IOException | FontFormatException e){
        // ca devrait pas arriver ici
        }

        mainPanel = new JPanel(new BorderLayout(20,20));
        mainPanel.setSize(width,height);
        mainPanel.setLocation( 0,0 );
        mainPanel.setBackground( Color.WHITE );

        helpPanel = new JPanel(new BorderLayout(20,20));
        helpPanel.setSize(width,height);
        helpPanel.setLocation( 0,0 );
        helpPanel.setBackground( Color.WHITE );

        helpLabel = new JLabel("Voici comment marche le jeu bla bla bla", SwingConstants.CENTER);


        btnback = new JButton("Retourner au menu principal!");
        btnback.setPreferredSize( new Dimension(200,100) );
        btnback.setBackground( Color.magenta );
        btnback.addActionListener( this );

        btn1 = new JButton("Commencer !");
        btn1.setFont(font);
        btn1.setPreferredSize( new Dimension(200,100) );
        btn1.setBackground( new Color(0,128,43) );
        btn1.setForeground( Color.black);
        btn1.addActionListener(this);

        btnhelp = new JButton("Aides et infos");
        btnhelp.setPreferredSize(new Dimension(200,100)  );
        btnhelp.setBackground( new Color(0,134,179) );
        btnhelp.setForeground( Color.black);
        btnhelp.setFont(font);
        btnhelp.addActionListener(this);

        mainPanel.add(btn1, BorderLayout.CENTER);
        mainPanel.add(btnhelp, BorderLayout.LINE_END);

        helpPanel.add(helpLabel, BorderLayout.CENTER);
        helpPanel.add(btnback, BorderLayout.AFTER_LAST_LINE);

        bigpanel = new JPanel(new BorderLayout());
        bigpanel.setSize(width,height);
        bigpanel.setLocation( 0,0 );
        bigpanel.setBackground( Color.WHITE );

        bigpanel.add( mainPanel );


        this.add(bigpanel, BorderLayout.CENTER);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnhelp){
            bigpanel.remove( mainPanel );
            bigpanel.add( helpPanel, BorderLayout.CENTER );
            bigpanel.validate();
            /* J'appelle le dim en dessous c'est la taille de l'écran en gros, dimension c'est une sorte d'objet pour utiliser dans les
            * layouts */
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            setBounds(100, 100, (int) dim.getWidth()-100, (int) dim.getHeight()-100);
            setLocationRelativeTo(null);

/* En gros la le pb c'était que ca affichait les 2 panels en même temps, du coup j'ai obligé à ce que ca se resize comme ca ca reinitialise*/



        }else if(e.getSource() == btnback){
            bigpanel.remove( helpPanel );
            bigpanel.add( mainPanel, BorderLayout.CENTER );
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            setBounds(100, 100, (int) dim.getWidth()/2, (int) dim.getHeight()/2);
            setLocationRelativeTo(null);
            bigpanel.validate();




        }else if(e.getSource() == btn1){
            new CharSelect();

            this.dispose();


        }
    }


}
