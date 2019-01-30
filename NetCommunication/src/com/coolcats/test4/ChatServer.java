package com.coolcats.test4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
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
				//等待客户端连接进入，进入后生成一个accept对象
				client = server.accept();
				ServerThread t = new ServerThread(client);
				t.start();
//				System.out.println("Incoming Client:" + client.getRemoteSocketAddress());

			} catch (IOException e) {
				e.printStackTrace();
			}

		
		}
	}
	public static void main(String[] args) {


		int port = 9091;
		ChatServer test = new ChatServer();
		test.setUpServer(port);
	}
	
	

}
