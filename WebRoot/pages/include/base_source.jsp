<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 所有页面引入的资源 -->
<!-- 在实施中需要动态获取 -->
<%-- 
<% String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<%=path %>
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% pageContext.setAttribute("ctx", request);%>
<base href="${ctx.scheme}://${ctx.serverName}:${ctx.serverPort}${ctx.contextPath}/"></base>
<script type="text/javascript" src="static/jquery-1.7.2.js"></script>
<style>
	.msg{
		color: red
	}
	table {
		border: 1px solid;
		border-collapse: collapse;
	}
	td,th{
		border: 1px solid;
	}
</style>
