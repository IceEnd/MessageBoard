<%@page import="antlr.debug.MessageListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">

<title>Cononicoの的留言簿</title>
<script language="javaScript">
function reply(a){
	
	var target = "reply_div";
	target = target+"_"+a;
	reply_div = document.getElementById(target);
	
	reply_div.style.display="block";
}

function display_reply(){
	reply_div = document.getElementById("reply_div");
	reply_div.style.display="none";
}

function check(){
	
}
</script>
</head>
<body>
<div class="ue_bar">
        <div class="ue_bar_warp">
            <div class="ue_bar_logo">
                <a href="http://www.coolecho.net">
                    <img src="img/icon.png" width="100" alt="logo" title="logo">
                </a>
            </div>
            <div class="ue_bar_title">
                <h1>Cononicoの的留言簿</h1>
            </div>
        </div>
</div>
<div class="ue_comment_bar">
<!-- 列出所有的留言 -->
<ol class="comments">
	<c:forEach items="${list}" var="messagelist"> 
	<li title="li_${messagelist.message.id}">
	<article>
		<div class="headimg">
			<img src="img/icon.png" width="50" alt="head" title="head">
		</div>
		<div class="cmt_r">
			<span class="username">姓名：${messagelist.message.username}</span>
			<span class="time">${message.time}</span>
			<a onclick="javascript:reply(${messagelist.message.id})">回复</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/pro/mdelete?id=${messagelist.message.id}">删除</a>
			<div class="cmt_con">
				<p class="content_p">${messagelist.message.content}</p>
			</div>
		</div>
	</article>
	</li>
	<ol class="children">
		<c:forEach items="${messagelist.message.reply}" var="messageReply"> 
		<li>
		<article>
			<div class="headimg">
				<img src="img/jipo.jpg" width="50" alt="head" title="head">
			</div>
			<div class="cmt_r">
				<span class="username">${messageReply.username}</span>
				<span class="time">${messageReply.time}</span>
				<a name="${messagelist.message.id}" onclick="javascript:reply(${messagelist.message.id})">回复</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/pro/rdelete?id=${messageReply.id}&mid=${messagelist.message.id}">删除</a>
				<div class="cmt_con">
					<p class="content_p">${messageReply.content}</p>
				</div>
			</div>
		</article>
		</li>
		</c:forEach>
	</ol>
	<div class="reply_div" id="reply_div_${messagelist.message.id}">
		<form class="message_form" action="reply" method="get">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="${messagelist.message.id}"></td>
				</tr>
				<tr>
					<td> 用户名： </td>
					<td><input type="text" name="username" size="40"></td>
				</tr>
				<tr>
					<td>内    容： </td>
					<td><textarea name="content" rows="2" cols="40"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" onclick="display_reply"></td>
					<td><input type="reset" value="重填"></td>
				</tr>
			</table>
		</form>
	</div>
	</c:forEach>
</ol>
</div>
<div class="get_message">
    <h2>来一发吐槽</h2>
	<form class="message_form" action="message" method="get">
		<table>
			<tr>
				<td> 用户名： </td>
				<td><input type="text" name="username" size="40"></td>
			</tr>
			<tr>
				<td>内    容： </td>
				<td><textarea name="content" rows="10" cols="40"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重填"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>