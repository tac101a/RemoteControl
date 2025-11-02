import javax.swing.*;

public class inputGUI {
    String name;
    boolean set = false;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    //bao gom textfield va nut xac nhan
    JTextField input = new JTextField();
    JButton confirmbutton = new JButton();
    //
    public inputGUI(String title, String guide, String confirmation) {
        frame.setBounds(100, 100, 500, 100);
		frame.setAlwaysOnTop(true);
		frame.setTitle(title);
		input.setBounds(100, 100, 290, 50);
        input.setColumns(30);
        panel.add(new JLabel(guide));
        panel.add(input);
        //
        panel.add(confirmbutton);
        confirmbutton.setText(confirmation);
        confirmbutton.setBounds(100,100,60,30);
        //
		frame.setContentPane(panel);
        frame.setTitle(title);
        frame.setVisible(false);
    }
}

