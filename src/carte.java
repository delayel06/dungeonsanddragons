import javax.swing.*;
import java.awt.*;

public class carte extends JFrame {

    public carte (){
        //Met la carte en fond de fenêtre
        JLabel background = new JLabel(new ImageIcon("MapDonjon.pnj"));
        this.add(background);

        //définition de la fenêtre
        this.setTitle("CARTE DU DONJON");
        this.setLocationRelativeTo(null);
        this.setSize(1280,720);

    }
}