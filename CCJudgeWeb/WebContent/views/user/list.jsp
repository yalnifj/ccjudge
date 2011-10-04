<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="User List">
<h2>User List <c:if test="${contest != null }"> for Contest ${contest.name}</c:if></h2>
<table border="1" cellpadding="2">
	<tr><th>id</th><th>Username</th><th>Name</th><th>Email</th><th>Role</th><th></th></tr>
	<c:forEach items="${list}" var="user" varStatus="count">
		<tr>
		<td>${user.id}</td>
		<td><a href="${baseURL}/user/view?id=${user.id}">${user.username}</a></td>
		<td>${user.name}</td>
		<td>${user.email}</td>
		<td>${user.role}</td>
		<td><a href="${baseURL}/user/edit?id=${user.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/user/delete?id=${user.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this user?');"/></a>
		</td>
		</tr>
	</c:forEach>
</table>
</cc:CCJudge>