import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class StudentOutputStream extends OutputStream {
    private DataOutputStream outputStream;

    public StudentOutputStream(OutputStream outputStream) {
        super();
        this.outputStream = new DataOutputStream(outputStream);

    }

    public void writeStudent(Student st) throws IOException {
        //ByteBuffer bb = ByteBuffer.allocate(50);
        try {
            //byte[] namebuffer = st.getName().getBytes();
            outputStream.writeUTF(st.getName());
            outputStream.writeUTF(st.getGroup());
            outputStream.writeByte(st.getDate());
            outputStream.writeChar(st.getSex());
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }
}
