package service.impl;

import java.util.List;

import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService
{
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Override
	public void saveItem(OrderItem item)
	{
		// TODO 自动生成的方法存根
		orderItemDao.saveOrderItem(item);
	}

	@Override
	public List<OrderItem> getOrderItem(String OrderID)
	{
		// TODO 自动生成的方法存根
		return orderItemDao.getOrderItems(OrderID);
	}

	@Override
	public void batch(List<OrderItem> list)
	{
		// TODO 自动生成的方法存根
		orderItemDao.saveBatch(list);
	}

}
