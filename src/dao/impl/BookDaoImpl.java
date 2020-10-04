package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.BookDao;

/**
 * 实现BookDao
 * @author shenjunjie
 *
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao
{

	@Override
	public Book getBook(Book book)
	{
//		String sql = "select id,title,author,price,sales,stock,imgPath from book_book where id=?";
		String sql = "select * from book_book where id=?";
		return getBean(sql,book.getId());
	}

	@Override
	public List<Book> getAllBooks()
	{
		// TODO 自动生成的方法存根
//		String sql = "select id,title,author,price,sales,stock,imgPath from book_book";
		String sql = "select * from book_book";
		return getBeanList(sql);
	}

	@Override
	public boolean addBook(Book book)
	{
		// TODO 自动生成的方法存根
		String sql="insert into book_book (title,author,price,sales,stock,imgPath) values (?,?,?,?,?,?)";
		int update = update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
		return update > 0;
	}

	@Override
	public boolean deleteBook(Book book)
	{
		// TODO 自动生成的方法存根
		String sql = "delete from book_book where id=?";
		int update = update(sql, book.getId());
		return update > 0;
	}

	@Override
	public boolean updateBook(Book book)
	{
		// TODO 自动生成的方法存根
		String sql = "update book_book set title=?,author=?,price=?,sales=?,stock=?,imgPath=? where id=?";
		int update = update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
		return update > 0;
	}

	@Override
	public List<Book> getPageList(int index, int size)
	{
		// TODO 自动生成的方法存根
		String sql = "select * from book_book limit ?,?";
		return getBeanList(sql,index,size);
	}

	@Override
	public int getTotalCount()
	{
		// TODO 自动生成的方法存根
		String sql = "select count(*) from book_book";
		int count = 0;
		try
		{
			count = Integer.parseInt(getSingleValue(sql).toString());
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public List<Book> getPageListByPrice(int index, int size, int minPrice, int maxPrice)
	{
		String sql = "select * from book_book where price between ? and ? limit ?,?";
		return getBeanList(sql,minPrice,maxPrice,index,size);
	}

	@Override
	public int getTotalCountByPrice(int minPrice, int maxPrice)
	{
		String sql = "select count(*) from book_book where price between ? and ?";
		int count = 0;
		try
		{
			count = Integer.parseInt(getSingleValue(sql,minPrice,maxPrice).toString());
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return count;
	}

	
	
}
