import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class BufferStudents {
	private final static int STUDENT_SIZE = 50;
	private final int count = 0;
	private int c = 0;
	public static void main(String[] args) {
		ArrayList<Student> st = new ArrayList<>();
		st.add(new Student("Samarin Evgeny",(byte) 30, "11-903", 'm'));
		st.add(new Student("Gulko Anastasia",(byte) 28, "205-206", 'f'));
		st.add(new Student("Barakhov Egor",(byte) 32, "11-903", 'm'));
		st.add(new Student("Loh Obyknovenii",(byte) 0, "1111111", 'f'));
		st.add(new Student("Enjoy Some",(byte) 29, "11-90x", 'm'));
		st.add(new Student("Samarin Evgeny",(byte) 30, "11-903", 'm'));
		st.add(new Student("Samarin Evgeny",(byte) 30, "11-903", 'm'));

		//Student st = new Student("Samarin Evgeny",(byte) 30, "11-903", 'm');
		BufferStudents.write(st);
		//System.out.println(read());

	}
	
	public static void write(ArrayList<Student> studentList) {
		//String p = new String("\n");
		//byte [] bytes = p.getBytes();
		try(FileOutputStream fos = new FileOutputStream("data.txt", true)) {
			for(Student st :studentList) {
				ByteBuffer bb = ByteBuffer.allocate(STUDENT_SIZE);
				//byte[] nameBuffer = st.getName().getBytes();
				//byte[] groupBuffer = st.getGroup().getBytes();
				//byte[] dateBuffer = st.getDate();
				//byte[] sexBuffer =(byte[]) (st.getSex() >> 8);
				bb = bb.put((byte) st.getName().length());
				bb = bb.put(st.getName().getBytes());
				//System.out.println(Arrays.toString(st.getName().getBytes()));
				bb = bb.put((byte) st.getGroup().length());
				bb = bb.put(st.getGroup().getBytes());
				bb = bb.put(st.getDate());
				bb = bb.put((byte) (st.getSex() >> 8));
				bb = bb.put((byte) st.getSex());
				//bb = bb.put(bytes);
				fos.write(bb.array());
				fos.flush();

			}

			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Student> read() {
		try(FileInputStream fis = new FileInputStream("data.txt")) {
			Student st = new Student();
			ArrayList<Student> studentList= new ArrayList<>();
			ByteBuffer bb = ByteBuffer.allocate(STUDENT_SIZE * 10);
			while (fis.read() != -1) {
				bb.put((byte) fis.read());
			}
			fis.close();
			bb.rewind();
			byte[] bbb = bb.array();
			/*int sum = 0;
			for(int i = 0; i < bbb.length; i++) {
				sum = i;
			}
			System.out.println(sum);*/
			int ind = 0;
			while (ind <bbb.length) {
				ind++;
				st.setName(new String(bbb, ind, bbb[ind - 1], "UTF-8"));
				ind += bbb[ind - 1] + 1;
				//System.out.println(ind);
				st.setGroup(new String(bbb, ind, bbb[ind - 1], "UTF-8"));
				ind += bbb[ind - 1];
				//System.out.println(ind);
				st.setDate(bbb[ind]);
				ind++;
				char sex = (char) (bbb[ind] >> 8);
				ind++;
				sex |= bbb[ind];
				st.setSex(sex);
				studentList.add(st);
			}
			return studentList;
		} catch (IOException e) {
			return null;
		}
	}
}
