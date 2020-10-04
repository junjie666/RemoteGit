<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>junjie登录页面</title>
<%@ include file="/pages/include/base_source.jsp" %>
<script type="text/javascript">
	window.onload = function()
	{
		var btn = document.getElementById("sub_btn");
		btn.onclick = function()
		{
			this.disabled=true;
			document.getElementsByTagName("form")[0].submit();
		};
	};
</script>
</head>
<body>
<%
 String uuid = UUID.randomUUID().toString();//产生一个唯一不重复的令牌 
 session.setAttribute("token", uuid);
%>
		<div id="login_header">
		</div>
			<div class="login_banner">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>欢迎登录内网！</h1>
								<a href="pages/user/regist.jsp">前往注册</a>
								<!-- 显示提示信息 -->
								<span class="msg">
									<%--
										 String message=(String)request.getAttribute("message");
										 out.print(message==null?"请输入您的用户名和密码":message);
									 --%>
									 ${empty message?"请输入您的用户名和密码":message}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="type" value="login"></input>
									<input type="hidden" name="page_token" value="<%=uuid%>"></input>
									<label>用户名</label> 
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username}"/>
									<br />
									<br />
									<label>密码</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
</body>
</html>