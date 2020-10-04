<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>junjie会员注册页面</title>
<%@ include file="/pages/include/base_source.jsp" %>

<script type="text/javascript">
	$(function() {
		//点击图片更换验证码
		$("#code").click(function(){
		//区分不同请求，防止浏览器读缓存
			$(this).prop("src","code.jpg?t"+Math.random());
		});
	
		//1、验证用户名，密码，确认密码，email是否符合规定
		$("#sub_btn").click(function(){
			//2、验证成功提交表单。
			  //获取用户输入的所有值
			 var  username = $(".itxt[name='username']").val();
			 var  password = $(".itxt[name='password']").val();
			 var  repwd = $(".itxt[name='repwd']").val();
			 var  email = $(".itxt[name='email']").val();
			 var  code = $(".itxt[name='code']").val();
			 //用户名规则：长度>6  <18  不能写非法字符       合法（字母，数字,_,-）;
			 //密码规则：长度>6  <18  不能写非法字符       合法（字母，数字,_,-）;
			 //确认密码规则：和密码相同;
			 //email：  xxxx@.com
			 //验证码：保证用户已经输入值即可
			 
			 //正则表达式：定义正确规则的一个表达式
			 //    作用：验证字符串是否符合表达式规则
			 //使用：
			 //1、创建一个正则表达式
			// var reg = /a/;
			 //2、使用表达式的test方法验证传入的字符串是否符合规则   返回boolean
			 //alert(reg.test("bc"));
			 
			var regUserName = /^[a-zA-Z0-9]{5,18}$/;
			var regPwd = /^[a-zA-Z0-9]{5,18}$/;
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if(!regUserName.test(username)){
				//如果用户名验证失败
				$(".msg").text("用户名格式错误");
				return false;
			}
			if(!regPwd.test(password)){
				//如果面验证失败
				$(".msg").text("密码格式错误");
				return false;
				
			}
			if(repwd != password){
				$(".msg").text("两次密码不一致!");
				return false;
			}
			//3、验证失败，交代为什么失败
			if(code=="")
			{
				$(".msg").text("验证码不能为空！");
				return false;
			}
		});
	});
</script>


</head>
<body>
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册junjie会员</h1>
								<span class="msg">
									<%--
										String message=(String)request.getAttribute("message");
										System.out.print(message);
										out.print(message==null?"请输入用户信息":message);
									 --%>
									 ${empty message?"请输入用户信息":message}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="type" value="regist"></input>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username }"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" value=""/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" value=""/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" placeholder="输入验证码" autocomplete="off" tabindex="1" name="code" value="" />
									<img id="code" alt="" src="code.jpg"  style="width: 100px; ">
									<br />
									<br />
									 
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
</body>
</html>