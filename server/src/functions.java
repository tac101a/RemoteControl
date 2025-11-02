///////////////////SERVER - LIST PROCESS////////////
// import
//import java.net.*;
import java.io.*;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
//import java.util.*;
//
public class functions {
    public static void proclist(BufferedWriter writer) throws Exception { //LIST PROCESSES
        String line;
        Process p = new ProcessBuilder("powershell","Get-Process | Format-Table name, ID").start();
        BufferedReader getProcess = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = getProcess.readLine()) != null) {
            writer.write(line + "\n");
            writer.flush();
        }
        getProcess.close();
    }
    public static void applist(BufferedWriter writer) throws Exception { //LIST APPS
        String line;
        Process p = new ProcessBuilder("powershell","Get-Process | ? {$_.mainwindowtitle.length -ne 0} | Format-Table name, ID").start();
        BufferedReader getProcess = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = getProcess.readLine()) != null) {
            writer.write(line + "\n");
            writer.flush();
        }
        getProcess.close();
    }
    public static String getCommand(BufferedReader reader) throws Exception {
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }   
        return line;     
    }
    public static void kill(String line) {
        String cmd = "taskkill.exe /F /PID " + line;
        System.out.println(cmd);
        try {
            Runtime.getRuntime().exec(cmd);
        }
        catch (Exception e) {}
    }
    public static void start(String line) {
        try {
            new ProcessBuilder(line).start();
        }
        catch (Exception e) {}
    }
    public static BufferedImage getScreenshot() {
        try {
        BufferedImage img;
        Robot robot = new Robot();
		//to store the size of image
		Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		//capturing the image
		img = robot.createScreenCapture(rectangle);
        return img;
        }
        catch (Exception e) {
            return null;
        }
    }
    public static void sendImage(ObjectOutputStream writer, BufferedImage img) {
        try {
        ImageIO.write(img, "png", writer);
        } catch (Exception e) {
        }
    }
    public static void shutdown() {
        String cmd = "shutdown /s";
        System.out.println(cmd);
        try {
            Runtime.getRuntime().exec(cmd);
        }
        catch (Exception e) {}
    }
}