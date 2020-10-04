<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/pages/include/base_source.jsp" %>
<html>
<head>
<title>图书管理页面</title>

</head>
<body>
<h1>欢迎进入图书管理页面</h1>
	 <table>
	 	<tr>
		 	<th>书名</th>
		 	<th>作者</th>
		 	<th>价格</th>
		 	<th>销量</th>
		 	<th>库存</th>
		 	<th>操作</th>
	 	</tr>
	 	<c:forEach items="${page.pageData}" var="book">
		 <tr>
		 	<td>${book.title}</td>
		 	<td>${book.author}</td>
		 	<td>${book.price}</td>
		 	<td>${book.sales}</td>
		 	<td>${book.stock}</td>
		 	<td>
		 		<a href="manager/BookManagerServlet?type=search&id=${book.id}&pageNum=${page.pageNum}">修改</a>
		 		<a href="manager/BookManagerServlet?type=delete&id=${book.id}" class="btn_del">删除</a>
		 	</td>	 	
		 </tr>
	 	</c:forEach>
	 </table>
	 <a href="pages/manager/bookedit.jsp">添加图书</a>
	 <%@ include file="/pages/include/page_include.jsp" %>
</body>
