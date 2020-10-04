package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.ObjectUtils;

public class BookManagerServlet extends BaseServlet
{
	private BookService service = new BookServiceImpl();
	
	public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/**
		 * 分页显示
		 */
//		System.out.println("启用分页");
		String pageNum = request.getParameter("pageNum");
		Page<Book> page = service.getPage(pageNum,"3");
		page.setUrl("manager/BookManagerServlet?type=page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/booklist.jsp").forward(request, response);
		
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/**
		 * 显示图书列表
		 */
		List<Book> list = service.getAll();
		request.setAttribute("booklist", list);
		request.getRequestDispatcher("/pages/manager/booklist.jsp").forward(request, response);
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/**
		 * 添加图书
		 */
		
		Book book_temp = ObjectUtils.param2bean2(request, new Book());
//		System.out.println(book_temp.toString());
		if(book_temp.getId()>0)
		{
			boolean flag = service.update(book_temp);
			if(flag)
			{
				String pageNum = request.getParameter("pageNum");
				System.out.println("图书修改成功");
//				request.getRequestDispatcher("/manager/BookManagerServlet?type=list").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?type=page&pageNum="+pageNum);
			}
			else
			{
				System.out.println("图书修改失败，请重试");
				request.getRequestDispatcher("/manager/BookManagerServlet?type=search&id="+book_temp.getId()).forward(request, response);
			}
		}
		else
		{
			boolean flag = service.add(book_temp);
			if(flag)
			{
				System.out.println("图书添加成功");
//				request.getRequestDispatcher("/manager/BookManagerServlet?type=list").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?type=page&pageNum="+service.getPage("", "").getTotalPageNum());

			}
			else
			{
				System.out.println("图书添加失败，请重试");
				request.getRequestDispatcher("/pages/manager/bookedit.jsp").forward(request, response);
			}
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		String pageNum = request.getParameter("pageNum");
		String referer = request.getHeader("Referer");
		Book book_temp = ObjectUtils.param2bean2(request, new Book());
		boolean flag = service.delete(book_temp);
//		request.getRequestDispatcher("/manager/BookManagerServlet?type=page&pageNum=1").forward(request, response);
		response.sendRedirect(referer);
		
	}
	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Book book_temp = ObjectUtils.param2bean2(request, new Book());
		Book book_get = service.get(book_temp);
		request.setAttribute("book", book_get);
		request.getRequestDispatcher("/pages/manager/bookedit.jsp").forward(request, response);
	}
	
}
