package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet
{
	private UserService service=new UserServiceImpl();
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		boolean register = service.register(new User(null, username, password, email));
		if(register==true)
		{
			//注册成功
			System.out.println(username+"注册成功！");
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
		else
		{
			//注册失败
			System.out.println(username+"注册失败！ 用户已存在！");
			request.setAttribute("message", "该用户名已存在！注册失败！");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
