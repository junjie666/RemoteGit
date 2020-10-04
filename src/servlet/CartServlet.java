package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import bean.Cart;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.ObjectUtils;

public class CartServlet extends BaseServlet
{
	BookService book_service = new BookServiceImpl();
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Book book = ObjectUtils.param2bean2(request, new Book());
		book = book_service.get(book);
		HttpSession session = request.getSession();
		Cart cart = ObjectUtils.getCart(request);
		session.setAttribute("book", book);
		cart.addBookToCart(book);
		System.out.println(request.getHeader("Referer"));
		response.sendRedirect(request.getHeader("Referer"));
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		Cart cart = ObjectUtils.getCart(request);
		cart.deleteBookFromCart(id);
		response.sendRedirect(request.getHeader("Referer"));
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		String count = request.getParameter("count");
		Cart cart = ObjectUtils.getCart(request);
		cart.updateItem(id, count);
		response.sendRedirect(request.getHeader("Referer"));
	}
	public void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Cart cart = ObjectUtils.getCart(request);
		cart.clear();
		response.sendRedirect(request.getHeader("Referer"));
	}
}
