package travel.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FlightBook extends JFrame implements ActionListener {
    JButton book,back;
    FlightBook(){
        setBounds(300,100,800,600);
        setLayout(null);
        
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/PIA.jpg"));
Image i2= i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0,0,800,700);
add(image);

book = new JButton("Book");
book.setBounds(420,0,80,40);
book.addActionListener(this);
image.add(book);

back = new JButton("Back");
back.setBounds(520,0,80,40);
back.addActionListener(this);
image.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()== book){
        setVisible(false);
        new Flight();
    }else{
        setVisible(false);
        
    }
}
    public static void main(String[] args){
        new FlightBook();
    }
}
