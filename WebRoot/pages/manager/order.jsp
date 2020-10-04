<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<html>
  <head>
    <title>订单管理界面</title>
  </head>
  
  <body>
     <table>
	 	<tr>
		 	<th>订单号</th>
		 	<th>日期</th>
		 	<th>金额</th>
		 	<th>状态</th>
		 	<th>详情</th>
	 	</tr>
	 	 <c:forEach items="${requestScope.allOrder}" var="data">
	 	 <tr>
		  	<td>${data.orderID}</td>
		  	<td>${data.createDate}</td>
		  	<td>${data.totalMoney}</td>
		  	<td>
		  		<c:choose>
		  			<c:when test="${data.status == 0}">
		  				未发货<a href="manager/OrderManagerServlet?type=deliver&&orderID=${data.orderID}">点击发货</a>
		  			</c:when>
		  			<c:when test="${data.status == 1}">
		  				已发货
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
  </body>
</html>
