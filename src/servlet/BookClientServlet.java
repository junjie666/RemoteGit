package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookClientServlet extends BaseServlet
{
	BookService service = new BookServiceImpl();
	public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pageNum = request.getParameter("pageNum");
		Page<Book> page = service.getPage(pageNum,"2");
		page.setUrl("client/BookClientServlet?type=page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/booklist.jsp").forward(request, response);
	}
	
	public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		System.out.println("根据价格查询");
		String pageNum = request.getParameter("pageNum");
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		Page<Book> page = service.getPageByPrice(pageNum, "2", minPrice, maxPrice);
		page.setUrl("client/BookClientServlet?type=pageByPrice&minPrice="+minPrice+"&maxPrice="+maxPrice);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/booklist.jsp").forward(request, response);
	}
}
