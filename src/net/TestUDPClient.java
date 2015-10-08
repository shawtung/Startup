package net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * Created by Shaw on 2015/10/7.
 */
public class TestUDPClient {
	public static void main(String[] args) throws IOException {
//		long n = 100000L;
		String date = new Date().toString();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(date);
//		dos.writeLong(n);
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,	new InetSocketAddress("127.0.0.1", 56789));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();

	}
}
