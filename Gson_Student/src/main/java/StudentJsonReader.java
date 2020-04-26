package main.java;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class StudentJsonReader extends InputStream {
    private DataInputStream inputStream;

    public StudentJsonReader(InputStream inputStream) {
        this.inputStream = new DataInputStream(new BufferedInputStream(inputStream));
    }

    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
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

    public int read() throws IOException {
        return inputStream.read();
    }

    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    public int available() throws IOException {
        return inputStream.available();
    }

    public void close() throws IOException {
        inputStream.close();
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

    public Student studentJsonReader() {
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(inputStream);
        Student student = gson.fromJson(reader, Student.class);
        return student;
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student("Евгений", (byte)28, "11-903", 'm');
        StudentJsonDecorator sjd = new StudentJsonDecorator(new FileOutputStream("student.json"));
        sjd.writeStudent(student);
    }
}
