package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Book;
import bean.Cart;
import bean.Item;
import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.BookService;
import service.OrderItemService;
import service.OrderService;

public class OrderServiceImpl implements OrderService
{
	BookService bookService = new BookServiceImpl();
	OrderDao orderDao = new OrderDaoImpl();
	OrderItemService orderItemService = new OrderItemServiceImpl();
	@Override
	public String save(Cart cart,User user)
	{
		//将购物车中的数据封装并保存
		//①封装订单
		Order order = new Order();
		Date date = new Date();
		order.setCreateDate(date);
		String orderID = date.getTime()+user.getId().toString();
		order.setOrderID(orderID);
		order.setTotalMoney(cart.getTotalPrice());
		order.setStatus(0);
		order.setUserID(user.getId());
		
		//②保存订单
		orderDao.saveOrder(order);
		
		//③封装订单项,修改库存
		List<OrderItem> list = new ArrayList<OrderItem>();
		for(Item item : cart.getAllItems())
		{
			OrderItem order_item = new OrderItem();
			order_item.setTitle(item.getBook().getTitle());
			order_item.setPrice(item.getBook().getPrice());
			order_item.setCount(item.getCount());
			order_item.setOrderID(orderID);
			order_item.setTotal(item.getPrice());
			list.add(order_item);
//			Book book = item.getBook();//bug 读取的是购物车中库存，应该从数据库中取
			Book book = new Book();
			book.setId(item.getBook().getId());
			book = bookService.get(book);
			book.setSales(book.getSales()+item.getCount());
			book.setStock(book.getStock()-item.getCount());
			bookService.update(book);
		}
		

		orderItemService.batch(list);
		
		//结账完毕，清空购物车
		cart.clear();
		
		return orderID;
	}

	@Override
	public void updateStatus(String orderID, String status)
	{
		// TODO 自动生成的方法存根
		Order order = new Order();
		order.setOrderID(orderID);
		int order_status = 0;
		try
		{
			order_status = Integer.parseInt(status);
		}
		catch (NumberFormatException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		order.setStatus(order_status);
		orderDao.updateStatus(order);
	}

	@Override
	public List<Order> getAllOrder()
	{
		// TODO 自动生成的方法存根
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> getOrderByUserID(Integer userID)
	{
		// TODO 自动生成的方法存根
		return orderDao.getOrderListByUserID(userID);
	}

}
