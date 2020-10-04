<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<html>
  <head>
  </head>
  <body>
  <%@ include file="/pages/include/user_include.jsp" %>
  <form action="client/BookClientServlet" method="get">
  	<input type="hidden" name="type" value="pageByPrice"/>
  	<input type="hidden" name="pageNum" value="1"/>
  	最低价：<input type="text" name="minPrice" value="${param.minPrice }"/>
  	最高价：<input type="text" name="maxPrice" value="${param.maxPrice }"/>
  	<input type="submit" value="提交查询"/>
  </form>
  <c:if test="${ ! empty sessionScope.cart}">
  	您的购物车中共有 ${sessionScope.cart.totalCount}件商品!<br/>
  	您刚刚将 《${sessionScope.book.title}》加入了购物车！<br/>
  </c:if>
  <c:forEach items="${page.pageData }" var="data">
  	书名：${data.title}<br>
  	作者：${data.author}<br>
  	价格：${data.price}<br>
  	销量：${data.sales}<br>
  	库存：${data.stock}<br>
  	<img width="300" height="300" src="${data.imgPath}">
  	<br>
  	<a href="client/CartServlet?type=add&id=${data.id}">加入购物车</a>
  	<br>
  </c:forEach>
 	 <%@ include file="/pages/include/page_include.jsp" %>
  </body>
</html>
