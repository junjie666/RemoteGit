package service;

import java.util.List;

import bean.Book;
import bean.Page;

/**
 * 图书增删改查业务逻辑
 * @author shenjunjie
 *
 */
public interface BookService
{
	List<Book> getAll(); // 显示所有图书
	boolean add(Book book); //增加图书
	boolean delete(Book book); //删除图书
	boolean update(Book book);//修改图书
	Book get(Book book); //显示一本图书
	Page<Book> getPage(String PageNum, String PerCount); // 显示分页
	Page<Book> getPageByPrice(String PageNum, String PerCount, String MinPrice, String MaxPrice); // 显示分页
}
