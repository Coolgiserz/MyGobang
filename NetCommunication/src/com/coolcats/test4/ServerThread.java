package com.coolcats.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ����ĳһ�ͻ���������ʵ��
 * 
 * @author CoolCats
 *
 */
public class ServerThread extends Thread{
	private Socket _client;
	private OutputStream _ous;
	private ClientInfo _user;

	public ServerThread(Socket client) {
		this._client = client;
	}

	/**
	 * ȡ�ø��̶߳��������û�
	 * 
	 * @return
	 */
	public ClientInfo getOwnerUser() {
		return this._user;
	}
	public Socket getOwnerSocket() {
		return this._client;
	}

	public void run() {
		processSocket();

	}

	private void processSocket() {
		try {
			InputStream ins = _client.getInputStream();
			_ous = _client.getOutputStream();
			BufferedReader brd = new BufferedReader(new InputStreamReader(ins));
			String s = "Welcome to CoolCats! Enter your username and password:\r\n";
			sendMessage(s);
			String userName = brd.readLine();
			sendMessage(userName+"'s ����:");

			String userPwd = brd.readLine();
			_user = new ClientInfo();
			_user.setUserName(userName);
			_user.setUserPwd(userPwd);
			boolean loginState = DaoTool.checkLoginState(_user);
			if(!loginState) {//�����ڴ��û���ر�
				this.closeClient();
				return;
			}
			ChatTool.addClient(this);//��֤�ɹ������˶���������������
			String input = brd.readLine();//���ж�ȡ�ͻ�����Ϣ
			while(!input.equals("byes")) {
				System.out.println("��������ȡ��"+input);
				ChatTool.castMsg(_user, input);
				input = brd.readLine();
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChatTool.castMsg(_user, "������");
		this.closeClient();
	}

	private void closeClient() {
		try {
			_ous.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * ��װ��telnet�����ַ����ĺ���
	 * 
	 * @param out
	 * @param s
	 */
	public void sendMessage( String s) {
		try {
			s += "\r\n";
			_ous.write(s.getBytes());
			_ous.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��װ��ȡ�ͻ����ַ����ĺ���
	 * 
	 * @param ins
	 * @return
	 */
	private String readClientString(InputStream ins) {
		int in = 0;
		StringBuffer buffer = new StringBuffer();
		char c;
		while (in != 13) {
			try {
				in = ins.read();
				c = (char) in;
				buffer.append(c);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString().trim();
	}
}
