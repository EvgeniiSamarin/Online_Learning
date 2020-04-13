import java.io.*;
import java.nio.ByteBuffer;

public class ByteBuffer1  {
    public static ByteBuffer bbs = ByteBuffer.allocate(70);

    public static void write(Student st1) throws IOException{
        FileOutputStream fos = new FileOutputStream("data.txt", true);
        fos.write(st1.getName().getBytes(), 0 , 50);
        fos.write(st1.getGroup().getBytes(), st1.getName().getBytes().length, 14);
        //fos.write(st1.getDate(), st1.getName().getBytes().length + st1.getGroup().getBytes().length, 4 );

    }
   /* public static Student read() throws IOException{
        FileInputStream fis = new FileInputStream("data.txt");
        while(fis.read() != -1) {
            bbs.put((byte)fis.read());
        }
        bbs.rewind();
        Student st = new Student();


    } */

    public static void main(String[] args) throws IOException {
        Student st1 = new Student("Vasya Pupkin", (byte) 30, "11-903", 'm');
        write(st1);

    }
}