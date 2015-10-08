import java.io.*;
import java.util.Date;

/**
 * Created by Shaw on 2015/9/20.
 */
public class TestObjectIO {

	public static void main(String[] args) throws Exception{
		TTT t = new TTT();
		t.j = 1;
		System.out.println(t);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));


		oos.writeObject(t);
		oos.flush();
		oos.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (br.readLine() == "\r"){
			break;
		}

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/1.txt"));
		TTT t_Read = (TTT)ois.readObject();
		System.out.println(t_Read);
	}

}

class TTT implements Externalizable {
	int i;
	int j;
	double d;
	double e;

	public TTT(){
		i = 10;
//		j = 9;
		d = 2.3;
		e = Math.random();
	}

	public void writeExternal(ObjectOutput oo) throws IOException{
		Date day = new Date();
		System.out.println(day);
		oo.writeObject(day);
		oo.writeObject(i);
		oo.writeObject(d);
		oo.writeObject(e);
	}

	public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException{
		Date day_r = (Date)oi.readObject();
		System.out.println(day_r);
		System.out.println(new Date());
		this.i = (int)oi.readObject();
		this.d = (double)oi.readObject();
//		this.e = (double)oi.readObject();
	}

	public String toString(){
		return i + " " + j + " " + d + " " + e;
	}
}