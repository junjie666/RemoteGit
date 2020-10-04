<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/pages/include/base_source.jsp" %>
<%@ include file="/pages/include/user_include.jsp" %>

<html>
  <head>
    <title>购物车界面</title>
    <script type="text/javascript">
	$(function(){
		$(".btn_delete").click(function(){
			var td = $(this).parents("tr").children(":first");//this表示当前被点击的标签
			if(!confirm("确认删除"+td.text()+"吗？"))
				return false;//点击取消
		});
		$(".clear").click(function(){
			if(!confirm("确认清空购物车吗？"))
				return false;//点击取消
		});
		//当input框内容发生变化
		$(".change").change(function(){
			var id = $(this).attr("updateID");
			var count = $(this).val();
			window.location.href="client/CartServlet?type=update&id="+id+"&count="+count;
		});
	});
</script>
  </head>
  <body>
   <table>
	 	<tr>
		 	<th>书名</th>
		 	<th>数量</th>
		 	<th>单价</th>
		 	<th>金额</th>
		 	<th>操作</th>
	 	</tr>
	 	 <c:forEach items="${sessionScope.cart.allItems }" var="data">
	 	 <tr>
		  	<td>${data.book.title}</td>
		  	<td><input updateID="${data.book.id }" class="change" type="text" value="${data.count}" style="width: 30px"></input></td>
		  	<td>${data.book.price}</td>
		  	<td>${data.price}</td>
		  	<td><a class="btn_delete" href="client/CartServlet?type=delete&id=${data.book.id}">删除</a></td>
		 </tr>
		 </c:forEach>
	 </table>
 
  	购物车中共有${sessionScope.cart.totalCount}件商品	总金额${sessionScope.cart.totalPrice}元<br/>
  	<a class="clear" href="client/CartServlet?type=clear">清空购物车</a>	<a href="client/OrderClientServlet?type=check">去结账</a>
  </body>
</html>
