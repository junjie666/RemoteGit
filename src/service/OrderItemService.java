package service;

import java.util.List;

import bean.OrderItem;

public interface OrderItemService
{
	public void saveItem(OrderItem item);//保存订单项
	
	public void batch(List<OrderItem> list);
	
	public  List<OrderItem> getOrderItem(String OrderID);
}
