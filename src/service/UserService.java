package service;
/**
 * 完成用户的登录注册功能
 */
import bean.User;

public interface UserService
{
	public User login(User user);
	public boolean register(User user);
}
