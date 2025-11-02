import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class imgGUI {
	//bao gom textfield cho ten file, nut de luu
	JFrame frame = new JFrame();
	private JPanel contentPane;
	JFileChooser fileChooser;
	String extension = "png";
	private JTextField inputFileName;
	public imgGUI(BufferedImage img) {
		frame.setBounds(100, 100, 300, 120);
		frame.setTitle("SCREENSHOT");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
        frame.setVisible(true);
		
		JLabel label = new JLabel("img name: ");
		label.setBounds(90,0,120,15);
		contentPane.add(label);
        
		inputFileName = new JTextField();
		inputFileName.setText("screenshot");
		inputFileName.setBounds(90, 20, 120, 20);
		contentPane.add(inputFileName);
		inputFileName.setColumns(30);

		JButton save = new JButton("SAVE");
		save.setBounds(100, 50, 100, 23);
		save.addActionListener((e) -> { //tao mot file chooser khi nhan save
            try {
                fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					String directory = fileChooser.getSelectedFile().getAbsolutePath().toString();
                    File file = new File(directory + "\\" + inputFileName.getText() + "." + extension);
					ImageIO.write(img, extension,file);
				}
                frame.setVisible(false);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			inputFileName.setText("screenshot");
		});
		contentPane.setLayout(null);
		contentPane.add(save);
	}
}