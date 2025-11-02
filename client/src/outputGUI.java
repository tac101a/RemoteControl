import javax.swing.*;
import java.awt.*;
// xuat ra list process hoac list app
public class outputGUI {
    public outputGUI(String title, String content) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        //
        JTextArea textArea = new JTextArea(15,30);
        textArea.setText(content);
        textArea.setEditable(false);
        //
        panel.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        //
        frame.add(panel,BorderLayout.CENTER);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }
}

