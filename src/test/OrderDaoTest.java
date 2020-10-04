package test;

import java.util.Date;

import org.junit.Test;

import bean.Order;
import bean.OrderItem;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;

public class OrderDaoTest
{
	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Test
	public void testSave()
	{
		Order order = new Order("3", new Date(), 2, 105, 2);
		orderDao.saveOrder(order);
	}
	
	@Test
	public void testUpdate()
	{
		Order order = new Order();
		order.setStatus(10);
		order.setOrderID("1");
		orderDao.updateStatus(order);
	}
	
	@Test
	public void testShowAll()
	{
		for(Order order : orderDao.getOrderList())
			System.out.println(order.toString());
	}
	
	@Test
	public void testShowByUserID()
	{
		for(Order order : orderDao.getOrderListByUserID(1))
			System.out.println(order.toString());
	}
	
	@Test
	public void testItemSave()
	{
		OrderItem item = new OrderItem(null, "新华字典", 120.00, 100, 12000, "1");
		orderItemDao.saveOrderItem(item);
	}
	
	@Test
	public void testShowItem()
	{
		for(OrderItem order : orderItemDao.getOrderItems("1"))
			System.out.println(order.toString());
	}
}
