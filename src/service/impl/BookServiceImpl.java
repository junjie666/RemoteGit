package service.impl;

import java.util.List;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl implements BookService
{
	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> getAll()
	{
		// TODO 自动生成的方法存根
		return bookDao.getAllBooks();
	}

	@Override
	public boolean add(Book book)
	{
		// TODO 自动生成的方法存根
		return bookDao.addBook(book);
	}

	@Override
	public boolean delete(Book book)
	{
		// TODO 自动生成的方法存根
		return bookDao.deleteBook(book);
	}

	@Override
	public boolean update(Book book)
	{
		// TODO 自动生成的方法存根
		return bookDao.updateBook(book);
	}

	@Override
	public Book get(Book book)
	{
		// TODO 自动生成的方法存根
		return bookDao.getBook(book);
	}

	@Override
	public Page<Book> getPage(String PageNum, String PerCount)
	{
		// TODO 自动生成的方法存根
		Page<Book> page = new Page<Book>();
		// 设置默认值
		int pageNum = 1;
		int perCount = page.getPerCount();
		try
		{
			pageNum = Integer.parseInt(PageNum);
			perCount = Integer.parseInt(PerCount);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		page.setTotalCount(bookDao.getTotalCount());
		page.setPageNum(pageNum);
		page.setPerCount(perCount);
		page.setPageData(bookDao.getPageList(page.getIndex(),page.getPerCount()));
		return page;
	}

	@Override
	public Page<Book> getPageByPrice(String PageNum, String PerCount, String MinPrice, String MaxPrice)
	{
		// TODO 自动生成的方法存根
		Page<Book> page = new Page<Book>();
		// 设置默认值
		int pageNum = 1;
		int perCount = page.getPerCount();
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;
		try
		{
			pageNum = Integer.parseInt(PageNum);
			perCount = Integer.parseInt(PerCount);
			minPrice = Integer.parseInt(MinPrice);
			maxPrice = Integer.parseInt(MaxPrice);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		page.setTotalCount(bookDao.getTotalCountByPrice(minPrice, maxPrice));
		page.setPageNum(pageNum);
		page.setPerCount(perCount);
		page.setPageData(bookDao.getPageListByPrice(page.getIndex(),page.getPerCount(),minPrice,maxPrice));
		return page;
	}

	
}
