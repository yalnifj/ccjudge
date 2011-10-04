<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="User Information">
<h2>${user.name}</h2>
<table>
	<tr><td>ID</td><td>${user.id} 
		<a href="${baseURL}/user/edit?id=${user.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/user/delete?id=${user.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this user?');"/></a>
	</td></tr>
	<tr><td>Username</td><td>${user.username}</td></tr>
	<tr><td>Name</td><td>${user.name}</td></tr>
	<tr><td>Email</td><td>${user.email}</td></tr>
	<tr><td>Role</td><td>${user.role}</td></tr>
	<tr><td>Teams</td><td>
		<c:forEach items="${user.teams}" var="teamRole">
			<a href="${baseURL}/team/view?id=${teamRole.team.id}">${teamRole.team.name} </a>
			<a href="${baseURL}/team/edit?id=${teamRole.team.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
			<a href="${baseURL}/team/delete?id=${teamRole.team.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this team?');"/></a>
			<br />
		</c:forEach>
	</td></tr>
</table>
</cc:CCJudge>