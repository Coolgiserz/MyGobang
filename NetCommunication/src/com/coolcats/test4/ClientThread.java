package com.coolcats.test4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread{

	private Socket _client;
	public ClientThread(Socket client) {
		this._client = client;
		
		System.out.println("Incoming client:"+client.getRemoteSocketAddress());
		
	}
	public void run() {
		try {
			processChat(this._client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			System.out.println("�ͻ���"+client.getPort()+"������"+inputString);
			s = "������յ���"+inputString+"\r\n";
			sendMessage(out,s);
			inputString = readClientString(ins);
		}
		s = "OK,BYES"+inputString+"\r\n";
		sendMessage(out,s);
		System.out.println("Byes��"+client.getPort()+","+this.getId()+"Exit");

		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * ��װ��telnet�����ַ����ĺ���
	 * @param out
	 * @param s
	 */
	private void sendMessage(OutputStream out,String s) {
		try {
			out.write(s.getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��װ��ȡ�ͻ����ַ����ĺ���
	 * @param ins
	 * @return
	 */
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
		}
		return buffer.toString().trim();
	}

	

	
}
