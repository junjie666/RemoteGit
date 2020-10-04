package dao;

import bean.User;

/**
 * 定义userdao接口
 * @author shenjunjie
 *
 */
public interface UserDao
{
	//①根据用户名和密码查询方法
	public User getUserByUsernameAndPassword(User user);
	//②注册方法
	public boolean registeUser(User user);
}
