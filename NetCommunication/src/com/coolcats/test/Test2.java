package com.coolcats.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2 {

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
				System.out.println("Incoming:" + client.getRemoteSocketAddress());
				OutputStream out = client.getOutputStream();
				InputStream ins = client.getInputStream();
				String s = "Welcome to CoolCats!";
				byte[] data = s.getBytes();
				out.write(data);
				out.flush();
				int in = 0;
				while(in!=13) {
					in = ins.read();
					System.out.println("读到的字符："+in+":"+(char)in);
				}
				System.out.println("客户端退出："+in);


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

	public static void main(String[] args) {


		int port = 9091;
		Test2 test = new Test2();
		test.setUpServer(port);
//		String s = "Welcome to CoolCats's Blog";
//		System.out.println("s长度："+s.length());
//		byte[] b = s.getBytes();
//		System.out.println("b长度："+b.length);
//		for(int i=0;i<b.length;i++) {
//			System.out.println(i+"个字节："+b[i]+", "+Integer.toBinaryString(b[i]));
//			
//		}
		}
	
	


	}


