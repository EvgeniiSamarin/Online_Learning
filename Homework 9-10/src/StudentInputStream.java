import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentInputStream extends InputStream {
    private DataInputStream inputStream;

    public StudentInputStream(InputStream inputStream){
        this.inputStream = new DataInputStream(inputStream);
    }

    public Student readStudent() {
        Student st = new Student();
        try {
            st.setName(inputStream.readUTF());
            st.setGroup(inputStream.readUTF());
            st.setDate(inputStream.readByte());
            st.setSex(inputStream.readChar());
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return st;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

    @Override
    public void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        inputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return inputStream.markSupported();
    }


    @Override
    public int read() throws IOException {
        return 0;
    }
}
