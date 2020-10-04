package service;

import java.util.List;

import bean.Cart;
import bean.Order;
import bean.User;

public interface OrderService
{
	public String save(Cart cart, User user); //结账操作
	
	public void updateStatus(String orderID,String status); //修改订单状态
	
	public List<Order> getAllOrder();//管理员获取所有订单
	
	public List<Order> getOrderByUserID(Integer userID);//获取某个用户的订单
	
}
