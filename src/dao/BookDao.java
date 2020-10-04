package dao;

import java.util.List;

import bean.Book;

/**
 * 图书类接口
 * @author shenjunjie
 *
 */
public interface BookDao
{
	Book getBook(Book book); //显示一本图 书
	List<Book> getAllBooks(); // 显示所有图书
	boolean addBook(Book book); //增加图书
	boolean deleteBook(Book book); //删除图书
	boolean updateBook(Book book);//修改图书
	List<Book> getPageList(int index, int size);//分页显示图书
	List<Book> getPageListByPrice(int index, int size, int minPrice, int maxPrice);//根据价格分页显示图书
	int getTotalCount();//获取记录总数
	int getTotalCountByPrice(int minPrice, int maxPrice);//根据价格获取记录总数
}
