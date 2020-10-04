<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<html>
  <head>
    <title>订单详情</title>
  </head>
  <body>
  	<c:if test="${empty requestScope.order_list}">
  		<h2>很抱歉，暂时没有您的订单哦！<a href="index.jsp">马上去购物</a></h2>
  	</c:if>
  	<c:if test="${!empty requestScope.order_list}">
  		 <table>
	 	<tr>
		 	<th>日期</th>
		 	<th>金额</th>
		 	<th>状态</th>
		 	<th>详情</th>
	 	</tr>
	 	 <c:forEach items="${requestScope.order_list}" var="data">
	 	 <tr>
		  	<td>${data.createDate}</td>
		  	<td>${data.totalMoney}</td>
		  	<td>
		  		<c:choose>
		  			<c:when test="${data.status == 0}">
		  				未发货
		  			</c:when>
		  			<c:when test="${data.status == 1}">
		  				已发货<a href="client/OrderClientServlet?type=delivered&orderID=${data.orderID}">确认收货</a>
		  			</c:when>
		  			<c:when test="${data.status == 2}">
		  				交易完成
		  			</c:when>
		  			
		  		</c:choose>
		  	</td>
		  	<td><a href="client/OrderClientServlet?type=orderDetail&orderID=${data.orderID}">订单详情</a></td>
		 </tr>
		 </c:forEach>
	 </table>
  	</c:if>
  	  
  </body>
</html>
