package bean;
/**
 * 购物车类
 * @author shenjunjie
 *
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class Cart implements Serializable
{
	int totalCount;//总数量
	double totalPrice;//总金额
	Map<Integer, Item> items = new LinkedHashMap<Integer, Item>();
	public int getTotalCount()
	{
		int count=0;
		for(Item item:getAllItems())
			count+=item.getCount();
		return count;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public double getTotalPrice()
	{
		BigDecimal price = new BigDecimal(0);
		for(Item item:getAllItems())
			price=price.add(new BigDecimal(String.valueOf(item.getPrice())));
		return price.doubleValue();
	}
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public Map<Integer, Item> getItems()
	{
		return items;
	}
	public void setItems(Map<Integer, Item> items)
	{
		this.items = items;
	}
	public Cart(int totalCount, double totalPrice, Map<Integer, Item> items)
	{
		super();
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
		this.items = items;
	}
	public Cart()
	{
		super();
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String toString()
	{
		return "Cart [totalCount=" + totalCount + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}
	
	public List<Item> getAllItems()
	{
		return new ArrayList<Item>(items.values());
	}
	
	public void addBookToCart(Book book)
	{
		Item current = items.get(book.getId());
		if(current==null)
		{
			items.put(book.getId(), new Item(book, 1, book.getPrice()));
		}
		else
		{
			current.setCount(current.getCount()+1);
		}
	}
	
	public void deleteBookFromCart(String id)
	{
		items.remove(Integer.parseInt(id));
	}
	
	public void updateItem(String id,String count)
	{
		int book_id = 0;
		int book_count = 1;
		try
		{
			book_id = Integer.parseInt(id);
			book_count = Integer.parseInt(count);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		book_id=book_id>0?book_id:1;
		Item current = items.get(book_id);
		if(current!=null)
			current.setCount(book_count);
	}
	
	public void clear()
	{
		items.clear();
	}
}
