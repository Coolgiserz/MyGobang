package com.coolcats.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ��Telnet�ļ�ͨ�ţ��ַ����Ի�
 * @author CoolCats
 *
 */
public class Test3 {

	public void setUpServer(int port) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println(port+"Wating...");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Socket client = null;
		while(true) {
			try {
				//�ȴ��ͻ������ӽ��룬���������һ��accept����
				client = server.accept();
				System.out.println("Incoming:" + client.getRemoteSocketAddress());
				processChat(client);

			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��Ϣ������
	 * ��ȡ�ͻ��˷��������ַ���
	 * @param client
	 * @throws IOException 
	 */
	private void processChat(Socket client) throws IOException {
		OutputStream out = client.getOutputStream();
		InputStream ins = client.getInputStream();
		String s = "Welcome to CoolCats!\r\n";
		byte[] data = s.getBytes();
		out.write(data);
		out.flush();
		System.out.println("Incoming client"+client.getRemoteSocketAddress());
		String inputString = readClientString(ins); 
		while(!inputString.equals("bye")) {
			System.out.println("�ͻ��˷�����"+inputString);
			s = "������յ���"+inputString+"\r\n";
			out.write(s.getBytes());
			out.flush();
			inputString = readClientString(ins);
		}
		s = "OK,BYES"+inputString+"\r\n";
		out.write(s.getBytes());
		out.flush();
		System.out.println("Byes��");



	}
	private String readClientString(InputStream ins) {
		int in = 0;
		StringBuffer buffer = new StringBuffer();
		char c;
		while(in!=13) {
			try {
				in = ins.read();
				c = (char)in;
				buffer.append(c);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("�������ַ���"+in+":"+(char)in);
		}
		return buffer.toString().trim();
	}

	public static void main(String[] args) {


		int port = 9091;
		Test3 test = new Test3();
		test.setUpServer(port);
//		String s = "Welcome to CoolCats's Blog";
//		System.out.println("s���ȣ�"+s.length());
//		byte[] b = s.getBytes();
//		System.out.println("b���ȣ�"+b.length);
//		for(int i=0;i<b.length;i++) {
//			System.out.println(i+"���ֽڣ�"+b[i]+", "+Integer.toBinaryString(b[i]));
//			
//		}
		}
	
	


	}


