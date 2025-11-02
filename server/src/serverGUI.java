import javax.swing.*;
import java.awt.*;

public class serverGUI {
    public serverGUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(new GridLayout(2,1,10,30));
        frame.setSize(100,20);
        panel.add(new JLabel("  SERVER now open for client to control  "));
        panel.add(new JLabel("                       Developed by N09  "));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SERVER");
        frame.pack();
        frame.setVisible(true);
    } 
}
