package bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable
{
	private Book book;//购买的图书
	private int count;//购买的数量
	private double price;//总金额
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public double getPrice()
	{
		return new BigDecimal(String.valueOf(book.getPrice())).multiply(new BigDecimal(count)).doubleValue();
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public Item(Book book, int count, double price)
	{
		super();
		this.book = book;
		this.count = count;
		this.price = price;
	}
	public Item()
	{
		super();
	}
	@Override
	public String toString()
	{
		return "Item [book=" + book + ", count=" + count + ", price=" + price + "]";
	}
	
	
}
