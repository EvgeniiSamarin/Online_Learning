package main.java;

import com.google.gson.Gson;

import java.io.*;

public class StudentJsonDecorator {
    private DataOutputStream outputStream;

    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    public void flush() throws IOException {
        outputStream.flush();
    }

    public void writeBoolean(boolean v) throws IOException {
        outputStream.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        outputStream.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        outputStream.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        outputStream.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        outputStream.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        outputStream.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        outputStream.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        outputStream.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        outputStream.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        outputStream.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        outputStream.writeUTF(str);
    }

    public int size() {
        return outputStream.size();
    }

    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    public void close() throws IOException {
        outputStream.close();
    }

    public StudentJsonDecorator(OutputStream outputStream) {
        this.outputStream = new DataOutputStream( new BufferedOutputStream(outputStream));
    }

    public void writeStudent(Student student) {
        try {
            Gson gson = new Gson();
            String JSON = gson.toJson(student);
            outputStream.writeUTF(JSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
