package dao;

import java.util.List;

import bean.Order;

public interface OrderDao
{
	int saveOrder(Order order);//保存订单
	int updateStatus(Order order);//修改订单状态
	List<Order> getOrderList();//获取订单列表（管理员）
	List<Order> getOrderListByUserID(Integer userID);//查询某个用户的所有订单
}
