package com.coolcats.test4;
/**
 * 数据访问和控制类，增删查改
 * 账号验证、数据保存、更改
 * @author CoolCats
 *
 */

import java.util.HashMap;
import java.util.Map;

public class DaoTool {
	/**
	 * 检查用户是否存在
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
	 * 内存区模拟用户数据
	 */
	private static Map<String, ClientInfo> userDB = new HashMap();
	/**
	 * 类被装载时只执行一次
	 */
	static {
		
		for(int i=0;i<10;i++) {
			String userN = "user"+i;
			String userPwd = "pwd"+i;
			ClientInfo user = new ClientInfo();
			user.setUserName(userN);
			user.setUserPwd(userPwd);
			userDB.put(user.getUserName(), user);//还考虑对注册的用户名进行过滤
		}
			
	}
}
