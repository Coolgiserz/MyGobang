package com.coolcats.test4;
/**
 * ���ݷ��ʺͿ����࣬��ɾ���
 * �˺���֤�����ݱ��桢����
 * @author CoolCats
 *
 */

import java.util.HashMap;
import java.util.Map;

public class DaoTool {
	/**
	 * ����û��Ƿ����
	 * @param user
	 * @return
	 */
	public static boolean checkLoginState(ClientInfo user) {
		if(userDB.containsKey(user.getUserName())) {
			return true;
		}
		System.out.println("Verify Fail! "+user.getUserName()+" does not exist.");
		return false;
		
	}
	/**
	 * �ڴ���ģ���û�����
	 */
	private static Map<String, ClientInfo> userDB = new HashMap();
	/**
	 * �౻װ��ʱִֻ��һ��
	 */
	static {
		
		for(int i=0;i<10;i++) {
			String userN = "user"+i;
			String userPwd = "pwd"+i;
			ClientInfo user = new ClientInfo();
			user.setUserName(userN);
			user.setUserPwd(userPwd);
			userDB.put(user.getUserName(), user);//�����Ƕ�ע����û������й���
		}
			
	}
}
