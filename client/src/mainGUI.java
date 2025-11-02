import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class mainGUI implements ActionListener {
    // choice
    // 1 - list process, 2 - list app
    // 3 - kill, 4 - start
    // 5 - keylogger start ; 8 - keylogger stop
    // 6 - screenshot
    // 7 - shutdown 
    public int choice = 0;
    String addr = "";
    // cac GUI phu, killGUI va startGUI se an di, GUI chinh se an di, chi co duy nhat connectGUI
    // "setVisible(true)" hien len cho toi khi dia chi hop le"
    inputGUI killGUI = new inputGUI("KILL  A PROCESS/APP","Input PID to kill: ", "OK");
    inputGUI startGUI = new inputGUI("START A PROCESS/APP","Input name: ", "OK");
    inputGUI connectGUI = new inputGUI("CONNECT TO SERVER","Input server address: ", "OK");
    //khoi tao cac nut, tuong ung voi cac choice cua cac chuc nang
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button_listproc = new JButton("GET LIST OF PROCESSES");
    JButton button_listapp = new JButton("GET LIST OF APPS");
    JButton button_kill = new JButton("KILL APP/PROCESS");
    JButton button_start = new JButton("START APP/PROCESS");
    JButton button_keylogger = new JButton("KEYLOGGER");
    JButton button_screenshot = new JButton("SCREENSHOT");
    JButton button_shutdown = new JButton("SHUT DOWN");
    public mainGUI() {
        connectGUI.confirmbutton.addActionListener(this);
        connectGUI.frame.setVisible(true);
        connectGUI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (!addr.isBlank()) {
        }
        //them action listener de nhan biet khi nao nut duoc bam
        button_listproc.addActionListener(this);
        button_listapp.addActionListener(this);
        button_kill.addActionListener(this);
        button_start.addActionListener(this);
        button_screenshot.addActionListener(this);
        button_shutdown.addActionListener(this);
        killGUI.confirmbutton.addActionListener(this);
        startGUI.confirmbutton.addActionListener(this);
        //
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(4,2,10,10));
        panel.add(button_listproc);
        panel.add(button_listapp);
        panel.add(button_kill);
        panel.add(button_start);
        panel.add(button_keylogger);
        panel.add(button_screenshot);
        panel.add(button_shutdown);
        panel.add(new JLabel("Developed by N09"));
        //
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("REMOTE CONTROL: CLIENT");
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //khi nhan nut "xac nhan" cua connectGUI, lay dia chi tu textfield
        if (ae.getSource() == connectGUI.confirmbutton) {
            connectGUI.name = "";
            connectGUI.name = connectGUI.input.getText();
            try {
                //thu tao mot socket de gui thong qua socket
                //neu thanh cong thi hide connectGUI, GUI chinh hien len, thiet lap dia chi host
                //neu khong thanh cong thi bao loi
                Socket testsocket = new Socket(connectGUI.name,6000);
                BufferedWriter testWriter = new BufferedWriter(new OutputStreamWriter(testsocket.getOutputStream()));
                testWriter.write("");
                testWriter.flush();
                testWriter.close();
                testsocket.close();
                addr = connectGUI.name;
                connectGUI.frame.setVisible(false);
                frame.setVisible(true);
            } catch(Exception e) { 
                JOptionPane.showMessageDialog(null, "not connected, please try again"); 
            }
        }
        // cac nut mang cac che do lam viec tuong ung
        if (ae.getSource() == button_listproc) {
            choice = 1;
        }
        if (ae.getSource() == button_listapp) {
            choice = 2;
        }
        // kill - start la 2 chuc nang can nut xac nhan tu mot GUI khac cho chung
        // khi an vao GUI rieng cua chung se hien len
        if (ae.getSource() == button_kill) {
            choice = 3;
            killGUI.frame.setVisible(true);
        }
        if (ae.getSource() == button_start) {
            choice = 4;
            startGUI.frame.setVisible(true);
        }
        //
        if (ae.getSource() == button_screenshot) {
            choice = 6;
        }
        if (ae.getSource() == button_shutdown) {
            choice = 7;
        }
        // khi co xac nhan tu GUI phu thi moi chay client voi chuc nang do
        // co kiem tra chuoi khi xac nhan
        if (ae.getSource() == killGUI.confirmbutton) {
            killGUI.name = "";
            killGUI.name = killGUI.input.getText();
            if (killGUI.name.isBlank()) killGUI.set = false;
            try {
                boolean success = client.work(this,3,addr);
                if (!success) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            killGUI.frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "KILLED");
            killGUI.set = false; 
        }
        if (ae.getSource() == startGUI.confirmbutton) {
            startGUI.name = "";
            startGUI.name = startGUI.input.getText();
            if (startGUI.name.isBlank()) killGUI.set = false;
            try {
                System.out.println(choice);
                boolean success = client.work(this,4,addr);
                if (!success) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            startGUI.frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "STARTED");
            startGUI.set = false; 
        }
        //doi voi cac chuc nang khong co GUI phu thi tien hanh lam viec voi client ngay
        if (choice == 1 || choice == 2 || choice == 6 || choice == 7) {
            try {
                System.out.println(choice);
                boolean success = client.work(this,choice,addr);
                if (!success) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
        }
    }
}
