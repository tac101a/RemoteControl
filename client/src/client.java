import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
//import java.util.*;
//khi client duoc khoi chay//

public class client {
    public static boolean work(mainGUI gui, int mode, String address) throws Exception {
        try{
        int port = 6000;
        //
        String result = "";
        //khoi tao socket
        Socket sk = new Socket(address,port);
        BufferedReader socReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		BufferedWriter socWriter = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        //tuong ung voi cac lua chon khac nhau se co cac cong viec khac nhau nhu: 
        //gui request den server, gui command den server...
		if (mode == 1) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //nhan ket qua tra ve tu socket va xuat ra outputgui
            result = functions.out(socReader);
            new outputGUI("PROCESS LIST" , result);
        }
        if (mode == 2) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //nhan ket qua tra ve va xuat ra outputgui
            result = functions.out(socReader);
            new outputGUI("APP LIST" , result);
        }
        if (mode == 3) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //gui pid toi server de kill
            functions.sendCommand(socWriter,gui.killGUI.name);
        }
        if (mode == 4) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //gui lenh cho server de start
            functions.sendCommand(socWriter,gui.startGUI.name);
        }
        if (mode == 5) {
            //gui request bat dau listen ban phim den server
            socWriter.write(mode);
		    socWriter.flush();
        }
        if (mode == 8) {
            //gui request den server de ngung listen
            socWriter.write(mode);
		    socWriter.flush();
        }
        if (mode == 6) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //doc anh chup tu server
            ObjectInputStream imgReader  = new ObjectInputStream(sk.getInputStream());
            BufferedImage img = ImageIO.read(imgReader);
            //tao GUI de luu anh ve
            new imgGUI(img);
        }
        if (mode == 7) {
            //gui request toi server
            socWriter.write(mode);
		    socWriter.flush();
            //
            JOptionPane.showMessageDialog(null, "SERVER SHUT DOWN");
        }
		//lam viec xong voi client thi dong cac object can thiet
        socReader.close();
		socWriter.close();
        sk.close();
        return true;
        } catch (Exception e) {
            return false;
        }
    }
}
