package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user = service.login(new User(null,username,password,null));
		if(user==null)
		{
			//登录失败  转发至登录页面
			System.out.println(username+"登录失败，即将跳转到登录页面...");
			request.setAttribute("message", "用户名或密码错误！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
		else
		{
			//登录成功  重定向至成功页面
			System.out.println(username+"登录成功！");
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}

}
