package net;

import java.io.*;
import java.net.*;

/**
 * Created by Shaw on 2015/10/7.
 */
public class TestTCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(57643);
			while (true) {
				Socket s1 = s.accept();
				System.out.println("A client connected!");

				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hello, " + s1.getInetAddress() + " port# " + s1.getPort() + " Bye!");


				InputStream is = s1.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				System.out.println(dis.readUTF());


				dos.close();
				os.close();
				dis.close();
				is.close();

				s1.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Error" + ioe);
		}
	}
}
