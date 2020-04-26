import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = new File("answer.txt");


        try {
            URL url = new URL("https://javarush.ru/help/20105");

            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fis = new FileOutputStream(file);

            byte[] buffer = new byte[20];
            int count = 0;
            int ch = 0;
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((count = bis.read(buffer, 0, 20)) != -1) {
                fis.write(buffer, 0, count);
            }
            bis.close();
            fis.close();

            String str = in.readLine();
            in.close();
            if (str.contains("PDF")) {
                System.out.println("Вы скачали pdf");
                String buf = file.getAbsolutePath();
                File f = new File("answer.pdf");
                if (f.exists()) {
                    f.delete();
                }
                file.renameTo(new File("answer.pdf"));
            }
            if (str.contains("JFIF") || str.contains("JPE") || str.contains("JPEG") || str.contains("JPG")) {
                System.out.println("Вы скачали jpeg");
                String buf = file.getAbsolutePath();
                File f = new File("answer.jpeg");
                if (f.exists()) {
                    f.delete();
                }
                file.renameTo(new File("answer.jpeg"));
            }
            if (str.contains("!DOCTYPE html")){
                System.out.println("Вы скачали html страничку");
                File f = new File("answer.html");
                if (f.exists()) {
                    f.delete();
                }
                file.renameTo(new File("answer.html"));
            }
            if (str.contains("GIF")) {
                System.out.println("Вы скачали GIF");
                String buf = file.getAbsolutePath();
                File f = new File("answer.gif");
                if (f.exists()) {
                    f.delete();
                }
                file.renameTo(new File("answer.gif"));
            }
        } catch (UnknownHostException ex){
            System.out.println("Ссылка неверная");
        } catch (MalformedURLException ex) {

        }
    }
}



