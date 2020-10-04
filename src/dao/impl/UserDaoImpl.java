package dao.impl;

import bean.User;
import dao.BaseDao;
import dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao
{

	@Override
	public User getUserByUsernameAndPassword(User user)
	{
		// TODO 自动生成的方法存根
		String sql="select * from book_user where username=? and password=?";
		User userQuery=getBean(sql, user.getUsername(),user.getPassword());
		return userQuery;
	}

	@Override
	public boolean registeUser(User user)
	{
		// TODO 自动生成的方法存根
		String sql="insert into book_user(username,password,email) VALUES(?,?,?)";
		int count=update(sql, user.getUsername(),user.getPassword(),user.getEmail());
		return count>0;
	}

}
