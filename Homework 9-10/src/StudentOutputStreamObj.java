import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StudentOutputStreamObj {
    private ObjectOutputStream outputStream;

    public StudentOutputStreamObj(OutputStream outputStream) throws IOException {
        this.outputStream = new ObjectOutputStream(outputStream);
    }

    public void writeStudent(Student st) {
        try {
            outputStream.writeObject(st);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void useProtocolVersion(int version) throws IOException {
        outputStream.useProtocolVersion(version);
    }

    public void writeObject(Object obj) throws IOException {
        outputStream.writeObject(obj);
    }

    public void writeUnshared(Object obj) throws IOException {
        outputStream.writeUnshared(obj);
    }

    public void defaultWriteObject() throws IOException {
        outputStream.defaultWriteObject();
    }

    public ObjectOutputStream.PutField putFields() throws IOException {
        return outputStream.putFields();
    }

    public void writeFields() throws IOException {
        outputStream.writeFields();
    }

    public void reset() throws IOException {
        outputStream.reset();
    }

    public void write(int val) throws IOException {
        outputStream.write(val);
    }

    public void write(byte[] buf) throws IOException {
        outputStream.write(buf);
    }

    public void write(byte[] buf, int off, int len) throws IOException {
        outputStream.write(buf, off, len);
    }

    public void flush() throws IOException {
        outputStream.flush();
    }

    public void close() throws IOException {
        outputStream.close();
    }

    public void writeBoolean(boolean val) throws IOException {
        outputStream.writeBoolean(val);
    }

    public void writeByte(int val) throws IOException {
        outputStream.writeByte(val);
    }

    public void writeShort(int val) throws IOException {
        outputStream.writeShort(val);
    }

    public void writeChar(int val) throws IOException {
        outputStream.writeChar(val);
    }

    public void writeInt(int val) throws IOException {
        outputStream.writeInt(val);
    }

    public void writeLong(long val) throws IOException {
        outputStream.writeLong(val);
    }

    public void writeFloat(float val) throws IOException {
        outputStream.writeFloat(val);
    }

    public void writeDouble(double val) throws IOException {
        outputStream.writeDouble(val);
    }

    public void writeBytes(String str) throws IOException {
        outputStream.writeBytes(str);
    }

    public void writeChars(String str) throws IOException {
        outputStream.writeChars(str);
    }

    public void writeUTF(String str) throws IOException {
        outputStream.writeUTF(str);
    }
}
