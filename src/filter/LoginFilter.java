package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

public class LoginFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO 自动生成的方法存根

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// 验证用户是否登录
		HttpSession session = ((HttpServletRequest)request).getSession();
		User user = (User) session.getAttribute("user");
		if(user == null)
		{
			// 用户未登录
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/pages/user/login.jsp");
		}
		else
		{
			// 用户已登录
			// 放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy()
	{
		// TODO 自动生成的方法存根

	}

}
