package net;

import java.io.*;
import java.net.*;

/**
 * Created by Shaw on 2015/10/7.
 */
public class TestTCPClient {
	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("127.0.0.1", 57643);

			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());

			OutputStream os = s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Oh my gosh...");

			dis.close();
			is.close();
			dos.close();
			os.close();

			s1.close();
		} catch (ConnectException connExc) {
			connExc.printStackTrace();
			System.out.println("Server connection failed");
		} catch (IOException ioExc) {
			ioExc.printStackTrace();
		}
	}
}
