import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LancementCombat extends JFrame implements ActionListener{
    JLabel description;
    JButton combattre;
    Personnage personnage;
    Monstre monstre;
    public LancementCombat (Personnage p, Monstre m){
        personnage=p;
        monstre= m;
        setTitle( " La carte du jeu ");
        setSize(400,200);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tailleMoniteur.width - getSize().width)/2,(tailleMoniteur.height - getSize().height)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelLancementCombat = new JPanel();
        panelLancementCombat.setLayout(null);

        JPanel panelDesccription = new JPanel();
        panelDesccription.setBounds(0,0,400,100);
        panelDesccription.setLayout(null);
        panelDesccription.setBackground(Color.yellow);

        description = new JLabel("Voulez-vous combattre ce monstre ?");
        description.setBounds(100,50, 300,20);

        JPanel panelAccepeterOuPas = new JPanel();
        panelAccepeterOuPas.setBounds(0,100,400,100);
        panelAccepeterOuPas.setBackground(Color.yellow);
        panelAccepeterOuPas.setLayout(new FlowLayout());

        combattre = new JButton("Combattre");
        combattre.addActionListener(this);


        panelAccepeterOuPas.add(combattre);
        panelDesccription.add(description);

        panelLancementCombat.add(panelDesccription);
        panelLancementCombat.add(panelAccepeterOuPas);
        add(panelLancementCombat);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==combattre){
            //Gobelin gob = new Gobelin();
            new InterfaceCombat( personnage, monstre);
        }

    }
}
// on ne peut pas fuire parce que des qu'on cree une nouvelle fenetre l'ancienne se ferme
// il a un pb avec l'action performed aussi