package servlet;
/**
 * 处理所有和用户相关的请求
 * 抽取baseservlet后，此处只需要编写相应的处理逻辑
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.ObjectUtils;

public class UserServlet extends BaseServlet
{
	
	private UserService service=new UserServiceImpl();
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
		
		//服务器端令牌,验证客户端令牌
		String token = (String) request.getSession().getAttribute("token");
		System.out.println(token);
		//客户端令牌
		String page_token = request.getParameter("page_token");
		System.out.println(page_token);
		
		//服务器中的token已被移除，页面会带来缓存的token
		if(page_token.equals(token))
		{
			User user_temp = ObjectUtils.param2bean2(request, new User());
			User user = service.login(user_temp);
			if(user==null)
			{
				//登录失败  转发至登录页面
				System.out.println(user_temp.getUsername()+"登录失败，即将跳转到登录页面...");
				request.setAttribute("message", "用户名或密码错误！");
//				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			}
			else
			{
				//登录成功  重定向至成功页面
				request.getSession().setAttribute("user", user);
				System.out.println(user.getUsername()+"登录成功！");
				request.getRequestDispatcher("/pages/user/hello.jsp").forward(request, response);
//				response.sendRedirect(request.getContextPath()+"/pages/user/hello.jsp");//使用重定向，防止表单重复提交
			}
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/pages/user/duplicate.jsp");//使用重定向，防止表单重复提交
		}
		request.getSession().removeAttribute("token");
		
	}
	
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
		String code=request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		String page_code=request.getParameter("code");
		if(code.equals(page_code))
		{
			User user = ObjectUtils.param2bean2(request, new User());
			boolean register = service.register(user);
			if(register==true)
			{
				//注册成功
				System.out.println(user.getUsername()+"注册成功！");
				response.sendRedirect(request.getContextPath()+"/pages/user/hello.jsp");
			}
			else
			{
				//注册失败
				System.out.println(user.getUsername()+"注册失败！ 用户已存在！");
				request.setAttribute("message", "该用户名已存在！注册失败！");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("message", "验证码错误！");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		System.out.println("用户已注销");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

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
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		doPost(request, response);
//	}

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
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
////		String type=request.getParameter("type");
////		if(type!=null)
////		{
////			switch (type)
////			{
////			case "login":
////				System.out.println("这是登录请求");
////				login(request, response);
////				break;
////				
////			case "regist":
////				System.out.println("这是注册请求");
////				regist(request, response);
////				break;
////
////			default:
////				break;
////			}
////		}
//		
//		String type=request.getParameter("type");
//		try
//		{
//			//使用反射获取方法
//			Method method = this.getClass().getDeclaredMethod(type, HttpServletRequest.class,HttpServletResponse.class);
//			method.setAccessible(true);
//			method.invoke(this, request,response);
//		}
//		catch (Exception e)
//		{
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//	}

}
