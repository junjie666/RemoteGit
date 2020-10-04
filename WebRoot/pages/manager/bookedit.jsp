<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/pages/include/base_source.jsp" %>
<title>图书修改页面</title>

</head>
<body>
<h1>欢迎进入图书修改页面</h1>
<form action="manager/BookManagerServlet" method="post">
	<input type="hidden" name="type" value="add"/>
	<table>
		 	<tr>
			 	<th>书名</th>
			 	<th>作者</th>
			 	<th>价格</th>
			 	<th>销量</th>
			 	<th>库存</th>
			 	<th>操作</th>
		 	</tr>
		 	<tr>
			 	<input name="id" type="hidden" value="${book.id}"/>
			 	<input name="pageNum" type="hidden" value="${param.pageNum}"/>
			 	<td><input name="title" type="text" value="${book.title}"/></td>
			 	<td><input name="author" type="text" value="${book.author}"/></td>
			 	<td><input name="price" type="text" value="${book.price}"/></td>
			 	<td><input name="sales" type="text" value="${book.sales}"/></td>
			 	<td><input name="stock" type="text" value="${book.stock}"/></td>
			 	<td><input name="submit" type="submit" value="提交"/></td>
		 	</tr>
	</table>
</form>	
</body>
</html>