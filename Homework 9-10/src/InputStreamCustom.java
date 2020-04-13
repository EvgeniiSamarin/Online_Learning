import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamCustom {
    public static void main(String[] args) {
        int b = 0;
        try(FileInputStream in = new FileInputStream("C:/data.txt")){
            InputStreamReader ins = new InputStreamReader(in, "UTF-8");
            int x = 43;
            System.out.println(Integer.toBinaryString(x));
            int integ = 0;
            while((b = ins.read())!=-1) {

                integ |= in.read() << 24;
                integ |= in.read() << 16;
                integ |= in.read() << 8;
                integ |= in.read();

                char ch = 0;
                ch = (char) ((char) ch | (short) in.read() >> 8);
                ch = (char) ((char) ch | (short) in.read());

            }
            System.out.println(integ);
        }
        catch(IOException e){
            e.getMessage();
        }
    }
}
