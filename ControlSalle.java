import javax.swing.*;
import java.awt.*;
import java.util.LinkedList; 
import java.awt.event.*;

public class ControlSalle extends JFrame implements ActionListener {
    Salle laSalle ;
    LinkedList<Salle> touteLesSalles;
    JLabel descriptionSalle;
    JButton haut;
    JButton gauche;
    JButton droite;
    JButton bas;
    public ControlSalle(LinkedList<Salle> ListeSalles){
        setTitle( " La carte du jeu ");
        setSize(500,500);
        setLocation(200,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        laSalle = ListeSalles.get(0);
        touteLesSalles = ListeSalles;

        descriptionSalle = new JLabel("Vous etes dans la salle n° "+ laSalle.numSalle);
        descriptionSalle.setBounds(50,50,400,100);

        JPanel conteneur1 = new JPanel();
        conteneur1.setLayout(null);
        conteneur1.setBounds(0,0,500,500);
        conteneur1.setBackground(Color.green);
        conteneur1.add(descriptionSalle);

		haut = new JButton("haut");
		haut.addActionListener(this);
		
        bas = new JButton("bas");
        bas.addActionListener(this);
        
        gauche = new JButton("gauche");
        gauche.addActionListener(this);
        
        droite = new JButton("droite");
        droite.addActionListener(this);
        //JButton centre = new JButton("O");
         
        JPanel conteneur2 = new JPanel();
        conteneur2.setLayout(new BorderLayout());
        conteneur2.setBounds(300,300,150,80);
        
        conteneur2.add(haut, BorderLayout.NORTH);
        conteneur2.add(bas, BorderLayout.SOUTH);
        conteneur2.add(droite , BorderLayout.EAST);
        conteneur2.add(gauche, BorderLayout.WEST);
        //conteneur2.add(centre, BorderLayout.CENTER);
        
        conteneur1.add(conteneur2);
        add(conteneur1);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == haut){
			
			if(laSalle.autour[0]!=0){
				laSalle =  touteLesSalles.get(laSalle.autour[0]-1);
			}else{JOptionPane.showMessageDialog(this,"Il n'y a pas de salle en haut");}
			
			descriptionSalle.setText("Vous etes dans la salle n° "+ laSalle.numSalle);
			
		}
		else if (e.getSource() == droite){
			
			if(laSalle.autour[1]!=0){
				laSalle =  touteLesSalles.get(laSalle.autour[1]-1);
			}else{JOptionPane.showMessageDialog(this,"Il n'y a pas de salle a droite");}
			
			descriptionSalle.setText("Vous etes dans la salle n° "+ laSalle.numSalle);
			
		}
		else if (e.getSource() == bas ){
			
			if(laSalle.autour[2]!=0){
				laSalle =  touteLesSalles.get(laSalle.autour[2]-1);
			}else{JOptionPane.showMessageDialog(this,"Il n'y a pas de salle en bas");}
			
			descriptionSalle.setText("Vous etes dans la salle n° "+ laSalle.numSalle);
		}
		else if (e.getSource()==gauche){
			
			if(laSalle.autour[3]!=0){
				laSalle =  touteLesSalles.get(laSalle.autour[3]-1);
			}else{JOptionPane.showMessageDialog(this,"Il n'y a pas de salle a gauche");}
			
			descriptionSalle.setText("Vous etes dans la salle n° "+ laSalle.numSalle);
			
		}
	}
}
