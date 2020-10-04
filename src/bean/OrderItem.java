package bean;
/**
 * 订单详情
 * @author shenjunjie
 *
 */
public class OrderItem
{
	
	private Integer id;//默认自增id
	private String title;//书名
	private double price;//单价
	private int count;//购买数量
	private double total;//总金额
	private String orderID;//多个订单项对应一个订单
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public double getTotal()
	{
		return total;
	}
	public void setTotal(double total)
	{
		this.total = total;
	}
	public String getOrderID()
	{
		return orderID;
	}
	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}
	public OrderItem()
	{
		super();
	}
	public OrderItem(Integer id, String title, double price, int count, double total, String orderID)
	{
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.count = count;
		this.total = total;
		this.orderID = orderID;
	}
	@Override
	public String toString()
	{
		return "OrderItem [id=" + id + ", title=" + title + ", price=" + price + ", count=" + count + ", total=" + total
				+ ", orderID=" + orderID + "]";
	}
	
	
}
