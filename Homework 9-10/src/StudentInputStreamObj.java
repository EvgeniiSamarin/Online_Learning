import java.io.*;

public class StudentInputStreamObj {
    private ObjectInputStream inputStream;

    public StudentInputStreamObj(InputStream inputStream) {
        try {
            this.inputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student readStudent(){
        try{
            Student student = (Student) inputStream.readObject();
            inputStream.close();
            return student;
        } catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();

        }
        return null;
    }
    public Object readObject() throws IOException, ClassNotFoundException {
        return inputStream.readObject();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return inputStream.readUnshared();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
    }

    public ObjectInputStream.GetField readFields() throws IOException, ClassNotFoundException {
        return inputStream.readFields();
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        inputStream.registerValidation(obj, prio);
    }

    public int read() throws IOException {
        return inputStream.read();
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        return inputStream.read(buf, off, len);
    }

    public int available() throws IOException {
        return inputStream.available();
    }

    public void close() throws IOException {
        inputStream.close();
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

    public char readChar() throws IOException {
        return inputStream.readChar();
    }

    public short readShort() throws IOException {
        return inputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return inputStream.readUnsignedShort();
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

    public void readFully(byte[] buf) throws IOException {
        inputStream.readFully(buf);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        inputStream.readFully(buf, off, len);
    }

    public int skipBytes(int len) throws IOException {
        return inputStream.skipBytes(len);
    }

    @Deprecated
    public String readLine() throws IOException {
        return inputStream.readLine();
    }

    public String readUTF() throws IOException {
        return inputStream.readUTF();
    }

    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    public void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    public void reset() throws IOException {
        inputStream.reset();
    }

    public boolean markSupported() {
        return inputStream.markSupported();
    }
}
