package com.coolcats.test4;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器端连接管理类
 * 新的客户机连入时，创建一个Socket对象，用独立的线程处理Socket对象的操作（因其方法是阻塞式）
 * 管理连接处理线程对象的方法
 * 此类只提供方法调用，无需创建对象
 * @author CoolCats
 *
 */
public class ChatTool {
	private static List<ServerThread> stList = new ArrayList<>();
	//无需在外部创建此类对象，将构造器访问限制符设置为private
	private ChatTool() {}
	/**
	 * 增加客户处理线程
	 * @param ct 处理线程对象
	 */
	public static void addClient(ServerThread ct) {
		castMsg(ct.getOwnerUser(), ct.getOwnerUser().getUserName()+"上线了");
		stList.add(ct);//将处理线程对象加入队列
		System.out.println(ct.getOwnerUser().getUserName()+"上线"+ct.getOwnerSocket().getRemoteSocketAddress());
	}
	/**
	 * 消息转发
	 * @param user
	 * @param message
	 */
	public static void castMsg(ClientInfo user,String message) {
		message = user.getUserName()+": "+message;
		for(int i=0;i<stList.size();i++) {
			ServerThread st = stList.get(i);
			//st 发送消息
			st.sendMessage(message);
		}
	}
}
