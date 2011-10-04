<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Problem Information">
<h2>${problem.name}</h2>
<table>
	<tr><td>ID</td><td>${problem.id} 
		<a href="${baseURL}/problem/edit?id=${problem.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/problem/delete?id=${problem.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this problem?');"/></a>
	</td></tr>
	<tr><td>Short Name</td><td>${problem.shortName}</td></tr>
	<tr><td>Name</td><td>${problem.name}</td></tr>
	<tr><td>Contest</td><td>
		<cc:contestList contests="${problem.contests}"></cc:contestList>
	</td></tr>
	<tr><td>Description</td><td>
		${problem.description}
	</td></tr>
	<tr><td colspan="2"><a href="${baseURL}/submission/list?problem=${problem.id}">View Submissions</a><br />
	</td></tr>
</table>
</cc:CCJudge>