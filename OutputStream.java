import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OutputStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char b = (char)sc.nextInt();
        String chString = String.valueOf(b);
        String aString = Integer.toString(a);
        byte[] bytes = aString.getBytes();
        byte[] bytes1 = chString.getBytes();
        try(FileOutputStream output = new FileOutputStream("data.txt")){
            output.write(bytes);
            output.write(bytes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}