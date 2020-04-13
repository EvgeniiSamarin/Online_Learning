import javax.crypto.Cipher;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

public class Program {

    public static void main(String[] args) {

        Person tom = new Person("Tom", "TRAAA", 1.68, false);
        // запись в файл
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.ini")))
        {
            // записываем значения
            dos.writeUTF(tom.name);
            dos.writeUTF(tom.age);
            dos.writeDouble(tom.height);
            dos.writeBoolean(tom.married);
            System.out.println("File has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        // обратное считывание из файла
        try(DataInputStream dos = new DataInputStream(new FileInputStream("unins000.ini")))
        {
            try{
                Properties p = new Properties();
                p.load(dos);
                System.out.println("UserID=" + p.getProperty("productID"));

            } catch (Exception e) {
                System.out.println(e);
            }
            ByteBuffer bb = ByteBuffer.allocate(500);
            while (dos.read() != -1) {
                bb.put(dos.readByte());
            }
            int ind = 0;
            byte [] bba = bb.array();
            String st = new String(bba, ind, bba.length, "UTF-8");
            System.out.println(st);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Person
{
    public String name;
    public String age;
    public double height;
    public boolean married;

    public Person(String n, String a, double h, boolean m)
    {
        this.name=n;
        this.height=h;
        this.age=a;
        this.married=m;
    }


    /*public static void main(String[] args) {
        try {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012345467890\r\n /=+-";
            byte ascii[] = str.getBytes(StandardCharsets.US_ASCII);
            byte current[] = str.getBytes(Charset.defaultCharset());
            if (Arrays.equals(ascii, current)) {
                System.err.printf("Run this test with non-ascii native encoding,%n");
                System.err.printf("for example java -Dfile.encoding=UTF-16%n");
            }
            Cipher.getInstance("RC4");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }*/
}