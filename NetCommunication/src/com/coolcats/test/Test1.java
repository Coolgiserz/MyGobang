package com.coolcats.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {

	public static void main(String[] args) {

		ServerSocket server;
		Socket client = null;
		while(true) {
			try {
				int port = 9091;
				server = new ServerSocket(port);
				System.out.println("server:" + port);
				//�ȴ��ͻ������ӽ��룬���������һ��accept����
				client = server.accept();
				System.out.println("Incoming:" + client.getRemoteSocketAddress());
				OutputStream out = client.getOutputStream();
				InputStream ins = client.getInputStream();
				String s = "Welcome to CoolCats!";
				byte[] data = s.getBytes();
				out.write(data);
				out.flush();

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

}
