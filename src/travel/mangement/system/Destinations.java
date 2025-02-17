package travel.mangement.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    private Thread t1;
    private JLabel[] label;
    private JLabel caption;

    public void run() {
        String[] text = new String[]{"JW Marriott Hotel", "Madarin Oriental Hotel", "Four Seasons Hotel", "Raddisson Blue Hotel", "Classio Hotel", "The Bay Club Hotel", "Breeze Blow Hotel", "The Taj Hotel", "Happy Morning Motel", "River"};

        try {
            for (int i = 0; i < 10; i++) {
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(300, 80, 800, 600);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        label = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            image[i] = new ImageIcon(getClass().getResource("/icons/dest" + (i + 1) + getImageExtension(i + 1)));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }

        setVisible(true);
        t1 = new Thread(this);
        t1.start();
    }

    private String getImageExtension(int index) {
        switch (index) {
            case 2:
                return ".png";
            case 7:
                return ".jpeg";
            default:
                return ".jpg";
        }
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
