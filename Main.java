import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       // IniFileReader ifr = new IniFileReader(new FileInputStream("unins000.ini"));
       // String str = ifr.readIni("[lllll]", "kolokok");
        //System.out.println(str);
        IniFileWriter ifw = new IniFileWriter(new FileOutputStream("goglog.ini"), "goglog.ini");
        String [] key_value = new String[2];
        key_value[0] = "RootKey_0";
        key_value[1] = "SubKey";
        ifw.writeIni("[lllll]", key_value );
    }
}
