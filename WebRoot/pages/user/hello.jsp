<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/include/base_source.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功页面</title>
</head>

<body>
		<div id="header">
			<%@ include file="/pages/include/user_include.jsp" %>
			<a href="UserServlet?type=logout">退出登录</a>
		</div>
</body>
</html>