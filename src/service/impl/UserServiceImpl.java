package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDao userdao=new UserDaoImpl();
	@Override
	public User login(User user)
	{
		// TODO 自动生成的方法存根
		return userdao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean register(User user)
	{
		// TODO 自动生成的方法存根
		return userdao.registeUser(user);
	}

}
