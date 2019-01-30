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
	 * ������
	 * 
	 * @param ip   �����IP
	 * @param port ����˿��Ŷ˿�
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
			// ��ȡ��������һ����Ϣ
			input = brd.readLine();
			System.out.println(input);
			// ���շ���������
			name += "\r\n";
			ous.write(name.getBytes());
			ous.flush();
			System.out.println("���ύ�û������ȴ���������Ӧ����");

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
	 * �ӷ�������ȡ��Ϣ������������
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
		if(nc.conn2Server()) {//������Ӵ����ɹ�
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter username");
			String name = sc.next();//next()��extLine����
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
