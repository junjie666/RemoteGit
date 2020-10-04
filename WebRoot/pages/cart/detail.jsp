<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<%@ include file="/pages/include/user_include.jsp" %>
<html>
  <head>
    <title>订单详情</title>
  </head>
  
  <body>
  	<table>
	 	<tr>
		 	<th>书名</th>
		 	<th>单价</th>
		 	<th>数目</th>
		 	<th>总价</th>
	 	</tr>
	 	 <c:forEach items="${requestScope.order_item}" var="data">
	 	 <tr>
		  	<td>${data.title}</td>
		  	<td>${data.price}</td>
		  	<td>${data.count}</td>
		  	<td>${data.total}</td>
		 </tr>
		 </c:forEach>
	 </table>
  </body>
</html>
