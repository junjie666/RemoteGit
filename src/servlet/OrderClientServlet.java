package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Constants;
import bean.Order;
import bean.OrderItem;
import bean.User;
import service.OrderItemService;
import service.OrderService;
import service.impl.OrderItemServiceImpl;
import service.impl.OrderServiceImpl;
import utils.ObjectUtils;

public class OrderClientServlet extends BaseServlet
{
	OrderService orderService =  new OrderServiceImpl();
	OrderItemService orderItemService = new OrderItemServiceImpl();
	public void orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderID = request.getParameter("orderID");
		List<OrderItem> order_item= orderItemService.getOrderItem(orderID);
		request.setAttribute("order_item", order_item);
		request.getRequestDispatcher("/pages/cart/detail.jsp").forward(request, response);
		
	}
	public void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Order> order_list = orderService.getOrderByUserID(user.getId());
		request.setAttribute("order_list", order_list);
		request.getRequestDispatcher("/pages/cart/order.jsp").forward(request, response);
	}
	public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//结算方法
		
//		//验证是否登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		if(user==null)
//		{
//			request.setAttribute("message", "请登录");
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//			return;
//		}
		Cart cart = ObjectUtils.getCart(request);
		String orderID = orderService.save(cart, user);
		session.setAttribute("orderID", orderID);
		response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
	}

	public void delivered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderID = request.getParameter("orderID");
		orderService.updateStatus(orderID, String.valueOf(Constants.DELIVERED));
		response.sendRedirect(request.getHeader("Referer"));
	}
}
