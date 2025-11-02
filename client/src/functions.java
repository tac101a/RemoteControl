import java.io.*;
//
public class functions {
    public static String out(BufferedReader reader) throws Exception {
        String result = "";
        String line;
        while ((line = reader.readLine()) != null) {
            line = line + "\n";
            result = result + line;
        }
        return result;
    }
    public static void sendCommand (BufferedWriter writer, String line) throws Exception {
        writer.write(line);
        writer.flush();
    }

}

