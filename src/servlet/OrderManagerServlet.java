package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Constants;

import bean.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderManagerServlet extends BaseServlet
{
	OrderService orderService = new OrderServiceImpl();
	public void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Order> allOrder = orderService.getAllOrder();
		request.setAttribute("allOrder", allOrder);
		request.getRequestDispatcher("/pages/manager/order.jsp").forward(request, response);
	}
	public void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderID = request.getParameter("orderID");
		orderService.updateStatus(orderID, String.valueOf(Constants.DELIVERING));
		response.sendRedirect(request.getHeader("Referer"));
	}
}
