import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventaire extends JFrame implements ActionListener {

    JPanel panelObjets;
    JButton btn0;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;

    public Inventaire (){
        setTitle( " INVENTAIRE");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurInventaire = tailleMoniteur.width * 1/2;
        int largeurInventaire  = tailleMoniteur.height * 1/2;
        setSize(longueurInventaire+12,largeurInventaire+39);
        setResizable( false );
        setLocation((tailleMoniteur.width - getSize().width)/2,((tailleMoniteur.height - getSize().height)/2)-20);

        JLabel description = new JLabel("Voici les objets dont vous disposez : ");
        description.setBounds(longueurInventaire /2 -150 ,largeurInventaire/4 - 30,320,30);
        description.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel conteneurDescription = new JPanel();
        conteneurDescription.setLayout(null);
        conteneurDescription.setBounds(0,0 , longueurInventaire,largeurInventaire/2);
        conteneurDescription.setBackground(Color.red);
        conteneurDescription.add(description);

        btn0 = new JButton(new ImageIcon("boneInventaire.png"));
        btn1 = new JButton(new ImageIcon("epeeInventaire.png"));
        btn2 = new JButton("B");
        btn3 = new JButton("C");
        btn4 = new JButton("D");
        btn5 = new JButton("E");
        btn6 = new JButton("F");
        btn7 = new JButton("G");
        btn8 = new JButton("H");
        btn9 = new JButton("I");

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);

        panelObjets = new JPanel();
        panelObjets.setLayout(new GridLayout(2,5,10,10));
        panelObjets.setBounds(0,largeurInventaire/2,longueurInventaire,largeurInventaire/2 );
        panelObjets.setBackground(Color.blue);

        panelObjets.add(btn0);
        panelObjets.add(btn1);
        panelObjets.add(btn2);
        panelObjets.add(btn3);
        panelObjets.add(btn4);
        panelObjets.add(btn5);
        panelObjets.add(btn6);
        panelObjets.add(btn7);
        panelObjets.add(btn8);
        panelObjets.add(btn9);

        btn0.setVisible(true);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);

        JPanel inventaireTotal = new JPanel();
        inventaireTotal.setLayout(null);

        inventaireTotal.add(conteneurDescription);
        inventaireTotal.add(panelObjets);
        this.add(inventaireTotal);

        setVisible(false);
    }
    public void ajouterObjet(int a){
        // ici on boost les stats et autre
        // on aurait pu ajouter les boutons au panal ici mais c'est moche a cause des dimension

        if(a==1){
            btn1.setVisible(true);
        }
        if(a==2){
            btn2.setVisible(true);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn0){
            JOptionPane.showMessageDialog(this,"Os robuste");
        }
        if (e.getSource()==btn1){
            JOptionPane.showMessageDialog(this,"Une épée augmentant considerablement les stats");
        }
    }
}
