package test;

import java.util.List;

import org.junit.Test;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookDaoTest
{
	Page<Book> page = new Page<Book>();
	BookDao bookDao = new BookDaoImpl();
	Book book = new Book(null,"西游记", "吴承恩", 20, 3000, 1000 ,null);
	BookService bookService = new BookServiceImpl();

	
	@Test
	public void testGetBook()
	{
		book.setId(7);
		Book abook = bookDao.getBook(book);
		System.out.println(abook.toString());
	}
	
	@Test
	public void testGetAllBooks()
	{
		List<Book> books = bookDao.getAllBooks();
		System.out.println(books);
	}
	
	@Test
	public void testAddBook()
	{
		boolean flag = bookDao.addBook(book);
		System.out.println(flag);
	}
	
	@Test
	public void testDeleteBook()
	{
		book.setId(8);
		boolean flag = bookDao.deleteBook(book);
		System.out.println(flag);
	}
	
	@Test
	public void testUpdateBook()
	{
		book.setId(7);
		book.setSales(500);
		boolean flag = bookDao.updateBook(book);
		System.out.println(flag);
	}
	
	@Test
	public void testGetPage()
	{
		page = bookService.getPage("0", "2");
		System.out.println(page.getTotalPageNum());
	}
	@Test
	public void testGetPageByPrice()
	{
		page = bookService.getPageByPrice("0", "2", "15", "25");
		System.out.println(page.getPageData());
		System.out.println(page.getTotalCount());
	}
	
	
}
