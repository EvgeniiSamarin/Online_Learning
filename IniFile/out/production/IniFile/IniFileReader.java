import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IniFileReader extends InputStream {
    private DataInputStream inputStream;
    private InputStreamReader isr;

    public IniFileReader(InputStream inputStream) throws FileNotFoundException {
        this.inputStream = new DataInputStream(inputStream);
        this.isr = new InputStreamReader(inputStream);
    }

    public String readIni(String section, String key) throws IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(isr);
        String line = reader.readLine();
        //System.out.println(line);
        while(line != null){
            if (line.equals(section)) {
                //System.out.print(line + "");
                line = reader.readLine();
                while (!line.matches("\\s*\\[([^]]*)\\]\\s*")){
                    String [] words = line.split("=", 2);
                    if(words[0].equals(key)) return words[1];
                    line = reader.readLine();
                    //System.out.print(line + " ");
                }
                return "Not Found";
            }
            line = reader.readLine();
            //System.out.println(line);
        }
        return "Not Fouund";
    }
    public void writeIni(String section, String [] key_value) throws IOException {
        String searchWord = key_value[0];
        String changeWord = key_value[1];
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(isr)) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.equals(section)) {
                    strLine = br.readLine();
                    while (!strLine.matches("\\s*\\[([^]]*)\\]\\s*")){
                        String [] words = strLine.split("=", 2);
                        if(words[0].equals(key_value[0])) {
                            sb.append(strLine.replace(searchWord, key_value[1])).append("\r\n");
                        }
                        strLine = br.readLine();
                        //System.out.print(line + " ");
                    }
                }

            }
        }

    }


    public void readFully(byte[] b) throws IOException {
        inputStream.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        inputStream.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return inputStream.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return inputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return inputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return inputStream.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return inputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return inputStream.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return inputStream.readChar();
    }

    public int readInt() throws IOException {
        return inputStream.readInt();
    }

    public long readLong() throws IOException {
        return inputStream.readLong();
    }

    public float readFloat() throws IOException {
        return inputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return inputStream.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return inputStream.readLine();
    }

    public String readUTF() throws IOException {
        return inputStream.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }



}
