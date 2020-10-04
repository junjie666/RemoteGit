package test;

import java.math.BigDecimal;

import org.junit.Test;

import bean.Book;
import bean.Cart;
import bean.User;
import service.BookService;
import service.OrderService;
import service.impl.BookServiceImpl;
import service.impl.OrderServiceImpl;

public class CartTest
{
	OrderService orderService = new OrderServiceImpl();
	BookService bookService = new BookServiceImpl();
	Book book1 =new Book(1, "水浒传1", "", 12.3, 100, 1000, null);
	Book book2 =new Book(2, "水浒传2", "", 10.5, 100, 1000, null);
	Book book3 =new Book(3, "水浒传3", "", 18.2, 100, 1000, null);
	Book book4 =new Book(4, "水浒传4", "", 12.4, 100, 1000, null);
	@Test
	public void add()
	{ 
		
		Cart cart = new Cart();
		Book book = new Book();
		book.setId(1);
		cart.addBookToCart(bookService.get(book));
		cart.addBookToCart(bookService.get(book));
		cart.addBookToCart(bookService.get(book));
		cart.addBookToCart(bookService.get(book));
		cart.addBookToCart(bookService.get(book));
//		cart.addBookToCart(book3);
//		cart.addBookToCart(book4);
		System.out.println(cart);
		System.out.println("购物车总数："+cart.getTotalCount());
		System.out.println("总价格："+cart.getTotalPrice());
		
		User user = new User();
		user.setId(1);
		System.out.println(orderService.save(cart, user));
	}
}
