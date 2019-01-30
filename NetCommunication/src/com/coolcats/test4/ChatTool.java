package com.coolcats.test4;

import java.util.ArrayList;
import java.util.List;

/**
 * �����������ӹ�����
 * �µĿͻ�������ʱ������һ��Socket�����ö������̴߳���Socket����Ĳ��������䷽��������ʽ��
 * �������Ӵ����̶߳���ķ���
 * ����ֻ�ṩ�������ã����贴������
 * @author CoolCats
 *
 */
public class ChatTool {
	private static List<ServerThread> stList = new ArrayList<>();
	//�������ⲿ����������󣬽��������������Ʒ�����Ϊprivate
	private ChatTool() {}
	/**
	 * ���ӿͻ������߳�
	 * @param ct �����̶߳���
	 */
	public static void addClient(ServerThread ct) {
		castMsg(ct.getOwnerUser(), ct.getOwnerUser().getUserName()+"������");
		stList.add(ct);//�������̶߳���������
		System.out.println(ct.getOwnerUser().getUserName()+"����"+ct.getOwnerSocket().getRemoteSocketAddress());
	}
	/**
	 * ��Ϣת��
	 * @param user
	 * @param message
	 */
	public static void castMsg(ClientInfo user,String message) {
		message = user.getUserName()+": "+message;
		for(int i=0;i<stList.size();i++) {
			ServerThread st = stList.get(i);
			//st ������Ϣ
			st.sendMessage(message);
		}
	}
}
