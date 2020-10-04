<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<c:if test="${!empty sessionScope.user }">
	<div>
	<span>${sessionScope.user.username} 欢迎您！</span> 
	<a href="index.jsp">图书主页</a> 
	<a href="manager/BookManagerServlet?type=page&pageNum=1" >图书管理</a> 
	<a href="pages/cart/cart.jsp" >购物车</a> 
	<a href="client/OrderClientServlet?type=orderList">我的订单</a> 
	<a href="manager/OrderManagerServlet?type=orderList">订单管理</a> 
	<a href="UserServlet?type=logout">注销</a>
	</div>
</c:if>
<c:if test="${empty sessionScope.user }">
    <a href="pages/user/login.jsp">前往登录！</a>
    <a href="pages/user/regist.jsp">前往注册</a>
</c:if>

