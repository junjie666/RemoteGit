package dao.impl;

import java.util.List;

import bean.OrderItem;
import dao.BaseDao;
import dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao
{

	@Override
	public int saveOrderItem(OrderItem item)
	{
		String sql = "insert into order_item (title,price,count,total,orderID) values(?,?,?,?,?)";
		return update(sql, item.getTitle(),item.getPrice(),item.getCount(),item.getTotal(),item.getOrderID());
	}

	@Override
	public List<OrderItem> getOrderItems(String OrderID)
	{
		//根据订单号获取所有的订单项
		String sql = "select * from order_item where orderID=? ";
		return getBeanList(sql,OrderID);
	}

	@Override
	public void saveBatch(List<OrderItem> list)
	{
		// TODO 自动生成的方法存根
		String sql = "insert into order_item (title,price,count,total,orderID) values(?,?,?,?,?)";
		Object[][] params = new Object[list.size()][5];
		for(int i=0;i<params.length;i++)
		{
			params[i] = new Object[]{list.get(i).getTitle(),list.get(i).getPrice(),list.get(i).getCount(),list.get(i).getTotal(),list.get(i).getOrderID()};
		}
		batch(sql, params);
	}

	
}
