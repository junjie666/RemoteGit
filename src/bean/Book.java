package bean;

import java.io.Serializable;

/**
 * 图书类
 * @author shenjunjie
 *
 */
public class Book implements Serializable
{
	private Integer id;
	private String title;
	private String author;
	private double price;
	private int sales;
	private int stock;
	private String imgPath = "static/img/book_default.jpg"; //默认路径
	
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
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getSales()
	{
		return sales;
	}
	public void setSales(int sales)
	{
		this.sales = sales;
	}
	public int getStock()
	{
		return stock;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public String getImgPath()
	{
		return imgPath;
	}
	public void setImgPath(String imgPath)
	{
		//不为空进行覆盖，为空采用默认值
		if(imgPath!=null)
			this.imgPath = imgPath;
	}
	
	
	
	public Book()
	{
		super();
	}
	
	
	

	public Book(Integer id, String title, String author, double price, int sales, int stock, String imgPath)
	{
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		if(imgPath!=null)
			this.imgPath = imgPath;
	}
	
	@Override
	public String toString()
	{
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}
	
	
}
