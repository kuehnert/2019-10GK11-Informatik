import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {
    JLabel lbEingabe = new JLabel("Eingabe:");
    JLabel lbAusgabe = new JLabel("Ausgabe:");
    JTextArea taEingabe = new JTextArea("Testeingabe");
    JTextArea taAusgabe = new JTextArea("Testausgabe");
    JScrollPane spEingabe = new JScrollPane(taEingabe);
    JScrollPane spAusgabe = new JScrollPane(taAusgabe);
    JButton bCaesar = new JButton("Cäsar");

    class MeinListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String eingabe = taEingabe.getText();
            eingabe = eingabe.toUpperCase();
            taAusgabe.setText(eingabe);
        }
    }

    public Fenster() {
        setTitle("Mein cooles Fenster");
        setVisible(true);
        setSize(800, 600);

        MeinListener listen = new MeinListener();
        bCaesar.addActionListener(listen);

        JPanel pButtons = new JPanel();
        pButtons.add(bCaesar);

        // Füge alle Komponenten dem vert. Panel hinzu
        JPanel pVertikal = new JPanel();
        pVertikal.setLayout(new BoxLayout(pVertikal, BoxLayout.PAGE_AXIS));
        pVertikal.add(lbEingabe);
        pVertikal.add(spEingabe);
        pVertikal.add(pButtons);
        pVertikal.add(lbAusgabe);
        pVertikal.add(spAusgabe);

        // Füge alle Komponenten dem Fenster hinzu
        add(pVertikal);
    }
}
