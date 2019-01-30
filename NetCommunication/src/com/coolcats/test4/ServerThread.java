package com.coolcats.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 处理某一客户机交互的实现
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
	 * 取得该线程对象代表的用户
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
			sendMessage(userName+"'s 密码:");

			String userPwd = brd.readLine();
			_user = new ClientInfo();
			_user.setUserName(userName);
			_user.setUserPwd(userPwd);
			boolean loginState = DaoTool.checkLoginState(_user);
			if(!loginState) {//不存在此用户则关闭
				this.closeClient();
				return;
			}
			ChatTool.addClient(this);//认证成功，将此对象加入服务器队列
			String input = brd.readLine();//逐行读取客户机信息
			while(!input.equals("byes")) {
				System.out.println("服务器读取："+input);
				ChatTool.castMsg(_user, input);
				input = brd.readLine();
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChatTool.castMsg(_user, "下线了");
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
	 * 封装向telnet发送字符串的函数
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
	 * 封装读取客户端字符串的函数
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
