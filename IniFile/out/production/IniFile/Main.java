import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        IniFileReader ifr = new IniFileReader(new FileInputStream("valve.ini"));
        String str = ifr.readIni("[lllll]", "kolokok");
        System.out.println(str);
        IniFileWriter ifw = new IniFileWriter(new FileOutputStream("valve.ini"));
        String [] key_value = {"AppId", "NoAppId"};
        ifw.writeIni("Settings", key_value, new File("valve.ini"));

    }
}
