package bean;

import java.util.Date;

/**
 * 订单类
 * @author shenjunjie
 *
 */
public class Order
{
	private String orderID;//订单号
	private Date createDate;//创建日期
	private int status;//订单状态
	private double totalMoney;//景丹总额
	private Integer userID;//关联的用户
	public String getOrderID()
	{
		return orderID;
	}
	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public double getTotalMoney()
	{
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney)
	{
		this.totalMoney = totalMoney;
	}
	public Integer getUserID()
	{
		return userID;
	}
	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}
	
	
	
	public Order()
	{
		super();
		// TODO 自动生成的构造函数存根
	}
	public Order(String orderID, Date createDate, int status, double totalMoney, Integer userID)
	{
		super();
		this.orderID = orderID;
		this.createDate = createDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.userID = userID;
	}
	@Override
	public String toString()
	{
		return "Order [orderID=" + orderID + ", createDate=" + createDate + ", status=" + status + ", totalMoney="
				+ totalMoney + ", userID=" + userID + "]";
	}
	
	
}
