package travel.mangement.system;

import javax.swing.*;
import java.awt.event.*;

public class Flight extends JFrame implements ActionListener {

    Flight() {
        setBounds(300, 100, 800, 600);
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
           
            pane.setPage("https://www.piac.com.pk/");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>could not load, error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        // Add the "Back" button directly to the JFrame, not the JEditorPane
        pane.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Flight();
    }
}
