import javax.swing.*;
import java.awt.*;

public class carte extends JFrame {

    public carte (){

        this.setTitle("CARTE DU DONJON");
        this.setLocation(300,200);
        this.setSize(630,380);
        this.setVisible(true);

        JLabel labelCarte = new JLabel(new ImageIcon("MapDonjon.png"), JLabel.CENTER);

        this.add(labelCarte);

    }
}