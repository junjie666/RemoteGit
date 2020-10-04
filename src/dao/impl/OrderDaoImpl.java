package dao.impl;

import java.util.List;

import bean.Order;
import dao.BaseDao;
import dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao
{

	@Override
	public int saveOrder(Order order)
	{
		// TODO 自动生成的方法存根
		String sql = "insert into book_order (orderID,createDate,totalMoney,status,userID) values(?,?,?,?,?)";
		return update(sql, order.getOrderID(),order.getCreateDate(),order.getTotalMoney(),order.getStatus(),order.getUserID());
	}

	@Override
	public int updateStatus(Order order)
	{
		// TODO 自动生成的方法存根
		String sql = "update book_order set status=? where orderID=?";
		return update(sql, order.getStatus(),order.getOrderID());
	}

	@Override
	public List<Order> getOrderList()
	{
		// TODO 自动生成的方法存根
		String sql = "select * from book_order";
		return getBeanList(sql);
	}

	@Override
	public List<Order> getOrderListByUserID(Integer userID)
	{
		// TODO 自动生成的方法存根
		String sql = "select * from book_order where userID=?";
		return getBeanList(sql,userID);
	}

}
