import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MeinListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Hallo, Welt!");
    }
}

public class Fenster {
    public void start() {
        JFrame fenster = new JFrame("Mein cooles Fenster");
        fenster.setVisible(true);
        fenster.setSize(800, 600);
        
        JButton button = new JButton("Klick mich für Corona Virus!");
        MeinListener listen = new MeinListener();
        button.addActionListener(listen);
        fenster.add(button);
    }
    
}
