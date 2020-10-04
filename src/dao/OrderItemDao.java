package dao;

import java.util.List;

import bean.OrderItem;

public interface OrderItemDao
{
	int saveOrderItem(OrderItem item);//保存订单项
	void saveBatch(List<OrderItem> list);//批量保存
	List<OrderItem> getOrderItems(String OrderID);//根据您订单号查询订单项
}
