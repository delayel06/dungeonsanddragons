import javax.swing.*;
import java.awt.*;

public class carte extends JFrame {

    public carte (){

        this.setTitle("CARTE DU DONJON");
        this.setLocation(10,10);
        this.setSize(1280,720);
        this.setVisible(true);

        JLabel labelCarte = new JLabel(new ImageIcon("MapDonjon.png"), JLabel.CENTER);

        this.add(labelCarte);

    }
}