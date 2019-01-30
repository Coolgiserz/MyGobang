package com.coolcats.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient extends Thread {
	private String serverIp;
	private int port;
	private OutputStream ous;
	private BufferedReader brd;

	/**
	 * 构造器
	 * 
	 * @param ip   服务端IP
	 * @param port 服务端开放端口
	 */
	public SimpleClient(String ip, int port) {
		this.serverIp = ip;
		this.port = port;
	}

	public boolean conn2Server() {
		try {
			Socket client = new Socket(this.serverIp, this.port);
			InputStream ins = client.getInputStream();
			brd = new BufferedReader(new InputStreamReader(ins));
			ous = client.getOutputStream();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean login2Server(String name, String pwd) {
		String input;
		try {
			// 读取服务器的一条消息
			input = brd.readLine();
			System.out.println(input);
			// 按照服务器流程
			name += "\r\n";
			ous.write(name.getBytes());
			ous.flush();
			System.out.println("已提交用户名，等待服务器响应……");

			input = brd.readLine();
			System.out.println(input);
			pwd += "\r\n";
			ous.write(pwd.getBytes());
			ous.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void run() {
		while (true) {
			readFromServer();
		}
	}

	/**
	 * 从服务器读取消息，方法会阻塞
	 */
	private void readFromServer() {
		String input;
		try {
			input = brd.readLine();
			System.out.println(input);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(String msg) {
		msg += "\r\n";
		try {
			ous.write(msg.getBytes());
			ous.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SimpleClient nc = new SimpleClient("localhost", 9091);
		if(nc.conn2Server()) {//如果连接创建成功
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter username");
			String name = sc.next();//next()和extLine区别
			System.out.println("Please enter password");
			String pwd = sc.next();
			if(nc.login2Server(name, pwd)) {
				nc.start();
				while(true) {
					System.out.println("Enter the message: ");
					String msg = sc.next();
					nc.sendMsg(msg);
				}
			}
		}else {
			
		}
	}
}
