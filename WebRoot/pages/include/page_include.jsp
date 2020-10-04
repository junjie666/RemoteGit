<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">
	$(function(){
		$(".btn_del").click(function(){
			var td = $(this).parent().parent().children().first();//this表示当前被点击的标签
			if(!confirm("确认删除"+td.text()+"吗？"))
				return false;//点击取消
		});
		$("#btn_page").click(function(){
			//1.获取用户输入的值
			var go = $("#txt_page").val();
			go=(go>=1 && go<=${page.totalPageNum})?go:${page.pageNum};
			//2.发送请求
			window.location.href="${page.url}&pageNum="+go;
		});
	});
</script>

	<div id="page">
	 	<a href="${page.url}&pageNum=1">首页</a>
	 	<c:if test="${page.hasPre}">
	 		<a href="${page.url}&pageNum=${page.pageNum-1}">上一页</a>
	 	</c:if>
	 	<c:forEach begin="${page.pageNum-5>=1?page.pageNum-5:1}" end="${page.pageNum+5<=page.totalPageNum?page.pageNum+5:page.totalPageNum}" var="num">
	 		<c:if test="${num==page.pageNum}">
	 			<span style="color: blue;">[${num}]</span>
	 		</c:if>
	 		<c:if test="${num!=page.pageNum}">
	 			<a href="${page.url}&pageNum=${num}">${num}</a>
	 		</c:if>
	 	</c:forEach>
	 	<c:if test="${page.hasNext}">
	 		<a href="${page.url}&pageNum=${page.pageNum+1}">下一页</a>
	 	</c:if>
	 	<a href="${page.url}&pageNum=${page.totalPageNum}">末页</a>
	 	共${page.totalPageNum}页，${page.totalCount}条记录！跳转到<input id="txt_page" type="text" value="${page.pageNum}"/>页
	 	<input id="btn_page" type="submit" value="go!"/>
	 </div>