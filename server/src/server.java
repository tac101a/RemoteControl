///////////////////SERVER////////////
// import
import java.net.*;
import java.io.*;
import java.awt.image.BufferedImage;
/////////////////////////////////
public class server {
    public static void main(String[] args) throws Exception {
        //khoi tao socket
        new serverGUI();
        int port = 6000;
        ServerSocket svsk = new ServerSocket(port);
        try {
		while (true) {
            //accpet socket de ket noi voi client
            Socket sk = svsk.accept();
			// tao luong doc ghi
			BufferedReader socReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			BufferedWriter socWriter = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			// docrequest cua client
            int choice = socReader.read();
            // voi cac choice request khac nhau thi lam cac cong viec khac nhau
            if (choice == 1) {
                // lay danh sach process thanh chuoi va gui ve client
                functions.proclist(socWriter);
            }
            if (choice == 2) {
                // lay danh sach app thanh chuoi va gui ve client
                functions.applist(socWriter);
            }
            if (choice == 3) {
                // doc lenh va thuc thi (kill)
                String line = socReader.readLine();
                functions.kill(line);
            }
            if (choice == 4) {
                // doc lenh va thuc thi (start)
                String line = socReader.readLine();
                functions.start(line);
            }
            if (choice == 6) {
                //chup man hinh
                BufferedImage img = functions.getScreenshot();
                //tra tro lai hinh anh ve client qua socket
			    ObjectOutputStream imgWriter  = new ObjectOutputStream(sk.getOutputStream());
                functions.sendImage(imgWriter,img);
            }
            if (choice == 7) {
                //shutdown
                functions.shutdown();
            }
            //dong cac object can thiet
            socReader.close();
			socWriter.close();
            sk.close();
		}
        } catch (Exception e) {
            System.out.println("ERROR");
            svsk.close();
        }
    }
}
